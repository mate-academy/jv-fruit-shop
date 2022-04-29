package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface ShopService {
    void updateStorageInfo(List<TransactionDto> fruitTransactions);
}
