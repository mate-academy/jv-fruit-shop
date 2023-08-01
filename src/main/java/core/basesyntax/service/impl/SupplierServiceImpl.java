package core.basesyntax.service.impl;

import static core.basesyntax.Constants.FRUIT_NAME_ARRAY_INDEX;

import core.basesyntax.handler.SupplierHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.SupplierService;
import java.util.List;

public class SupplierServiceImpl implements SupplierService {
    private final SupplierHandler supplierHandler;
    private final DataParserService dataParserService;

    public SupplierServiceImpl(SupplierHandler supplierHandler,
                               DataParserService dataParserService) {
        this.supplierHandler = supplierHandler;
        this.dataParserService = dataParserService;
    }

    @Override
    public boolean add(List<String> dataList) {
        boolean isAdded = false;
        for (int i = FRUIT_NAME_ARRAY_INDEX; i < dataList.size(); i++) {
            FruitTransaction fruitTransaction = dataParserService
                    .createFruitTransaction(dataList.get(i));
            if (fruitTransaction.getOperationType() == Operation.BALANCE
                    || fruitTransaction.getOperationType() == Operation.SUPPLY) {
                FruitTransaction newFruit = new FruitTransaction.FruitBuilder()
                        .setOperationType(fruitTransaction.getOperationType())
                        .setFruitName(fruitTransaction.getFruitName())
                        .setFruitPrice(fruitTransaction.getFruitPrice())
                        .setOperationType(fruitTransaction.getOperationType())
                        .build();
                isAdded = supplierHandler.add(newFruit);
            }
        }
        return isAdded;
    }
}
