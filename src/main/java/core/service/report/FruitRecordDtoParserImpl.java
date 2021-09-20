package core.service.report;

import core.model.FruitRecordDto;
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

    public FruitRecordDtoParserImpl(Map<String, OperationHandler> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public void createFruitRecordDto(List<String> strings) {
        for (String string : strings) {
            String[] tmpStrings = string.split(COMA_SEPARATOR);
            fruitRecordDto = new FruitRecordDto(tmpStrings[INDEX_OPERATION_FOR_OPERATION_STRATEGY],
                    tmpStrings[INDEX_FRUIT_NAME],
                    tmpStrings[INDEX_QUANTITY]);
            OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlersMap);
            OperationHandler operationHandler =
                    operationStrategy.get(fruitRecordDto.getOperationType().get());
            operationHandler.apply(fruitRecordDto);
        }
    }
}
