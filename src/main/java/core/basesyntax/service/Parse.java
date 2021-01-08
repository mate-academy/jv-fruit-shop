package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface Parse {
    List<TransactionDto> parse(List<String> data);
}
