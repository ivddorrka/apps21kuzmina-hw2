package ua.edu.ucu.collections;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;


public class Queue {
    private ImmutableLinkedList queueHere = new ImmutableLinkedList();

    public Object peek() {
        return queueHere.getFirst();
    }

    public Object dequeue() {
        Object firstToDelete = queueHere.getFirst();
        queueHere = queueHere.removeFirst();
        return  firstToDelete;
    }

    public void enqueue(Object e) {
        queueHere = queueHere.addLast(e);
    }
}
