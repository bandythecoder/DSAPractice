package Trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SingleTraversalINPREPOST {

    public void printDifferentOrders(Tree node)
    {
        Stack<PairValue> st = new Stack<>();
        List<Integer> pre = new ArrayList<>();
        List<Integer> in = new ArrayList<>();
        List<Integer> post = new ArrayList<>();
        if(node != null)
            st.push(new PairValue(node,1));
            while(!st.isEmpty())
            {
                var v = st.peek();
                if(v.value == 1)
                {
                   pre.add(v.node.data);
                   st.pop();
                   st.add(new PairValue(v.node, v.value +1));
                  if(v.node.left != null)  st.add(new PairValue(v.node.left, 1));
                }
                else    if(v.value == 2)
                {
                    in.add(v.node.data);
                    st.pop();
                    st.add(new PairValue(v.node, v.value +1));
                    if(v.node.right != null) st.add(new PairValue(v.node.right, 1));
                }
                else
                {
                    post.add(v.node.data);
                    st.pop();
                }
            }
    System.out.println("pre");
        pre.forEach( a -> System.out.println(a));
        System.out.println("in");
        in.forEach( a -> System.out.println(a));
        System.out.println("post");
        post.forEach( a -> System.out.println(a));

    }

    public class PairValue
    {
        Tree node;

        public PairValue(Tree node, Integer value) {
            this.node = node;
            this.value = value;
        }

        Integer value;
    }
}
