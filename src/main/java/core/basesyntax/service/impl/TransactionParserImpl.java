package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationValidator;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final String UTF8_BOM = "\uFEFF";
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private OperationValidator validator;

    public TransactionParserImpl(OperationValidator validator) {
        this.validator = validator;
    }

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
