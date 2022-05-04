package strategy;

import java.util.Map;
import model.FruitTransferDto;
import service.inerfaces.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void handle(FruitTransferDto dto) {
        operationHandlerMap.get(dto.getOperationType())
                .doOperation(dto.getFruit(), dto.getQuantity());
    }
}
