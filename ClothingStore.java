import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;

public class ClothingStore {

    static JFrame frame = new JFrame("Clothing Store");
    static LinkedList<StoreProducts.Product> orderList = new LinkedList<>();

    public static void main(String[] args) {
        StoreProducts.loadProducts();  
        showHomePage();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(480, 520);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // ------------------ HOMEPAGE --------------------
    static void showHomePage() {
    frame.getContentPane().removeAll();
    frame.setLayout(new BorderLayout());

    // Title (NO BACKGROUND PANEL ANYMORE)
    JLabel title = new JLabel("CLOTHING STORE", SwingConstants.CENTER);
    title.setFont(new Font("Segoe UI Black", Font.BOLD, 32));
    title.setForeground(new Color(120, 40, 150)); // purple text instead of purple background

    // Add spacing above title so it's not at the very top
    JPanel titleWrapper = new JPanel();
    titleWrapper.setLayout(new BoxLayout(titleWrapper, BoxLayout.Y_AXIS));
    title.setAlignmentX(Component.CENTER_ALIGNMENT);
    titleWrapper.add(Box.createRigidArea(new Dimension(0, 30))); // space from top
    titleWrapper.add(title);
    titleWrapper.add(Box.createRigidArea(new Dimension(0, 30))); // space below
    
    titleWrapper.setBackground(new Color(240, 225, 255));

    // Buttons
    JButton startBtn = new JButton("Start Ordering");
    JButton exitBtn = new JButton("Exit");

    styleHomepageButton(startBtn);
    styleHomepageButton(exitBtn);

    startBtn.addActionListener(e -> showOrderPage());
    exitBtn.addActionListener(e -> System.exit(0));

    // Center panel (compact buttons, not stretched)
    JPanel center = new JPanel();
    center.setBackground(new Color(240, 225, 255));
    center.setLayout(new BoxLayout(center, BoxLayout.Y_AXIS));

    startBtn.setAlignmentX(Component.CENTER_ALIGNMENT);
    exitBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

    center.add(startBtn);
    center.add(Box.createRigidArea(new Dimension(0, 25))); // spacing
    center.add(exitBtn);

    frame.add(titleWrapper, BorderLayout.NORTH);
    frame.add(center, BorderLayout.CENTER);

    frame.revalidate();
    frame.repaint();
}


    // ------------------ ORDER PAGE --------------------
    static void showOrderPage() {
    frame.getContentPane().removeAll();
    frame.setLayout(new BorderLayout());

    // ---------- TOP ----------
    JLabel title = new JLabel("AVAILABLE ITEMS", SwingConstants.CENTER);
    title.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
    title.setForeground(Color.WHITE);

    JPanel topPanel = new JPanel();
    topPanel.setBackground(new Color(50, 120, 200));
    topPanel.setPreferredSize(new Dimension(100, 80));
    topPanel.add(title);

    // ---------- CENTER ----------
    JPanel center = new JPanel();
    center.setLayout(new GridLayout(6, 1, 10, 10));
    center.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));
    center.setBackground(new Color(240, 245, 255));

    JLabel catLbl = new JLabel("Select Category:");
    JLabel subLbl = new JLabel("Select Subcategory:");
    JLabel itemLbl = new JLabel("Select Item:");

    JComboBox<String> categoryBox = new JComboBox<>();
    JComboBox<String> subCategoryBox = new JComboBox<>();
    JComboBox<String> itemBox = new JComboBox<>();

    categoryBox.addItem("Select");
    subCategoryBox.addItem("Select");
    itemBox.addItem("Select");

    // Load unique categories
    for (StoreProducts.Product p : StoreProducts.inventory) {
        if (((DefaultComboBoxModel<String>) categoryBox.getModel())
                .getIndexOf(p.category) == -1) {
            categoryBox.addItem(p.category);
        }
    }

    // When category changes → load subcategories
    categoryBox.addActionListener(e -> {
        subCategoryBox.removeAllItems();
        subCategoryBox.addItem("Select");
        itemBox.removeAllItems();
        itemBox.addItem("Select");

        String selectedCategory = (String) categoryBox.getSelectedItem();

        for (StoreProducts.Product p : StoreProducts.inventory) {
            if (p.category.equals(selectedCategory)) {
                if (((DefaultComboBoxModel<String>) subCategoryBox.getModel())
                        .getIndexOf(p.subcategory) == -1) {
                    subCategoryBox.addItem(p.subcategory);
                }
            }
        }
    });

    // When subcategory changes → load items
    subCategoryBox.addActionListener(e -> {
        itemBox.removeAllItems();
        itemBox.addItem("Select");

        String cat = (String) categoryBox.getSelectedItem();
        String sub = (String) subCategoryBox.getSelectedItem();

        for (StoreProducts.Product p : StoreProducts.inventory) {
            if (p.category.equals(cat) && p.subcategory.equals(sub)) {
                itemBox.addItem(p.name + " — ₱" + p.price);
            }
        }
    });

    center.add(catLbl);
    center.add(categoryBox);
    center.add(subLbl);
    center.add(subCategoryBox);
    center.add(itemLbl);
    center.add(itemBox);

    // ---------- BOTTOM ----------
    JButton addBtn = new JButton("Add Item");
    JButton finishBtn = new JButton("Finish Order");
    JButton backBtn = new JButton("Back");

    styleMediumButton(addBtn);
    styleMediumButton(finishBtn);
    styleMediumButton(backBtn);

    addBtn.addActionListener(e -> {
        String selected = (String) itemBox.getSelectedItem();
        if (selected == null || selected.equals("Select")) {
            JOptionPane.showMessageDialog(frame, "Please select an item.");
            return;
        }

        String itemName = selected.split(" — ")[0];

        for (StoreProducts.Product p : StoreProducts.inventory) {
            if (p.name.equals(itemName)) {
                orderList.add(p);
                JOptionPane.showMessageDialog(frame, "Added: " + p.name);
                break;
            }
        }
    });

    finishBtn.addActionListener(e -> showReceiptPage());
    backBtn.addActionListener(e -> showHomePage());

    JPanel bottom = new JPanel(new GridLayout(3, 1, 10, 10));
    bottom.setBorder(BorderFactory.createEmptyBorder(10, 30, 20, 30));
    bottom.setBackground(new Color(230, 240, 255));

    bottom.add(addBtn);
    bottom.add(finishBtn);
    bottom.add(backBtn);

    // ---------- ADD TO FRAME ----------
    frame.add(topPanel, BorderLayout.NORTH);
    frame.add(center, BorderLayout.CENTER);
    frame.add(bottom, BorderLayout.SOUTH);

    frame.revalidate();
    frame.repaint();
}


    // ------------------ RECEIPT PAGE --------------------
    static void showReceiptPage() {
        frame.getContentPane().removeAll();
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("RECEIPT", SwingConstants.CENTER);
        title.setFont(new Font("Segoe UI Black", Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(20, 150, 100));
        topPanel.setPreferredSize(new Dimension(100, 90));
        topPanel.add(title);

        JPanel center = new JPanel();
        center.setBackground(new Color(235, 250, 240));
        center.setLayout(new GridBagLayout()); // centers content

        JTextArea receipt = new JTextArea();
        receipt.setEditable(false);
        receipt.setFont(new Font("Segoe UI", Font.BOLD, 17));
        receipt.setBackground(new Color(255, 255, 255));
        receipt.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        StringBuilder sb = new StringBuilder();
        sb.append("===== RECEIPT =====\n\n");
        double total = 0;

        for (StoreProducts.Product p : orderList) {
            sb.append(p.name).append(" - ₱").append(p.price).append("\n");
            total += p.price;
        }

        sb.append("\n----------------------\n");
        sb.append("TOTAL: ₱").append(total).append("\n");

        receipt.setText(sb.toString());

        center.add(receipt);

        JButton homeBtn = new JButton("Back to Home");
        styleHomepageButton(homeBtn);

        homeBtn.addActionListener(e -> {
            orderList.clear();
            showHomePage();
        });

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottom.setBackground(new Color(235, 250, 240));
        bottom.add(homeBtn);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        frame.add(bottom, BorderLayout.SOUTH);

        frame.revalidate();
        frame.repaint();
    }

    // ------------------ BUTTON STYLES --------------------
    static void styleSmallButton(JButton b) {
        b.setPreferredSize(new Dimension(100, 40));
        b.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 15));
        b.setFocusPainted(false);
        b.setBackground(new Color(190, 160, 255));
        b.setBorder(BorderFactory.createLineBorder(new Color(100, 0, 150), 2));
    }

    static void styleMediumButton(JButton b) {
        b.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
        b.setFocusPainted(false);
        b.setBackground(new Color(200, 220, 255));
        b.setBorder(BorderFactory.createLineBorder(new Color(70, 110, 180), 2));
    }
	
	static void styleHomepageButton(JButton b) {
    b.setPreferredSize(new Dimension(180, 45));  // better size
    b.setMaximumSize(new Dimension(180, 45));    // prevent stretching
    
    b.setFont(new Font("Segoe UI Semibold", Font.PLAIN, 16));
    b.setFocusPainted(false);

    b.setBackground(new Color(210, 190, 255));
    b.setForeground(Color.BLACK);

    // Slightly thicker border (but not too thick)
    b.setBorder(BorderFactory.createLineBorder(new Color(120, 40, 150), 3));
}

}
