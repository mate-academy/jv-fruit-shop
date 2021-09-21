package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface Calculate {
    List<String> calculate(List<TransactionDto> parsedInfo);
}
