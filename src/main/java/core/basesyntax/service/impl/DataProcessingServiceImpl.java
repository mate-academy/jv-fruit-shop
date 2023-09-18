package core.basesyntax.service.impl;

import core.basesyntax.model.FruitDto;
import core.basesyntax.model.OperationType;
import core.basesyntax.service.DataProcessingService;
import core.basesyntax.service.ParserService;
import core.basesyntax.strategy.OperationsHandler;
import core.basesyntax.strategy.impl.BalanceOperationsHandler;
import core.basesyntax.strategy.impl.PurchaseOperationsHandler;
import core.basesyntax.strategy.impl.ReturnOperationsHandler;
import core.basesyntax.strategy.impl.SupplyOperationsHandler;
import java.util.List;

public class DataProcessingServiceImpl implements DataProcessingService {
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_SORT = 1;
    private static final int INDEX_OF_OPERATIONS_AMOUNT = 2;

    @Override
    public void processing(List<String> transactionsList) {
        OperationsHandler operationsHandler;
        ParserService parser = new ParserServiceImpl();
        List<String[]> transactions = parser.parseInputData(transactionsList);

        for (String[] transaction : transactions) {
            operationsHandler = getOperationsHandler(transaction[INDEX_OF_OPERATION_TYPE]);
            operationsHandler.operation(new FruitDto(transaction[INDEX_OF_FRUIT_SORT],
                    Integer.parseInt(transaction[INDEX_OF_OPERATIONS_AMOUNT])));
        }
    }

    private OperationsHandler getOperationsHandler(String operationsCode) {
        if (operationsCode.equals(OperationType.BALANCE.getCode())) {
            return new BalanceOperationsHandler();
        }
        if (operationsCode.equals(OperationType.SUPPLY.getCode())) {
            return new SupplyOperationsHandler();
        }
        if (operationsCode.equals(OperationType.PURCHASE.getCode())) {
            return new PurchaseOperationsHandler();
        }
        if (operationsCode.equals(OperationType.RETURN.getCode())) {
            return new ReturnOperationsHandler();
        }
        throw new RuntimeException("Incorrect operations code");
    }
}
