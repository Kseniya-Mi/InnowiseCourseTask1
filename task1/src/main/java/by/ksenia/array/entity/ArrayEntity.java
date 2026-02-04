package by.ksenia.array.entity;

import java.util.Arrays;

public class ArrayEntity {
    private final int[] array;
    private Long id;

    public ArrayEntity(Long id, int[] array) {
        this.array = array.clone();
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public int[] getArray() {
        return array.clone();
    }

    public int getLength() {
        return array.length;
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
