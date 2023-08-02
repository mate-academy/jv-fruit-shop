package core.basesyntax.service.implementation;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConversionService;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class DataConversionServiceImpl implements DataConversionService {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> convert(String rawData) {
        List<FruitTransaction> list = new ArrayList<>();
        for (String line : rawData.split(System.lineSeparator())) {
            if (Objects.equals(line, HEADER)) {
                continue;
            }
            String[] dataUnits = line.split(COMMA);
            FruitTransaction fruitTransaction = new FruitTransaction();
            for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
                if (operation.getCode().equals(dataUnits[OPERATION_INDEX])) {
                    fruitTransaction.setOperation(operation);
                }
            }
            fruitTransaction.setFruit(dataUnits[PRODUCT_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(dataUnits[AMOUNT_INDEX]));
            list.add(fruitTransaction);
        }
        return list;
    }
}
