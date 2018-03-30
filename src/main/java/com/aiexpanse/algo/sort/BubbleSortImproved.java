package com.aiexpanse.algo.sort;

public class BubbleSortImproved extends SortTet {

    /*
     * If no number is swapped in one pass, then the array is already sorted. no need to continue;
     */
    @Override
    protected void sort(int[] array, int n) {
        boolean swapped = true;
        for (int pass=n-1; pass>=0 && swapped; pass--) {
            swapped = false;
            for (int i=0; i<pass; i++) {
                if (array[i] > array[i+1]) {
                    int tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    swapped = true;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSortImproved bubbleSort = new BubbleSortImproved();
        bubbleSort.run();
    }

}
