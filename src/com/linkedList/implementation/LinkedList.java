package com.linkedList.implementation;

import java.util.Scanner;

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
                    return;
                }

            } else if(comparison > 0) {  // added newNode is less than the current newNode
                if(currentItem == root) {
                    root = newNode;
                    newNode.setNext(currentItem).setPrevious(newNode);
                } else {
                    currentItem.previous().setNext(newNode).setPrevious(currentItem.previous());
                    newNode.setNext(currentItem).setPrevious(newNode);
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
        if(root == null) {
            System.out.println("The list is empty. Nothing to remove");
            return;
        }

        Item foundItem = containsItem(removedItem);

        if(foundItem == null) {
            System.out.println("\"" + removedItem + "\" could not be found in the list, hence no deletion processed");
            return;
        }

        if(foundItem.previous() == null && foundItem.next() == null) {    // if the searched for item is actually the root and is the only one element in the list
            root = null;
            System.out.println("\"" + removedItem + "\" successfully removed. The list is empty now");
        } else if(foundItem.previous() == null && foundItem.next() != null) {  // if item is the root but there is at least one element more in the list
            root = root.next();
            root.setPrevious(null);
            System.out.println("\"" + removedItem + "\" was the first element in the list and has been successfully deleted");
        } else if(foundItem.previous() != null && foundItem.next() != null) {  // if the item is in middle of the list, having at least one previous element and at least one next element
            System.out.println("\"" + removedItem + "\" successfully removed from the list");
            foundItem.previous().setNext(foundItem.next()).setPrevious(foundItem.previous());
        } else {                                            // if the item is at the last position in the list, having no successor
            System.out.println("\"" + removedItem + "\" successfully removed from the end of the list");
            foundItem.previous().setNext(null);
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


    @Override
    public Item containsItem(Object searchedItem) {
        if(root == null) {
            System.out.println("The list is empty.");
            return null;
        }

        Item searchedNode = new Node(searchedItem);

        if(searchedNode.compareTo(root) == 0) {   // if the searched for item is actually the root
            return root;
        }

        if(root.next() == null) {  // if list has one element only and it is not equal to removed searchedNode
            return null;
        }

        Item currentItem = root.next();
        int comparison;

        while(true) {
            comparison = currentItem.compareTo(searchedNode);

            if(comparison > 0) {  // searched item is less than the current item, which means it is not present in the list (any further list items will only be even greater)
                return null;
            } else if(comparison < 0) {  // searched item is greater than the current one
                if(currentItem.next() == null) {  // no more items in the list, hence the item searched for is not present in the list
                    return null;
                } else {
                    currentItem = currentItem.next();  // this will lead to another while loop iteration for the next element in the list
                }
            } else {   // found the item supposed to be removed
                return currentItem;
            }
        }
    }


    public void containsItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What element are you searching for?: ");
        String choice = scanner.nextLine();
        Item foundItem = containsItem(choice);

        if(foundItem != null) {
            System.out.println("\"" + choice + "\" found in the List");
        } else {
            System.out.println("\"" + choice + "\" NOT found in the List");
        }
    }
}

















