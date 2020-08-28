package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.io.IOException;
import java.util.List;

public interface ReadFileService {
    List<TransactionDto> readFile(String path) throws IOException;
}
