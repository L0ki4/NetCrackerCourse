package com.netcracker.edu.java.tasks;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

import static java.lang.Math.pow;

public class ComplexNumberImpl implements ComplexNumber {

    private double re = 0;
    private double im = 0;


    @Override
    public double getRe() {
        return re;
    }

    @Override
    public double getIm() {
        return im;
    }

    @Override
    public boolean isReal() {
        return im == 0;
    }

    @Override
    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    @Override
    public void set(String value) throws NumberFormatException {

        String real = "";
        String imag = "";

        boolean minusRe = false;
        boolean minusIm = false;

        if(value.indexOf('-') == -1 && value.indexOf('+') == -1){
            //we work with 24i or 256
            if(value.indexOf('i') == -1){
                real = value;
            }
            else{
                imag = value.substring(0, value.indexOf('i'));
            }
        }
        else{
            //let's count + & -
            if (value.indexOf('-') != value.lastIndexOf('-')){
                //there are two minuses
                imag = value.substring(value.lastIndexOf('-') + 1, value.indexOf('i'));
                real = value.substring(1, value.lastIndexOf('-'));
                minusIm = true;
                minusRe = true;
            }
            else{
                if(value.indexOf('-') == -1){
                    //there are no -
                    if (value.indexOf('+') != value.lastIndexOf('+')){
                        //there are two +
                        imag = value.substring(value.lastIndexOf('+') + 1, value.indexOf('i'));
                        real = value.substring(value.indexOf('+') + 1, value.lastIndexOf('+'));
                    }
                    else{
                        if (value.indexOf('+') == 0){
                            //the number is +4i or +4
                            if (value.indexOf('i') == -1){
                                real = value.substring(value.indexOf('+') + 1, value.length());
                            }
                            else{
                                imag = value.substring(value.indexOf('+') + 1, value.indexOf('i'));
                            }
                        }
                        else{
                            // the numer is 1 + 4i
                            real = value.substring(0, value.indexOf('+'));
                            imag = value.substring(value.indexOf('+') + 1, value.indexOf('i'));
                        }
                    }
                }
                else {
                    //there are 1 minus
                    if(value.indexOf('-') == 0){
                        // the number is -i or -1 or -1 + 5i
                        if (value.indexOf('i') != -1){
                            if (value.indexOf('-') + 1 == value.indexOf('i')) {
                                imag = "1";
                                minusIm = true;
                            }
                            else {
                                if(value.indexOf('+') != -1){
                                    real = value.substring(1, value.indexOf('+'));
                                    minusRe = true;
                                    imag = value.substring(value.indexOf('+') + 1, value.indexOf('i'));
                                }
                                else {
                                    imag = value.substring(value.indexOf('-') + 1, value.indexOf('i'));
                                    minusIm = true;
                                }
                            }
                        }
                        else{
                            real = value.substring(value.indexOf('-') + 1, value.length());
                            minusRe = true;
                        }
                    }
                    else{
                        //the number is 1 - 5i
                        if (value.indexOf('-') + 1 == value.indexOf('i')){
                            //1-i
                            real = value.substring(0,value.indexOf('-'));
                            imag = "1";
                            minusIm = true;
                        }
                        else{
                            real = value.substring(0, value.indexOf('-'));
                            imag = value.substring(value.indexOf('-') + 1, value.indexOf('i'));
                            minusIm = true;
                        }
                    }
                }
            }
        }
//        System.out.println(real + "check" + imag);
        if(!real.equals("")) {
            re = Double.valueOf(real.trim());
        }
        else{
            re = 0;
        }
        if(!imag.equals("")) {
            im = Double.valueOf(imag.trim());
        }
        else{
            im = 0;
        }
        if(minusIm){
            im *= -1;
        }
        if(minusRe){
            re *= -1;
        }
    }

    @Override
    public ComplexNumber copy() {
        ComplexNumber a = new ComplexNumberImpl();
        a.set(this.re, this.im);
        return a;
    }

    @Override
    public String toString(){
        if(im == 0 && re == 0){
            return "";
        }
        else{
            if(im == 0){
                return re + "";
            }
            else {
                if (re == 0) {
                    return im + "i";
                } else {
                    if (im > 0) {
                        return re + "+" + im + "i";
                    }
                    else{
                        return re + "" + im + "i";
                    }
                }
            }
        }
    }

    @Override
    public int compareTo(ComplexNumber other) {
        double mod_this = pow(re,2) + pow(im,2);
        double mod_other = pow(other.getRe(),2) + pow(other.getIm(), 2);
        return Double.compare(mod_this, mod_other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ComplexNumberImpl that = (ComplexNumberImpl) o;
        return this.compareTo(that) == 0;
    }


    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        ComplexNumber a = new ComplexNumberImpl();
        a.set(this.re, this.im);
        return a;
    }



    @Override
    public void sort(ComplexNumber[] array) {
        Integer[] sortedIDXs  = new Integer[]{0,1,2,3,4};
//        Arrays.sort(array, compareTo());
    }

    @Override
    public ComplexNumber negate() {
        ComplexNumber arg1 = this.copy();
        arg1.set(-1*arg1.getRe(), -1*arg1.getIm());
        re = arg1.getRe();
        im = arg1.getIm();
        return this;
    }

    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        re += arg2.getRe();
        im += arg2.getIm();
        return this;
    }

    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        re = re * arg2.getRe() - im * arg2.getIm();
        im = im * arg2.getRe() + re * arg2.getIm();
        return this;
    }
}