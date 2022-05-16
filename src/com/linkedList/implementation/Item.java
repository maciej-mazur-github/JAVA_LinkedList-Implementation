package com.linkedList.implementation;

public abstract class Item {
    protected Item leftLink = null;
    protected Item rightLink = null;
    private Object value;

    public Item(Object value) {
        this.value = value;
    }

    public abstract Item next();
    public abstract Item setNext(Item item);
    public abstract Item previous();
    public abstract Item setPrevious(Item item);

    public abstract int compareTo(Item item);

    public Object getValue() {
        return value;
    }
}
