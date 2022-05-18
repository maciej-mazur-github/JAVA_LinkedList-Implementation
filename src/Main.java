import com.linkedList.implementation.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList myList = new LinkedList();
        String string = "CDABE";
        String[] array = string.split("");

        for(String s : array) {
            myList.addItem(s);
        }

        myList.traverseList();

        myList.removeItem("B");
        myList.traverseList();
        myList.addItem("A");
        myList.traverseList();
        myList.containsItem();

    }
}
