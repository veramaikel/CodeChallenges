package tree.upright;

import java.util.*;

public class Node {
    Integer data;
    Map<Integer, Node> children;
    boolean upright;

    Node(Integer data){
        this.data = data;
        children = new HashMap<>();
        upright = false;
    }

    private Node addChildren(Integer data){
        if(children.isEmpty() && data > this.data) upright = true;
        if(upright && data < this.data) upright = false;

        return children.put(data, new Node(data));
    }

    public Node addChildren(Integer father, Integer child){
        if(Objects.equals(data, father)) return addChildren(child);

        if(children.isEmpty()) return null;

        Collection<Node> nodes = children.values();
        for (Node node: nodes) {
            Node aux = node.addChildren(father, child);
            if(aux!=null) {
                if(upright && data < child) upright = false;
                return aux;
            }
        }

        return null;
    }

    public List<Integer> getUprights(){
        List<Integer> list = new ArrayList<>();

        if(upright) list.add(data);

        Collection<Node> nodes = children.values();
        for (Node node: nodes) {
            list.addAll(node.getUprights());
        }

        return list;
    }

    public Integer getData(){
        return this.data;
    }
}
