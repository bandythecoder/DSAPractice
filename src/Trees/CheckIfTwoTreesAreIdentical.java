package Trees;

public class CheckIfTwoTreesAreIdentical {

    public boolean checkIfTreeIdentical(Tree node1, Tree node2)
    {
        if(node1 == null || node2 == null)
        {
            return node1 == node2;
        }

       var v = checkIfTreeIdentical(node1.left , node2.left);
        var v1 =checkIfTreeIdentical(node1.right,node2.right);

        return node1 == node2 && v && v1;

    }
}
