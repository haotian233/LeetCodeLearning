/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 //错误，只能判断每个节点的树的情况，无法判断整颗树的情况，例如[5,1,6,null,null,3,7]
class Solution {
    public boolean search(TreeNode root){
        
        if(root.left != null){
            if(root.left.val >= root.val)
                return false;
            if(!search(root.left))
            return false;
        }
        
        if(root.right != null){
            if(root.right.val <= root.val)
                return false;
            if(!search(root.right))
                return false;
        }
        return true;
    }
    public boolean isValidBST(TreeNode root) {
        return search(root);
    }
}
//采用中序遍历的思想，二叉搜索树在中序遍历的情况下是从小到大有序排列的，检查这一队列是否排列就OK
class Solution {
public boolean isValidBST(TreeNode root) {
    Stack<TreeNode> stack = new Stack();
    double inorder = - Double.MAX_VALUE;

    while (!stack.isEmpty() || root != null) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();
      // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
      if (root.val <= inorder) return false;
      inorder = root.val;
      root = root.right;
    }
    return true;
  }
}
