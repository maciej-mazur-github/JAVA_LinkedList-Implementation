package com.linkedList.implementation;

public abstract class ListItem {
    protected ListItem leftLink = null;
    protected ListItem rightLink = null;
    private Object value;

    public ListItem(Object value) {
        this.value = value;
    }

    public abstract ListItem next();
    public abstract ListItem setNext(ListItem item);
    public abstract ListItem previous();
    public abstract ListItem setPrevious(ListItem item);

    public abstract int compareTo(ListItem item);

    public Object getValue() {
        return value;
    }
}