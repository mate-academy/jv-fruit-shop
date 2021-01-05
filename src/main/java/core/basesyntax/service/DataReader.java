package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface DataReader {
    List<TransactionDto> read(String filePath);
}
