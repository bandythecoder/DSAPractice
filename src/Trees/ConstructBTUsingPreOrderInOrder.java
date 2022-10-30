package Trees;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class ConstructBTUsingPreOrderInOrder {

    public Tree constructTree(int[] preOrder, int[] inorder)
    {
        Map<Integer,Integer> map = new HashMap<>();
        AtomicInteger count= new AtomicInteger(0);
        Arrays.stream(inorder).forEach(x -> map.put(x, count.getAndIncrement()));
        return constructBTree(preOrder,0,preOrder.length-1,inorder,0,inorder.length-1,map);
    }

    private Tree constructBTree(int[] preOrder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> map)
    {
        if(preStart > preEnd && inStart > inEnd )
        {
            return null;
        }
        Tree node = new Tree(preOrder[preStart]);
        var inRoot = map.get(preOrder[preStart]);
        var numLeft = inRoot - inStart;
        node.left = constructBTree(preOrder,preStart+1, preStart
                +numLeft,inorder, inStart, inRoot-1,map);
        node.right = constructBTree(preOrder,preStart +1 +numLeft, preEnd,inorder, inRoot+1, inEnd,map);
        return node;
    }
}
