package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;

class LogoBuilder {
    String[][] grid = null;
    int logoSize = 0;

    public LogoBuilder(int logoSize) {
        this.logoSize = logoSize;
        this.grid = this.createEmptryGrid(logoSize * 5, logoSize + 1);
    }

    public static void main(String[] args) {
        LogoBuilder logo = new LogoBuilder(5);
        logo.printGrid();

    }

    public void printGrid() {
        for (int i = 0; i < this.grid.length; i++) {
            String row = String.join("", this.grid[i]);

        }
    }

    private String[][] createEmptryGrid(Integer x, Integer y) {
        String[][] grid = new String[y][];
        for (int i = 0; i < y; i++) {
            String[] row = new String[x];
            Arrays.fill(row, "-");
            grid[i] = row;
        }
        return grid;

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

    private String[][] createLogo(Integer n) {

        Integer x = 0;
        Integer y = n;
        Boolean goingUp = true;
        while (x <= (n * 5 - n)) {
            // Replace the n characters at index x with '*'
            String[] items = new String[n];
            Arrays.fill(items, "*");
            this.grid[y] = LogoBuilder.splice(this.grid[y], x, n, items);


            if ((y == n && !goingUp) || (y == 0 && goingUp)) {
                goingUp = !goingUp;
            }

            x++;
            y += goingUp ? -1 : 1;
        }

        return grid;
    }


}