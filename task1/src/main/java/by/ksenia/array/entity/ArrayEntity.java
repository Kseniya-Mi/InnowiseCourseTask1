package by.ksenia.array.entity;

import java.util.Arrays;

public class ArrayEntity {
    private final int[] array;

    public ArrayEntity(int[] array) {
        this.array = array.clone();
    }

    public int[] getArray() {
        return array.clone();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (this == obj) {
            return true;
        }

        if (this.getClass() != obj.getClass()) {
            return false;
        }

        ArrayEntity arr = (ArrayEntity) obj;

        return Arrays.equals(this.array, arr.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
