package shop.service.impl;

import java.util.List;
import shop.service.Validator;

public class ValidatorImpl implements Validator {
    private static final String FIRST_LINE = "type,fruit,quantity";
    private static final int COUNT_INDEX = 2;
    private static final int SORTED_LENGTH = 3;

    @Override
    public boolean valid(List<String> data) {
        if (data.isEmpty()) {
            throw new RuntimeException("Empty file");
        }
        if (data.get(0).equals(FIRST_LINE)) {
            data.remove(0);
        }
        for (String parsedData : data) {
            String[] strings = parsedData.split(",");
            if (strings.length != SORTED_LENGTH || Integer.parseInt(strings[COUNT_INDEX]) < 0) {
                throw new RuntimeException("Invalid data");
            }
        }
        return true;
    }
}
