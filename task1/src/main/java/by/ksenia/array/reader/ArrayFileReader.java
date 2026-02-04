package by.ksenia.array.reader;

import by.ksenia.array.exception.ArrayValidationException;

import java.util.List;

public interface ArrayFileReader {
    List<String> readLines(String fileName, String dirName) throws ArrayValidationException;
    List<String> readLinesFromFile(String filePath) throws ArrayValidationException;

}
