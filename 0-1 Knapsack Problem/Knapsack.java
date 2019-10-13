/*
You are given weights and values of N items, put these items in a knapsack of 
capacity W to get the maximum total value in the knapsack. Note that we have 
only one quantity of each item.
Input :
1
3
4
4 5 1
1 2 3
*/
import java.util.*;

class Knapsack{
    public int getMaxItem(int[] wt,int[] value, int maxCapacity){
        int[][] dp = new int[wt.length][maxCapacity+1]; //added 1 to incude 0th column
        //Fill the first row as we pick only one item, where we inset only the value
        for(int j = wt[0];j<maxCapacity+1;j++){
            dp[0][j] = value[0];
        }
        for(int i=1;i<wt.length;i++){
            for(int j=1;j<maxCapacity+1;j++){
                //if j is less than weight of the items than take the value from row above
                if(j<wt[i]){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(value[i] + dp[i-1][j-wt[i]], dp[i-1][j]);
                }
            }
        }
        return dp[wt.length-1][maxCapacity];
    }
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        Knapsack knapsack = new Knapsack();
        int testcase = s.nextInt();
        while(testcase-- > 0){
            int noOfItems = s.nextInt();
            int maxCapacity = s.nextInt();
            int [] wt = new int[noOfItems];
            int [] value = new int[noOfItems];
            //Input all values
            for(int i=0;i<noOfItems;i++){
                value[i] = s.nextInt();
            }
            //Input all weights
            for(int i=0;i<noOfItems;i++){
                wt[i] = s.nextInt();
            }
            System.out.println(knapsack.getMaxItem(wt,value, maxCapacity));
        }
    }
}