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
            try {
                String[] splitDataLine = dataLine.split(SEPARATOR);
                if (!Objects.equals(splitDataLine[OPERATION_INDEX], HEADER_FIRST_VALUE)) {
                    operationHandlerMap.get(splitDataLine[OPERATION_INDEX])
                            .calculateResult(splitDataLine[FRUIT_INDEX],
                                    Integer.parseInt(splitDataLine[QUANTITY_INDEX]));
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("Wrong data format", e);
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
