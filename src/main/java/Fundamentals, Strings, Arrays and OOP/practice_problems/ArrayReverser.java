import java.util.Arrays;

public class ArrayReverser {
    public static void reverseInPlace(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {11, 22, 33, 44};
        reverseInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }
}