package com.company;

import java.util.Locale;
import java.util.Scanner;

abstract class Account {
    protected String name;
    protected int clock;
    protected double deposit;
    protected double loan;
    protected double unapproved_loan;

    //double int_rate;
    abstract boolean create_account(String name, double taka);

    abstract boolean deposit_money(double taka);

    abstract boolean withdraw(double taka);

    abstract void increase_year(double r);

    abstract void loan_req(double taka);

    abstract String get_type();

    public double approveAcc_loan() {
        double temp = unapproved_loan;
        loan += unapproved_loan;
        deposit += unapproved_loan;
        unapproved_loan = 0;
        return temp;
    }

    public boolean haveloan() {
        return (unapproved_loan > 0);
    }

    public void query() {
        System.out.print("Current Balance " + deposit + "$");
        if (loan > 0) {
            System.out.print("; loan " + loan + "$");
        }
        System.out.println(".");
    }

    public String get_name() {
        return this.name;
    }

    public Double get_deposit() {
        return this.deposit;
    }


}

class Student extends Account {

    public boolean create_account(String name, double taka) {
        this.name = name;
        this.deposit = taka;
        clock = 0;
        loan = 0.0;
        unapproved_loan = 0.0;
        System.out.println("Student account for " + name + " Created; initial balance " + taka + "$");
        return true;
    }

    public boolean deposit_money(double taka) {
        this.deposit += taka;
        System.out.println(taka + "$ deposited; current balance " + deposit + "$");
        return true;
    }

    public boolean withdraw(double taka) {
        if (taka > 10000 || deposit < taka) {
            System.out.println("Invalid transaction; current balance " + deposit + "$");
            return false;
        } else {
            this.deposit -= taka;
            System.out.println(taka + "$ Transaction successful; current balance " + deposit + "$");
            return true;
        }

    }

    public void increase_year(double int_rate) {
        double added = (deposit * int_rate) / 100.0;
        deposit += added;
        clock++;
        if (loan > 0) {
            deposit -= (loan * 10) / 100;
        }


    }

    public void loan_req(double taka) {
        if (taka > 1000) {
            System.out.println("Loan request failed.");
        } else {
            System.out.println("Loan request successful, sent for approval");
            unapproved_loan += taka;
        }
    }

    public String get_type() {
        return "Student";
    }

}

class Fixed extends Account {

    public boolean create_account(String name, double taka) {
        if (taka < 100000) {
            System.out.println("Account Can't be created for " + name);
            return false;
        } else {
            this.name = name;
            this.deposit = taka;
            clock = 0;
            loan = 0;
            unapproved_loan = 0.0;
            System.out.println("Fixed account for " + name + " Created; initial balance " + taka + "$");
            return true;
        }
    }

    public boolean deposit_money(double taka) {
        if (taka < 50000) {
            System.out.println("Insufficient to deposit for Fixed Account");
            return false;
        } else {
            this.deposit += taka;
            System.out.println(taka + "$ deposited; current balance " + deposit + "$");
            return true;
        }

    }

    public boolean withdraw(double taka) {
        if (clock < 1 || deposit < taka) {
            System.out.println("Invalid transaction; current balance " + deposit + "$");
            return false;
        } else {
            this.deposit -= taka;
            System.out.println(taka + "$ Transaction successful; current balance " + deposit + "$");
            return true;
        }

    }

    public void increase_year(double int_rate) {
        deposit -= 500;
        double added = (deposit * int_rate) / 100.0;
        deposit += added;
        clock++;
        if (loan > 0) {
            deposit -= (loan * 10) / 100;
        }

    }

    public void loan_req(double taka) {
        if (taka > 100000) {
            System.out.println("Loan request failed.");
        } else {
            System.out.println("Loan request successful, sent for approval");
            unapproved_loan += taka;
        }
    }

    public String get_type() {
        return "Fixed";
    }

}

class Savings extends Account {


    public boolean create_account(String name, double taka) {
        this.name = name;
        this.deposit = taka;
        clock = 0;
        loan = 0;
        unapproved_loan = 0.0;
        System.out.println("Savings account for " + name + " Created; initial balance " + taka + "$");
        return true;
    }

    public boolean deposit_money(double taka) {
        this.deposit += taka;
        System.out.println(taka + "$ deposited; current balance " + deposit + "$");
        return true;
    }

    public boolean withdraw(double taka) {
        if (taka < 1000 || deposit < taka) {
            System.out.println("Invalid transaction; current balance " + deposit + "$");
            return false;
        } else {
            this.deposit -= taka;
            System.out.println(taka + "$ Transaction successful; current balance " + deposit + "$");
            return true;
        }

    }

    public void increase_year(double int_rate) {
        deposit -= 500;
        double added = (deposit * int_rate) / 100.0;
        deposit += added;
        clock++;
        if (loan > 0) {
            deposit -= (loan * 10) / 100;
        }
    }

    public void loan_req(double taka) {
        if (taka > 10000) {
            System.out.println("Loan request failed.");
        } else {
            System.out.println("Loan request successful, sent for approval");
            unapproved_loan += taka;
        }
    }

    public String get_type() {
        return "Savings";
    }

}

class Employee {
    //String desig;
    public void lookup(Account ac) {
        String n = ac.get_name();
        double d = ac.get_deposit();
        System.out.println(n + "'s current balance " + d + "$");
    }

    public void change_rate(double r, bank b, String typ) {
        System.out.println("You don’t have permission for this operation");
    }

    public void see_fund(bank b) {
        System.out.println("You don’t have permission for this operation");
    }

    public boolean approve(Account[] ac, bank b) {
        System.out.println("You don’t have permission for this operation");
        return false;
    }


}

class Managing_director extends Employee {

    public void change_rate(double r, bank b, String typ) {
        b.set_int_rate(typ, r);
    }

    public void see_fund(bank b) {
        System.out.println("The internal Fund " + b.get_fund() + "$");
    }

    public boolean approve(Account[] ac, bank b) {
        double l, tot = b.get_fund();
        System.out.print("Loan for ");
        for (int i = 0; ac[i] != null; i++) {
            if (ac[i].haveloan()) {
                l = ac[i].approveAcc_loan();
                tot -= l;
                System.out.print(ac[i].get_name() + ", ");
            }

        }
        System.out.println("approved");
        b.set_fund(tot);
        return true;
    }


}

class Cashier extends Employee {

}

class Officer extends Employee {
    public boolean approve(Account[] ac, bank b) {
        double l, tot = b.get_fund();
        System.out.print("Loan for ");
        for (int i = 0; ac[i] != null; i++) {
            if (ac[i].haveloan()) {
                l = ac[i].approveAcc_loan();
                tot -= l;
                System.out.print(ac[i].get_name() + ", ");
            }

        }
        System.out.println("approved");
        b.set_fund(tot);
        return true;
    }

}

class bank {
    private double total;
    private int iter = 0;
    private Account[] accs;
    private double student_rate, savings_rate, fixed_rate;
    private Employee MD;
    private Employee[] c;
    private Employee o1;
    private Employee o2;
    private int active;
    private Employee activeEmp;
    private String activeTyp;
    private boolean pending;
    //String activeEmp;

    bank() {
        total = 1000000;
        MD = new Managing_director();
        c = new Cashier[5];
        o1 = new Officer();
        o2 = new Officer();
        for (int i = 0; i < 5; i++)
            c[i] = new Cashier();
        accs = new Account[500];
        student_rate = 5.0;
        savings_rate = 10.0;
        fixed_rate = 15.0;
        active = -1;
        activeEmp = null;
        pending = false;
        activeTyp = null;
        System.out.println("Bank Created; MD, O1, O2, C1, C2, C3, C4, C5 created");

    }

    public void set_int_rate(String s, double r) {
        if (s.equalsIgnoreCase("Student")) {
            student_rate = r;
        } else if (s.equalsIgnoreCase("Fixed")) {
            fixed_rate = r;
        } else {
            savings_rate = r;
        }
    }

    public double get_fund() {
        return total;
    }

    public void set_fund(double taka) {
        total = taka;
    }

    public String getActiveType() {
        if (active != -1 && activeEmp == null)
            return "account";
        else if (activeEmp != null && active == -1)
            return "Employee";
        else {
            return null;
        }

    }

    public void create(String typ, String n, double d) {
        int i = 0;
        for (i = 0; i < iter; i++) {
            if (accs[i].get_name().equalsIgnoreCase(n)) {
                System.out.println("Account Can't be created for " + n);
                return;

            }
        }
        Account ac;
        if (typ.equalsIgnoreCase("Student")) {
            ac = new Student();
        } else if (typ.equalsIgnoreCase("Fixed")) {
            ac = new Fixed();
        } else if (typ.equalsIgnoreCase("Savings")) {
            ac = new Savings();
        } else {
            System.out.println("Account Can't be created for " + n);
            return;
        }


        boolean x = ac.create_account(n, d);

        if (x) {
            accs[iter] = ac;
            iter++;
            active = iter - 1;
        }

        return;
    }

    public void add_money(double money) {
        if (active == -1) {
            System.out.println("This Function is not available for you.");
            return;
        }

        accs[active].deposit_money(money);

    }

    public void openAcc(String n) {
        if (active != -1 || activeEmp != null) {
            System.out.println("You should close the previous login first");
            return;
        }
        int i = 0;
        for (i = 0; i < iter; i++) {
            if (accs[i].get_name().equalsIgnoreCase(n)) {
                active = i;
                System.out.println("Welcome back, " + n);
                return;

            }
        }

        System.out.println("This Account doen't exist.");
        return;
    }

    public void closeAcc() {
        System.out.println("Transaction Closed for " + accs[active].get_name());
        active = -1;
    }

    public void withdraw_money(double taka) {
        if (active == -1) {
            System.out.println("This Function is not available for you.");
            return;
        }
        accs[active].withdraw(taka);
    }

    public void do_query() {
        if (active == -1) {
            System.out.println("This Function is not available for you.");
            return;
        }
        accs[active].query();
    }

    public void request_loan(double taka) {
        if (active == -1) {
            System.out.println("This Function is not available for you.");
            return;
        }
        if (taka > total) {
            System.out.println("Bank doesn't have sufficient money");
        } else {
            pending = true;
            accs[active].loan_req(taka);
        }

    }

    public void openEmp(String s) {
        if (active != -1 || activeEmp != null) {
            System.out.println("You should close the previous login first");
            return;
        }
        if (s.equalsIgnoreCase("MD")) {
            activeEmp = MD;
            activeTyp = s;

        } else if (s.equalsIgnoreCase("O1")) {
            activeEmp = o1;
            activeTyp = s;
        } else if (s.equals("O2")) {
            activeEmp = o2;
            activeTyp = s;
        } else {
            activeEmp = c[Integer.parseInt(s.substring(1))];
            activeTyp = s;
            // System.out.println(activeEmp);
        }
        System.out.print(s + " active. ");
        if (pending)
            System.out.print("there are loan approvals pending");
        System.out.println("");

    }

    public void closeEmp() {
        //String des=activeEmp.get_des();
        System.out.println("Operations for " + activeTyp + " closed");
        activeEmp = null;

    }

    public void lookupAcc(String n) {
        if (activeEmp == null) {
            System.out.println("This Function is not available for you.");
        }
        int i = 0;
        for (i = 0; i < iter; i++) {
            if (accs[i].get_name().equalsIgnoreCase(n)) {
                activeEmp.lookup(accs[i]);
                return;

            }
        }
    }

    public void approve_loan() {
        if (activeEmp == null) {
            System.out.println("This Function is not available for you.");
        }
        if (pending) {
            pending = (!activeEmp.approve(accs, this));
        } else
            System.out.println("Nothing Pending");


    }

    public void changeRate(String typ, double r) {
        if (activeEmp == null) {
            System.out.println("This Function is not available for you.");
        }
        activeEmp.change_rate(r, this, typ);
    }

    public void seeFund() {
        if (activeEmp == null) {
            System.out.println("This Function is not available for you.");
        }

        activeEmp.see_fund(this);
    }

    public void inc() {
        for (int i = 0; i < iter; i++) {
            if (accs[i].get_type().equalsIgnoreCase("Student")) {
                accs[i].increase_year(student_rate);
            } else if (accs[i].get_type().equalsIgnoreCase("Fixed")) {
                accs[i].increase_year(fixed_rate);
            } else {
                accs[i].increase_year(savings_rate);
            }
        }
        System.out.println("1 year passed.");
    }


}


public class Main {

    public static void main(String[] args) {
        // write your code

        bank b = new bank();
        while (true) {
            Scanner sc = new Scanner(System.in);
            String s = sc.next();
            if (s.equalsIgnoreCase("create")) {
                String n = sc.next();
                String typ = sc.next();
                double taka = sc.nextDouble();

                b.create(typ, n, taka);

            } else if (s.equalsIgnoreCase("deposit")) {
                double taka = sc.nextDouble();
                b.add_money(taka);
            } else if (s.equalsIgnoreCase("withdraw")) {
                double taka = sc.nextDouble();
                b.withdraw_money(taka);
            } else if (s.equalsIgnoreCase("query")) {
                b.do_query();
            } else if (s.equalsIgnoreCase("request")) {
                double taka = sc.nextDouble();
                b.request_loan(taka);
            } else if (s.equalsIgnoreCase("close")) {
                if (b.getActiveType() == null)
                    System.out.println("This Function is not available for you.");
                else if (b.getActiveType().equalsIgnoreCase("account")) {
                    b.closeAcc();
                } else if (b.getActiveType().equalsIgnoreCase("employee")) {
                    b.closeEmp();
                }
            } else if (s.equalsIgnoreCase("open")) {
                String n = sc.next();
                if (n.equalsIgnoreCase("O1") || n.equalsIgnoreCase("O2") || n.equalsIgnoreCase("MD") || n.equalsIgnoreCase("C1") || n.equalsIgnoreCase("C2") || n.equalsIgnoreCase("C3") || n.equalsIgnoreCase("C4") || n.equalsIgnoreCase("C5")) {
                    b.openEmp(n);
                } else {
                    b.openAcc(n);
                }
            } else if (s.equalsIgnoreCase("approve")) {
                b.approve_loan();
            } else if (s.equalsIgnoreCase("change")) {
                String t = sc.next();
                double r = sc.nextDouble();
                b.changeRate(s, r);
            } else if (s.equalsIgnoreCase("lookup")) {
                String t = sc.next();
                b.lookupAcc(t);
            } else if (s.equalsIgnoreCase("see")) {
                b.seeFund();
            } else if (s.equalsIgnoreCase("INC")) {
                b.inc();
            } else {
                break;
            }
        }

    }
}
