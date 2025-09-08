class Day25 {
    
    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    
    public boolean isValidBST(TreeNode root) {
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

   
    private boolean isValid(TreeNode node, long min, long max) {
        
        if (node == null) return true;

        
        if (node.val <= min || node.val >= max) return false;

        
        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }

    
    public static void main(String[] args) {
        Day25 solution = new Day25();

        
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        
        System.out.println(solution.isValidBST(root));
    }
}
