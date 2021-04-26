package core.basesyntax.service.parser;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FileEntryParser {
    List<TransactionDto> parseProduct(List<String> records);
}
