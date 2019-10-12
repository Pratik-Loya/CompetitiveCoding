import java.util.*;

/*
Input Format:
no. of testcase : 
length of array : 
array numbers.
e.g:
1
8
2 -1 4 3 5 -1 3 2
*/
class Bitonic{
    public int getBitonicLength(int[] arr, int n){
        int[] temp1 = new int[n];
        int[] temp2 = new int[n];
        int[] temp3 = new int[n];
        int max = 0;
        Arrays.fill(temp1,1);
        Arrays.fill(temp2,1);
        // Finding Longest INcreasing subsequence from left to right
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[j] < arr[i]){
                    temp1[i] = Math.max(temp1[j]+1,temp1[i]);
                }
            }
        }
        // Finding Longest INcreasing subsequence from right to left
        for(int i=n-2;i>=0;i--){
            for(int j=n-1;j>i;j--){
                if(arr[j] < arr[i]){
                    temp2[i] = Math.max(temp2[j]+1,temp2[i]);
                }
            }
        }

        // Finding Longest Bitonic sequence
        for(int i=0;i<n;i++){
            temp3[i] = temp1[i] + temp2[i] -1 ;
            if(temp3[i] > max){
                max = temp3[i];
            }
        }

        return max;
    }
	public static void main (String[] args)
	 {
        Bitonic bitonic = new Bitonic();
    	 Scanner s = new Scanner(System.in);
    	 int testcase= s.nextInt();
    	 while(testcase-->0){
    	     int n = s.nextInt();
    	     int[] arr = new int[n];
    	     for(int i=0;i<n;i++){
    	         arr[i] = s.nextInt();
    	     }
    	     System.out.println("Max Bitonic Length = " + bitonic.getBitonicLength(arr,n));
    	 }
	 }
}