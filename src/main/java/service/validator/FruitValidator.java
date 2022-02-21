package service.validator;

import java.util.ArrayList;
import java.util.List;

public class FruitValidator implements InputValidator {
    @Override
    public boolean isFileEmpty(List<String> rawData) {
        if (rawData.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        return false;
    }

    @Override
    public boolean isDataCorrect(List<String[]> parsedData) {
        List<Integer> wrongLines = new ArrayList<>();
        for (int i = 0; i < parsedData.size(); i++) {
            if (parsedData.get(i).length != 3) {
                wrongLines.add(i);
            }
        }
        if (!wrongLines.isEmpty()) {
            throw new RuntimeException("Wrong data at lines" + wrongLines);
        }
        return true;
    }
}
