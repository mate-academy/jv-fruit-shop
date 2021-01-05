package core.basesyntax.service.implementations;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Operation;
import core.basesyntax.model.ShopItem;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ShopItemService;
import core.basesyntax.strategy.OperationStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ShopItemServiceImpl implements ShopItemService {
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public ShopItemServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void applyOperationOnShopItem(List<TransactionDto> transactionDtoList) {
        for (TransactionDto dto : transactionDtoList) {
            OperationStrategy operationStrategy = operationStrategyMap.get(dto.getOperation());
            operationStrategy.apply(dto, dto.getQuantity());
        }
    }

    @Override
    public String getStringReport() {
        StringBuilder report = new StringBuilder();
        for (Map.Entry<ShopItem, Integer> entry : Storage.storage.entrySet()) {
            String line = entry.getKey().getName() + "," + entry.getValue();
            report.append(System.lineSeparator()).append(line);
        }
        return report.toString();
    }
}
