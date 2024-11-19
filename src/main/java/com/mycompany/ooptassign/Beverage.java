package com.mycompany.ooptassign;

/*
 * @author Tang Qiao Ling
 */
public class Beverage extends Product {

    private int prodNo;
    private static int nextBevNo = 1001;

    public Beverage(String name, double price, char size) {
        super(name, price, size);
        this.prodNo = nextBevNo++;
    }

    public int getProdNo() {
        return this.prodNo;
    }

    public static int getNextBevNo() {
        return Beverage.nextBevNo;
    }

    public void displayProduct(){
         System.out.printf("| %-4s %-64s",
                this.getProdNo(), super.toString());
    }
    
}
