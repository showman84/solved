package com.company;

public class MissingPositive {

    int firstMissingPositive(int A[], int n)
    {
        for(int i = 0; i < n; ++ i)
            while(A[i] > 0 && A[i] <= n && A[A[i] - 1] != A[i])
                swap(A, i, A[i] - 1);

        for(int i = 0; i < n; ++ i)
            if(A[i] != i + 1)
                return i + 1;

        return n + 1;
    }

    public int partition(int[] A){
        int n=A.length;
        int q=-1;
        for(int i=0;i<n;i++){
            if(A[i]>0){
                q++;
                swap(A,q,i);
            }
        }
        return q;
    }

    public void swap(int[] A, int i, int j){
        if(i!=j){
            A[i]^=A[j];
            A[j]^=A[i];
            A[i]^=A[j];
        }
    }

    public static void main(String[] args) {

        int A[] =  {3,4,-1,1};



        System.out.println(new MissingPositive().firstMissingPositive(A, 4));

    }
}
