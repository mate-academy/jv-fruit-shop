package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.stratege.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    public static final String HEADER_LINE = "fruit,quantity";
    public static final String COMA = ",";
    private final Map<Operation, OperationStrategy> operationStrategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public void selectOperationAndWriteToStorage(List<TransactionDto> transactionDto) {
        if (transactionDto == null) {
            throw new RuntimeException("transactionDto can't be null");
        }
        for (TransactionDto dto : transactionDto) {
            operationStrategyMap.get(dto.getOperation()).doOperation(dto);
        }
    }

    @Override
    public String prepareDataForReport() {
        Map<Fruit, Integer> data = Storage.fruitsAndAmountsMap;
        StringBuilder result = new StringBuilder();
        result.append(HEADER_LINE).append(System.lineSeparator());
        for (Map.Entry<Fruit, Integer> line : data.entrySet()) {
            result.append(line.getKey().getName())
                    .append(COMA)
                    .append(line.getValue().toString())
                    .append(System.lineSeparator());
        }
        return result.toString();
    }
}
