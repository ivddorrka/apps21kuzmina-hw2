package ua.edu.ucu.collections.immutable;

import java.util.Arrays;
import java.util.Objects;

public final class ImmutableArrayList implements ImmutableList {
    private final int length;
    private final Object[] array;

    public ImmutableArrayList(Object[] elements) {
        if (elements.length==0){
            this.array = new Object[]{};
            this.length = 0;
        } else {
            this.array = Arrays.copyOf(elements, elements.length);
            this.length = elements.length;
        }
    }
    public ImmutableArrayList() {
        this.array = new Object[]{};
        this.length = 0;
    }

    @Override
    public ImmutableList add(Object e) {
        return add(array.length, e);
    }

    @Override
    public ImmutableList add(int index, Object e) {
        return addAll(index, new Object[]{e});
    }

    @Override
    public ImmutableList addAll(Object[] c) {
        return addAll(array.length, c);
    }

    @Override
    public ImmutableList addAll(int index, Object[] c) {
        if (index > size() || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] arrayResult = new Object[array.length+c.length];
        int j = 0;
        int i = 0;
        while (i < index) {
            arrayResult[i] = array[j];
            i++;
            j++;
        }

        for (Object elem: c) {
            arrayResult[j] = elem;
            j++;
        }

        while (j < array.length) {
            arrayResult[i] = array[j];
            j++;
            i++;
        }

        return new ImmutableArrayList(arrayResult);
    }


    @Override
    public Object get(int index) {
        if (index >= array.length || index < 0) {
            throw new IllegalArgumentException();
        }
        return array[index];
    }

    @Override
    public ImmutableList remove(int index) {
        if (index >= array.length || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] returnList = new Object[array.length - 1];
        for (int i = 0; i < returnList.length; i++) {
            if (i >= index) {
                returnList[i] = get(i+1);
            }
            else {
                returnList[i] = get(i);
            }
        }
        return new ImmutableArrayList(returnList);
    }

    @Override
    public ImmutableList set(int index, Object e) {
        if (index >= array.length || index < 0) {
            throw new IllegalArgumentException();
        }
        Object[] setArray = toArray();
        setArray[index] = e;
        return new ImmutableArrayList(setArray);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == e) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public ImmutableList clear() {
        Object[] newArray = new Object[this.length];
        return new ImmutableArrayList(newArray);
    }

    @Override
    public boolean isEmpty() {
        return this.length == 0;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(this.array, this.length);
    }
}
