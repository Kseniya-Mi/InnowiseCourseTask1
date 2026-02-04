package by.ksenia.array.service;

import by.ksenia.array.entity.ArrayEntity;

public interface ArrayService {
    int findMin(ArrayEntity array);
    int findMax(ArrayEntity array);
    int calculateSum(ArrayEntity array);
    ArrayEntity sortWithBubbleSort(ArrayEntity array);
    ArrayEntity sortWithSelectionSort(ArrayEntity array);
}
