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
public class print_data {
         
    private String Pns;
    private float pric;
    private int qty;
    private String totals;

    public print_data(String Pns, int qty ,float pric,String totals){
       
        this.Pns = Pns;
        this.pric = pric;
        this.qty = qty;
        
        this.totals = totals;
      
    }

   
   public String getPns(){
       return Pns;
   }
   public int getQTY(){
       return qty;
   }
   public float getpric(){
       return pric;
   }
 
  public String getTotal(){
      return totals;
  }
}
  

