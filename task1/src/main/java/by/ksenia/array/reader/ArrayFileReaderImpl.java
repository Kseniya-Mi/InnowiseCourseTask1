package by.ksenia.array.reader;

import by.ksenia.array.exception.ArrayValidationException;
import by.ksenia.array.validator.DataValidatorImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ArrayFileReaderImpl implements ArrayFileReader {
    private static final Logger logger = LogManager.getLogger(ArrayFileReaderImpl.class);
    DataValidatorImpl validator = new DataValidatorImpl();


    @Override
    public List<String> readLines(String fileName, String dirName) throws ArrayValidationException {
        try {
            Path path = FileSystems.getDefault().getPath(dirName, fileName);
            logger.info("Reading file: {}", path);

            List<String> allLines = Files.readAllLines(path, StandardCharsets.UTF_8);

            if (validator != null) {
                List<String> validLines = allLines.stream()
                        .filter(line -> {
                            boolean isValid = validator.isValidLine(line);
                            if (!isValid) {
                                logger.debug("Filtered out invalid line: {}", line);
                            }
                            return isValid;
                        })
                        .collect(java.util.stream.Collectors.toList());

                logger.info("File read successfully. Total lines: {}, Valid lines: {}",
                        allLines.size(), validLines.size());
                return validLines;
            } else {
                logger.info("File read successfully. Lines count: {}", allLines.size());
                return allLines;
            }

        } catch (IOException e) {
            logger.error("Error reading file: {}", fileName, e);
            throw new ArrayValidationException(String.format("Error reading file %s", fileName));
        }
    }
    @Override
    public List<String> readLinesFromFile(String filePath) throws ArrayValidationException {
        java.nio.file.Path path = java.nio.file.Paths.get(filePath);
        String dirName = path.getParent() != null ? path.getParent().toString() : ".";
        String fileName = path.getFileName().toString();
        return readLines(fileName, dirName);
    }
}
