package Trees.BinarySearchTrees;

import Trees.Tree;

public class Floor {

    public int getFloor(Tree x, int y)
    {
        int floor = -1;
        while(x != null)
        {
            if(x.data <= y)
            {
                floor = x.data;
                x = x.right;
            }
            else
            {
                x = x.left;
            }
        }
        return floor;
    }

}
