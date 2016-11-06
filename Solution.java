

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
/////////////////////////////////////////////////////////////////////////////
public int maximalSquare(char[][] matrix) {  //final .optimized!save space .O(n^2) time and O(n) space

        if (matrix.length == 0) return 0;

        int nr = matrix.length;

        int nc = matrix[0].length;

        int[] dp = new int[nc +1]; 

        int maxSize = 0;

        int pre = 0;

        for (int i = 1; i <= nr; i++) {

            for (int j = 1; j <= nc; j++) {

                int temp = dp[j];

                if (matrix[i -1][j -1] == '0') dp[j] = 0;

                else {

                   dp[j] = Math.min(dp[j -1],Math.min(dp[j],pre)) + 1;

                   maxSize = Math.max(dp[j],maxSize);

                }

                pre = temp; 

            }

                

        }

        return maxSize*maxSize;

    }

   /* public int maximalSquare(char[][] matrix) {     //easy to understand

        if (matrix.length == 0) return 0;

        int m = matrix.length;

        int n = matrix[0].length;

        int[][] p = new int[m][n]; 

        int maxSize = 0;

        for (int i = 0; i < m; i++) {

            p[i][0] = matrix[i][0] - '0';

            maxSize = Math.max(p[i][0],maxSize);

        }

        for (int j = 0; j < n; j++) {

            p[0][j] = matrix[0][j] - '0';

            maxSize = Math.max(p[0][j],maxSize);

        }

        for (int i = 1; i < m; i++) {

            for (int j = 1; j < n; j++) {

                if (matrix[i][j] == '1') {

                p[i][j] = Math.min(p[i -1][j],Math.min(p[i][j - 1],p[i - 1][j - 1])) + 1;

                maxSize = Math.max(p[i][j],maxSize);

                }

            }

        }

        return maxSize*maxSize;
    }*/
///////////////////////////////////////////////////////////////////:
public class NumArray {

    final int[] nums;

    public NumArray(int[] nums) {

        for (int i = 1; i < nums.length; i++)

        nums[i] += nums[i - 1];

        

    this.nums = nums;

    }



    public int sumRange(int i, int j) {

        return i == 0 ? nums[j] : nums[j] - nums[i - 1];

    }

}





// Your NumArray object will be instantiated and called as such:

// NumArray numArray = new NumArray(nums);

// numArray.sumRange(0, 1);

// numArray.sumRange(1, 2);

//////////////////////////////////////////////////////////////////////////////////////////////////
public class Solution {

    public int coinChange(int[] coins, int amount) {   //322. Coin Change

        if(amount < 0) return -1;

        if(amount == 0) return 0;

        int[] sum = new int[amount +1];

        for(int i = 1; i < amount +1; i++) {

            sum[i] = amount +1;

        }

        

        for(int i = 1; i <= amount; i++) {

            for(int j = 0; j < coins.length; j++) {

                if (coins[j] <= i) {

                sum[i] = Integer.min(sum[i], sum[i - coins[j]] + 1 );

            }

        }

    }

    return sum[amount] > amount ? -1 : sum[amount];

}

}
 public class Solution {
//the following answer is recursive with prunning
   public int curMin=Integer.MAX_VALUE;
public int coinChange(int[] coins, int amount) {    322. Coin Change    DFS
    if(coins.length==0||amount==0)
      return 0;
     Arrays.sort(coins);
   DFS(coins,coins.length-1,amount,0);
   if(curMin==Integer.MAX_VALUE)
     return -1;
   return curMin;
}
public void DFS(int[]coins,int index,int amount,int count)
{
  if(index==-1)
    return ;
   int number=amount/coins[index];
   for(int i=number;i>=0;i--)
   {
       int remain=amount-coins[index]*i;
       int newcount=count+i;
       if(remain>0&&newcount<curMin)
         DFS(coins,index-1,remain,newcount);
        else if(newcount<curMin)
         curMin=newcount;
        else 
          break;
   }
}
}

//////////////////////////////////////////////////////////////////////////////////
// just have a try use vs code git remote 
// low battery again 


class TrieNode {             //208. Implement Trie (Prefix Tree)  
    TrieNode[] children; 
    boolean isEndOfString;
    // Initialize your data structure here.
    public TrieNode() {
        children = new TrieNode[26];
        isEndOfString = false;
    }
     TrieNode nextChild(int i) {
        return children[i];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) curr.children[c - 'a'] = new TrieNode();
            curr = curr.nextChild(c - 'a');
        }
        curr.isEndOfString = true;
        
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.nextChild(c - 'a');
        }
        return curr.isEndOfString;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (char c : prefix.toCharArray()) {
            if(curr.children[c - 'a'] == null) return false;
            curr = curr.nextChild(c - 'a');
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");