package com.mycompany.ooptassign;

import static java.lang.Character.toUpperCase;
import java.util.Scanner;

/* @author GUAN WEN */
public abstract class Member {

    public static Member[] member = new Member[150];
    static Scanner input = new Scanner(System.in);
    private String name;
    private String memberType;
    private String memberTel;
    
    public abstract int getMemberID();
    
    public abstract int getNextMemberID();

    public static void displayMember(Member[] member) {
        int choice;
        do {
            choice = memberMenu();

            if (choice == 1) {
                for (int i = 0; i < member.length; i++) {
                    if (member[i] == null) {
                        member[i] = member[0].addMember();
                        break;
                    }
                }
            } else if (choice == 2) {
                member[0].modifyMember(member);
            } else if (choice == 3) {
                member[0].deleteMember(member);
            } else if (choice == 4) {
                int mmDisplay = member[0].displayMemberMenu();

                if (mmDisplay == 1) {
                    System.out.print("""
                         +--------------------------------------------------------------------------------------------------+
                         |   MEMBER ID   |           NAME            |    MEMBER TYPE    |   No. Telephone   |   DISCOUNT   |
                         +--------------------------------------------------------------------------------------------------+\n""");
                    for (int i = 0; i < member.length; i++) {
                        if (member[i] instanceof Classic) {
                            member[i].displayMember();
                            System.out.print("\n");
                        }
                    }
                    System.out.println("+--------------------------------------------------------------------------------------------------+");

                } else if (mmDisplay == 2) {
                    System.out.print("""
                         +--------------------------------------------------------------------------------------------------+
                         |   MEMBER ID   |           NAME            |    MEMBER TYPE    |   No. Telephone   |   DISCOUNT   |
                         +--------------------------------------------------------------------------------------------------+\n""");
                    for (int i = 0; i < member.length; i++) {
                        if (member[i] instanceof Premium) {
                            member[i].displayMember();
                            System.out.print("\n");
                        }
                    }
                    System.out.println("+--------------------------------------------------------------------------------------------------+");

                } else {
                    System.out.print("""
                         +--------------------------------------------------------------------------------------------------+
                         |   MEMBER ID   |           NAME            |    MEMBER TYPE    |   No. Telephone   |   DISCOUNT   |
                         +--------------------------------------------------------------------------------------------------+\n""");

                    for (int i = 0; i < member.length; i++) {
                        if (member[i] instanceof NonMember) {
                            member[i].displayMember();
                            System.out.print("\n");
                        }
                    }
                    System.out.println("+--------------------------------------------------------------------------------------------------+");
                }
            }

        } while (choice != 5);

    }

    public static Member addMember() {
        boolean valid;

        System.out.print("Enter name : ");
        input.nextLine();
        String username = input.nextLine();

        System.out.print("Enter the member type(Classic/Premium/Non-Member) : ");
        String mmType = input.nextLine();

        do {
            if (mmType.equals("Classic") || mmType.equals("Premium") || mmType.equals("Non-Member")) {
                valid = true;
            } else {
                System.out.println("\nInvalid member type, please try again");
                System.out.print("Enter the member type(Classic/Premium/Non-Member) : ");
                mmType = input.next();
                valid = false;
            }
        } while (valid != true);

        System.out.print("Enter the No. telephone (with -) : ");
        String telephone = input.next();

        System.out.println("\nAdd Successful !");
        if (mmType.equals("Classic")) {
            Member newMember = new Classic(username, mmType, telephone);
            return newMember;
        } else if (mmType.equals("Premium")) {
            Member newMember = new Premium(username, mmType, telephone);
            return newMember;
        } else {
            Member newMember = new NonMember(username, mmType, telephone);
            return newMember;
        }
    }

    public void modifyMember(Member[] member) {
        int editOption;

        System.out.print("""
                         +-----------------------------------------------------------------------------------------------------------+
                         |   No.  |   MEMBER ID   |           NAME            |    MEMBER TYPE    |   No. Telephone   |   DISCOUNT   |
                         +-----------------------------------------------------------------------------------------------------------+\n""");

        for (int i = 0; i < member.length; i++) {
            if (member[i] != null) {
                System.out.printf("| %-6d ", (i + 1));
                member[i].displayMember();
                System.out.print("\n");
            }
        }

        System.out.println("+-----------------------------------------------------------------------------------------------------------+");
        System.out.print("Enter the number you want to edit : ");
        int editNo = input.nextInt();

        while (editNo < 1 || member[editNo - 1] == null) {
            System.out.println("The number you entered does not exist, please try again...\n");
            System.out.print("Enter the number you want to edit : ");
            editNo = input.nextInt();
            System.out.print("\n");
        }
        System.out.print("""
                         +-------------------------------------------------------------------+
                         |            NAME           |    MEMBER TYPE    |   No. Telephone   |
                         +-------------------------------------------------------------------+\n""");
        System.out.println(member[editNo - 1]);
        System.out.println("+-------------------------------------------------------------------+");

        if (member[editNo - 1] != null) {
            System.out.println("---------Modify Member Menu---------");
            System.out.println("1. Name");
            System.out.println("2. Telephone No.");
            System.out.println("3. Back");

            System.out.print("\nEnter an option you want to modify : ");
            editOption = input.nextInt();

            while (editOption > 3 || editOption < 1) {
                System.out.println("Invalid option, please try again...");
                System.out.print("Enter an option you want to modify : ");
                editOption = input.nextInt();
            }

            switch (editOption) {
                case 1:
                    System.out.printf("\nNew name for No.%d : ", editNo);
                    input.nextLine();
                    String newMemberName = input.nextLine();
                    System.out.printf("Confirm change No.%d's name to %s ? (Y/N) : ", editNo, newMemberName);
                    char confirm = input.next().charAt(0);
                    if (toUpperCase(confirm) == 'Y') {
                        member[editNo - 1].setName(newMemberName);
                        System.out.println("\nModify Successfully !\n");
                    } else {
                        System.out.println("\nModify failed....\n");
                    }
                    break;

                case 2:
                    System.out.printf("\nNew No. telephone for No.%d : ", editNo);
                    input.nextLine();
                    String newMemberTelNo = input.nextLine();
                    System.out.printf("Confirm change No.%d's No. telephone to %s ? (Y/N) : ", editNo, newMemberTelNo);
                    confirm = input.next().charAt(0);
                    if (toUpperCase(confirm) == 'Y') {
                        member[editNo - 1].setMemberTel(newMemberTelNo);
                        System.out.println("\nModify Successfully !\n");
                    } else {
                        System.out.println("\nModify failed....\n");
                    }
                    break;

                case 3:
                    break;
            }
        } else {
            System.out.println("The number is invalid...");
        }
    }

    public static int memberMenu() {
        int choice;
        System.out.println("+---------------------------+");
        System.out.println("|        MEMBER MENU        |");
        System.out.println("+---------------------------+");
        System.out.println("|    1.   Add Member        |");
        System.out.println("|    2.   Modify Member     |");
        System.out.println("|    3.   Delete Member     |");
        System.out.println("|    4.   Display Member    |");
        System.out.println("|    5.   Back              |");
        System.out.println("+---------------------------+");
        System.out.print("\n\nEnter your choice : ");
        choice = input.nextInt();

        while (choice > 5 || choice < 1) {
            System.out.println("Invalid choice, please try again...");
            System.out.print("\nEnter your choice : ");
            choice = input.nextInt();
        }

        return choice;
    }

    public int displayMemberMenu() {
        int mmDisplay;

        System.out.println("--------Member Display Menu--------");
        System.out.println("1. Classic");
        System.out.println("2. Premium");
        System.out.println("3. Non-Member");
        System.out.println("4. Back");

        System.out.print("\nEnter an option : ");
        mmDisplay = input.nextInt();

        while (mmDisplay < 1 || mmDisplay > 4) {
            System.out.println("Invalid option, please try again");
            System.out.print("Enter option : ");
            mmDisplay = input.nextInt();
            System.out.print("\n");
        }
        return mmDisplay;
    }

    public void deleteMember(Member[] member) {
        System.out.print("""
                         +-----------------------------------------------------------------------------------------------------------+
                         |   No.  |   MEMBER ID   |           NAME            |    MEMBER TYPE    |   No. Telephone   |   DISCOUNT   |
                         +-----------------------------------------------------------------------------------------------------------+\n""");
        for (int i = 0; i < member.length; i++) {
            if (member[i] != null) {
                System.out.printf("| %-6d ", (i + 1));
                member[i].displayMember();
                System.out.print("\n");
            }
        }
        System.out.println("+-----------------------------------------------------------------------------------------------------------+");
        System.out.print("Enter the number you want to delete : ");
        int deleteNo = input.nextInt();

        while (deleteNo < 1 || member[deleteNo - 1] == null) {
            System.out.println("The number you entered does not exist, please try again...\n");
            System.out.print("Enter the number you want to delete : ");
            deleteNo = input.nextInt();
        }

        if (member[deleteNo - 1] != null) {
            System.out.print("""
                         +-------------------------------------------------------------------+
                         |            NAME           |    MEMBER TYPE    |   No. Telephone   |
                         +-------------------------------------------------------------------+\n""");
            System.out.println(member[deleteNo - 1]);
            System.out.println("+-------------------------------------------------------------------+\n");
            System.out.print("Confirm to delete this member ? (Y/N)");
            char confirmDlt = input.next().charAt(0);
            if (toUpperCase(confirmDlt) == 'Y') {
                for (int j = (deleteNo - 1); j < (member.length - 1); j++) {
                    member[j] = member[j + 1];
                }
                System.out.println("\nDelete Successfully !\n");
            } else {
                System.out.println("\nDelete failed...\n");
            }
        } else {
            System.out.println("Error number...\n");
        }
    }

    public Member(String name, String memberType, String memberTel) {
        this.name = name;
        this.memberType = memberType;
        this.memberTel = memberTel;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMemberType() {
        return this.memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }
    
    public void setMemberTel(String memberTel) {
        this.memberTel = memberTel;
    }
    
    public String getMemberTel() {
        return this.memberTel;
    }

    public String toString() {
        return String.format("| %-25s | %-17s | %-17s |", this.getName(), this.getMemberType(), this.getMemberTel());
    }

    public abstract void displayMember();

}
