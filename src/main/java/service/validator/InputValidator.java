package service.validator;

import java.util.List;

public interface InputValidator {
    boolean isFileEmpty(List<String> rawData);

    boolean isDataCorrect(List<String[]> parsedData);
}
