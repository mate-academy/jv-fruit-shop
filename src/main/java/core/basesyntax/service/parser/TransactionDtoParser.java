package core.basesyntax.service.parser;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface TransactionDtoParser {
    List<TransactionDto> parse(List<String> records);
}
