package com.mycompany.ooptassign;

import static com.mycompany.ooptassign.OOPTAssign.member;
import static com.mycompany.ooptassign.OOPTAssign.orderCount;
import static com.mycompany.ooptassign.OOPTAssign.prod;
import java.util.Scanner;

public abstract class Staff implements Comparable {

    private int staffID;
    protected String name;
    protected String password;
    private int totalYear;
    private static int lastAssignID = 1001;

    public Staff() {

    }

    public Staff(String name, String password, int totalYear) {
        this.name = name;
        this.password = password;
        this.totalYear = totalYear;
        this.staffID = lastAssignID++;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTotalYear(int totalYear) {
        this.totalYear = totalYear;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return this.name;
    }

    public int getTotalYear() {
        return this.totalYear;
    }

    public String getPassword() {
        return this.password;
    }

    public int getStaffID() {
        return this.staffID;
    }

    public static int getLastAssignID() {
        return Staff.lastAssignID;
    }

    public String toString() {
        return "Username           : " + this.name + "\n" + "Password           : " + this.password + "\n"
                + "Staff ID           : " + getStaffID() + "\n" + "Total Working Year : " + getTotalYear();
    }

    public abstract double calSalary();

    public int compareTo(Object o) {
        Staff otherStaff = (Staff) o;
        return this.name.compareTo(otherStaff.name);
    }

    public static void displayStaffPos(String staffname) {
        int choice = 0;
        int value = 0;
        Scanner input = new Scanner(System.in);
        do {
            System.out.println("\n+---------------------------------------+");
            System.out.println("|       GUAN WEN CHA JI POS SYSTEM      |");
            System.out.println("+---------------------------------------+");
            System.out.println("|        1.Accept Order                 |");
            System.out.println("|        2.Manage Member                |");
            System.out.println("|        3.Log Out                      |");
            System.out.println("+---------------------------------------+");

            System.out.print("      Enter Your Choice (1-3) : ");
            choice = input.nextInt();
            System.out.print("\n");

            while (choice < 1 || choice > 3) {
                System.out.println("Invalid option. Please enter again...\n");
                System.out.print("Enter an option: ");
                choice = input.nextInt();
            }

            switch (choice) {
                case 1:
                    Order.acceptOrder(staffname, orderCount, prod);
                    break;
                case 2:
                    Member.displayMember(member);
                    break;
                case 3:
                    break;
            }
        } while (choice != 3);

    }

    public static void displayManagerPos(Staff[] s, Order[] order) {

        int option = 0;
        Scanner input = new Scanner(System.in);

        do {
            System.out.print("\n");
            System.out.println("\t\t --------------------------- ");
            System.out.println("\t\t |   Choose an option      |");
            System.out.println("\t\t --------------------------- ");
            System.out.println("\t\t |1.Sales Summary          |");
            System.out.println("\t\t |2.Staff details Report   |");
            System.out.println("\t\t |3.Manage Product         |");
            System.out.println("\t\t |4.Log Out                |");
            System.out.println("\t\t --------------------------- \n");

            System.out.print("Enter an option: ");
            option = input.nextInt();

            while (option < 1 || option > 4) {
                System.out.println("Invalid option. Please enter again...\n");
                System.out.print("Enter an option: ");
                option = input.nextInt();
            }

            if (option == 1) {
                Order.summary(order);
            } else if (option == 2) {
                Staff.staffDetails(s);
            } else if (option == 3) {
                Product.displayProdMenu(prod);
            }else if(option == 4){
                
            }

        } while (option != 4);
    }

    public static Staff[] selectionSort(Staff[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int indexOfSmallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[indexOfSmallest]) < 0) {
                    indexOfSmallest = j;
                }
            }
            Staff tempArr = arr[indexOfSmallest];
            arr[indexOfSmallest] = arr[i];
            arr[i] = tempArr;
        }
        return arr;
    }

    public static void staffDetails(Staff[] s) {
        s = s[0].selectionSort(s);

        System.out.println("\n");

        System.out.println("----------------------------------------------------------------");
        System.out.println("|                         Staff Details                        |");
        System.out.println("----------------------------------------------------------------");

        for (int j = 0; j < s.length; j++) {
            System.out.println(s[j].toString());
            if (s[j] instanceof Manager) {
                System.out.println("Position           : Manager");
            } else {
                System.out.println("Position           : Normal Staff");

            }
            System.out.printf("\nCurrent Salary     : %-10.2f\n", s[j].calSalary());
            System.out.print("----------------------------------------------------------------\n");
        }
    }

}
