package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitShopService {
    void saveData(List<TransactionDto> data);

    String createReport();
}
