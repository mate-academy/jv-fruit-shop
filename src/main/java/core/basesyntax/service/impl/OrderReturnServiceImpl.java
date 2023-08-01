package core.basesyntax.service.impl;

import static core.basesyntax.Constants.FRUIT_NAME_ARRAY_INDEX;

import core.basesyntax.handler.OrderReturnHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParserService;
import core.basesyntax.service.OrderReturnService;
import java.util.List;

public class OrderReturnServiceImpl implements OrderReturnService {
    private final OrderReturnHandler orderReturnHandler;
    private final DataParserService dataParserService;

    public OrderReturnServiceImpl(OrderReturnHandler orderReturnHandler,
                                  DataParserService dataParserService) {
        this.orderReturnHandler = orderReturnHandler;
        this.dataParserService = dataParserService;
    }

    @Override
    public boolean returnOrder(List<String> dataList) {
        boolean isReturned = false;
        for (int i = FRUIT_NAME_ARRAY_INDEX; i < dataList.size(); i++) {
            FruitTransaction fruitTransaction = dataParserService
                    .createFruitTransaction(dataList.get(i));
            if (fruitTransaction.getOperationType() == Operation.RETURN) {
                orderReturnHandler.returnOrder(fruitTransaction.getFruitName(),
                        fruitTransaction.getFruitPrice());
                isReturned = true;
            }
        }
        return isReturned;
    }
}
