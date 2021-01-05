package core.basesyntax.shop.service;

import core.basesyntax.shop.model.TransactionDto;
import java.util.List;

public interface FileReader {
    List<TransactionDto> readData(String filePath);
}
