package ua.edu.ucu.collections.immutable;
import static org.junit.Assert.*;
import junit.framework.TestCase;

public class ImmutableArrayListTest extends TestCase {

    public void testAdd() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[] {-1, 4, 5 ,1});
        ImmutableList outputArray = array.add(0);
        int[] expected = new int[]{-1, 4, 5 ,1, 0};
        Object[] actual = outputArray.toArray();
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testAddAll() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[] {1, 2, 3});
        ImmutableList newArray = array.addAll(new Object[] {4, 6});
        int[] expectedResult = new int[]{1, 2, 3, 4, 6};
        Object[] actualResult = newArray.toArray();
        for (int i = 0; i < expectedResult.length; i ++) {
            assertEquals(actualResult[i], expectedResult[i]);
        }
    }

    public void testGet() {
        ImmutableArrayList arr = new ImmutableArrayList(new Object[]{0, 1, 2, 3, 4});
        int expected = 2;
        Object got = arr.get(2);
        assertEquals(got, expected);
    }

    public void testRemove() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[] {0, 1, 2, 3, 4});
        Object[] actual = arrayList.remove(4).toArray();
        int[] expected = new int[]{0, 1, 2, 3};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testSet() {
        ImmutableArrayList arrayList = new ImmutableArrayList(new Object[]{0, 2, 3, 4, 5, 6, 7, 8, 9});
        Object[] actual = arrayList.set(0, 4).toArray();
        int[] expected = new int[]{4, 2, 3, 4, 5, 6, 7, 8, 9};
        for (int i = 0; i < expected.length; i++) {
            assertEquals(actual[i], expected[i]);
        }
    }

    public void testIndexOf() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[] {0, 1, 2, 3});
        int index = array.indexOf(2);
        assertEquals(index, 2);
    }

    public void testSize() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[] {0, 1, 2, 3, 4, 5, 6});
        assertEquals(array.size(), 7);
    }
    public void testClear() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[] {0, 1, 2, 3, 4, 5, 6});
        ImmutableList newArray = array.clear();
        Object[] actualResult = newArray.toArray();
        for (Object o : actualResult) {
            assertNull(o);
        }
    }

    public void testIsEmpty() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[] {});
        assertEquals(array.size(), 0);
    }

    public void testToArray() {
        ImmutableArrayList array = new ImmutableArrayList(new Object[] {1, 2, 3});
        int[] expected = new int[]{1, 2, 3};
        Object[] actual = array.toArray();
        for (int i = 0; i < expected.length; i ++) {
            assertEquals(actual[i], expected[i]);
        }
    }
}