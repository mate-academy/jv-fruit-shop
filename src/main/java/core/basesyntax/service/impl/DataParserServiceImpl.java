package core.basesyntax.service.impl;

import static core.basesyntax.Constants.COMMA_SIGN;
import static core.basesyntax.Constants.FRUIT_NAME_ARRAY_INDEX;
import static core.basesyntax.Constants.OPERATION_TYPE_INDEX;
import static core.basesyntax.Constants.PRICE_ARRAY_INDEX;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.OperationService;
import java.math.BigDecimal;

public class DataParserServiceImpl implements DataParserService {
    private final OperationService operationService;

    public DataParserServiceImpl(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public FruitTransaction createFruitTransaction(String data) {
        String[] splitData = data.split(COMMA_SIGN);
        Operation operationType = operationService
                .getOperation(splitData[OPERATION_TYPE_INDEX].trim());
        String fruitName = splitData[FRUIT_NAME_ARRAY_INDEX];
        BigDecimal fruitPrice = new BigDecimal(splitData[PRICE_ARRAY_INDEX]);
        return new FruitTransaction.FruitBuilder()
                .setFruitName(fruitName)
                .setFruitPrice(fruitPrice)
                .setOperationType(operationType)
                .build();
    }
}
