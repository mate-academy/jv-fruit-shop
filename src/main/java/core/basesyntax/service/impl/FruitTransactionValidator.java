package core.basesyntax.service.impl;

import core.basesyntax.service.ValidationService;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FruitTransactionValidator implements ValidationService {
    private static final String FILE_HEADERS = "type,fruit,quantity";
    private static final String RECORD_PATTERN = "[bprs],[a-z]+,[0-9]+";
    private static final int HEADERS_INDEX = 0;

    @Override
    public boolean isValid(List<String> records) {
        return checkHeaders(records.get(HEADERS_INDEX))
                && checkRecords(records);
    }

    private boolean checkHeaders(String headers) {
        Pattern pattern = Pattern.compile(FILE_HEADERS);
        Matcher matcher = pattern.matcher(headers);

        if (matcher.matches()) {
            return true;
        }
        throw new RuntimeException("Invalid file headers");
    }

    private boolean checkRecords(List<String> records) {
        Pattern pattern = Pattern.compile(RECORD_PATTERN);
        Matcher matcher;
        records.remove(HEADERS_INDEX);

        for (String record : records) {
            matcher = pattern.matcher(record);
            if (!matcher.matches()) {
                throw new RuntimeException("Invalid file record");
            }
        }
        return true;
    }
}

