package Trees;

import javax.swing.tree.TreeNode;
import java.util.*;

public class MinTimeToBurnATree {

    public int minTimeToBurnABT(Tree tree, Tree node) {
        Map<Tree, Tree> map = markParent(tree);
        Queue<Tree> q = new LinkedList<>();
        Set<Tree> visited = new HashSet<>();
q.add(node);
        visited.add(node);
        int level=0;
        while (!q.isEmpty()) {
            var v = q.size();
            int max = 0;
            for (int i = 0; i < v; i++) {

               var v1 = q.poll();
               if(v1.left != null && !visited.contains(v1.left)) {
                   max =1;
                   q.add(v1.left);
                   visited.add(v1.left);
               }
                if(v1.right != null && !visited.contains(v1.right)) {
                    max =1;
                    q.add(v1.right);
                    visited.add(v1.right);
                }
                if(map.get(v1) != null  && !visited.contains(map.get(v1)))
                {
                    max =1;
                    q.add(map.get(v1));
                    visited.add(map.get(v1));
                }
                if(max==1)
                {
                    level++;
                }
            }
        }
        return level;
    }

    private Map<Tree, Tree> markParent(Tree tree)
    {
        Map<Tree,Tree> map = new HashMap<>();
        Queue<Tree> q = new LinkedList<>();
q.add(tree);
        while(!q.isEmpty())
        {
            var v = q.poll();
            if(v.left != null) {
                q.add(v.left);
                map.put(v.left,v);
            }
            if(v.right != null) {
                q.add(v.right);
                map.put(v.right,v);
            }
            }
        return map;
        }
    }

