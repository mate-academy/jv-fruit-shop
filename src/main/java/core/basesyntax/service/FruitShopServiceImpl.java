package core.basesyntax.service;

import core.basesyntax.db.FruitsStorage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.operation.OperationTypeStrategy;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private static final String COLUMNS_TITLE = "fruit,quantity";
    private static final String SEPARATOR = ",";
    private final OperationTypeStrategy operationTypeStrategy;

    public FruitShopServiceImpl(OperationTypeStrategy operationTypeStrategy) {
        this.operationTypeStrategy = operationTypeStrategy;
    }

    @Override
    public String report() {
        StringBuilder report = new StringBuilder(COLUMNS_TITLE)
                .append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> entry : FruitsStorage.fruitsStorage.entrySet()) {
            report.append(entry.getKey().getFruit())
                    .append(SEPARATOR)
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }

    @Override
    public void saveInformation(List<TransactionDto> transactionDtoList) {
        for (TransactionDto data : transactionDtoList) {
            operationTypeStrategy.get(data.getOperationType()).getOperationResult(data);
        }
    }
}
