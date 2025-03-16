package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    public static final int PARTS_LENGTH = 3;
    public static final int OPERATION_PART = 0;
    public static final int FRUIT_PART = 1;
    public static final int QUANTITY_PART = 2;

    public List<FruitTransactionImpl> convertToTransaction(List<String> inputReport) {
        List<FruitTransactionImpl> fruitTransactionImplList = new ArrayList<>();

        for (int i = 0; i < inputReport.size(); i++) {
            if (inputReport.get(i) != null && !inputReport.get(i).isEmpty()) {
                String[] parts = inputReport.get(i).split(",");

                if (parts.length < PARTS_LENGTH) {
                    System.out.println("Запис не повний, елементів менше трьох");
                    continue;
                }

                FruitTransactionImpl fruitTransactionImpl = new FruitTransactionImpl();
                fruitTransactionImpl.setOperation(getOperationByCode(parts[OPERATION_PART]));
                fruitTransactionImpl.setFruit(parts[FRUIT_PART]);
                fruitTransactionImpl.setQuantity(Integer.parseInt(parts[QUANTITY_PART]));

                fruitTransactionImplList.add(fruitTransactionImpl);
            }
        }
        return fruitTransactionImplList;
    }

    public FruitTransactionImpl.Operation getOperationByCode(String code) {
        for (FruitTransactionImpl.Operation op : FruitTransactionImpl.Operation.values()) {
            if (op.getCode().equals(code)) {
                return op;
            }
        }
        throw new IllegalArgumentException("Невідомий код операції: " + code);
    }
}
