package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface Parser {
    List<TransactionDto> parseLine(List<String> inputData);
}
