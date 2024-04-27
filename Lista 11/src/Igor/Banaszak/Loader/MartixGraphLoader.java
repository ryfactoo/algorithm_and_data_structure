package Igor.Banaszak.Loader;


import Igor.Banaszak.Digraph.AdjacencyMatrixWeightedDigraph;
import Igor.Banaszak.Digraph.IWeightedDigraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MartixGraphLoader extends Loader{

    private static Scanner scanner;
    private static Pattern pattern;
    private static Matcher matcher;

    public static AdjacencyMatrixWeightedDigraph loadDirectedGraph(String path) throws MalformedGraphDescriptionException {
        int lineCount = 1;
        int size;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        pattern = Pattern.compile("\\s*(\\d+)\\s*");
        String stringLine = scanner.nextLine();
        IWeightedDigraph digraph;
        matcher = pattern.matcher(stringLine);
        if(matcher.matches()){
            digraph = new AdjacencyMatrixWeightedDigraph(size = Integer.parseInt(matcher.group(1)));
            pattern = Pattern.compile("\\s*(u{0,1})\\s*(\\d+)\\s*(\\d+)\\s*(\\-{0,1}\\d+\\.{0,1}\\d*)\\s*");
            while(scanner.hasNextLine()){
                stringLine = scanner.nextLine();
                matcher = pattern.matcher(stringLine);
                lineCount++;
                if(matcher.matches()){
                    if(matcher.group(1).isBlank()){
                        if (Integer.parseInt(matcher.group(2)) >= size || Integer.parseInt(matcher.group(3)) >= size ){
                            throw new MalformedGraphDescriptionException(lineCount, stringLine,"size is " + size + " remember about 0 ;)");

                        }
                        if (!digraph.addEdge(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Double.parseDouble(matcher.group(4)))){
                            throw new MalformedGraphDescriptionException(lineCount, stringLine,"this edge exists");
                        }
                    } else {
                        digraph.addEdgeU(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Double.parseDouble(matcher.group(4)));
                    }
                } else {
                    throw new MalformedGraphDescriptionException(lineCount, stringLine,"(optional) u  2 x non-negative integers  1 double");
                }
            }
        } else {
            throw new MalformedGraphDescriptionException(lineCount, stringLine,"positive integer");
        }
        return (AdjacencyMatrixWeightedDigraph) digraph;


    }

    public static AdjacencyMatrixWeightedDigraph loadUndirectedGraph(String path) throws MalformedGraphDescriptionException {
        int lineCount = 1;
        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        pattern = Pattern.compile("\\s*(\\d+)\\s*");
        String stringLine = scanner.nextLine();
        IWeightedDigraph digraph;
        matcher = pattern.matcher(stringLine);
        if(matcher.matches()){
            digraph = new AdjacencyMatrixWeightedDigraph(Integer.parseInt(matcher.group(1)));
            pattern = Pattern.compile("\\s*(u{1})\\s*(\\d+)\\s*(\\d+)\\s*(\\-{0,1}\\d+\\.{0,1}\\d*)\\s*");
            while(scanner.hasNextLine()){
                stringLine = scanner.nextLine();
                matcher = pattern.matcher(stringLine);
                lineCount++;
                if(matcher.matches()){
                    digraph.addEdgeU(Integer.parseInt(matcher.group(2)), Integer.parseInt(matcher.group(3)), Double.parseDouble(matcher.group(4)));
                } else {
                    throw new MalformedGraphDescriptionException(lineCount, stringLine,  "u  2 x non-negative integers  1 double");
                }
            }
        } else {
            throw new MalformedGraphDescriptionException(lineCount, stringLine,"positive integer");
        }
        return (AdjacencyMatrixWeightedDigraph) digraph;

    }
}
