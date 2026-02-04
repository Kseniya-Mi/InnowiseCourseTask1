package by.ksenia.array.factory;

import by.ksenia.array.entity.ArrayEntity;
import by.ksenia.array.exception.ArrayValidationException;

public interface ArrayFactory {

    ArrayEntity createArray(int[] data) throws ArrayValidationException;
}
