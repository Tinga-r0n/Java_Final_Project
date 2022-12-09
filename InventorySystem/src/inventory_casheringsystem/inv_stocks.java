package inventory_casheringsystem;

public class inv_stocks {

    private int id;
    private String Productname;
    private String Category;
    private String Portion;
    private String Serving;
    private float price;
    private float qty;
   

    public inv_stocks(int id, String Productname, String Category, float price,float qty) {
        this.id = id;
        this.Productname = Productname;
        this.Category = Category;
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

    public float getprice() {
        return price;
    }
    public float getQty(){
        return qty;
    }
    
    
}
