public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        int maxTotal = -1;
        int busiestRowIndex = 0;

        for (int i = 0; i < grid.length; i++) {
            int currentRowTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                currentRowTotal += grid[i][j];
            }

            if (currentRowTotal > maxTotal) {
                maxTotal = currentRowTotal;
                busiestRowIndex = i;
            }
        }

        System.out.println("Row " + busiestRowIndex + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        System.out.print("Sample Output: ");
        busiestRow(grid); // Row 1, Total 7
    }
}