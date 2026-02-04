package by.ksenia.array.validator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Pattern;

public class DataValidatorImpl implements DataValidator {
    private static final Logger logger = LogManager.getLogger();
    private static final Pattern VALID_LINE =
            Pattern.compile("^\\s*(-?\\d+([; ,\\-]+)?)*\\s*$");

    @Override
    public boolean isValidLine(String line) {
        logger.debug("Start validating line: '{}'", line);

        if (line == null || line.isBlank()) {
            logger.warn("Line is null or blank: '{}'", line);

            return false;
        }

        boolean isValid = VALID_LINE.matcher(line).matches();

        if (isValid) {
            logger.info("Line is valid: '{}'", line);
        } else {
            logger.error("Line is invalid: '{}'", line);
        }

        logger.debug("Validation result for line '{}': {}", line, isValid);

        return isValid;
    }
}
