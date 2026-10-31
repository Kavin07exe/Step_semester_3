package week11.class_problems;

import java.util.Scanner;
import java.util.Arrays;

public class RemoveDuplicatesSortedArray {

    static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return 0;

        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[k - 1])
                nums[k++] = nums[i];
        }

        return k;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();

        int k = removeDuplicates(nums);

        System.out.println("Length: " + k);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, k)));

        sc.close();
    }
}