package Trees;

public class DiameterOfTree {

    public Integer diameter = 0;

    public int checkDiameter(Tree node)
    {
        if(node == null)
        {
            return 0;
        }

       var lh = checkDiameter(node.left);
        var rh = checkDiameter(node.right);

        diameter = Math.max(diameter,lh+rh);

        return 1 + Math.max(lh,rh);

    }
}
