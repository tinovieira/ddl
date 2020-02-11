import java.util.LinkedList;
import java.util.List;

public class DoublyLinkedList<T> {

    Node<T> head;

    /**
     * Adding a node at the front of the list.
     *
     * @param data the data
     */
    public void push(T data) {
        // allocate node and put in the data
        final Node<T> newNode = new Node<>(data);

        // make next of new node as head and previous as NULL
        newNode.next = head;
        newNode.previous = null;

        // change previous of head node to new node
        if (head != null) {
            head.previous = newNode;
        }

        // move the head to point to the new node
        head = newNode;
    }

    /**
     * Given a node as previous node, insert a new node after the given node.
     *
     * @param previousNode the previous node
     * @param data         the data
     */
    public void insertAfter(Node<T> previousNode, T data) {
        // check if the given previous node is NULL
        if (previousNode == null) {
            return;
        }

        // allocate node and put in the data
        final Node<T> newNode = new Node<>(data);

        // make next of new node as next of previous node
        newNode.next = previousNode.next;

        // make the next of previous node as new node
        previousNode.next = newNode;

        // make previous node as previous of new node
        newNode.previous = previousNode;

        // change previous of new node's next node
        if (newNode.next != null) {
            newNode.next.previous = newNode;
        }
    }

    /**
     * Add a node at the end of the list.
     *
     * @param data the data
     */
    void append(T data) {
        // allocate node and put in the data
        final Node<T> newNode = new Node<>(data);

        // used in step 5
        Node<T> last = head;

        // this new node is going to be the last node, so make next of it as NULL
        newNode.next = null;

        // if the linked list is empty, then make the new node as head
        if (head == null) {
            newNode.previous = null;
            head = newNode;
            return;
        }

        // else traverse till the last node
        while (last.next != null) {
            last = last.next;
        }

        // change the next of last node
        last.next = newNode;

        // make last node as previous of new node
        newNode.previous = last;
    }

    /**
     * Function to delete a node in a Doubly Linked List.
     *
     * @param toDelete data of node to be deleted
     */
    void delete(Node<T> toDelete) {
        // base case
        if (head == null || toDelete == null) {
            return;
        }

        // if node to be deleted is head node
        if (head == toDelete) {
            head = toDelete.next;
        }

        // change next only if node to be deleted is NOT the last node
        if (toDelete.next != null) {
            toDelete.next.previous = toDelete.previous;
        }

        // change prev only if node to be deleted is NOT the first node
        if (toDelete.previous != null) {
            toDelete.previous.next = toDelete.next;
        }
        // garbage collector will free the memory, cause node to delete is not anymore referenced
    }

    /**
     * This function prints contents of linked list starting from the given node
     *
     * @param node the starting node
     */
    public List<T> list(Node<T> node) {
        final List<T> list = new LinkedList<>();

        // traversal in forward direction
        while (node != null) {
            list.add(node.data);
            node = node.next;
        }

        return list;
    }

    /**
     * This function prints contents of linked list starting from the given node
     *
     * @param node the starting node
     */
    public List<T> reverseList(Node<T> node) {
        final List<T> list = new LinkedList<>();

        // go to last node
        Node<T> last = null;
        while (node != null) {
            last = node;
            node = node.next;
        }

        // traversal in reverse direction
        while (last != null) {
            list.add(last.data);
            last = last.previous;
        }

        return list;
    }

    static class Node<T> {
        T data;
        Node<T> previous;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.previous = null;
            this.next = null;
        }
    }
}
