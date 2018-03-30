package com.aiexpanse.algo.sort;

public abstract class SortTet {

    protected abstract void sort(int[] array, int n);

    protected void run() {
        int[] array = null;
        sort(array, 0);
        array = new int[]{};
        sort(array, 0);
        array = new int[]{1};
        assertEquals(array, 1);

        array = new int[]{0, 1};
        sort(array, 2);
        assertEquals(array, 0, 1);

        array = new int[]{0,-1,1};
        sort(array, 3);
        assertEquals(array, -1, 0, 1);

        array = new int[]{7, 3, 1, 0, -5, 12, 8, 8, 3, 11, 5};
        sort(array, 11);
        assertEquals(array, -5, 0, 1, 3, 3, 5, 7, 8, 8, 11, 12);

        array = new int[]{1, 3, -5, 2};
        sort(array, 4);
        assertEquals(array, -5, 1, 2, 3);
    }

    private void assertEquals(int[] array, int... expect) {
        for (int i = 0; i < expect.length; i++) {
            assertEquals(array[i], expect[i], i);
        }
    }

    private void assertEquals(int i, int expect, int index) {
        if (i != expect) {
            throw new RuntimeException("[" + index + "]: " + i + " != " + expect + "(expect)");
        }
    }

}
