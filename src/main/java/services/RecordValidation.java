package services;

import java.util.function.Predicate;

public class RecordValidation implements Predicate<String[]> {
    @Override
    public boolean test(String[] fields) {
        return fields.length == 3 && Integer.parseInt(fields[2]) >= 0;
    }
}
