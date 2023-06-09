package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserOperationService;
import java.util.ArrayList;
import java.util.List;

public class ParserOperationServiceImpl implements ParserOperationService {
    private static final String SEPARATOR_IN_LINE = ",";
    private static final int INDEX_FOR_OPERATION_IN_STRING = 0;
    private static final int INDEX_FOR_PRODUCT_NAME_IN_STRING = 1;
    private static final int INDEX_FOR_PRODUCT_VALUE_IN_STRING = 2;
    private static final List<FruitTransaction> fruitTransactionList = new ArrayList<>();

    @Override
    public List<FruitTransaction> parser(List<String> data) {

        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (String current : data) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] line = current.split(SEPARATOR_IN_LINE);
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getOperationByCode(line[INDEX_FOR_OPERATION_IN_STRING]));
            fruitTransaction.setFruit(
                    line[INDEX_FOR_PRODUCT_NAME_IN_STRING]);
            fruitTransaction.setQuantity(Integer.parseInt(
                    line[INDEX_FOR_PRODUCT_VALUE_IN_STRING]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }
}
