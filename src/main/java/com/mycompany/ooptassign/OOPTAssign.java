package com.mycompany.ooptassign;



import java.util.Scanner;

public class OOPTAssign {

    public static Scanner input = new Scanner(System.in);
    public static Staff[] s = new Staff[4];
    public static Order[] order = new Order[30];
    public static Product[] prod = new Product[150];
    public static Member[] member = new Member[150];
    static int orderCount = 0;

    public static void main(String[] args) {

        prod[0] = new Beverage("Brown Sugar Milk Tea", 10.00, 'M');
        prod[1] = new Beverage("Brown Sugar Milk Tea", 13.00, 'L');
        prod[2] = new Beverage("Mango Frappe", 12.00, 'S');
        prod[3] = new Beverage("Fruity Party", 7.90, 'M');
        prod[4] = new Beverage("Fruity Party", 9.90, 'L');
        prod[5] = new Beverage("Cheese Green Tea", 8.90, 'M');
        prod[6] = new Beverage("Cheese Green Tea", 11.90, 'L');
        prod[7] = new Beverage("Green Tea", 6.90, 'M');
        prod[8] = new Beverage("Green Tea", 7.90, 'L');
        prod[9] = new Beverage("Mix Fruit Yogurt", 17.90, 'S');
        prod[10] = new Beverage("Dalgona Coffee", 12.90, 'S');
        prod[11] = new Topping("Grass Jelly", 2.50, 'S');
        prod[12] = new Topping("Black Pearl", 3.00, 'S');
        prod[13] = new Topping("Golden Pearl", 3.00, 'S');
        prod[14] = new Topping("Oreo", 4.00, 'S');
        prod[15] = new Topping("Nada de Coco", 2.50, 'S');

        s[0] = new Manager("ABU", "A1234", 5);
        s[1] = new NormalStaff("LILY", "C5678", 2);
        s[2] = new Manager("MUTHU", "B1010", 3);
        s[3] = new NormalStaff("BAOYI", "D1314", 1);

        member[0] = new Classic("Ng Chong Jian", "Classic", "012-5644789");
        member[1] = new Classic("Loh Thiam Wei", "Classic", "014-0908878");
        member[2] = new Premium("Law Guan Wen", "Premium", "014-9034682");
        member[3] = new Premium("Wong Bao Yi", "Premium", "018-2341156");
        member[4] = new NonMember("Tang Qiao Ling", "Non-Member", "013-8997689");
        member[5] = new NonMember("Ng Tian Chun", "Non-Member", "012-33212781");

        for (int i = 0; i < 30; i++) {
            order[i] = new Order();
        }

        displayLogin();

    }

    public static void displayLogin() {
        String name;
        int found = 0;
        int arrayCount = 0;
        int choice = 0;
        String staffname = "";
        System.out.println("\t\t--------WELCOME TO GUAN WEN CHA JI--------");
        do {
            do {
                System.out.print("\nEnter username: ");
                name = input.next();
                System.out.print("\n");

                System.out.print("Enter password: ");
                String password = input.next();

                for (int i = 0; i < s.length; i++) {
                    if (name.equals(s[i].getName()) && (password.equals(s[i].getPassword()))) {
                        found = 1;
                        arrayCount = i;
                        staffname = s[i].getName();
                    }
                }

                if (found == 0) {
                    System.out.println("\nInvalid Username and password......");
                }
            } while (found == 0);

            if (found == 1) {
                if (s[arrayCount] instanceof Manager) {
                    Staff.displayManagerPos(s, order);
                } else {
                    Staff.displayStaffPos(staffname);
                }
            }

            System.out.println("\nLoggin Out.....");
            System.out.println("Do You Want to Login Again?");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            do {
                System.out.print("Enter your choice: ");
                choice = input.nextInt();
                if (choice < 1 || choice > 2) {
                    System.out.println("Invalid Choice, Please Enter Again");
                }
            } while (choice < 1 || choice > 2);
        } while (choice == 1);

    }

}
