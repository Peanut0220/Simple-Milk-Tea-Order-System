package com.mycompany.ooptassign;

/*
 * @author Tang Qiao Ling
 */
public class Topping extends Product {

    private int prodNo;
    private static int nextTopNo = 2001;

    public Topping(String name, double price, char size) {
        super(name, price, size);
        this.prodNo = nextTopNo++;
    }

    public int getProdNo() {
        return this.prodNo;
    }

    public static int getNextTopNo() {
        return Topping.nextTopNo;
    }
    
    public void displayProduct(){
         System.out.printf("| %-4s %-64s",
                this.getProdNo(), super.toString());
    }
    

}
