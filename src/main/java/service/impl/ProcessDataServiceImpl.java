package service.impl;

import java.util.List;
import model.Operation;
import service.OperationStrategy;
import service.ProcessDataService;

public class ProcessDataServiceImpl implements ProcessDataService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final OperationStrategy operationStrategy = new OperationStrategyImpl();

    @Override
    public void getData(List<String[]> list) {
        for (String [] str: list) {
            operationStrategy.get(Operation.getByCode(str[TYPE_INDEX]))
                    .getAmount(str[FRUIT_NAME_INDEX], Integer.parseInt(str[AMOUNT_INDEX]));
        }
    }
}
