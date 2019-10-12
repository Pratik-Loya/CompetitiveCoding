//Given an array of integers and a sum, the task is to count all subsets of given array with sum equal to given sum.
/*
Input:
2
6
2 3 5 6 8 10
10
5
1 2 3 4 5
10

*/
import java.util.*;

class PerfectSum{
    public int GetPerfectSum(int[] arr, int n, int perfectsum){
        int [][]dp = new int[n+1][perfectsum+1];
        for(int i=0;i<=n;i++){
            dp[i][0] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=0;j<=perfectsum;j++){
                if(j<arr[i-1]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][perfectsum];
    }
    public static void main (String[] args){
        Scanner s = new Scanner(System.in);
        PerfectSum ps = new PerfectSum();
        int testcase = s.nextInt();
        while(testcase-- > 0){
            int n = s.nextInt();
            int arr[] = new int[n];
            for(int i= 0 ; i<n;i++){
                arr[i] = s.nextInt();
            }
            int perfectsum = s.nextInt();
            System.out.println(ps.GetPerfectSum(arr, n, perfectsum));
        }
    }
}