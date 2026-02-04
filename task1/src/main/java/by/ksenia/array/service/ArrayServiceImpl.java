package by.ksenia.array.service;

import by.ksenia.array.entity.ArrayEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArrayServiceImpl implements ArrayService {
    private static final Logger logger = LogManager.getLogger(ArrayServiceImpl.class);

    @Override
    public int findMin(ArrayEntity array) {
        int[] arr = array.getArray();
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        logger.info("Minimum value found: {}", min);
        return min;
    }

    @Override
    public int findMax(ArrayEntity array) {
        int[] arr = array.getArray();
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        logger.info("Maximum value found: {}", max);
        return max;
    }

    @Override
    public int calculateSum(ArrayEntity array) {
        int[] arr = array.getArray();
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        logger.info("Sum calculated: {}", sum);
        return sum;
    }

    @Override
    public ArrayEntity sortWithBubbleSort(ArrayEntity array) {
        int[] arr = array.getArray();
        int n = arr.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
        logger.info("Array sorted with Bubble Sort");
        return new ArrayEntity(arr);
    }

    @Override
    public ArrayEntity sortWithSelectionSort(ArrayEntity array) {
        int[] arr = array.getArray();
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
        logger.info("Array sorted with Selection Sort");
        return new ArrayEntity(arr);    }
}
