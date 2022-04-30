package tree.upright;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
Given a tree where the nodes are integers, determine how many vertical nodes the tree has,
knowing that a node is vertical if its value is less than the value of all its descendant nodes.
Input: the value of the parent node and the list of edges are received
 */
public class UprightNodes {

    public static void main(String[] arg){
        Map<Integer, Integer[][]> map = getTests();

        Set<Integer> keys = map.keySet();
        for (Integer key: keys){
            TreeUpright tree = new TreeUpright(key, map.get(key));
            List<Integer> uprightList = tree.getUprightList();
            System.out.println("Upright Count: "+uprightList.size());
            uprightList.forEach(data -> System.out.print(data+" "));
            System.out.println();
        }

    }

    public static Map<Integer, Integer[][]> getTests(){

        return new HashMap<>(){{
            put(1, new Integer[][]{
                    {1, 12},
                    {1, 8},
                    {12, 3},
                    {12, 15},
                    {3, 5},
                    {3, 7},
                    {7, 9},
                    {15, 2}
            });
        }};
    }
}
