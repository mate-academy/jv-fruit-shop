package core.basesyntax.services;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface Parser<T> {
    List<TransactionDto> parseLine(List<String> line);
}
