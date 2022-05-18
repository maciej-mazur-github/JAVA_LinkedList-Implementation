package com.linkedList.implementation;

public class LinkedList implements List {
    private Item root = null;


    @Override
    public Item getRoot() {
        return root;
    }

    @Override
    public void addItem(Object newItem) {
        Item newNode = new Node(newItem);
        
        if(root == null) {  // the list has still been empty
            root = newNode;
            //System.out.println("\"" + (String) newNode.getValue() + "\" successfully added to the list as a first element");
            return;
        }

        Item currentItem = root;
        int comparison;

        while(true) {
            comparison = currentItem.compareTo(newNode);

            if(comparison < 0) {  // added newNode is greater than the current newNode
                if(currentItem.next() != null) {
                    currentItem = currentItem.next();  // this will lead to while loop make another iteration, this time for current item's successor
                } else {  // current item was the last item in the list the new item needs to be appended right after the current item
                    currentItem.setNext(newNode).setPrevious(currentItem);
                    //System.out.println("\"" + (String) newNode.getValue() + "\" has been successfully added at the end of the list");
                    return;
                }

            } else if(comparison > 0) {  // added newNode is less than the current newNode
                if(currentItem == root) {
                    root = newNode;
                    newNode.setPrevious(root);
                    newNode.setNext(currentItem).setPrevious(newNode);
                    //System.out.println("\"" + (String) newNode.getValue() + "\" has been successfully added as a new list root");
                } else {
                    currentItem.previous().setNext(newNode).setPrevious(currentItem.previous());
                    newNode.setNext(currentItem).setPrevious(newNode);
                    //System.out.println("\"" + (String) newNode.getValue() + "\" has been successfully added to the list in ascending order");
                }

                return;

            } else {    // if added value is already present in the list
                System.out.println("\"" + (String) newNode.getValue() + "\" has already been present in the list. Not added.");
                return;
            }
        }
    }

    @Override
    public void removeItem(Object removedItem) {
        Item removedNode = new Node(removedItem);
        
        if(root == null) {
            System.out.println("The list is empty. Nothing to remove");
            return;
        }


        if(removedNode.compareTo(root) == 0) {   // if the searched for item is actually the root
            if(root.next() == null) {  // if the list contains root only and no other removedNodes
                root = null;
                System.out.println("\"" + (String) removedNode.getValue() + "\" successfully removed. The list is empty now");
            } else {                    // the list contains at least 2 removedNodes
                root.setNext(root.next()).setPrevious(null);
                System.out.println("\"" + (String) removedNode.getValue() + "\" was the first element in the list and has been successfully deleted");
            }

            return;
        }
        
        if(root.next() == null) {  // if list has one element only and it is not equal to removed removedNode
            System.out.println("\"" + (String) removedNode.getValue() + "\" could not be found in the list, hence no deletion processed");
            return;
        }

        Item currentItem = root.next();
        int comparison;
        
        while(true) {
            comparison = currentItem.compareTo(removedNode);

            if(comparison > 0) {  // searched item is less than the current item, which means it is not present in the list (any further list items will only be even greater)
                System.out.println("\"" + (String) removedNode.getValue() + "\" could not be found in the list, hence no deletion processed");
                return;
            } else if(comparison < 0) {  // searched item is greater than the current one
                if(currentItem.next() == null) {  // no more items in the list, hence the item searched for is not present in the list
                    System.out.println("\"" + (String) removedNode.getValue() + "\" could not be found in the list, hence no deletion processed");
                    return;
                } else {
                    currentItem = currentItem.next();  // this will lead to another while loop iteration for the next element in the list
                }
            } else {   // found the item supposed to be removed
                if(currentItem.next() == null) { // removed item is the last element in the list
                    System.out.println("\"" + (String) removedNode.getValue() + "\" successfully removed from the end of the list");
                    currentItem.previous().setNext(null);
                } else {
                    System.out.println("\"" + (String) removedNode.getValue() + "\" successfully removed from the list");
                    currentItem.previous().setNext(currentItem.next()).setPrevious(currentItem.previous());
                }

                return;
            }
        }

    }

    @Override
    public void traverseList() {
        if(root == null) {
            System.out.println("\nThe list is empty");
            return;
        }

        System.out.println("Current List status:");
        System.out.print("\t");

        Item currentItem = root;

        while(currentItem != null) {
            System.out.print("\"" + (String)currentItem.getValue() + "\"");

            if(currentItem.next() != null) {
                System.out.print(", ");
            } else {
                System.out.println("\n");
            }

            currentItem = currentItem.next();
        }
    }
}

















