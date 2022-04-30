package tree.upright;

import java.util.List;

public class TreeUpright {
    Node root;

    TreeUpright(Integer data, Integer[][] edges){
        root = new Node(data);
        for(Integer[] edge : edges){
            root.addChildren(edge[0], edge[1]);
        }
    }

    public List<Integer> getUprightList(){
        return root.getUprights();
    }


}
