package Trees;

import java.security.PublicKey;

public class SerializeAndDeserializeBT {
    String  s = "";
    public String serialize(Tree node) {
        serializeInOrder(node);
        return s;
    }

    private void serializeInOrder(Tree node)
    {
        if(node == null)
        {
            s +=  "#,";
            return;
        }
        s += node.data + ",";
        serializeInOrder(node.left);
        serializeInOrder(node.right);
    }

    public Tree des(String s)
    {
       this.s = s;
       return Deserialize();
    }
    public Tree Deserialize()
    {
        if(s.charAt(0) == '#')
        {
            s = s.substring(2);
            return null;
        }
        Tree node = new Tree(Character.getNumericValue(s.charAt(0)));
        s = s.substring(2);
        node.left= Deserialize();
        node.right = Deserialize();
        return node;
    }
    }