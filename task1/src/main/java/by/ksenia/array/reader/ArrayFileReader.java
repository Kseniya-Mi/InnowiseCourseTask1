package by.ksenia.array.reader;

import by.ksenia.array.exception.ArrayValidationException;
import by.ksenia.array.validator.DataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ArrayFileReader {
    private static final Logger logger = LogManager.getLogger(ArrayFileReader.class);
    private static final String DATA_DIR = "task1/src/main/resources/data/";

    public static List<int[]> readArraysFromFile(String filename) throws ArrayValidationException {
        List<int[]> result = new ArrayList<>();
        Path path = Paths.get(DATA_DIR + filename);

        try {
            List<String> lines = Files.readAllLines(path);

            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i).trim();

                if (line.isEmpty()) {
                    logger.debug("Empty line skipped at position {}", i);
                    continue;
                }

                if (!DataValidator.isValidString(line)) {
                    logger.warn("Invalid data format in line {}: {}", i, line);
                    continue;
                }

                int[] array = parseLine(line);
                if (array != null && array.length > 0) {
                    result.add(array);
                    logger.info("Successfully parsed array from line {}: {} elements", i, array.length);
                }
            }

        } catch (Exception e) {
            throw new ArrayValidationException("Error reading file: " + filename, e);
        }

        return result;
    }

    private static int[] parseLine(String line) {
        String[] parts = line.split("[,\\-;\\s]+");
        List<Integer> numbers = new ArrayList<>();

        for (String part : parts) {
            if (!part.isEmpty() && DataValidator.isNumber(part)) {
                numbers.add(Integer.parseInt(part));
            }
        }

        return numbers.stream().mapToInt(i -> i).toArray();
    }
}
