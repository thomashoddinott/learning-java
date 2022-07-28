package com.newthinktank;

public class Threads {
    public static void main(String[] args) { // main counts as a thread!
        // Thread t1 = new Thread(new MyThread(), "Thread 1");
        // Thread t2 = new Thread(new MyThread(), "Thread 2");
        // Thread t3 = new Thread(new MyThread(), "Thread 3");

        // t1.start();
        // t2.start();

        // try {
        //     t1.join();
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }

        // t3.start();

        ThreadTest tT1 = new ThreadTest(new Customer("Sam"));
        tT1.start();
        ThreadTest tT2 = new ThreadTest(new Customer("Sue"));
        tT2.start();
        ThreadTest tT3 = new ThreadTest(new Customer("Sally"));
        tT3.start();

    }

}

class Customer {
    public String name;

    public Customer(String _name) {
        this.name = _name;
    }
}

class BankAccount {
    static BankAccount account;
    static int balance = 100;
    static Customer cust;

    public static BankAccount getAccount(Customer _cust) {
        if (account == null) {
            account = new BankAccount();
        }
        BankAccount.cust = _cust;
        return account;
    }

    public static int getBalance() {
        return balance;
    }

    public synchronized void Withdraw(int bal) {
        try {
            if (balance >= bal) {
                System.out.println(cust.name + " requested $" + bal);
                Thread.sleep(1000);
                balance -= bal;
                System.out.println(cust.name + " received $" + bal);
            } else {
                System.out.println(cust.name + " tried to exceed balance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Current Balance: $" + balance);
        System.out.println();
    }
}

class ThreadTest extends Thread implements Runnable {
    Customer cust;

    public ThreadTest(Customer _cust) {
        this.cust = _cust;
    }

    public void run() {
        for (int i = 0; i < 4; i++) {
            try {
                BankAccount account = BankAccount.getAccount(cust);
                account.Withdraw(10);
                Thread.sleep(1000);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Active Threads : " + Thread.activeCount());
        System.out.println("Start Thread : " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("End Thread : " + Thread.currentThread().getName());

    }

}
