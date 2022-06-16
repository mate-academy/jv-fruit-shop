package core.basesyntax.service.imp;

import core.basesyntax.service.CsvValidator;
import java.util.List;

public class CsvValidatorImp implements CsvValidator {
    private final String header;

    public CsvValidatorImp(String header) {
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
