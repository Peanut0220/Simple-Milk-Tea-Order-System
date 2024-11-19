package com.mycompany.ooptassign;

/* @author GUAN WEN*/

public class Classic extends Member{
    private static double discount=0.05;
    private int memberID;
    private static int nextMemberID = 101;
    
    public Classic(String name, String memberType, String memberTel) {
        super(name, memberType, memberTel);
        this.memberID = Classic.nextMemberID++;
    }
    
    public int getMemberID() {
        return this.memberID;
    }
    
    public int getNextMemberID() {
        return Classic.nextMemberID;
    }
    
    public static double getDiscount(){
        return Classic.discount;
    }
    
    public void displayMember() {
        System.out.printf("| %-13s %-59s %-12.2f |", this.getMemberID(),super.toString(), this.getDiscount());
    }
    
}
