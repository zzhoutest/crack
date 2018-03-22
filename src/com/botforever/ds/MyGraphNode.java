package com.botforever.ds;

import java.util.ArrayList;

public class MyGraphNode {
    public String name;
    public ArrayList<MyGraphNode> children = new ArrayList<MyGraphNode>();
    public boolean visited = false;
    public MyGraphNode(String n) {
        name = n;
    }
    public void visit(String target) {
        visited = true;
        System.out.print(name + " ");
        if (name.equalsIgnoreCase(target)) {
            System.out.println(" route to target is found");
        }
    }
}
