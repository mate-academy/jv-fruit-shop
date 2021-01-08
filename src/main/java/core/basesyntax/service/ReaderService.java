package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface ReaderService {
    List<TransactionDto> readData(String filename);
}
