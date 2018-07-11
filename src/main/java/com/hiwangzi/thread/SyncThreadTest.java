package com.hiwangzi.thread;

public class SyncThreadTest {

    public static void main(String args[]) {
        final Bank bank = new Bank();

        Thread tadd = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    bank.addMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");

                }
            }
        });

        Thread tsub = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    bank.subMoney(100);
                    bank.lookMoney();
                    System.out.println("\n");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        tsub.start();

        tadd.start();
    }

}