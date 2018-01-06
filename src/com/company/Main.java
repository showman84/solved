package com.company;

import java.util.ArrayList;

public class Main {

    public int findLength(int[] A, int[] B) {

        int result[][] = new int[A.length + 1][B.length + 1];
        int max = 0;
        for (int i = A.length - 1; i >= 0; i--) {
            for (int j = B.length - 1; j >= 0; j--) {
                if (A[i] == B[j]) {
                    result[i][j] = result[i + 1][j + 1] + 1;
                    if (max < result[i][j]) {
                        max = result[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {

	   int A[] =  {1,2,3,2,1};
	   int B[] =  {3,2,1,4,7};
       System.out.println(new Main().findLength(A,B));

    }
}
