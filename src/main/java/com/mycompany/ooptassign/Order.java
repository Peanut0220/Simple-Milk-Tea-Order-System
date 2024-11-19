package com.mycompany.ooptassign;
/* @author: Chong Jian */
import static com.mycompany.ooptassign.OOPTAssign.member;
import static com.mycompany.ooptassign.OOPTAssign.order;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Order {

    private Beverage[] orderBeverage = new Beverage[10];
    private int[] orderBeverageID = new int[10];
    private int[] orderQuantity = new int[10];
    private Topping[] orderTopping = new Topping[10];
    private int[] orderToppingID = new int[10];

    private double[] orderSubTotal = new double[10];
    private String orderCust;
    private double orderFTotal;
    private double orderSTotal;
    private double orderPaid;
    private static int orderID = 10001;
    private double discount = 0;
    private static double taxes = 0.06;
    private static int noOfBeverage = 0;

    public Order() {
        this.orderFTotal = 0;
    }

    public Order(Beverage[] orderBeverage, int[] orderBeverageID, int[] orderQuantity, Topping[] orderTopping, int[] orderToppingID, double[] orderSubTotal, String orderCust, double orderFTotal, double orderSTotal, double orderPaid, double discount) {
        this.orderBeverage = orderBeverage;
        this.orderBeverageID = orderBeverageID;
        this.orderQuantity = orderQuantity;
        this.orderTopping = orderTopping;
        this.orderToppingID = orderToppingID;
        this.orderCust = orderCust;
        this.orderSubTotal = orderSubTotal;
        this.orderFTotal = orderFTotal;
        this.orderSTotal = orderSTotal;
        this.orderPaid = orderPaid;
        this.discount = discount;
        Order.orderID++;
    }

    public Beverage[] getOrderBeverage() {
        return this.orderBeverage;
    }

    public Topping[] getOrderTopping() {
        return this.orderTopping;
    }

    public int[] getOrderBeverageID() {
        return this.orderBeverageID;
    }

    public int[] getOrderToppingID() {
        return this.orderToppingID;
    }

    public int[] getOrderQuantity() {
        return this.orderQuantity;
    }

    public double getOrderFTotal() {
        return this.orderFTotal;
    }

    public double getOrderSTotal() {
        return this.orderSTotal;
    }

    public String getOrderCust() {
        return orderCust;
    }

    public double[] getOrderSubTotal() {
        return this.orderSubTotal;
    }

    public double getOrderPaid() {
        return this.orderPaid;
    }

    public static int getOrderID() {
        return Order.orderID;
    }

    public double getDiscount() {
        return this.discount;
    }

    public static double getTaxes() {
        return Order.taxes;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public void setOrderCust(String orderCust) {
        this.orderCust = orderCust;
    }

    public void setOrderBeverage(Beverage[] orderBeverage) {
        this.orderBeverage = orderBeverage;
    }

    public void setOrderTopping(Topping[] orderTopping) {
        this.orderTopping = orderTopping;
    }

    public void setOrderID(int[] orderBeverageID) {
        this.orderBeverageID = orderBeverageID;
    }

    public void setToppingID(int[] orderToppingID) {
        this.orderToppingID = orderToppingID;
    }

    public void setOrderFTotal(double orderFTotal) {
        this.orderFTotal = orderFTotal;
    }

    public void setOrderQuantity(int[] orderQuantity) {
        this.orderQuantity = orderQuantity;
    }

    public void addOrderBeverage(Beverage orderBeverage) {
        this.orderBeverage[noOfBeverage] = orderBeverage;
    }

    public void addOrderTopping(Topping orderTopping) {
        this.orderTopping[noOfBeverage] = orderTopping;
    }

    public void addBeverageID(int beverageID) {
        this.orderBeverageID[noOfBeverage] = beverageID;
    }

    public void addBeverageQuantity(int beverageQty) {
        this.orderQuantity[noOfBeverage] = beverageQty;
    }

    public void addOrderToppingID(int toppingID) {
        this.orderToppingID[noOfBeverage] = toppingID;
    }

    public void addBeverageTotal(double beverageTotal) {
        this.orderSubTotal[noOfBeverage] = beverageTotal;
        Order.noOfBeverage++;
    }

    public double calChanges(double pay) {
        double total = this.orderFTotal;
        this.orderPaid = pay;
        total = pay - this.orderFTotal;
        return total;
    }

    public double calTotal() {
        double total = 0;
        for (int i = 0; i < noOfBeverage; i++) {
            total += this.orderSubTotal[i];
        }
        this.orderSTotal = total;
        return total;
    }

    public double calFinalTotal() {
        double subtotal = 0;
        double total = 0;
        subtotal = this.orderSTotal;
        total = subtotal - (subtotal * this.discount) + (subtotal * taxes);
        this.orderFTotal = total;
        return total;
    }

    public static void IncOrderID() {
        Order.orderID++;
    }

    public static void resetNo() {
        Order.noOfBeverage = 0;
    }

    public static void summary(Order[] order) {
        double total = 0;
        int totalQty = 0;

        System.out.print("\nTotal Sales : RM ");
        for (int i = 0; i < order.length; i++) {
            total += order[i].getOrderFTotal();
        }
        System.out.printf("%7.2f\n\n", total);

        for (int i = 0; i < order.length; i++) {
            int[] quantity = order[i].getOrderQuantity();;
            for (int j = 0; j < quantity.length; j++) {
                totalQty += quantity[j];
            }
        }
        System.out.print("Total Beverage Quantity Purchased: ");
        System.out.printf("%3d\n\n", totalQty);

    }

    public static void generateReceipt(int itemCount, int orderCount, String staff) {
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        DecimalFormat decFormat = new DecimalFormat("#%");

        int[] id = order[orderCount].getOrderBeverageID();
        Beverage[] beverage = order[orderCount].getOrderBeverage();
        Topping[] topping = order[orderCount].getOrderTopping();
        int[] qty = order[orderCount].getOrderQuantity();
        double[] subtotal = order[orderCount].getOrderSubTotal();
        double subTotal = order[orderCount].getOrderSTotal();
        double total = order[orderCount].getOrderFTotal();
        double pay = order[orderCount].getOrderPaid();

        System.out.println("\n\n			                 RECEIPT ");
        System.out.println("************************************************************************************************");
        System.out.println("*                                  GUAN WEN CHA JI MALAYSIA                                    *");
        System.out.println("*                                      Tel : 089-888888                                        *");
        System.out.println("*                                 guanwenchaji0904@gmail.com                                   *");
        System.out.println("*                             29, Jalan 11/62a, Bandar Menjalara,                              *");
        System.out.println("*                    52200 Kuala Lumpur, Wilayah Persekutuan Kuala Lumpur                      *");
        System.out.println("************************************************************************************************");
        System.out.printf("*Employee   : %-81s*\n", staff);
        System.out.println("*Order Date : " + formattedDate + "                                                              *");
        System.out.println("*Order ID   : " + order[orderCount].getOrderID() + "                                                                            *");
        System.out.printf("*Customer Name : %-78s*\n", order[orderCount].getOrderCust());
        System.out.println("*                                                                                              *");
        System.out.println("*------------+--------------------------------+------------+--------+---------+----------------*");
        System.out.printf("*%-12s|%-32s|%-12s|%8s|%9s|%16s*\n", "Beverage ID", "Beverage Name", "Topping", "Quantity", "Price(RM)", "Subtotal(RM)");
        System.out.println("*------------+--------------------------------+------------+--------+---------+----------------*");
        for (int i = 0; i < itemCount; i++) {

            System.out.printf("*%12d|%-29s(%c)|%-12s|%8d|%9.2f|%16.2f*\n", id[i], beverage[i].getName(), beverage[i].getSize(), topping[i].getName(), qty[i], beverage[i].getPrice(), subtotal[i]);
        }
        System.out.println("*------------+--------------------------------+------------+--------+---------+----------------*");
        System.out.printf("*                                                                                              *\n");
        System.out.printf("*                                                                                              *\n");
        System.out.printf("*                                                                SubTotal     :  RM %7.2f    *\n", subTotal);
        System.out.printf("*                                                                Discount     :  %2s            *\n", decFormat.format(order[orderCount].getDiscount()));
        System.out.printf("*                                                                Taxes        :  %2s            *\n", decFormat.format(order[orderCount].getTaxes()));
        System.out.printf("*                                                                Total        :  RM %7.2f    *\n", total);
        System.out.printf("*                                                                Amount Pay   :  RM %7.2f    *\n", pay);
        System.out.printf("*                                                                Changes      :  RM %7.2f    *\n", order[orderCount].calChanges(pay));
        System.out.println("*----------------------------------------------------------------------------------------------*");
        System.out.println("*                                THANK YOU, PLEASE COME AGAIN !                                *");
        System.out.println("*                              BUSINESS HOUR :  11:00AM -- 9:00PM                              *");
        System.out.println("************************************************************************************************\n\n");
    }

    public static void payment(int orderCount) {
        DecimalFormat decFormat = new DecimalFormat("#%");
        Scanner input = new Scanner(System.in);
        System.out.printf("\n\nSubtotal             : RM %5.2f\n", order[orderCount].calTotal());
        System.out.println("Discount             :  " + decFormat.format(order[orderCount].getDiscount()));
        System.out.println("Taxes                :  " + decFormat.format(order[orderCount].getTaxes()));
        System.out.printf("Total Amount         : RM %5.2f\n", order[orderCount].calFinalTotal());
        int suff = 0;
        do {
            double paidAmount = 0;
            suff = 0;
            System.out.print("Enter The Amount Paid: RM ");
            paidAmount = input.nextDouble();
            if (paidAmount < order[orderCount].getOrderFTotal()) {
                suff = 1;
                System.out.println("Insufficient Amount Paid, Please Enter Again");
            } else {
                System.out.printf("Changes              : RM %5.2f\n\n", order[orderCount].calChanges(paidAmount));
            }

        } while (suff == 1);
    }

    public static void acceptOrder(String staff, int orderCount, Product[] prod) {

        DecimalFormat decFormat = new DecimalFormat("#%");
        int i = 0;
        int found = 0;

        String selection;

        do {
            Scanner input = new Scanner(System.in);
            Scanner input1 = new Scanner(System.in);
            int found1 = 0;
            int arrayCount = 0;
            Beverage[] orderBeverage = new Beverage[30];
            String[] orderBName = new String[30];
            int[] orderBID = new int[30];
            int[] orderBQty = new int[30];
            double[] orderBeveragePrice = new double[30];
            char[] orderBeverageSize = new char[30];
            Topping[] orderTopping = new Topping[30];
            String[] orderTName = new String[30];
            int[] orderTID = new int[30];
            double[] orderToppingPrice = new double[30];
            char[] orderToppingSize = new char[30];
            double[] orderSubTotal = new double[30];
            String[] orderCusName = new String[30];
            double discount = 0;

            int itemCount = 0;
            double paidAmount = 0;
            int suff = 0;
            int option1;

            order[orderCount].resetNo();
            String staffname = staff;

            System.out.println("Order ID: " + Order.getOrderID());
            do {
                System.out.print("Customer Name: ");
                orderCusName[orderCount] = input.nextLine();
                for (i = 0; i < member.length; i++) {
                    if (member[i] != null) {
                        if (orderCusName[orderCount].equals(member[i].getName())) {
                            found1 = 1;
                            if(member[i] instanceof Classic){
                                order[orderCount].setDiscount(Classic.getDiscount());
                            }else if (member[i] instanceof Premium){
                                order[orderCount].setDiscount(Premium.getDiscount());
                            }else 
                                 order[orderCount].setDiscount(NonMember.getDiscount());
                            order[orderCount].setOrderCust(orderCusName[orderCount]);
                            arrayCount = i;
                        }
                    }
                }
                if (found1 == 0) {

                    System.out.println("\nNo Matched Customer Name Found.");
                    System.out.println("Continue as a no name customer?");
                    System.out.println("1. Yes.");
                    System.out.println("2. No. I wan to enter again");
                    do {
                        System.out.print("Enter Your Option: ");
                        option1 = input1.nextInt();
                        if (option1 == 1) {
                            found1 = 1;
                            orderCusName[orderCount] = "Non-registered Customer";
                            order[orderCount].setOrderCust(orderCusName[orderCount]);
                        } else if (option1 == 2) {
                            found = 0;
                        } else {
                            System.out.println("Invalid option");
                        }
                    } while (option1 < 1 || option1 > 2);

                }

            } while (found1 == 0);

            if (orderCusName[orderCount].equals("Non-registered Customer")) {
                System.out.println("Customer Type = Non-registered Customer");

            } else {
                System.out.println("Customer Type = " + member[arrayCount].getMemberType());
            }

            System.out.println("Discount Applied = " + decFormat.format(order[orderCount].getDiscount()));
            do {

                do {
                    found = 0;
                    int toppingChoice = 0;
                    int toppingNo = 0;
                    System.out.print("\nBeverage ID: ");

                    orderBID[itemCount] = input1.nextInt();
                    for (i = 0; i < prod.length; i++) {
                        if (prod[i] != null) {
                            if (orderBID[itemCount] - prod[i].getProdNo() == 0) {
                                if ((orderBID[itemCount] - 2000) < 0) {
                                    if (prod[i] != null) {
                                        found = 1;
                                        orderBName[itemCount] = prod[i].getName();
                                        System.out.println("Beverage Name           : " + prod[i].getName() + " (" + prod[i].getSize() + ")");
                                        orderBeverageSize[itemCount] = prod[i].getSize();
                                        System.out.println("Beverage Price          : " + prod[i].getPrice());
                                        orderBeveragePrice[itemCount] = prod[i].getPrice();
                                        System.out.printf("Enter Quantity          : ");
                                        orderBQty[itemCount] = input1.nextInt();

                                        System.out.println("\nTopping List             ");
                                        for (int j = 0; j < prod.length; j++) {
                                            if (prod[j] != null) {
                                                if (prod[j].getProdNo() - 2000 > 0) {
                                                    toppingNo += 1;
                                                    System.out.println(toppingNo + ". " + prod[j].getName());
                                                }
                                            }
                                        }

                                        toppingNo += 1;
                                        System.out.println(toppingNo + ". None ");
                                        do {
                                            System.out.print("Enter Topping number : ");
                                            toppingChoice = input1.nextInt();

                                            if (toppingChoice < 1 || toppingChoice > toppingNo) {
                                                System.out.print("Invalid Choice, Please Enter Again\n");
                                            }

                                        } while (toppingChoice < 1 || toppingChoice > toppingNo);

                                        if (toppingChoice == toppingNo) {
                                            orderTID[itemCount] = 0;
                                        } else {
                                            orderTID[itemCount] = 2000 + toppingChoice;
                                        }
                                        orderTName[itemCount] = "None";

                                        for (int p = 0; p < prod.length; p++) {
                                            if (prod[p] != null) {
                                                if (orderTID[itemCount] - prod[p].getProdNo() == 0) {
                                                    orderToppingPrice[itemCount] = prod[p].getPrice();
                                                    orderTName[itemCount] = prod[p].getName();
                                                    orderToppingSize[itemCount] = prod[p].getSize();
                                                }
                                            }
                                        }
                                        orderBeverage[orderCount] = new Beverage(orderBName[itemCount], orderBeveragePrice[itemCount], orderBeverageSize[itemCount]);
                                        orderTopping[orderCount] = new Topping(orderTName[itemCount], orderToppingPrice[itemCount], orderToppingSize[itemCount]);
                                        orderSubTotal[itemCount] = prod[i].getPrice() * orderBQty[itemCount] + orderToppingPrice[itemCount];
                                        order[orderCount].addOrderBeverage(orderBeverage[orderCount]);
                                        order[orderCount].addOrderTopping(orderTopping[orderCount]);
                                        order[orderCount].addOrderToppingID(orderTID[itemCount]);
                                        order[orderCount].addBeverageID(orderBID[itemCount]);
                                        order[orderCount].addBeverageQuantity(orderBQty[itemCount]);
                                        order[orderCount].addBeverageTotal(orderSubTotal[itemCount]);

                                        System.out.printf("\nSubtotal                : RM %5.2f \n\n", orderSubTotal[itemCount]);
                                        itemCount++;
                                    }
                                } else {
                                    found = 2;
                                    System.out.println("The following ID is Topping ID, Please Enter Valid Beverage ID");
                                }
                            }
                        }
                    }
                    if (found == 0) {
                        System.out.println("Invalid Beverage ID,Please Enter Again");
                    }
                } while (found == 0 || found == 2);

                do {

                    System.out.printf("Next Item?(Y=Yes || N=No) :");
                    selection = input.next();

                    if (!(selection.equalsIgnoreCase("Y") || selection.equalsIgnoreCase("N"))) {
                        System.out.println("Invalid Command, Please Enter Again");
                    }

                } while (!(selection.equalsIgnoreCase("Y") || selection.equalsIgnoreCase("N")));

            } while (selection.equalsIgnoreCase("Y"));

            Order.payment(orderCount);

            do {
                System.out.printf("Generate Receipt?(Y=yes || y=yes) :");
                selection = input.next();
                if (selection.equalsIgnoreCase("Y")) {
                    Order.generateReceipt(itemCount, orderCount, staffname);
                }
                if (!(selection.equalsIgnoreCase("Y") || selection.equalsIgnoreCase("N"))) {
                    System.out.println("Invalid Command, Please Enter Again");
                }

            } while (!(selection.equalsIgnoreCase("Y") || selection.equalsIgnoreCase("N")));

            do {
                System.out.printf("Next Order?(Y=yes || y=yes) :");
                selection = input.next();

                if (!(selection.equalsIgnoreCase("Y") || selection.equalsIgnoreCase("N"))) {
                    System.out.println("Invalid Command, Please Enter Again");
                }

            } while (!(selection.equalsIgnoreCase("Y") || selection.equalsIgnoreCase("N")));

            order[orderCount].IncOrderID();
            orderCount++;
        } while (selection.equalsIgnoreCase("Y"));
    }

}
