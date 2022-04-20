package graph.buildorder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
    You are given a list of projects and a list of dependencies (which is a list of pairs of projects,
    where the second project is dependent on the first project). All of a project’s dependencies
    must be built before the project is. Find a build order that will allow the projects to be built.
    If there’s no valid order, return an error.

    Example:
        Input:
            projects: a, b, c, d, e, f
            dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
        Output: f, e, a, b, d, c
 */
public class BuildOrder {

    public static void main(String[] args){


        String[] test = getTest1();

        String[] projects = test[0].split(",");
        List<String[]> dependencies = Arrays.stream(test[1].split(","))
                .map(s -> s.split("<-"))
                .collect(Collectors.toList());

        System.out.println("Projects");
        Arrays.stream(projects).forEach((e) -> System.out.print(e+" "));

        System.out.println("\ndependencies");
        dependencies.forEach((e) -> System.out.println(e[1]+" is dependent on "+e[0]));
        System.out.println();

        GraphProject graph = new GraphProject(projects, dependencies);
        //System.out.println(graph);

        try {//order building....
            String[] taken = graph.buildOrder();
            System.out.println("Built Order");
            for (int i = 0; i < taken.length; i++) {
                if(i>0) System.out.print(", ");
                System.out.print(taken[i]);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println();
    }

    /*
     Example test Case
     Output: f, e, a, b, d, c
     */
    public static String[] getTest1(){

        System.out.println();
        System.out.println("      f      e");
        System.out.println("     / \\      ");
        System.out.println("    a   b     ");
        System.out.println("     \\ /      ");
        System.out.println("      d       ");
        System.out.println("      |       ");
        System.out.println("      c       ");
        System.out.println();

        String projectLine = "a,b,c,d,e,f";
        String depLine = "a<-d,f<-b,b<-d,f<-a,d<-c";

        return new String[]{projectLine,depLine};
    }

    /*
     Output: f, d, b, c, a, h, e, g
     */
    public static String[] getTest2(){

        System.out.println();
        System.out.println("      f     d ");
        System.out.println("     /|\\    | ");
        System.out.println("    c | b   | ");
        System.out.println("     \\|/|\\  | ");
        System.out.println("      a | h | ");
        System.out.println("       \\| | | ");
        System.out.println("        e | | ");
        System.out.println("         \\|/  ");
        System.out.println("          g   ");
        System.out.println();

        String projectLine = "a,b,c,d,e,f,g,h";
        String depLine = "c<-a,b<-h,a<-e,f<-b,d<-g,b<-a,f<-c,b<-e,f<-a,h<-g,e<-g";

        return new String[]{projectLine,depLine};
    }

    /*
     dependency issue between project 'c','a', and 'e'
    */
    public static String[] getTest3(){

        System.out.println();
        System.out.println("      f     d  ");
        System.out.println("     /|\\    |  ");
        System.out.println("    c | b   |  ");
        System.out.println("    |\\|/|\\  |  ");
        System.out.println("    | a | h |  ");
        System.out.println("    |  \\|  \\|  ");
        System.out.println("    --->e   g  ");
        System.out.println();

        //  dependency issue between project 'c','a', and 'e'
        //  because 'c' is dependent on 'e', 'a' is dependent on 'c', and 'e' id dependent on 'a'


        String projectLine = "a,b,c,d,e,f,g,h";
        String depLine = "c<-a,b<-h,a<-e,f<-b,d<-g,b<-a,f<-c,b<-e,f<-a,h<-g,e<-c";

        return new String[]{projectLine,depLine};
    }

}
