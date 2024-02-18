package core.basesyntax.service;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.operation.OperationHandler;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class ShopServiceStrategy {
    private Map<Operation, OperationHandler> opHandlerMap;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public ShopServiceStrategy(Map<Operation, OperationHandler> opHandlerMap) {
        this.opHandlerMap = opHandlerMap;
    }

    public OperationHandler get(Operation type) {
        return opHandlerMap.get(type);
    }

    public void handleData(String dataFromFile) {
        StorageDaoImpl.clear();
        Arrays.stream(dataFromFile.split(System.lineSeparator()))
                .map(line -> line.replaceAll("\\s", "").split(","))
                .forEach(values -> {
                    if (Objects.equals(values[0], Operation.SUPPLY.getCode())) {
                        get(Operation.SUPPLY).handle(values[1], Integer.parseInt(values[2]));
                    }

                    if (Objects.equals(values[0], Operation.PURCHASE.getCode())) {
                        get(Operation.PURCHASE).handle(values[1], Integer.parseInt(values[2]));
                    }

                    if (Objects.equals(values[0], Operation.RETURN.getCode())) {
                        get(Operation.RETURN).handle(values[1], Integer.parseInt(values[2]));
                    }

                    if (Objects.equals(values[0], Operation.BALANCE.getCode())) {
                        get(Operation.BALANCE).handle(values[1], Integer.parseInt(values[2]));
                    }
                });
    }
}
