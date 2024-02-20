package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class ShopServiceStrategy {
    private static final int OPERATION_HANDLER_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int FRUIT_AMOUNT_INDEX = 2;

    private Map<Operation, OperationHandler> opHandlerMap;

    public ShopServiceStrategy(Map<Operation, OperationHandler> opHandlerMap) {
        this.opHandlerMap = opHandlerMap;
    }

    public OperationHandler get(Operation type) {
        return opHandlerMap.get(type);
    }

    public void handleData(String dataFromFile) {
        StorageDaoImpl.clear();
        Arrays.stream(dataFromFile.split(System.lineSeparator()))
                .map(line -> line.split(","))
                .forEach(values -> {
                    if (Objects.equals(values[OPERATION_HANDLER_INDEX],
                            Operation.SUPPLY.getCode())) {
                        get(Operation.SUPPLY).handle(values[FRUIT_TYPE_INDEX],
                                Integer.parseInt(values[FRUIT_AMOUNT_INDEX]));
                    }

                    if (Objects.equals(values[OPERATION_HANDLER_INDEX],
                            Operation.PURCHASE.getCode())) {
                        get(Operation.PURCHASE).handle(values[FRUIT_TYPE_INDEX],
                                Integer.parseInt(values[FRUIT_AMOUNT_INDEX]));
                    }

                    if (Objects.equals(values[OPERATION_HANDLER_INDEX],
                            Operation.RETURN.getCode())) {
                        get(Operation.RETURN).handle(values[FRUIT_TYPE_INDEX],
                                Integer.parseInt(values[FRUIT_AMOUNT_INDEX]));
                    }

                    if (Objects.equals(values[OPERATION_HANDLER_INDEX],
                            Operation.BALANCE.getCode())) {
                        get(Operation.BALANCE).handle(values[FRUIT_TYPE_INDEX],
                                Integer.parseInt(values[FRUIT_AMOUNT_INDEX]));
                    }
                });
    }
}
