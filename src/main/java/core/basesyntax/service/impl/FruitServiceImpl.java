package core.basesyntax.service.impl;

import core.basesyntax.database.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.FruitOperationHandler;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Operation;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private static final String SEPARATOR = System.lineSeparator();
    private static final String COLUMNS_TITLE = "fruit,quantity";
    private static final String WORD_SEPARATOR = ",";
    private Map<Operation, FruitOperationHandler> operations;

    public FruitServiceImpl(Map<Operation, FruitOperationHandler> operations) {
        this.operations = operations;
    }

    @Override
    public void applyOperation(List<FruitRecordDto> fruitRecordDtoList) {
        for (FruitRecordDto fruitRecordDto : fruitRecordDtoList) {
            operations.get(fruitRecordDto.getOperationType()).apply(fruitRecordDto);
        }
    }

    @Override
    public String getFruitReport() {
        StringBuilder dataReport = new StringBuilder(COLUMNS_TITLE);
        for (Map.Entry<Fruit, Integer> entry : Storage.fruits.entrySet()) {
            dataReport.append(SEPARATOR)
                    .append(entry.getKey().getFruitName())
                    .append(WORD_SEPARATOR)
                    .append(entry.getValue());
        }
        return dataReport.append(SEPARATOR).toString();
    }
}
