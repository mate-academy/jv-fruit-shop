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
    private final Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void operationPerform(List<String> inputData) {
        for (String dataLine : inputData) {
            try {
                String[] splitDataLine = dataLine.split(SEPARATOR);
                if (!Objects.equals(splitDataLine[0], "fruit")) {
                    operationHandlerMap.get(splitDataLine[OPERATION_INDEX])
                            .calculateResult(splitDataLine[FRUIT_INDEX],
                                    Integer.parseInt(splitDataLine[QUANTITY_INDEX]));
                }
            } catch (RuntimeException e) {
                throw new RuntimeException("Wrong data format", e);
            }
        }
    }
}
