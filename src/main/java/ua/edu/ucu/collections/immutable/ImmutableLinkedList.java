package ua.edu.ucu.collections.immutable;

public final class ImmutableLinkedList implements ImmutableList {
    private Node head;
    private final Node tail;
    private final int length;

    public ImmutableLinkedList(Object[] elements) {
        int length1;
        Node prevNode = null;
        length1 = 0;
        for (Object element: elements) {
            length1++;
            Node thisNode = new Node();
            thisNode.setValue(element);
            thisNode.setPrevious(prevNode);
            if (prevNode != null) {
                prevNode.setNext(thisNode);
            } else {
                head = thisNode;
            }
            prevNode = thisNode;
        }
        length = length1;
        tail = prevNode;
    }

    public ImmutableLinkedList() {
        head = null;
        tail = null;
        length = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(size(), c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > length || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] arrayElements = new Object[length + c.length];
        int i = 0;
        Node headNode = head;
        while (i < index) {
            arrayElements[i] = headNode.getValue();
            headNode = headNode.getNext();
            i++;
        }

        for (Object inserted: c) {
            arrayElements[i] = inserted;
            i++;
        }

        while (headNode != null) {
            arrayElements[i] = headNode.getValue();
            headNode = headNode.getNext();
            i++;
        }

        return new ImmutableLinkedList(arrayElements);

    }

    @Override
    public Object get(int index) {
        if (index >= length || index < 0) {
            throw new IllegalArgumentException();
        }
        Node headNode = head;
        int i = 0;
        while (i != index) {
            headNode = headNode.getNext();
            i++;
        }
        return headNode.getValue();
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= length || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newList = new Object[length-1];
        Node headNode = head;
        int i = 0;
        while (headNode != null) {
            if (i == index){
                headNode = headNode.getNext();
            }
            newList[i] = headNode.getValue();
            headNode = headNode.getNext();
            i++;
        }
        return new ImmutableLinkedList(newList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= length || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] newList = toArray();
        newList[index] = e;
        return new ImmutableLinkedList(newList);

    }

    @Override
    public int indexOf(Object e) {
        Node headNode = head;
        int i = 0;
        while (headNode != null) {
            if (headNode.getValue()==e){
                return i;
            }
            i++;
            headNode = headNode.getNext();
        }
        return -1;
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public ImmutableList clear() {
        Object[] arrayNew = toArray();
        for(int i = 0; i<length; i++) {
            arrayNew[i] = null;
        }
        return new ImmutableLinkedList(arrayNew);
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    @Override
    public Object[] toArray() {
        Object[] arrayList = new Object[length];
        Node headNode = head;
        int i = 0;
        while (headNode != null) {
            arrayList[i] = headNode.getValue();
            i++;
            headNode = headNode.getNext();
        }
        return arrayList;
    }

    public ImmutableLinkedList addFirst(Object e) {
        Object[] wasList = toArray();
        Object[] newList = new Object[length+1];

        newList[0] = e;
        for (int i = 1; i < length + 1; i++) {
            newList[i] = wasList[i-1];
        }
        return new ImmutableLinkedList(newList);

    }

    public ImmutableLinkedList addLast(Object e) {
        Object[] wasList = toArray();
        Object[] newList = new Object[length+1];

        for (int i = 0; i < length; i++) {
            newList[i] = wasList[i];
        }

        newList[length] = e;
        return new ImmutableLinkedList(newList);

    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Object getFirst() {
        return head.getValue();
    }

    public Object getLast() {
        return tail.getValue();
    }

    public ImmutableLinkedList removeFirst() {
        Object[] newList = new Object[length-1];
        Node headNode = head.getNext();
        int i = 0;
        while (headNode != null) {
            newList[i] = headNode.getValue();
            headNode = headNode.getNext();
            i++;
        }
        return new ImmutableLinkedList(newList);

    }

    public ImmutableLinkedList removeLast() {
        Object[] wasList = toArray();
        Object[] newList = new Object[length-1];

        for (int i = 0; i < length-1; i++) {
            newList[i] = wasList[i];
        }
        return new ImmutableLinkedList(newList);

    }
}
