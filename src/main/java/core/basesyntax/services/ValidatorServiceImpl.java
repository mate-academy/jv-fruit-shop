package core.basesyntax.services;

import core.basesyntax.exception.ValidationException;
import core.basesyntax.model.Fruit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ValidatorServiceImpl implements ValidatorService {
    private static final String COMMA = ",";
    private static final int TITLE_INDEX = 0;
    private static final int DEFAULT_QUANTITY_ELEMENTS = 3;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public void inputDataValidator(List<String> inputData) {
        List<String> buffer = new ArrayList<>(inputData);
        buffer.remove(TITLE_INDEX);
        for (String line : buffer) {
            if (!(line.contains(COMMA))) {
                throw new ValidationException("Incorrect data: absent symbol ','");
            }
            if (line.split(COMMA).length < DEFAULT_QUANTITY_ELEMENTS) {
                throw new ValidationException("Incorrect data: wrong length string");
            }
        }
    }

    @Override
    public void positiveQuantityValidator(List<String> inputData) {
        List<String> buffer = new ArrayList<>(inputData);
        buffer.remove(TITLE_INDEX);
        for (String line : buffer) {
            if (Integer.parseInt(line.split(COMMA)[QUANTITY_INDEX]) < 0) {
                throw new ValidationException("Incorrect data: negative numbers");
            }
        }
    }

    @Override
    public void correctAmountValidator(Map<Fruit, Integer> countingActivities) {
        for (Integer amount : countingActivities.values()) {
            if (amount < 0) {
                throw new ValidationException("Incorrect day activities: negative amount");
            }
        }
    }
}
