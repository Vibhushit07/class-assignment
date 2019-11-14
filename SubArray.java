package subarray;

import java.util.*;

public class SubArray {
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        int i, j, n, k;
        System.out.println("Enter size of array: ");
        n = S.nextInt();
        int arr[] = new int[n];
        for(i = 0; i < n; i++)
            arr[i] = S.nextInt();
        k = S.nextInt();
        int count = (int)((n-k+1)*(n-k+2)/2.0);
        System.out.println(count);
    }   
}