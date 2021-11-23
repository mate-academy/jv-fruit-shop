package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface ParserService {
    TransactionDto parse(String line);

    List<TransactionDto> parseLine(List<String> data);
}
