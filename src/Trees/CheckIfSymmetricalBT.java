package Trees;

public class CheckIfSymmetricalBT {
    public boolean symmetricalBT(Tree node)
    {
        if(node != null)
        {
            return checkIfTreeSymmetrical(node.left,node.right);
        }
        return false;
    }

    private boolean checkIfTreeSymmetrical(Tree left, Tree right)
    {
        if(left == null || right ==null)
        {
            return left == right;
        }

        if(left.data != right.data) return false;
        var v = checkIfTreeSymmetrical(left.left,right.right);
        var v1 = checkIfTreeSymmetrical(left.right,right.left);

        return  v && v1;
    }
}
