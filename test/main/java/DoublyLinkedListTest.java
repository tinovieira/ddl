import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class DoublyLinkedListTest {

    @Test
    public void testSinglePush() {
        DoublyLinkedList<Integer> ddl = new DoublyLinkedList<>();

        ddl.push(1);

        Assert.assertNotNull(ddl.head);
        Assert.assertEquals(Integer.valueOf(1), ddl.head.data);
        Assert.assertNull(ddl.head.next);
    }

    @Test
    public void testDoublePush() {
        DoublyLinkedList<Integer> ddl = new DoublyLinkedList<>();

        ddl.push(2);
        ddl.push(1);

        Assert.assertNotNull(ddl.head);
        Assert.assertEquals(Integer.valueOf(1), ddl.head.data);
        Assert.assertEquals(Integer.valueOf(2), ddl.head.next.data);
        Assert.assertNull(ddl.head.next.next);
    }

    @Test
    public void testAppend() {
        DoublyLinkedList<Integer> ddl = new DoublyLinkedList<>();

        ddl.push(2);
        ddl.push(1);
        ddl.append(3);

        Assert.assertNotNull(ddl.head);
        Assert.assertEquals(Integer.valueOf(1), ddl.head.data);
        Assert.assertEquals(Integer.valueOf(2), ddl.head.next.data);
        Assert.assertEquals(Integer.valueOf(3), ddl.head.next.next.data);
    }

    @Test
    public void testInsertAfter() {
        DoublyLinkedList<Integer> ddl = new DoublyLinkedList<>();

        ddl.push(2);
        ddl.push(1);
        ddl.append(4);

        // this is node with data 2
        DoublyLinkedList.Node<Integer> previousNode = ddl.head.next;

        ddl.insertAfter(previousNode, 3);

        Assert.assertNotNull(ddl.head);
        Assert.assertEquals(Integer.valueOf(1), ddl.head.data);
        Assert.assertEquals(Integer.valueOf(2), ddl.head.next.data);
        Assert.assertEquals(Integer.valueOf(3), ddl.head.next.next.data);
        Assert.assertEquals(Integer.valueOf(4), ddl.head.next.next.next.data);
    }

    @Test
    public void testDelete() {
        DoublyLinkedList<Integer> ddl = new DoublyLinkedList<>();

        ddl.push(2);
        ddl.push(1);
        ddl.append(5);
        ddl.append(3);

        // this is node with data 5
        DoublyLinkedList.Node<Integer> toDelete = ddl.head.next.next;

        ddl.delete(toDelete);

        Assert.assertNotNull(ddl.head);
        Assert.assertEquals(Integer.valueOf(1), ddl.head.data);
        Assert.assertEquals(Integer.valueOf(2), ddl.head.next.data);
        Assert.assertEquals(Integer.valueOf(3), ddl.head.next.next.data);
    }

    @Test
    public void testOrder() {
        DoublyLinkedList<Integer> ddl = new DoublyLinkedList<>();

        ddl.push(2);
        ddl.push(1);
        ddl.append(3);

        LinkedList<Integer> integers = (LinkedList<Integer>) ddl.list(ddl.head);

        Assert.assertEquals(Integer.valueOf(1), integers.getFirst());
        Assert.assertEquals(Integer.valueOf(3), integers.getLast());
    }

    @Test
    public void testReverseOrder() {
        DoublyLinkedList<Integer> ddl = new DoublyLinkedList<>();

        ddl.push(2);
        ddl.push(1);
        ddl.append(3);

        LinkedList<Integer> integers = (LinkedList<Integer>) ddl.reverseList(ddl.head);

        Assert.assertEquals(Integer.valueOf(3), integers.getFirst());
        Assert.assertEquals(Integer.valueOf(1), integers.getLast());
    }

}
