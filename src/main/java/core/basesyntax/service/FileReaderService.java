package core.basesyntax.service;

import core.basesyntax.model.FruitTransactionDto;
import java.util.List;

public interface FileReaderService {
    List<FruitTransactionDto> readDataFile(String path);
}
