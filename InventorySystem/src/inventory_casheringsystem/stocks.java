
package inventory_casheringsystem;


public class stocks {
    
    private int id;
    private String Productname;
    private String Category;
    private int availableStocks;
    private int stocksOut;
    private int stocksIn;
    private String date;
   

    public stocks(int id, String Productname, String Category, int availableStocks, int stocksOut, int stocksIn,String date ) {
        this.id = id;
        this.Productname = Productname;
        this.Category = Category;
        this.availableStocks = availableStocks;
        this.stocksOut = stocksOut;
        this.stocksIn = stocksIn;
        this.date=date;
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

    public int getAvailable() {
        return availableStocks;
    }

    public int getStocksOut() {
        return stocksOut;
    }

    public int getStocksIn() {
        return stocksIn;
    }
    public String getDate(){
        return date;
    }
}
