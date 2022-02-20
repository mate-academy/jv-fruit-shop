package core.basesyntax.fruitshop.service;

import core.basesyntax.fruitshop.model.TransactionDto;
import java.util.List;

public interface FruitShopService {
    String createReport();

    void applyOperationsOnTransactionDto(List<TransactionDto> dtoList);
}

