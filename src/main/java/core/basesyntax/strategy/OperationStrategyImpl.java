package core.basesyntax.strategy;

import core.basesyntax.handlers.OperationHandler;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class OperationStrategyImpl implements OperationStrategy {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final String HEADER_FIRST_VALUE = "fruit";
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void operationPerform(List<String> inputData) {
        for (String dataLine : inputData) {
            String[] splitDataLine = dataLine.split(SEPARATOR);
            String operationType = splitDataLine[OPERATION_INDEX];
            try {
                if (!Objects.equals(operationType, HEADER_FIRST_VALUE)) {
                    String fruitType = splitDataLine[FRUIT_INDEX];
                    int quantity = Integer.parseInt(splitDataLine[QUANTITY_INDEX]);
                    operationHandlerMap.get(operationType)
                            .calculateResult(fruitType, quantity);
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("Wrong data format: " + "\"" + dataLine + "\"", e);
            }
        }
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operationCode;

        Operation(String operationCode) {
            this.operationCode = operationCode;
        }

        public String getOperationCode() {
            return operationCode;
        }
    }
}
