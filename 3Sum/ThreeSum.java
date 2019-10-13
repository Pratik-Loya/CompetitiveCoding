//Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.
/*
Input:
ArrayLength
Numbers in array
e.g.
6
-1 0 1 2 -4 5
*/
import java.util.*;

class ThreeSum{
    public List<List<Integer>> findSubset(int[] nums){
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2 && nums[i]<=0;i++){
            int j = i+1;
            int k = nums.length-1;
            while(j<k){
                if(nums[i] + nums[j] + nums[k] == 0){
                    List<Integer> newlist = new ArrayList<Integer>();
                    newlist.add(nums[i]);
                    newlist.add(nums[j]);
                    newlist.add(nums[k]);
                    if(!set.contains(newlist)){
                        set.add(newlist);
                        list.add(newlist);
                    }
                    k--;    
                }
                else if(nums[i] + nums[j] + nums[k] > 0){
                    k--;
                }else{
                    j++;
                }
            }
            while(i<nums.length-1 && nums[i]==nums[i+1])
                i++;
        }
        return list;
    }


    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        ThreeSum obj = new ThreeSum();
        int arrayLength = s.nextInt();
        int[] nums = new int[arrayLength];
        for(int i=0;i<arrayLength;i++){
            nums[i] = s.nextInt();
        }
        System.out.println(Arrays.toString(obj.findSubset(nums).toArray()));
    }
}