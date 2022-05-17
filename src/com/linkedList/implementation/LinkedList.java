package com.linkedList.implementation;

public class LinkedList implements List {
    private Item root = null;


    @Override
    public Item getRoot() {
        return root;
    }

    @Override
    public void addItem(Item newItem) {
        if(root == null) {  // the list has still been empty
            root = newItem;
            System.out.println("\"" + (String) newItem.getValue() + "\" successfully added to the list as a first element");
            return;
        }

        Item currentItem = root;
        int comparison;

        while(true) {
            comparison = currentItem.compareTo(newItem);

            if(comparison < 0) {  // added newItem is greater than the current newItem
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();  // this will lead to while loop make another iteration, this time for current item's successor
                } else {  // current item was the last item in the list the new item needs to be appended right after the current item
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    System.out.println("\"" + (String) newItem.getValue() + "\" has been successfully added at the end of the list");
                    return;
                }

            } else if(comparison > 0) {  // added newItem is less than the current newItem
                if(currentItem == root) {
                    root = newItem;
                    newItem.setPrevious(root);
                    newItem.setNext(currentItem).setPrevious(newItem);
                    System.out.println("\"" + (String) newItem.getValue() + "\" has been successfully added as a new list root");
                } else {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                    System.out.println("\"" + (String) newItem.getValue() + "\" has been successfully added to the list in ascending order");
                }

                return;

            } else {    // if added value is already present in the list
                System.out.println("\"" + (String) newItem.getValue() + "\" has already been present in the list. Not added.");
                return;
            }
        }
    }

    @Override
    public void removeItem(Item removedItem) {
        if(root == null) {
            System.out.println("The list is empty. Nothing to remove");
            return;
        }

        if(removedItem == root) {
            if(root.next() == null) {  // if the list contains root only and no other removedItems
                root = null;
                System.out.println("\"" + (String) removedItem.getValue() + "\" successfully removed. The list is empty now");
            } else {                    // the list contains at least 2 removedItems
                root.setNext(root.next()).setPrevious(null);
                System.out.println("\"" + (String) removedItem.getValue() + "\" was the first element in the list and has been successfully deleted");
            }

            return;
        }
        
        if(root.next() == null) {  // if list has one element only and it is not equal to removed removedItem
            System.out.println("\"" + (String) removedItem.getValue() + "\" could not be found in the list, hence no deletion processed");
            return;
        }

        Item currentItem = root.next();
        int comparison;
        
        while(true) {
            comparison = currentItem.compareTo(removedItem);

            if(comparison > 0) {  // searched item is less than the current item, which means it is not present in the list (any further list items will only be even greater)
                System.out.println();
            }
        }

    }

    @Override
    public void traverseList() {

    }
}
