package com.linkedList.implementation;

public interface List {
    Item getRoot();
    void addItem(Object item);
    void removeItem(Object item);
    Item containsItem(Object item);
    void traverseList();
}
