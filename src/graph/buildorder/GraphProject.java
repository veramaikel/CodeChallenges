package graph.buildorder;

import java.util.*;
import java.util.stream.Collectors;

public class GraphProject {
    private final Map<String, Project> projects = new HashMap<>();

    GraphProject(String[] projects, List<String[]> dependencies){
        for (String p: projects){
            this.projects.put(p, new Project(p));
        }

        for (String[] d: dependencies){
            Project father = this.projects.get(d[0]);
            Project child = this.projects.get(d[1]);

            child.addParent(father);
        }
    }

    public String[] buildOrder() {

        List<String> taken = new ArrayList<>();
        List<Project> orderedProject = getOrderedProject();
        for (Project p : orderedProject) {
            if(isValidOrder(p, taken)) {
                taken.add(p.getName());
            }
            else {//there is a dependency that is not taken by circular dependency issue
                throw new IllegalStateException(getErrorMessage(p));
            }
        }

        return taken.toArray(String[]::new);
    }

    private List<Project> getOrderedProject(){

        return projects.values().stream().sorted().collect(Collectors.toList());
    }

    private boolean isValidOrder(Project project, List<String> taken){

        if(!taken.isEmpty() && !project.getParents().isEmpty()){
            return taken.containsAll(project.getParents());
        }

        return true;
    }

    private String getErrorMessage(Project project){
        List<String> cycle = findChild(project, project);
        cycle.add(project.getName());

        StringBuilder message = new StringBuilder("No valid order: circular dependency between projects ");
        for (int i = 0; i < cycle.size(); i++) {
            if(i> 0 && i < cycle.size()-1) message.append(", ");
            else if(i == cycle.size()-1) message.append(", and ");
            message.append(cycle.get(i));
        }

        return message.toString();
    }

    private List<String> findChild(Project project, Project target){
        List<String> cycle = new ArrayList<>();
        List<Project> children = project.getChildren();
        for (Project child : children){
            if(child.hasChildren(target.getName())){
                cycle.add(child.getName());
                break;
            }
            else cycle = findChild(child, target);
            if(!cycle.isEmpty()) {
                cycle.add(child.getName());
                break;
            }
        }

        return cycle;
    }

    @Override
    public String toString() {
        return "GraphProject{" +
                "\t\n" + projects.values().stream().sorted()
                .map(project -> project.toString()+"\n")
                .collect(Collectors.joining()) +
                "}";
    }
}
