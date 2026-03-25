import java.util.LinkedList;

public class StoreProducts {

    public static class Product {
        String category;    
        String subcategory; 
        String name;
        double price;
        int stock;

        public Product(String category, String subcategory, String name, double price, int stock) {
            this.category = category;
            this.subcategory = subcategory;
            this.name = name;
            this.price = price;
            this.stock = stock;
        }
    }

    public static LinkedList<Product> inventory = new LinkedList<>();

		public static void loadProducts() {

		/* ===================== TOP : BASIC TOP (20) ===================== */
		inventory.add(new Product("Top","Basic Top","Classic T-Shirt",150,20));
		inventory.add(new Product("Top","Basic Top","Plain Tank Top",120,15));
		inventory.add(new Product("Top","Basic Top","Casual Crop Top",180,10));
		inventory.add(new Product("Top","Basic Top","Everyday Polo",130,17));
		inventory.add(new Product("Top","Basic Top","Seamless Tube Top",100,30));
		inventory.add(new Product("Top","Basic Top","Cotton Blouse",125,10));
		inventory.add(new Product("Top","Basic Top","Button Down Shirt",180,10));
		inventory.add(new Product("Top","Basic Top","Long Sleeve Tee",170,12));
		inventory.add(new Product("Top","Basic Top","V-Neck Shirt",160,14));
		inventory.add(new Product("Top","Basic Top","Sleeveless Top",140,18));
		inventory.add(new Product("Top","Basic Top","Striped T-Shirt",165,16));
		inventory.add(new Product("Top","Basic Top","Graphic Tee",175,14));
		inventory.add(new Product("Top","Basic Top","Oversized Tee",190,11));
		inventory.add(new Product("Top","Basic Top","Ribbed Tank",135,20));
		inventory.add(new Product("Top","Basic Top","Boxy Top",155,13));
		inventory.add(new Product("Top","Basic Top","Casual Henley",185,9));
		inventory.add(new Product("Top","Basic Top","Soft Knit Tee",170,15));
		inventory.add(new Product("Top","Basic Top","Basic Crewneck",160,17));
		inventory.add(new Product("Top","Basic Top","Relaxed Fit Top",150,19));
		inventory.add(new Product("Top","Basic Top","Minimalist Tee",145,22));

		/* ===================== TOP : FORMAL TOP (20) ===================== */
		inventory.add(new Product("Top","Formal Top","Dress Shirt",350,12));
		inventory.add(new Product("Top","Formal Top","Office Blouse",280,18));
		inventory.add(new Product("Top","Formal Top","Tailored Blazer",300,15));
		inventory.add(new Product("Top","Formal Top","Suit Vest",320,9));
		inventory.add(new Product("Top","Formal Top","Formal Polo",260,11));
		inventory.add(new Product("Top","Formal Top","Silk Blouse",340,7));
		inventory.add(new Product("Top","Formal Top","Corporate Shirt",290,13));
		inventory.add(new Product("Top","Formal Top","Long Sleeve Dress Shirt",360,10));
		inventory.add(new Product("Top","Formal Top","Chiffon Blouse",330,8));
		inventory.add(new Product("Top","Formal Top","Formal Button Shirt",310,12));
		inventory.add(new Product("Top","Formal Top","Executive Blazer",420,6));
		inventory.add(new Product("Top","Formal Top","Office Knit Top",275,14));
		inventory.add(new Product("Top","Formal Top","Formal Peplum",295,9));
		inventory.add(new Product("Top","Formal Top","Linen Dress Shirt",370,11));
		inventory.add(new Product("Top","Formal Top","Structured Blouse",315,10));
		inventory.add(new Product("Top","Formal Top","Classic White Shirt",350,15));
		inventory.add(new Product("Top","Formal Top","Professional Polo",280,16));
		inventory.add(new Product("Top","Formal Top","Formal Wrap Blouse",325,8));
		inventory.add(new Product("Top","Formal Top","Silk Office Top",390,7));
		inventory.add(new Product("Top","Formal Top","Business Casual Shirt",300,14));

		/* ===================== TOP : OUTERWEAR (20) ===================== */
		inventory.add(new Product("Top","Outerwear","Classic Jacket",500,8));
		inventory.add(new Product("Top","Outerwear","Pullover Hoodie",450,7));
		inventory.add(new Product("Top","Outerwear","Winter Coat",550,19));
		inventory.add(new Product("Top","Outerwear","Windbreaker",420,10));
		inventory.add(new Product("Top","Outerwear","Button Cardigan",380,14));
		inventory.add(new Product("Top","Outerwear","Denim Jacket",520,6));
		inventory.add(new Product("Top","Outerwear","Bomber Jacket",480,9));
		inventory.add(new Product("Top","Outerwear","Fleece Jacket",460,12));
		inventory.add(new Product("Top","Outerwear","Varsity Jacket",540,7));
		inventory.add(new Product("Top","Outerwear","Oversized Hoodie",470,11));
		inventory.add(new Product("Top","Outerwear","Lightweight Coat",510,10));
		inventory.add(new Product("Top","Outerwear","Knitted Cardigan",395,13));
		inventory.add(new Product("Top","Outerwear","Rain Jacket",490,8));
		inventory.add(new Product("Top","Outerwear","Puffer Jacket",600,6));
		inventory.add(new Product("Top","Outerwear","Track Jacket",430,15));
		inventory.add(new Product("Top","Outerwear","Zip-Up Hoodie",455,14));
		inventory.add(new Product("Top","Outerwear","Longline Coat",580,5));
		inventory.add(new Product("Top","Outerwear","Casual Blazer",520,9));
		inventory.add(new Product("Top","Outerwear","Thermal Jacket",610,4));
		inventory.add(new Product("Top","Outerwear","Streetwear Hoodie",480,13));

		/* ===================== BOTTOM : PANTS (20) ===================== */
		inventory.add(new Product("Bottom","Pants","Straight Jeans",400,10));
		inventory.add(new Product("Bottom","Pants","Slim Slacks",380,6));
		inventory.add(new Product("Bottom","Pants","Cargo Pants",420,8));
		inventory.add(new Product("Bottom","Pants","Chinos",390,12));
		inventory.add(new Product("Bottom","Pants","Jogger Pants",360,15));
		inventory.add(new Product("Bottom","Pants","Formal Trousers",450,7));
		inventory.add(new Product("Bottom","Pants","Wide-Leg Pants",410,9));
		inventory.add(new Product("Bottom","Pants","Skinny Jeans",395,11));
		inventory.add(new Product("Bottom","Pants","High-Waist Pants",430,10));
		inventory.add(new Product("Bottom","Pants","Relaxed Fit Pants",370,13));
		inventory.add(new Product("Bottom","Pants","Pleated Trousers",460,8));
		inventory.add(new Product("Bottom","Pants","Office Slacks",405,12));
		inventory.add(new Product("Bottom","Pants","Drawstring Pants",355,14));
		inventory.add(new Product("Bottom","Pants","Travel Pants",440,9));
		inventory.add(new Product("Bottom","Pants","Denim Joggers",415,10));
		inventory.add(new Product("Bottom","Pants","Ankle Pants",385,11));
		inventory.add(new Product("Bottom","Pants","Stretch Pants",375,13));
		inventory.add(new Product("Bottom","Pants","Utility Pants",460,7));
		inventory.add(new Product("Bottom","Pants","Casual Work Pants",420,9));
		inventory.add(new Product("Bottom","Pants","Tailored Pants",480,6));

		/* ===================== BOTTOM : SHORTS (20) ===================== */
		inventory.add(new Product("Bottom","Shorts","Denim Shorts",200,15));
		inventory.add(new Product("Bottom","Shorts","Cargo Shorts",250,10));
		inventory.add(new Product("Bottom","Shorts","Athletic Shorts",180,20));
		inventory.add(new Product("Bottom","Shorts","Cycling Shorts",190,13));
		inventory.add(new Product("Bottom","Shorts","Board Shorts",270,8));
		inventory.add(new Product("Bottom","Shorts","Lounge Shorts",160,17));
		inventory.add(new Product("Bottom","Shorts","Running Shorts",175,18));
		inventory.add(new Product("Bottom","Shorts","Drawstring Shorts",165,16));
		inventory.add(new Product("Bottom","Shorts","Cotton Shorts",185,14));
		inventory.add(new Product("Bottom","Shorts","Casual Fit Shorts",195,15));
		inventory.add(new Product("Bottom","Shorts","High-Waist Shorts",210,12));
		inventory.add(new Product("Bottom","Shorts","Pleated Shorts",225,10));
		inventory.add(new Product("Bottom","Shorts","Summer Shorts",170,20));
		inventory.add(new Product("Bottom","Shorts","Beach Shorts",260,9));
		inventory.add(new Product("Bottom","Shorts","Stretch Shorts",200,13));
		inventory.add(new Product("Bottom","Shorts","Printed Shorts",215,11));
		inventory.add(new Product("Bottom","Shorts","Relaxed Shorts",180,19));
		inventory.add(new Product("Bottom","Shorts","Urban Shorts",240,8));
		inventory.add(new Product("Bottom","Shorts","Classic Fit Shorts",205,14));
		inventory.add(new Product("Bottom","Shorts","Soft Fabric Shorts",190,16));

		/* ===================== BOTTOM : SKIRTS (20) ===================== */
		inventory.add(new Product("Bottom","Skirts","Mini Skirt",220,14));
		inventory.add(new Product("Bottom","Skirts","Pencil Skirt",300,9));
		inventory.add(new Product("Bottom","Skirts","Pleated Skirt",280,11));
		inventory.add(new Product("Bottom","Skirts","A-Line Skirt",260,13));
		inventory.add(new Product("Bottom","Skirts","Maxi Skirt",320,7));
		inventory.add(new Product("Bottom","Skirts","Wrap Skirt",290,10));
		inventory.add(new Product("Bottom","Skirts","High-Waist Skirt",270,12));
		inventory.add(new Product("Bottom","Skirts","Denim Skirt",250,15));
		inventory.add(new Product("Bottom","Skirts","Flowy Skirt",310,8));
		inventory.add(new Product("Bottom","Skirts","Office Skirt",295,9));
		inventory.add(new Product("Bottom","Skirts","Layered Skirt",330,6));
		inventory.add(new Product("Bottom","Skirts","Casual Skirt",240,14));
		inventory.add(new Product("Bottom","Skirts","Knee-Length Skirt",285,10));
		inventory.add(new Product("Bottom","Skirts","Summer Skirt",260,13));
		inventory.add(new Product("Bottom","Skirts","Printed Skirt",275,11));
		inventory.add(new Product("Bottom","Skirts","Stretch Skirt",255,12));
		inventory.add(new Product("Bottom","Skirts","Soft Fabric Skirt",265,14));
		inventory.add(new Product("Bottom","Skirts","Formal Skirt",320,8));
		inventory.add(new Product("Bottom","Skirts","Flared Skirt",290,10));
		inventory.add(new Product("Bottom","Skirts","Classic Cut Skirt",300,9));

		}


    public static Product findProduct(String name) {
        for (Product p : inventory) {
            if (p.name.equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

}
