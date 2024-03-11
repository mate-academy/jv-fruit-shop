package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvReadParseService;

public class CsvReadParseServiceImpl implements CsvReadParseService {
    private static final int CODE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;

    @Override
    public String parseCsv(String[] record) {
        if (record == null) {
            throw new RuntimeException("Can`t parse null data");
        }
        return (record[CODE].equals(FruitTransaction.Operation.SUPPLY.getCode())
                ? FruitTransaction.Operation.SUPPLY.getCode()
                : record[CODE].equals(FruitTransaction.Operation.RETURN.getCode())
                ? FruitTransaction.Operation.RETURN.getCode()
                : record[CODE].equals(FruitTransaction.Operation.PURCHASE.getCode())
                ? FruitTransaction.Operation.PURCHASE.getCode() :
                FruitTransaction.Operation.BALANCE.getCode())
                + "," + record[FRUIT]
                + "," + record[QUANTITY];
    }
}
