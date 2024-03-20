package core.basesyntax.services;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.List;

public interface InventoryService {
    void conductActivities(List<FruitTransactionDto> dtos);
}
