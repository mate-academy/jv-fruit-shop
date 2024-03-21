package core.basesyntax.service.interfaces;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface TransactionParser<T> {
    List<FruitTransactionDto> parse(List<String> rawString);
}
