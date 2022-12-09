package inventory_casheringsystem;

public class inv_products {

    private int id;
    private String Productname;
    private String Category;
    private String Portion;
    private String Serving;
    private float price;
    private float qty;
   

    public inv_products(int id, String Productname, String Category, String Portion, String Serving, float price,float qty) {
        this.id = id;
        this.Productname = Productname;
        this.Category = Category;
        this.Portion = Portion;
        this.Serving = Serving;
        this.price = price;
        this.qty = qty;
        
    }

    public int getID() {
        return id;
    }

    public String getProductname() {
        return Productname;
    }

    public String getCategory() {
        return Category;
    }

    public String getPortion() {
        return Portion;
    }

    public String getServing() {
        return Serving;
    }

    public float getprice() {
        return price;
    }
    public float getQty(){
        return qty;
    }
    
    
}
