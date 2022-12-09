package inventory_casheringsystem;

public class salesgetdata {

    private int id;
    private String Productname;
    private int qty;
    private float price;
    private float totalp;
    private String date;
    private String time;

    public salesgetdata(int id, String Productname, String date,String time, int qty, float price, float totalp) {
        this.id = id;
        this.Productname = Productname;
        this.date = date;
        this.time=time;
        this.qty = qty;
        this.price = price;
        this.totalp = totalp;

    }

    salesgetdata(int aInt, String string, String string0,String string1, String string2, int aInt0, float aFloat, float aFloat0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getProductCode() {
        return id;
    }

    public String getProductname() {
        return Productname;
    }
    public String getDate(){
        return date;
    }   
    public String getTime(){
     return time;
    
    }
    public int getQuality(){
        return qty;
    }
    public float getPrice(){
        return price;
    }
    public float getTotalPrice(){
        return totalp;
    }
}
