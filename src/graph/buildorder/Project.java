package graph.buildorder;

import java.util.*;
import java.util.stream.Collectors;

public class Project implements Comparable<Project>{

    private final String name;
    private int level;
    private final Map<String, Project> parents;
    private final Map<String, Project> children;

    Project(String name){
        this.name = name;
        this.level = 0;
        this.children = new HashMap<>();
        this.parents = new HashMap<>();
    }

    public void addChildren(Project p){
        this.children.put(p.name, p);
    }

    public void addParent(Project p){

        if(p.level + 1 > level ) {
            this.updateLevel(p.level + 1);
        }
        p.addChildren(this);
        this.parents.put(p.name, p);
    }

    public void updateLevel(int level){
        this.level = level;
        for(Project c: children.values()){
            if(c.level < level + 1) {
                c.updateLevel(level+1);
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public Set<String> getParents() {
        return this.parents.keySet();
    }

    public List<Project> getChildren(){
        return this.children.values().stream().toList();
    }

    public boolean hasChildren(String name){
        return this.children.containsKey(name);
    }

    /*
      It is a priority comparison.
      The lower the level, the higher the priority and if two projects have the same level,
      the priority is for the one with the most children.
     */
    @Override
    public int compareTo(Project o) {
        if (level < o.level) {
            return -1;
        } else if (level > o.level) {
            return 1;
        } else {
            int size = children.size();
            int oSize = o.children.size();
            return Integer.compare(oSize, size);
        }
    }

    @Override
    public String toString() {
        return "Project{" +
                "name=" + name +
                ", level=" + level +
                ", parents=( " + parents.keySet().stream().map(s -> s+" ").collect(Collectors.joining()) + ")" +
                ", children=( " + children.keySet().stream().map(s -> s+" ").collect(Collectors.joining()) + ")" +
                '}';
    }
}
