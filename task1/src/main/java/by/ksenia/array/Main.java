package by.ksenia.array;

import by.ksenia.array.entity.ArrayEntity;
import by.ksenia.array.exception.ArrayValidationException;
import by.ksenia.array.factory.ArrayFactory;
import by.ksenia.array.factory.ArrayFactoryImpl;
import by.ksenia.array.reader.ArrayFileReader;
import by.ksenia.array.service.ArrayService;
import by.ksenia.array.service.ArrayServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {
            List<int[]> arraysData = ArrayFileReader.readArraysFromFile("input.txt");
            ArrayFactory factory = new ArrayFactoryImpl();
            ArrayService service = new ArrayServiceImpl();

            for (int[] data : arraysData) {
                ArrayEntity array = factory.createArray(data);

                logger.info("Processing array with {} elements", array.getLength());

                int min = service.findMin(array);
                int max = service.findMax(array);
                int sum = service.calculateSum(array);

                logger.info("Min: {}, Max: {}, Sum: {}", min, max, sum);

                ArrayEntity sorted1 = service.sortWithBubbleSort(array);
                ArrayEntity sorted2 = service.sortWithSelectionSort(array);
            }

        } catch (ArrayValidationException e) {
            logger.error("Error processing arrays: {}", e.getMessage(), e);
        }
    }
}
