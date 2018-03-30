package com.aiexpanse.algo.sort;

public class InsertionSort extends SortTet {

    @Override
    protected void sort(int[] array, int n) {
        int v;
        for (int i=2; i<n; i++) {
            v = array[i];
            int j=i;
            while (array[j-1] > v && j>=1) {
                v = array[j-1];
                array[j-1] = array[j];
                j--;
            }
            array[j] = v;
        }
    }

    public static void main(String[] args) {
        InsertionSort bubbleSort = new InsertionSort();
        bubbleSort.run();
    }

}
