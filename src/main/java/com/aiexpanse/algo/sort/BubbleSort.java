package com.aiexpanse.algo.sort;

public class BubbleSort extends SortTet {

    @Override
    protected void sort(int[] array, int n) {
        for (int pass=n-1; pass>=0; pass--) {
            for (int i=0; i<pass; i++) {
                if (array[i] > array[i+1]) {
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.run();
    }

}
