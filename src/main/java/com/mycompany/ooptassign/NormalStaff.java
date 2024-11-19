package com.mycompany.ooptassign;

public class NormalStaff extends Staff {

    private static double salary = 1500.00;
    private static int increment = 100;
    private static double commission =100;

    public NormalStaff(String name, String password, int totalYear) {
        super(name, password, totalYear);
    }

    public double calSalary() {
        double salaryS = 0;
        salaryS = NormalStaff.salary + (this.getTotalYear() * NormalStaff.increment) + NormalStaff.commission;
        return salaryS;

    }
}
