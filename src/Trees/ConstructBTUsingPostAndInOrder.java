package Trees;

import java.util.HashMap;
import java.util.Map;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBTUsingPostAndInOrder {
    public Tree constructTree(int[] inorder, int[] postOrder)
    {
      Map<Integer,Integer> map = new HashMap<>();
      AtomicInteger count = new AtomicInteger();
      Arrays.stream(inorder).forEach(x -> map.put(x,count.getAndIncrement()));

     return constructBT(postOrder, 0, postOrder.length-1, inorder, 0, inorder.length-1,map);

    }

    private Tree constructBT(int[] postOrder, int postStart, int postEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map)
    {
        if(postStart > postEnd || inStart > inEnd )
        {
            return null;
        }

        var x = postOrder[postEnd];
        var inRoot = map.get(x);
        var numleft = inRoot - inStart;
        Tree node = new Tree(x);

        node.left = constructBT(postOrder, postStart, postStart + numleft - 1, inorder, inStart, inStart + numleft -1,map);
        node.right = constructBT(postOrder, postStart + numleft , postEnd - 1, inorder, inStart + numleft +1, inEnd,map);
        return node;
    }
}
