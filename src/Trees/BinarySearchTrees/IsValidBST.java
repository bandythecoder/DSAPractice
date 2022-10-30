package Trees.BinarySearchTrees;

import Trees.Tree;

public class IsValidBST {

        public boolean isValidBST(Tree root) {
        return validate(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    boolean validate(Tree root, long max, long min)
    {
        if(root == null) return true;
        if(root.data >= max || root.data <= min) return false;
        if(validate(root.left, root.data, min) && validate(root.right,  max, root.data))
        {
            return true;
        }
        return false;
    }
}
