package by.ksenia.array.service;

import by.ksenia.array.entity.ArrayEntity;

public interface ArrayService {
    int findMin(ArrayEntity array);
    int findMax(ArrayEntity array);
    int calculateSum(ArrayEntity array);
    void sortWithBubbleSort(ArrayEntity array);
    void sortWithSelectionSort(ArrayEntity array);
}
