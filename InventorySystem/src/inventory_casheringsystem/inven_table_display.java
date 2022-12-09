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
public class inven_table_display {
     private int id;
    private String productname;
    private String category;
    private int qty;
 
    
    public inven_table_display(int id, String productname, String category, int qty){
        this.id = id;
        this.productname = productname;
        this.category = category;
        this.qty = qty;
      
        
        
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

}


