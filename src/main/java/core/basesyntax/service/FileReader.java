package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FileReader {
    List<TransactionDto> readFromFile(String path);
}
