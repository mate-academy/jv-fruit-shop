package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface CsvParser {
    List<TransactionDto> convert(List<String> stringsTransaction);
}
