package core.basesyntax.service.dto;

import java.util.List;

public interface TransactionDtoParser {
    List<TransactionDto> parse(List<String> records);
}
