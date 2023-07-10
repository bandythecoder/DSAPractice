package Arrays.SengmentTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersistantSegmentTree {

    private ArrayList<Node> state = new ArrayList<>();
    private int n;

    public static void main(String[] args)
    {
        int[] arr = new int[]{3,1,7,11,9,15};
        int n = arr.length;

        int[][] sortedArray = new int[n][2];

        for(int i = 0; i < n ; i++)
        {
            sortedArray[i][0] = i;
            sortedArray[i][1] = arr[i];
        }

        Arrays.sort(sortedArray, (a, b) -> Integer.compare(a[1],b[1]));
        int[] indexInTree = new int[n];
        for(int i = 0; i < n ; i++)
        {
            indexInTree[sortedArray[i][0]]  = i;
        }

        int l = 1;
        int r = 5;
        int k = 5;
        List<Node> nodes = new ArrayList<>();
        Node root = Node.build(0,n-1);
        nodes.add(root);
        for(int i = 0; i < n ; i++)
        {
           Node r1 =  Node.update(nodes.get(nodes.size() -1), 0, n-1, indexInTree[i],1);
           nodes.add(r1);
        }

        int value = Node.query(nodes.get(l-1),nodes.get(r+1), 0, n-1, k);
        int ans = sortedArray[value][1];

    }
    static class Node
    {
        int sum;
        Node left;
        Node right;

        Node(int sum)
        {
            this.sum = sum;
        }

        Node(Node left , Node right)
        {
            this.left = left;
            this.right = right;
            this.sum = left.sum + right.sum;
        }

        public static  Node build(int start, int end)
        {
            if(start == end)
            {
                return new Node(0);
            } else
            {
                int mid = start + (end - start)/2;
                return new Node(build(start, mid), build(mid + 1, end));
            }
        }

        public static Node update(Node node, int start, int end, int pos, int val)
        {
            if(start == end)
            {
                return new Node(val);
            } else
            {
                int mid = start + (end - start)/2;
                if(start <= pos && pos <= mid)
                    return new Node(update(node,start, mid, pos, val), node.right);
                else
                {
                    return new Node(node.left, update(node,mid + 1, end, pos, val));

                }
            }
        }

        public static int query(Node past, Node pres , int start, int end , int k)
        {
            if(start == end)
            {
               return start;
            }
            else
            {
                int megCount = pres.left.sum - past.left.sum;
                if(k <= megCount)
                {
                    return query(past.left, pres.left, start, (start+end)/2,k);
                }
                else
                {
                    return query(past.right, pres.right, (start+end)/2 + 1,end, k - megCount);
                }

            }
        }
    }
}
