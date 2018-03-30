package com.aiexpanse.algo.sort;

public class SelectionSort extends SortTet {

    @Override
    protected void sort(int[] array, int n) {
        int min, tmp;
        for (int i = 0; i < n; i++) {
            min = i;
            for (int j=i+1; j<n; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            tmp = array[i];
            array[i] = array[min];
            array[min] = tmp;
        }
    }

    public static void main(String[] args) {
        SelectionSort bubbleSort = new SelectionSort();
        bubbleSort.run();
    }

}
