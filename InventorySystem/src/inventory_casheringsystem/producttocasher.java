
package inventory_casheringsystem;


public class producttocasher {
    private int id;
    private String productName;
    private String cate;
    private float price;
    private String Serve;
    private int qty;
    
    public producttocasher(int id,String productName,String cate,float price,String Serve,int qty){
        this.id = id;
        this.productName = productName;
        this.cate = cate;
        this.price = price;
        this.Serve = Serve;
        this.qty = qty;
       
        
    }
    public int getid(){
        return id;
        
    }
    public String getproductName(){
        return productName;
    }
    public String getcate(){
        return cate;
    }
    public float getprice(){
        return price;
    }
   public String getServe(){
       return Serve;
   }
    public int getQTY(){
       return qty;
   }
}
