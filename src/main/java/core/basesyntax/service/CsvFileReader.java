package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface CsvFileReader {
    List<TransactionDto> readDate(String fileName);
}
