package com.mycompany.ooptassign;

/* @author GUAN WEN */
public class Premium extends Member {

    private static double discount = 0.10;
    private int memberID;
    private static int nextMemberID = 201;

    public Premium(String name, String memberType, String memberTel) {
        super(name, memberType, memberTel);
        this.memberID = Premium.nextMemberID++;
    }

    public int getMemberID() {
        return this.memberID;
    }

    public int getNextMemberID() {
        return Premium.nextMemberID;
    }

    public static double getDiscount() {
        return Premium.discount;
    }

    public void displayMember() {
        System.out.printf("| %-13s %-59s %-12.2f |", this.getMemberID(), super.toString(), this.getDiscount());
    }
}
