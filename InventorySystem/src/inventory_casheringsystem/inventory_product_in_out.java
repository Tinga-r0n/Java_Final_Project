/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inventory_casheringsystem;

/**
 *
 * @author Sony
 */
public class inventory_product_in_out {
    private int id;
    private String productname;
    private String category;
    private int qty;
    private String date;
    private String stock_in_out;
    
    public inventory_product_in_out(int id, String productname, String category, int qty, String date, String stock_in_out){
        this.id = id;
        this.productname = productname;
        this.category = category;
        this.qty = qty;
        this.date = date;
        this.stock_in_out = stock_in_out;
        
        
    }
    public int getID(){
        return id;
    }
    public String getProductName(){
        return productname;
    }
    public String getCategory(){
        return category;
       
    }
    public int getQTY(){
        return qty;
    }
    public String getDate(){
        return date;
    }
    public String getIN_out(){
        return stock_in_out;
    }
}
