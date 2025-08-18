public class day4 {

  public static void merge(int[] arr1, int[] arr2, int m, int n) {
      int totalLength = m + n;
      int gap = nextGap(totalLength);

        while (gap > 0) {
            int i = 0;
            int j = gap;

            while (j < totalLength) {
                // Element 1 in arr1, Element 2 in arr1
                if (i < m && j < m && arr1[i] > arr1[j]) {
                    swap(arr1, i, arr1, j);
                }
                // Element 1 in arr1, Element 2 in arr2
                else if (i < m && j >= m && arr1[i] > arr2[j - m]) {
                    swap(arr1, i, arr2, j - m);
                }
                // Element 1 in arr2, Element 2 in arr2
                else if (i >= m && j >= m && arr2[i - m] > arr2[j - m]) {
                    swap(arr2, i - m, arr2, j - m);
                }

                i++;
                j++;
            }

            gap = nextGap(gap);
        }
    }

    // Helper to calculate next gap
    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    // Swap between arrays
    private static void swap(int[] arr1, int i, int[] arr2, int j) {
        int temp = arr1[i];
        arr1[i] = arr2[j];
        arr2[j] = temp;
    }

    // Driver code for testing
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 5, 7};
        int[] arr2 = {2, 4, 6, 8};

        merge(arr1, arr2, arr1.length, arr2.length);

        System.out.print("arr1 = ");
        for (int num : arr1) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.print("arr2 = ");
        for (int num : arr2) {
            System.out.print(num + " ");
        }
    }
}
