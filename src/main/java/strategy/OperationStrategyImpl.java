package strategy;

import java.util.Map;
import model.Fruit;
import model.FruitTransferDto;
import service.inerfaces.OperationHandler;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<String, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public void handle(FruitTransferDto dto) {
        String[] dtoArr = dto.getDto();
        operationHandlerMap.get(dtoArr[0]).doOperation(new Fruit(dtoArr[1]), dtoArr[2]);
    }
}
