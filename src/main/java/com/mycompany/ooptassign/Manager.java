package com.mycompany.ooptassign;

public class Manager extends Staff {

    private static double salary = 2500.00;
    private static double bonusRate = 0.1;
    private static int increment = 200;

    public Manager(String name, String password, int totalYear) {
        super(name, password, totalYear);
    }

    public double calSalary() {
        double salaryM = 0;
        salaryM = Manager.salary + (this.getTotalYear() * Manager.increment) + (Manager.salary * Manager.bonusRate);
        return salaryM;

    }
}
