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
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        int ans = 0;

        Queue<Object[]> q = new LinkedList<>();
        q.add(new Object[]{root, 0L});

        while (!q.isEmpty()) {
            int size = q.size();
            long mmin = (long) q.peek()[1];
            long first = 0, last = 0;

            for (int i = 0; i < size; i++) {
                TreeNode node = (TreeNode) q.peek()[0];
                long cur_id = (long) q.peek()[1] - mmin;
                q.poll();

                if (i == 0) first = cur_id;
                if (i == size - 1) last = cur_id;

                if (node.left != null) {
                    q.add(new Object[]{node.left, cur_id * 2 + 1});
                }
                if (node.right != null) {
                    q.add(new Object[]{node.right, cur_id * 2 + 2});
                }
            }
            ans = Math.max(ans, (int) (last - first + 1));
        }
        return ans;
    }
}