package core.basesyntax.service.parser;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface OperationParser {
    List<TransactionDto> parseOperations(List<String> inputData);
}
