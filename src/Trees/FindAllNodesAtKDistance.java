package Trees;

import javax.swing.tree.TreeNode;
import java.util.*;

public class FindAllNodesAtKDistance {

    public List<Integer> findNodesAtKDistance(Tree main, Tree findTree, int k)
    {
        Map<Tree,Tree> map = new HashMap<>();
        addParentMarkerInNodes(main, map);
        List<Integer> v = findNodes(map,findTree,k);
        return v;
    }

    private List<Integer> findNodes(Map<Tree, Tree> map, Tree findTree, int k)
    {
        List<Integer> li = new ArrayList<Integer>();
        Queue<TreeWithDistance> q = new LinkedList<>();
        q.add(new TreeWithDistance(findTree, 0));
        Set<Tree> visited = new HashSet<>();
visited.add(findTree);
        while(!q.isEmpty())
        {
            var v = q.poll();
            if(v.distance ==k)
            {
                li.add(v.node.data);
            }
            if(v.node.left != null && !visited.contains(v.node.left) && v.distance < k)
            {
                q.add(new TreeWithDistance(v.node.left,v.distance+1));
                visited.add(v.node.left);
            }
            if(v.node.right != null && !visited.contains(v.node.right)&& v.distance < k)
            {
                q.add(new TreeWithDistance(v.node.right,v.distance+1));
                visited.add(v.node.right);
            }
            if(map.containsKey(v.node)&& v.distance < k && !visited.contains(map.get(v.node)))
            {
                q.add(new TreeWithDistance(map.get(v.node),v.distance+1));
                visited.add(map.get(v.node));
            }
        }

        return li;
    }

    private void addParentMarkerInNodes(Tree main, Map<Tree,Tree> map)
    {
        Queue<Tree> q = new LinkedList<>();

        q.add(main);
        while (!q.isEmpty())
        {
            var v = q.poll();
            if(v.left!=null)
            {
                q.add(v.left);
                map.put(v.left, v);
            }
            if(v.right!=null)
            {
                q.add(v.right);
                map.put(v.right, v);
            }
        }

    }

    class TreeWithDistance
    {
        Tree node;
        int distance;

        public TreeWithDistance(Tree node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
