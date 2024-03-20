package core.basesyntax.service;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface FileReader {
    List<FruitTransactionDto> readFile(String fileName);
}
