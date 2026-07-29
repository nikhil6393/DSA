class Solution {
    int index = 0;
    private TreeNode bst(int[] preorder, int min, int max){

        if(index == preorder.length || preorder[index] < min || preorder[index] > max){
            return null;
        }

        TreeNode root = new TreeNode(preorder[index++]);
        root.left = bst(preorder, min, root.val);
        root.right = bst(preorder, root.val, max);

        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return bst(preorder,Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}