package core.basesyntax.dataservice;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface OperationParser {
    List<TransactionDto> parseOperations(String filePathFrom);
}
