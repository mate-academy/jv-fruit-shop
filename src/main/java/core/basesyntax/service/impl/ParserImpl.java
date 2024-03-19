package core.basesyntax.service.impl;

import core.basesyntax.model.Balance;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Purchase;
import core.basesyntax.model.Return;
import core.basesyntax.model.Supply;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.List;

public class ParserImpl implements Parser {
    private static final int REQUIRED_DATA_PARTS = 3;
    private static final String BALANCE_OPERATION = "b";
    private static final String SUPPLY_OPERATION = "s";
    private static final String PURCHASE_OPERATION = "p";
    private static final String RETURN_OPERATION = "r";
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int ENTITY_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<Operation> parseToOperations(List<String> records) {
        List<Operation> operations = new ArrayList<>();
        for (var record : records) {
            String[] splitData = record.split(DATA_SEPARATOR);
            if (splitData.length != REQUIRED_DATA_PARTS) {
                throw new RuntimeException("Can't parse data - " + record);
            }
            switch (splitData[OPERATION_TYPE_INDEX]) {
                case BALANCE_OPERATION -> operations.add(new Balance(splitData[ENTITY_NAME_INDEX],
                        Integer.parseInt(splitData[AMOUNT_INDEX])));
                case SUPPLY_OPERATION -> operations.add(new Supply(splitData[ENTITY_NAME_INDEX],
                        Integer.parseInt(splitData[AMOUNT_INDEX])));
                case PURCHASE_OPERATION -> operations.add(new Purchase(splitData[ENTITY_NAME_INDEX],
                        Integer.parseInt(splitData[AMOUNT_INDEX])));
                case RETURN_OPERATION -> operations.add(new Return(splitData[ENTITY_NAME_INDEX],
                        Integer.parseInt(splitData[AMOUNT_INDEX])));
                default -> throw new RuntimeException("Can't parse data - " + record);
            }
        }
        return operations;
    }
}
