package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface ParserService {
    List<TransactionDto> parseData(List<String> dataFromFile);
}
