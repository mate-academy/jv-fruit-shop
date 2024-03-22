package core.basesyntax.service.filereader;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface FruitDataReaderService {
    List<FruitTransactionDto> readData(String filePath);
}
