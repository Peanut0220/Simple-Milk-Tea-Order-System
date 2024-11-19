package com.mycompany.ooptassign;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/*
 * @author Tang Qiao Ling
 */
public abstract class Product {

    private String name;
    private double price;
    private char size;
    private String displaySize;
    private int prodNo;

    public Product() {
    }

    public Product(String name, double price, char size) {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setSize(char size) {
        this.size = size;
    }

    public char getSize() {
        return this.size;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public int getProdNo() {
        return this.prodNo;
    }

    public static void displayProdMenu(Product[] prod) {
        int selection;
        do {
            selection = productMenu();

            //call method
            if (selection == 1) {

                int prodSel = prod[0].displayProdMenu();

                if (prodSel == 1) {
                    System.out.print("""
               -----------------------------------------------------------------------
               | ID   | Beverage                        | Size       | Price         |
               -----------------------------------------------------------------------
               """);

                    for (int i = 0; i < prod.length; i++) {
                        if (prod[i] instanceof Beverage) {
                            prod[i].displayProduct();
                            System.out.print("\n");
                        }
                    }
                } else if (prodSel == 2) {
                    System.out.print("""
               -----------------------------------------------------------------------
               | ID   | Topping                         | Size       | Price         |
               -----------------------------------------------------------------------
               """);
                    for (int i = 0; i < prod.length; i++) {
                        if (prod[i] instanceof Topping) {
                            prod[i].displayProduct();
                            System.out.print("\n");
                        }
                    }
                }
                if (prodSel != 3) {
                    System.out.println("-----------------------------------------------------------------------\n");
                }

            } else if (selection == 2) {

                int prodSel = prod[0].addProdMenu();

                if (prodSel == 1) {
                    for (int i = 0; i < prod.length; i++) {
                        if (prod[i] == null) {
                            prod[i] = prod[0].addBev();
                            break;
                        }
                    }
                } else if (prodSel == 2) {
                    for (int i = 0; i < prod.length; i++) {
                        if (prod[i] == null) {
                            prod[i] = prod[0].addTop();
                            break;
                        }
                    }
                }

            } else if (selection == 3) {
                prod[0].editProd(prod);
            } else if (selection == 4) {
                prod[0].deleteProd(prod);
            }

        } while (selection != 5);
    }

    public Product addBev() {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        char size;
        double price;

        System.out.println("----- Add Beverage -----");
        System.out.print("Enter Name: ");
        String name = input.nextLine();

        System.out.print("Enter Price: ");
        price = input.nextDouble();

        do {
            System.out.print("Enter Size(M/L/S): ");
            size = input.next().charAt(0);

            if (toUpperCase(size) != 'M' && toUpperCase(size) != 'L' && toUpperCase(size) != 'S') {
                System.out.print("\n");
                System.out.println("Error Size Selection!");
                System.out.print("Enter again(M/L/S): ");
                size = input.next().charAt(0);
            }
        } while (toUpperCase(size) != 'M' && toUpperCase(size) != 'L' && toUpperCase(size) != 'S');

        Product newBev = new Beverage(name, price, size);
        System.out.print("\n");
        return newBev;
    }

    public Product addTop() {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        char size;
        System.out.println("----- Add Topping -----");
        System.out.print("Enter Name: ");
        String name = input.nextLine();
        System.out.print("Enter Price: ");
        double price = input.nextDouble();
        do {
            System.out.print("Enter Size(M/L/S): ");
            size = input.next().charAt(0);

            if (toUpperCase(size) != 'M' && toUpperCase(size) != 'L' && toUpperCase(size) != 'S') {
                System.out.print("\n");
                System.out.println("Error Size Selection!");
                System.out.print("Enter again(M/L/S): ");
                size = input.next().charAt(0);
            }
        } while (toUpperCase(size) != 'M' && toUpperCase(size) != 'L' && toUpperCase(size) != 'S');
        Product newTop = new Topping(name, price, size);
        System.out.print("\n");
        return newTop;
    }

    public String toString() {
        if (this.size == 'S' || this.size == 's') {
            displaySize = "Standard";
        } else if (this.size == 'M' || this.size == 'm') {
            displaySize = "Medium";
        } else if (this.size == 'L' || this.size == 'l') {
            displaySize = "Large";
        }

        return String.format("| %-31s | %-10s | %-13.2f |",
                this.getName(), this.displaySize, this.getPrice());
    }

    public static int productMenu() {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        int selection;
        System.out.println("------ Menu ------");
        System.out.println("1. Display Product");
        System.out.println("2. Add Product");
        System.out.println("3. Edit Product");
        System.out.println("4. Delete Product");
        System.out.println("5. Back");
        System.out.print("\nEnter Selection: ");
        selection = input1.nextInt();
        System.out.print("\n");

        while (selection > 5 || selection < 1) {
            System.out.println("Invalid selection!");
            System.out.print("Enter again: ");
            selection = input1.nextInt();
            System.out.print("\n");
        }
        return selection;
    }

    public int displayProdMenu() {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        int prodSel;

        System.out.println("------ Display Menu ------");
        System.out.println("1. Beverage");
        System.out.println("2. Topping");
        System.out.println("3. Back");
        System.out.print("\nEnter Selection: ");
        prodSel = input1.nextInt();
        System.out.print("\n");

        while (prodSel > 3 || prodSel < 1) {
            System.out.println("Invalid selection!");
            System.out.print("Enter again: ");
            prodSel = input1.nextInt();
            System.out.print("\n");
        }

        return prodSel;
    }

    public int addProdMenu() {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        int prodSel;
        System.out.println("------ Add Menu ------");
        System.out.println("1. Beverage");
        System.out.println("2. Topping");
        System.out.println("3. Back");
        System.out.print("\nEnter Selection: ");
        prodSel = input1.nextInt();
        System.out.print("\n");

        while (prodSel > 3 || prodSel < 1) {
            System.out.println("Invalid selection!");
            System.out.print("Enter again: ");
            prodSel = input1.nextInt();
            System.out.print("\n");
        }
        return prodSel;
    }

    public void editProd(Product[] prod) {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        int editSel;
        System.out.print("""
               -----------------------------------------------------------------------------
               | No. | ID   | Product                         | Size       | Price         |
               -----------------------------------------------------------------------------
               """);
        for (int i = 0; i < prod.length; i++) {
            if (prod[i] != null) {
                System.out.printf("| %-3d ", (i + 1));
                prod[i].displayProduct();
                System.out.print("\n");
            }
        }
        System.out.println("-----------------------------------------------------------------------------\n");
        System.out.print("Enter no. that wished to edit: ");
        int no = input1.nextInt();

        while (no < 1 || prod[no - 1] == null) {
            System.out.println("Error No.\n");
            System.out.print("Enter again: ");
            no = input1.nextInt();
            System.out.print("\n");
        }

        System.out.println("\n" + (prod[no - 1]));

        if (prod[no - 1] != null) {
            System.out.println("\n------ Beverage Edit Menu ------");
            System.out.println("1. Name");
            System.out.println("2. Price");
            System.out.println("3. Size");
            System.out.println("4. Back");
            System.out.print("\nEnter Option: ");
            editSel = input1.nextInt();
            System.out.print("\n");

            while (editSel > 4 || editSel < 1) {
                System.out.println("Invalid selection!");
                System.out.print("Enter again: ");
                editSel = input1.nextInt();
                System.out.print("\n");
            }

            switch (editSel) {
                case 1:
                    System.out.print("New Name: ");
                    String newName = input.nextLine();
                    System.out.print("Confirm edit(Y/N)? ");
                    char confirm = input.next().charAt(0);
                    if (toUpperCase(confirm) == 'Y') {
                        prod[no - 1].setName(newName);
                        System.out.println("\nEdit Sucessfully.\n");
                    } else {
                        System.out.println("\nEdit failed.\n");
                    }

                    break;

                case 2:
                    System.out.print("New Price: ");
                    double newPrice = input.nextDouble();
                    System.out.print("Confirm edit(Y/N)? ");
                    confirm = input.next().charAt(0);
                    if (toUpperCase(confirm) == 'Y') {
                        prod[no - 1].setPrice(newPrice);
                        System.out.println("\nEdit Sucessfully.\n");
                    } else {
                        System.out.println("\nEdit failed.\n");
                    }
                    break;

                case 3:
                    char newSize;
                    do {
                        System.out.print("Enter New Size(M/L/S): ");
                        newSize = input.next().charAt(0);

                        if (toUpperCase(newSize) != 'M' && toUpperCase(newSize) != 'L' && toUpperCase(newSize) != 'S') {
                            System.out.print("\n");
                            System.out.println("Error New Size Selection!");
                            System.out.print("Enter again(M/L/S): ");
                            newSize = input.next().charAt(0);
                        }
                    } while (toUpperCase(newSize) != 'M' && toUpperCase(newSize) != 'L' && toUpperCase(newSize) != 'S');

                    System.out.print("Confirm edit(Y/N)? ");
                    confirm = input.next().charAt(0);
                    if (toUpperCase(confirm) == 'Y') {
                        prod[no - 1].setSize(newSize);
                        System.out.println("\nEdit Sucessfully.\n");
                    } else {
                        System.out.println("\nEdit failed.\n");
                    }
            }
        } else {
            System.out.println("Error No.\n");
        }
    }

    public void deleteProd(Product[] prod) {
        Scanner input = new Scanner(System.in);
        Scanner input1 = new Scanner(System.in);
        System.out.print("""
               -----------------------------------------------------------------------------
               | No. | ID   | Product                         | Size       | Price         |
               -----------------------------------------------------------------------------
               """);
        for (int i = 0; i < prod.length; i++) {
            if (prod[i] != null) {
                System.out.printf("| %-3d ", (i + 1));
                prod[i].displayProduct();
                System.out.print("\n");
            }
        }
        System.out.println("-----------------------------------------------------------------------------\n");
        System.out.print("Enter no. that wished to delete: ");
        int no = input1.nextInt();

        while (no < 1 || prod[no - 1] == null) {
            System.out.println("Error No.\n");
            System.out.print("Enter again: ");
            no = input1.nextInt();
        }

        if (prod[no - 1] != null) {
            System.out.println("\n" + (prod[no - 1]));
            System.out.print("Confirm delete(Y/N)? ");
            char confirm = input.next().charAt(0);
            if (toUpperCase(confirm) == 'Y') {
                for (int j = (no - 1); j < (prod.length - 1); j++) {
                    prod[j] = prod[j + 1];
                }
                System.out.println("\nDelete Sucessfully.\n");
            } else {
                System.out.println("\nDelete failed.\n");
            }
        } else {
            System.out.println("Error No.\n");
        }
    }

    public abstract void displayProduct();

}
