/*Given two sequences, find the length of longest subsequence present in both of them. Both the strings are of uppercase.
Input:
no of testcase
string1_length string2_length
string1
string2 
2
6 6
ABCDGH
AEDFHR
3 2
ABC
AC
*/

import java.util.*;
import java.lang.*;
import java.io.*;
class MaxCommonSubsequence
 {
     public int longestCommonSubsequence(String text1, String text2) {
        if(text1.length()==0 || text2.length()==0) return 0;
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        for(int i=1;i<=text1.length();i++){
            for(int j=1;j<=text2.length();j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
    
	public static void main (String[] args)
	 {
	    Scanner s = new Scanner(System.in);
	    MaxCommonSubsequence mcs = new MaxCommonSubsequence();
	    int testcase = s.nextInt();
	    while(testcase-- > 0){
	        int length1 = s.nextInt();
	        int length2 = s.nextInt();
	        String str1 = s.next();
	        String str2 = s.next();
	        System.out.println(mcs.longestCommonSubsequence(str1,str2));
	    }
	 }
}