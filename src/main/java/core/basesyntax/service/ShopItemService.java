package core.basesyntax.service;

import core.basesyntax.model.TransactionDto;

import java.util.List;
import java.util.Map;

public interface ShopItemService {
    void applyOperationOnShopItem(List<TransactionDto> transactionDtoList);
    String getStringReport();
}
