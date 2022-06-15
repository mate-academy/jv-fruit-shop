package core.basesyntax.service.imp;

import core.basesyntax.service.CSVValidator;
import java.util.List;

public class CSVValidatorImp implements CSVValidator {
    private final String header;

    public CSVValidatorImp(String header) {
        this.header = header;
    }

    @Override
    public List<String> validate(List<String> records) {
        if (!records.remove(header)) {
            throw new RuntimeException("Wrong records table, expected header: " + header);
        }
        return records;
    }
}
