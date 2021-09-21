package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitShopService {
    void report();

    void saveInformation(List<TransactionDto> transactionDtoList);
}
