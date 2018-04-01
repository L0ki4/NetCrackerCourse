package ru.ncedu.java.tasks;

import static java.lang.Math.abs;
import static java.lang.Math.pow;

public class ControlFlowStatements3Impl implements ControlFlowStatements3 {

    public double getFunctionValue(double x){
        if(x <= 0){
            return -x;
        }
        else{
            if(x < 2){
                return x*x;
            }
            else{
                return 4;
            }
        }
    }

    public String decodeSeason(int monthNumber) {
        String st;
        switch (monthNumber){
            case 12:
            case 1:
            case 2:
                 st = "Winter";
                break;
            case 3:
            case 4:
            case 5:
                st = "Spring";
                break;
            case 6:
            case 7:
            case 8:
                st = "Summer";
                break;
            case 9:
            case 10:
            case 11:
                st =  "Autumn";
                break;
            default:
                st =  "Error";
                break;
        }
        return st;
    }


    public long[][] initArray() {
        long[][] a = new long[8][5];
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 5; j++){
                a[i][j] = (long) pow(abs(i - j), 5);
            }
        }
        return a;
    }


    public int getMaxProductIndex(long[][] array) {
        long max = -1;
        int max_index = -1;
        for(int i = 0; i < array.length; i++){
            long prod = 1;
            for(int j = 0; j < array[i].length; j++){
               prod = prod * abs(array[i][j]);
            }
            if (prod > max){
                max = prod;
                max_index = i;
            }
        }
        return max_index;
    }


    public float calculateLineSegment(float A, float B) {
        while (A >= B){
            A -= B;
        }
        return A;
    }
}
