package by.ksenia.array.factory;

import by.ksenia.array.entity.ArrayEntity;
import by.ksenia.array.exception.ArrayValidationException;

public class ArrayFactoryImpl implements ArrayFactory {
    @Override
    public ArrayEntity createArray(Long id, int[] data) throws ArrayValidationException {
        if (data == null)
            throw new ArrayValidationException("Array data cannot be null");

        if (data.length == 0)
            throw new ArrayValidationException("Array data cannot be empty");

        return new ArrayEntity(id, data);
    }
}
