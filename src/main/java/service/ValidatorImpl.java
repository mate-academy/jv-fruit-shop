package service;

import java.util.List;

public class ValidatorImpl implements Validator {
    private static final String INPUT_TEXT_FORMAT = "[bspr],[a-z]+,[0-9]+";

    @Override
    public boolean validator(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i) != null && lines.get(i).matches(INPUT_TEXT_FORMAT)) {
                return true;
            }
        }
        return false;
    }
}

