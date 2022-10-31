package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationValidator;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements core.basesyntax.services.TransactionParser {
    private static final String UTF8_BOM = "\uFEFF";
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private OperationValidator validator = new OperationValidatorImpl();

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        List<FruitTransaction> resultList = new ArrayList();
        String[] transation;
        for (String s : list) {
            if (s.startsWith(UTF8_BOM)) {
                continue;
            }
            transation = s.split(COMA_SEPARATOR);
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(validator.validate(transation[INDEX_OF_OPERATION]));
            fruitTransaction.setFruit(transation[INDEX_OF_FRUIT]);
            fruitTransaction.setQuantity(Integer.valueOf(transation[INDEX_OF_QUANTITY]));
            resultList.add(fruitTransaction);
        }
        return resultList;
    }
}
