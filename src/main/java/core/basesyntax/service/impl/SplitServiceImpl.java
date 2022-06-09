package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataValidator;
import core.basesyntax.service.SplitService;

public class SplitServiceImpl implements SplitService {
    private DataValidator checkSplitData;

    public SplitServiceImpl(DataValidator checkSplitData) {
        this.checkSplitData = checkSplitData;
    }

    @Override
    public FruitTransaction getTransactionFromRow(String line) {
        String[] splitData = line.split(",");
        if (!checkSplitData.isValidDataFromCsv(splitData)) {
            throw new RuntimeException("Bad data in *.csv file");
        }
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(splitData[Index.TYPE.ordinal()]);
        fruitTransaction.setFruit(splitData[Index.FRUIT.ordinal()]);
        fruitTransaction.setQuantity(Integer.parseInt(splitData[Index.QUANTITY.ordinal()]));
        return fruitTransaction;
    }

    public enum Index {
        TYPE,
        FRUIT,
        QUANTITY
    }
}
