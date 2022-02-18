package core.basesyntax.service.impl;

import core.basesyntax.service.ValidatorService;
import java.util.List;

public class ValidatorServiceImpl implements ValidatorService {
    private static final String TITLE_TEXT = "type,fruit,quantity";
    private static final String FORMAT_TEXT = "[bpsr]{1},[a-z]{3,},\\d{1,}";

    public boolean isValid(List<String> text) {
        if (text.isEmpty() || !text.get(0).equals(TITLE_TEXT)) {
            throw new RuntimeException(("Incorrect input data!"));
        }
        for (int i = 1; i < text.size(); i++) {
            String line = text.get(i);
            if (!line.matches(FORMAT_TEXT)) {
                throw new RuntimeException(("Incorrect format data!"));
            }
        }
        return true;
    }
}
