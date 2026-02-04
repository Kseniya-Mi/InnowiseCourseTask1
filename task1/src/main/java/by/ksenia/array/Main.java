package by.ksenia.array;

import by.ksenia.array.entity.ArrayEntity;
import by.ksenia.array.exception.ArrayValidationException;
import by.ksenia.array.factory.ArrayFactory;
import by.ksenia.array.factory.ArrayFactoryImpl;
import by.ksenia.array.parser.DataParser;
import by.ksenia.array.parser.DataParserImpl;
import by.ksenia.array.reader.ArrayFileReader;
import by.ksenia.array.reader.ArrayFileReaderImpl;
import by.ksenia.array.service.ArrayService;
import by.ksenia.array.service.ArrayServiceImpl;
import by.ksenia.array.validator.DataValidator;
import by.ksenia.array.validator.DataValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);

    public static void main(String[] args) {
        try {

            DataValidator validator = new DataValidatorImpl();
            ArrayFileReader fileReader = new ArrayFileReaderImpl();
            DataParser parser = new DataParserImpl();
            ArrayFactory factory = new ArrayFactoryImpl();
            ArrayService service = new ArrayServiceImpl();

            String filePath = "task1/src/main/resources/data/input.txt";

            List<String> lines = fileReader.readLinesFromFile(filePath);
            logger.info("Valid lines number: {}", lines.size());

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);

                try {
                    int[] numbers = parser.parse(line);

                    ArrayEntity customArray = factory.createArray((long) i + 1, numbers);

                    processArray(customArray, service);

                } catch (ArrayValidationException e) {
                    logger.error("Error during processing line '{}': {}", line, e.getMessage());
                }
                logger.info("-".repeat(50));
            }

        } catch (ArrayValidationException e) {
            logger.error("Critical Custom error: {}", e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            logger.error("Unexpected error: {}", e.getMessage());
            e.printStackTrace();
        }
    }

    private static void processArray(ArrayEntity customArray,
                                     ArrayService service)
            throws ArrayValidationException {

        int[] array = customArray.getArray();

        ArrayEntity bubbleCopy = new ArrayEntity(customArray.getId() * 10, array.clone());
        service.sortWithBubbleSort(bubbleCopy);
        logger.info("Bubble Sorted array: {}", bubbleCopy.getArray());

        ArrayEntity selectionCopy = new ArrayEntity(customArray.getId() * 20, array.clone());
        service.sortWithSelectionSort(selectionCopy);
        logger.info("Selection Sorted array: {}", selectionCopy.getArray());

        int max = service.findMax(customArray);

        int min = service.findMin(customArray);

        double sum = service.calculateSum(customArray);
    }
}
