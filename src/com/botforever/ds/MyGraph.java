package com.botforever.ds;

import java.util.*;

public class MyGraph {
    public ArrayList<MyGraphNode> nodes;
    public MyGraph(String[][] array) {
        nodes = new ArrayList<MyGraphNode>(array.length);
        for (int i = 0; i < array.length; i++) {
            MyGraphNode base = this.getNode(array[i][0]);
            if (base == null) {
                base = new MyGraphNode(array[i][0]);
                nodes.add(base);
            }

            for (int j = 1; j < array[i].length; j++) {
                MyGraphNode child = this.getNode(array[i][j]);
                if (child == null) {
                    child = new MyGraphNode(array[i][j]);
                    nodes.add(child);
                }
                base.children.add(child);
            }
        }

    }
    public boolean contains(String name) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != null && nodes.get(i).name.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }
    private MyGraphNode getNode(String name) {
        for (int i = 0; i < nodes.size(); i++) {
            if (nodes.get(i) != null && nodes.get(i).name.equalsIgnoreCase(name)) {
                return nodes.get(i);
            }
        }
        return null;
    }
    public void print() {
        for (int i = 0; i < nodes.size(); i++) {
            MyGraphNode base = nodes.get(i);
            System.out.print(base.name + ": ");
            for (int j = 0; j < base.children.size(); j++) {
                System.out.print(base.children.get(j).name + " ");
            }
            System.out.println();
        }
    }

    public void dsf(String name, String target) {
        MyGraphNode base = getNode(name);
        if (base == null) return;
        base.visit(target);
        for (int i = 0; i < base.children.size(); i++) {
            MyGraphNode child = base.children.get(i);
            if (child != null && !child.visited) {
                dsf(child.name, target);
            }
        }
    }

    public void bsf(String name, String target) {
        LinkedList<MyGraphNode> queue = new LinkedList<MyGraphNode>();
        MyGraphNode base = getNode(name);
        queue.add(base);

        while (!queue.isEmpty()) {
            MyGraphNode node = queue.removeFirst();
            node.visit(target);
            for (int i = 0; i < node.children.size(); i++) {
                MyGraphNode child = node.children.get(i);
                if (!child.visited) {
                    queue.add(child);
                }
            }
        }
    }
}
