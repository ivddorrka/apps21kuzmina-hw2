package ua.edu.ucu.collections.immutable;

import junit.framework.TestCase;

public class ImmutableLinkedListTest extends TestCase {

    public void testAdd() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {9, 6, 4, 3, 11, 2, 3});
        ImmutableList newLinkedList = newList.add(-1);
        int[] expected = new int[]{9, 6, 4, 3, 11, 2, 3, -1};
        Object[] actual = newLinkedList.toArray();
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testAddAll() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {1});
        ImmutableList newLinkedList = newList.addAll(new Object[] {0, 5});
        int[] expected = new int[]{1, 0, 5};
        Object[] actual = newLinkedList.toArray();
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }


    public void testGet() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {0, 1, 2, 3, 4, 5, 6});
        Object actual = newList.get(2);
        int expected = 2;
        assertEquals(actual, expected);
    }

    public void testRemove() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        Object[] actual = newList.remove(1).toArray();
        int[] expected = new int[]{1, 3};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testSet() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {0, 1, 2, 3, 4, 5});
        Object[] actual = newList.set(3, 4).toArray();
        int[] expected = new int[]{0, 1, 2, 4, 4, 5};
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testIndexOf() {
        ImmutableLinkedList linked = new ImmutableLinkedList(new Object[] {0, 1, 2, 3});
        int index = linked.indexOf(2);
        assertEquals(index, 2);
    }

    public void testSize() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {0, 9, 9, 1, 2, 3});
        assertEquals(newList.size(), 6);
    }

    public void testClear() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {9,8,6});
        ImmutableList newLinked = newList.clear();
        Object[] actual = newLinked.toArray();
        for (Object o : actual) {
            assertNull(o);
        }
    }

    public void testIsEmpty() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {9,8,6});
        assertFalse(newList.isEmpty());

    }

    public void testToArray() {
        ImmutableLinkedList listLink = new ImmutableLinkedList(new Object[] {1, 1, 1, 1, 1, 1, 1, 1});
        int[] expected = new int[]{1, 1, 1, 1, 1, 1, 1, 1};
        Object[] actual = listLink.toArray();
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testAddFirst() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {11, 22, 33, 4, 2, 3});
        ImmutableLinkedList newLinkedList = newList.addFirst(1001);
        Object[] actual = newLinkedList.toArray();
        Object[] expected = new Object[] {1001, 11, 22, 33, 4, 2, 3};
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testAddLast() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {11, 22, 33, 4, 2, 3});
        ImmutableLinkedList newLinkedList = newList.addLast(1001);
        Object[] actual = newLinkedList.toArray();
        Object[] expected = new Object[] {11, 22, 33, 4, 2, 3, 1001};
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testGetHead() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {0, 1, 2, 3, 4, 5, 6, 7});
        assertEquals(linkedList.getHead().getValue(), 0);
    }

    public void testGetTail() {
        ImmutableLinkedList linkedList = new ImmutableLinkedList(new Object[] {0, 1, 2, 3, 4, 5, 6, 7});
        assertEquals(linkedList.getTail().getValue(), 7);
    }

    public void testGetFirst() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {0, 1, 2, 3, 4, 5, 6, 7});
        assertEquals(newList.getFirst(), 0);
    }

    public void testGetLast() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {0, 1, 2, 3, 4, 5, 6, 7});
        assertEquals(newList.getLast(), 7);
    }

    public void testRemoveFirst() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {1, 2, 3});
        ImmutableLinkedList newLinkedList = newList.removeFirst();
        Object[] actual = newLinkedList.toArray();
        Object[] expected = new Object[] {2, 3};
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testRemoveLast() {
        ImmutableLinkedList newList = new ImmutableLinkedList(new Object[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
        ImmutableLinkedList newLinkedList = newList.removeLast();
        Object[] actual = newLinkedList.toArray();
        Object[] expected = new Object[] {1, 2, 3, 4, 5, 6, 7, 8};
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }
}