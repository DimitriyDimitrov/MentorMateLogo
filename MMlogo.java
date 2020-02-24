package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

class Main {
    private static String[][] res;

    public static String[][] createEmptryGrid(Integer x, Integer y) {
        String[][] grid = new String[y][];
        for (int i = 0; i < y; i++) {
            String[] row = new String[x];
            Arrays.fill(row, "-");
            grid[i] = row;
        }
        return grid;

    }

    public static void main(String[] args) {
        System.out.println(Main.getMMLogo(5));
    }

    public static <T> T[] splice(final T[] array, int start, final int deleteCount, final T... items) {
        if (start < 0)
            start += array.length;

        final T[] spliced = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length - deleteCount + items.length);
        if (start != 0)
            System.arraycopy(array, 0, spliced, 0, start);

        if (items.length > 0)
            System.arraycopy(items, 0, spliced, start, items.length);

        if (start + deleteCount != array.length)
            System.arraycopy(array, start + deleteCount, spliced, start + items.length, array.length - start - deleteCount);

        return spliced;
    }

    public static String[][] getMMLogo(Integer n) {
        String[][] grid = Main.createEmptryGrid(n * 5, n + 1);

        Integer x = 0;
        Integer y = n;
        Boolean goingUp = true;
        while (x <= (n * 5 - n)) {

            String[] items = new String[n];
            Arrays.fill(items, "-");
            grid[y] = Main.splice(res[y], x, n, items);


            if ((y == n && !goingUp) || (y == 0 && goingUp)) {
                goingUp = !goingUp;
            }

            x++;
            y += goingUp ? -1 : 1;
        }

        return grid;
    }


}