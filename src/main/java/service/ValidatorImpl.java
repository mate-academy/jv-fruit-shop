package service;

import java.util.List;

public class ValidatorImpl implements Validator {
    private Validator validator;
    private ReaderImpl fileRead;
    private String filePath;

    @Override
    public boolean validator(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i).matches("[bpsr]{1},[a-z]{3,},\\\\d+")) {
                return true;
            }
        }
        return false;
    }
}

