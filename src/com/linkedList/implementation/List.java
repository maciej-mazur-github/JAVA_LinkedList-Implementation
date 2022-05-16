package com.linkedList.implementation;

public interface List {
    Item getRoot();
    boolean addItem(Item item);
    boolean removeItem(Item item);
    void traverseList();
}
