package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;
import java.util.List;

public interface FruitShopService {
    void applyOperationsOnFruitsDto(List<TransactionDto> parsedInfo);
}
