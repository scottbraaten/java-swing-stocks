/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Scott Braaten
 */

/**************************************************** 
Program Name: Stock.java
Programmer's Name: Scott Braaten 
Program Description: Used by PortfolioManagementGUI.java to maintain storage
* of added Stock information.
***********************************************************/

public class Stock {
    private String name;
    private double purchasePrice, currentPrice, qty;

    // default constructor
    public Stock() {
    }
    
    // chained constructor (not used)
    public Stock(Stock stock) {
        this(stock.getName(), stock.getQty(), stock.getPurchasePrice(), stock.getCurrentPrice());
    }

    // input constructor
    public Stock(String name, double qty, double purchasePrice, double currentPrice) {
        this.name = name;
        this.qty = qty;
        this.purchasePrice = purchasePrice;
        this.currentPrice = currentPrice;
    }

    // getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }
    
    // toString
    @Override
    public String toString() {
        return this.name;
    }
    
    // returns profit or loss
    public double calcResults() {
        return (double) this.qty * (this.currentPrice - this.purchasePrice);
    }
}
