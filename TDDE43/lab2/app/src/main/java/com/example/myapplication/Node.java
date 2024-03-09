package com.example.myapplication;

import java.util.ArrayList;

public class Node {
    String name;
    ArrayList<Node> children = new ArrayList<>();
    Boolean isExpanded=false;
    Node parent;
    public Node(String name){

        this.name= name;
    }
    public Node(String name, ArrayList<Node> children)
    {
        this.name = name;
        this.children = children;
    }
    public void addChild(Node child){
        children.add(child);
        child.parent=this;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }
}
