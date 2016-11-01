

public class Solution {
	public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++)
        for(int j=i+1;j<nums.length;j++)
        if (nums[i]+nums[j]==target)
        {	return new int[] {i,j};}
		throw new IllegalArgumentException("No two sum solution");
    }
	
	////////////////////////////////////////////////
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	ListNode result, node;
	int temp, carry = 0;

	if (l1 == null && l2 == null) {
		return null;
	}
	result = new ListNode(0);
	node = result;
	do  {
		temp = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
		carry = temp < 10 ? 0 : 1;
		node.next = new ListNode(temp % 10);
		node = node.next;
		if (l1 != null)
			l1 = l1.next;
		if (l2 != null)
			l2 = l2.next;
	} while (l1 != null || l2 != null || carry > 0);
	return result.next;
}
	
	
}
         ///////////////////////////////////////
   String longestCommonPrefix(String[] strs) {//较为冗余

        int count = strs.length;  //数组内的字符串数量

        if(count < 1) return "";

        int minLen = Integer.MAX_VALUE;//求各字符串其中最小长度

        for(int i = 0; i < count; i++) {

            if(minLen > strs[i].length()) minLen = strs[i].length();

        }

        if (minLen < 1) return "";

        String pat = "";

        int k = 0;

        while(k < minLen) {//防止比较时二位串内越界

        pat += strs[0].charAt(k);

        k++;

        for (int i = 0; i < count; i++) {//比较所有字符

        	if(!prefix(strs[i],pat)) return pat.substring(0,k-1) ;//若失配返回上次匹配前缀子串

        }

        }

        return pat;

    }

     boolean prefix(String str, String pat) {//匹配前缀的子函数

         int length = pat.length();

         for (int i =0; i <length; i++) {

             if(str.charAt(i) != pat.charAt(i)) return false;

         }

         return true;

     }
     /////////////////////////////////////////////////////////////////
     public void nextPermutation(int[] nums) {
        if (nums.length < 2) return;
        int i = nums.length-2;
        for(;i >= 0; i--) {
            if (nums[i] < nums[i+1])
            break;
        }
        if (i == -1) {       //can't find a greater permutation
            reverse(nums,0);
            return;
        }
        int min = Integer.MAX_VALUE;
        int minIndex=0;
        for(int j = nums.length-1; j > i; j--) {
            if(nums[j] > nums[i] && min > nums[j]) {//find property minIndex；
                min = nums[j];
                minIndex = j;
            }
        }
        
        int temp;
        temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
        reverse(nums,i+1);
        return;
    }
    void reverse(int[] nums, int n) {
        for (int i = n,j = 0; i < nums.length-1-j; i++,j++) {
            //swap(nums[i],nums[nums.length-1-i]);
        int temp;
        temp = nums[i];
        nums[i] = nums[nums.length-1-j];
        nums[nums.length-1-j] = temp;
        }
    }
