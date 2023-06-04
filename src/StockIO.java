
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Scott Braaten
 */

public class StockIO {
    private String fileName;

    // default constructor
    public StockIO() {
        
    }
    
    public StockIO(String fileName) {
        this.fileName = fileName;
    }
    
    public ArrayList<Stock> getData() throws IOException {
        // declare/initialize arraylist
        ArrayList<Stock> stocks = new ArrayList<Stock>();
        
        // declare/initialize bufferedreader
        BufferedReader inbuffer = new BufferedReader(new FileReader(this.fileName));
        
        // get first line - first stock
        String inputString = inbuffer.readLine();
        
        while (inputString != null) {
            // delimiter ~ is used to separate fields so StringTokenizer used to easily get different fields
            StringTokenizer tokens = new StringTokenizer(inputString, "~");
            
            // get fields
            String name = tokens.nextToken();
            double qty = Double.parseDouble(tokens.nextToken());
            double purchasePrice = Double.parseDouble(tokens.nextToken());
            double currentPrice = Double.parseDouble(tokens.nextToken());
            
            // declare/initialize stock based on fields and add to stocks
            Stock stock = new Stock(name, qty, purchasePrice, currentPrice);
            stocks.add(stock);
            
            // read next line - next stock
            inputString = inbuffer.readLine();
        }
        
        inbuffer.close();
        
        return stocks;
    }
    
    public void saveData(ArrayList<Stock> stocks) throws IOException {
        // declare/initialize bufferedreader
        BufferedWriter outfile = new BufferedWriter(new FileWriter(this.fileName));
        
        // iterate through supplied stocks and write to file
        for (Stock stock : stocks) {
            outfile.write(stock.getName());
            outfile.write("~" + stock.getQty());
            outfile.write("~" + stock.getPurchasePrice());
            outfile.write("~" + stock.getCurrentPrice());
            outfile.newLine();
        }
        
        // close writer
        outfile.close();
    }
}
