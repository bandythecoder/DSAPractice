package Trees;

import java.util.List;

public class FindPath {

    public boolean findPath(Tree node, int x, List<Integer> path)
    {
        if(node == null)
        {
            return false;
        }
        path.add(node.data);
        if(node.data == x) return true;

        if(findPath(node.left,x,path) || findPath(node.right,x,path))
        {
            return true;
        }
        path.remove(path.size()-1);
        return false;
    }
}
