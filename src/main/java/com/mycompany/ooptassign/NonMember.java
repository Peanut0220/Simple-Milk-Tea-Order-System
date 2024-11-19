package com.mycompany.ooptassign;

/* @author GUAN WEN */
public class NonMember extends Member {

    private static double discount = 0.00;
    private int memberID;
    private static int nextMemberID = 301;

    public NonMember(String name, String memberType, String memberTel) {
        super(name, memberType, memberTel);
        this.memberID = NonMember.nextMemberID++;
    }

    public int getMemberID() {
        return this.memberID;
    }

    public int getNextMemberID() {
        return NonMember.nextMemberID;
    }

    public static double getDiscount() {
        return NonMember.discount;
    }

    public void displayMember() {
        System.out.printf("| %-13s %-59s %-12.2f |", this.getMemberID(), super.toString(), this.getDiscount());
    }
}
