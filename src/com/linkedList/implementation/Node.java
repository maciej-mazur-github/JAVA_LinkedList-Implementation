package com.linkedList.implementation;

public class Node extends ListItem{
    public Node(Object value) {
        super(value);
    }

    @Override
    public ListItem next() {
        return rightLink;
    }

    @Override
    public ListItem setNext(ListItem item) {
        rightLink = item;
        return item;
    }

    @Override
    public ListItem previous() {
        return leftLink;
    }

    @Override
    public ListItem setPrevious(ListItem item) {
        leftLink = item;
        return item;
    }

    @Override
    public int compareTo(ListItem item) {
        return ((String) super.getValue()).compareTo((String) item.getValue());
    }
}






