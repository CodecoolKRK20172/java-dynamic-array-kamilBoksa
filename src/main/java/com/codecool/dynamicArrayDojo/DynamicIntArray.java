package com.codecool.dynamicArrayDojo;

public class DynamicIntArray {
    private int[] intArray;

    DynamicIntArray() {
        intArray = new int[0];
    }
    DynamicIntArray(int size) {
        intArray = new int[size];
    }

    public void add(int number) {
        int[] newArray = new int[intArray.length + 1];
        System.arraycopy(intArray, 0, newArray, 0, intArray.length);
        newArray[newArray.length - 1] = number;
        intArray = newArray;
    }

    public void remove(int targetNumber) {
        if(targetNumber >= intArray.length || targetNumber < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int counter = 0;

        for(int number : intArray) {
            if(number == targetNumber) {
                counter++;
            }
        }

        int[] result = new int[intArray.length - counter];
        int index = 0;
        for(int number : intArray) {
            if(number != targetNumber) {
                result[index] = number;
                index++;
            }
        }
        intArray = result;
    }

    public void insert(int index, int numberToInsert) {
        int[] result = new int[intArray.length + 1];
        int counter = 0;

        for (int number : intArray) {
            if(counter == index) {
                result[counter] = numberToInsert;
                counter++;
                result[counter] = number;
                counter++;
            } else {
                result[counter] = number;
                counter++;
            }
        }

        if(index >= result.length) {
            result[result.length-1] = numberToInsert;
        }
        intArray = result;
    }

    @Override
    public String toString() {
        StringBuilder numbers = new StringBuilder(" ");
        for(int i = 0; i < intArray.length; i++) {
            if(i != intArray.length - 1) {
                numbers.append(intArray[i] + " ");
            } else {
                numbers.append(intArray[i]);
            }
        }
        return numbers.toString();
    }
}
