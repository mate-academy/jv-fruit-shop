package core.basesyntax.service.impl;

import static core.basesyntax.Constants.FRUIT_NAME_ARRAY_INDEX;

import core.basesyntax.handler.PurchaseHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.PurchaseService;
import java.util.List;

public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseHandler purchaseHandler;
    private final DataParserService dataParserService;

    public PurchaseServiceImpl(PurchaseHandler purchaseHandler,
                               DataParserService dataParserService) {
        this.purchaseHandler = purchaseHandler;
        this.dataParserService = dataParserService;
    }

    @Override
    public boolean purchase(List<String> dataList) {
        boolean isSubstract = false;
        for (int i = FRUIT_NAME_ARRAY_INDEX; i < dataList.size(); i++) {
            FruitTransaction fruitTransaction = dataParserService
                    .createFruitTransaction(dataList.get(i));
            if (fruitTransaction.getOperationType() == Operation.PURCHASE) {
                purchaseHandler.purchase(fruitTransaction.getFruitName(),
                        fruitTransaction.getFruitPrice());
                isSubstract = true;
            }
        }
        return isSubstract;
    }
}
