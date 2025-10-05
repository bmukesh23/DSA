/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] maxi = {Integer.MIN_VALUE};
        findMaxPathSum(root, maxi);
        return maxi[0]; 
    }

    private int findMaxPathSum(TreeNode root, int[] maxi){
        if(root == null) return 0;
        int leftMaxSum = Math.max(0, findMaxPathSum(root.left, maxi));
        int rightMaxSum = Math.max(0, findMaxPathSum(root.right, maxi));

        maxi[0] = Math.max(maxi[0], root.val + leftMaxSum + rightMaxSum);
        return Math.max(leftMaxSum, rightMaxSum) + root.val;
    }
}