package ru.ncedu.java.tasks;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.StrictMath.sin;

public class ControlFlowStatements1Impl implements ControlFlowStatements1 {
    @Override
    public float getFunctionValue(float x) {
        if(x > 0){
            return (float) (2*sin(x));
        }
        else{
            return 6-x;
        }
    }

    @Override
    public String decodeWeekday(int weekday) {
        String st = null;
        switch (weekday){
            case 1:
                st = "Monday";
                break;
            case 2:
                st = "Tuesday";
                break;
            case 3:
                st = "Wednesday";
                break;
            case 4:
                st = "Thursday";
                break;
            case 5:
                st = "Friday";
                break;
            case 6:
                st = "Saturday";
                break;
            case 7:
                st = "Sunday";
                break;
        }
        return st;
    }

    @Override
    public int[][] initArray() {
        int[][] a = new int[8][5];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){
                a[i][j] = i*j;
            }
        }
        return a;

    }

    @Override
    public int getMinValue(int[][] array) {
        int min = array[0][0];
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                if(array[i][j] < min){
                    min = array[i][j];
                }
            }
        }
        return min;
    }

    @Override
    public BankDeposit calculateBankDeposit(double P) {
        BankDeposit a = new BankDeposit();
        a.amount = 1000;
        a.years = 0;
        while (a.amount < 5000){
            a.amount = a.amount * (1 + P /100);
            a.years += 1;
        }
        return a;
    }
}
