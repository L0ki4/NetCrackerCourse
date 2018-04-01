package ru.ncedu.java.tasks;

import java.util.Arrays;

import static java.lang.Math.sqrt;

public class ArrayVectorImpl implements ArrayVector {

    private double[] vector = new double[] {0};


    @Override
    public void set(double... elements) {
        vector = new double[elements.length];
        vector = elements;
    }

    @Override
    public double[] get() {
        return vector;
    }

    @Override
    public ArrayVector clone() {
        ArrayVectorImpl a = new ArrayVectorImpl();
        a.set(vector.clone());
        return a;
    }

    @Override
    public int getSize() {
        return vector.length;
    }

    @Override
    public void set(int index, double value) {
        if(index < this.getSize() && index >= 0){
            vector[index] = value;
        }
        else{
            if(index >= 0) {
                double[] new_vector = new double[index + 1];
                for(int i = 0; i < this.getSize(); i++){
                    new_vector[i] = vector[i];
                }
                new_vector[index] = value;
                this.set(new_vector);
            }
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if(index < this.getSize()){
            return  vector[index];
        }
        else{
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    @Override
    public double getMax() {
        double max = vector[0];
        for(int i = 1; i < this.getSize(); i++){
            if (vector[i] > max){
                max = vector[i];
            }
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = vector[0];
        for(int i = 1; i < this.getSize(); i++){
            if (vector[i] < min){
                min = vector[i];
            }
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(vector);
    }

    @Override
    public void mult(double factor) {
        for(int i = 0; i < this.getSize(); i++){
            vector[i] = vector[i] * factor;
        }
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        double[] vec = anotherVector.get();
        int len;
        if(this.getSize() >= anotherVector.getSize()){
            len = anotherVector.getSize();
        }
        else{
            len = this.getSize();
        }
        for(int i = 0; i < len; i++){
            vector[i] += vec[i];
        }
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        double[] vec = anotherVector.get();
        int len;
        double sum = 0;
        if(this.getSize() >= anotherVector.getSize()){
            len = anotherVector.getSize();
        }
        else{
            len = this.getSize();
        }
        for(int i = 0; i < len; i++){
            sum += vector[i]*vec[i];
        }
        return sum;
    }


    @Override
    public double getNorm() {
        return sqrt(scalarMult(this));
    }
}