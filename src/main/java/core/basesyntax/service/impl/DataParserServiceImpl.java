package core.basesyntax.service.impl;

import static core.basesyntax.Constants.COMMA_SIGN;
import static core.basesyntax.Constants.FIRST_INDEX_WITH_DATA;
import static core.basesyntax.Constants.FRUIT_NAME_ARRAY_INDEX;
import static core.basesyntax.Constants.PRICE_ARRAY_INDEX;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.OperationService;
import core.basesyntax.util.DataValidator;
import java.util.ArrayList;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private final OperationService operationService;

    public DataParserServiceImpl(OperationService operationService) {
        this.operationService = operationService;
    }

    @Override
    public List<FruitTransaction> createFruitTransaction(List<String> data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = FIRST_INDEX_WITH_DATA; i < data.size(); i++) {
            String[] splitData = data.get(i).split(COMMA_SIGN);
            if (splitData.length >= 3) {
                String operationCode = splitData[0].trim();
                String fruitName = splitData[FRUIT_NAME_ARRAY_INDEX].trim();
                int fruitQuantity = Integer.parseInt(splitData[PRICE_ARRAY_INDEX].trim());
                DataValidator.validateInputData(operationCode, fruitName, fruitQuantity);
                fruitTransactionList.add(new FruitTransaction.FruitBuilder()
                        .setOperationType(operationService.getOperation(operationCode))
                        .setFruitName(fruitName)
                        .setFruitQuantity(fruitQuantity)
                        .build());
            } else {
                throw new IllegalArgumentException(String.format(
                        "Data elements count %d is less then necessary 3", splitData.length));
            }
        }
        return fruitTransactionList;
    }
}
