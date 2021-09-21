package core.service.report;

import core.model.FruitRecordDto;
import core.model.TypeOperations;
import core.service.oparation.OperationHandler;
import core.service.oparation.OperationStrategy;
import core.service.oparation.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class FruitRecordDtoParserImpl implements FruitRecordDtoParser {
    private static final String COMA_SEPARATOR = ",";
    private static final int INDEX_OPERATION_FOR_OPERATION_STRATEGY = 0;
    private static final int INDEX_FRUIT_NAME = 1;
    private static final int INDEX_QUANTITY = 2;
    private Map<String, OperationHandler> operationHandlersMap;
    private FruitRecordDto fruitRecordDto;
    private TypeOperations operationType;

    public FruitRecordDtoParserImpl(Map<String, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public void createFruitRecordDto(List<String> strings) {
        for (String string : strings) {
            String[] tmpStrings = string.split(COMA_SEPARATOR);
            TypeOperations[] typeOperationsArray = TypeOperations.values();
            for (TypeOperations typeOperation : typeOperationsArray) {
                if (typeOperation.get()
                        .equals(tmpStrings[INDEX_OPERATION_FOR_OPERATION_STRATEGY])) {
                    operationType = typeOperation;
                }
            }
            int fruitQuantity = Integer
                    .parseInt(tmpStrings[INDEX_QUANTITY]);
            fruitRecordDto =
                    new FruitRecordDto(operationType, tmpStrings[INDEX_FRUIT_NAME], fruitQuantity);
            launchOperationStrategy();
        }
    }

    private void launchOperationStrategy() {
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
        OperationHandler operationHandler =
                operationStrategy.get(fruitRecordDto.getOperationType());
        operationHandler.apply(fruitRecordDto);
    }
}
