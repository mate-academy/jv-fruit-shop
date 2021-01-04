package core.basesyntax.service.impl;

import core.basesyntax.dao.PlantsDao;
import core.basesyntax.model.objects.Plant;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.StoreService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.validator.OperationValidation;
import core.basesyntax.validator.impl.OperationValidationImpl;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoreServiceImpl<T extends Plant> implements StoreService<T> {
    protected static final Integer OPERATION_POSITION = 0;
    protected static final Integer PLANT_NAME_POSITION = 1;
    protected static final Integer VALUE_POSITION = 2;
    protected PlantsDao plantsDao;
    protected OperationStrategy operationStrategy;
    protected List<String> operations;

    public StoreServiceImpl(PlantsDao plantsDao, OperationStrategy operationStrategy) {
        this.plantsDao = plantsDao;
        this.operationStrategy = operationStrategy;
        operations = operationStrategy.getListOfOperations();
    }

    @Override
    public void getDataFromFile(String filePath) {
        FileReaderService fileReaderService = new FileReaderServiceImpl(filePath);
        String[] strings = fileReaderService.getDataFromFile(filePath);
        plantsDao.setData(Arrays.asList(strings));
    }

    @Override
    public List<T> getPlantsBalance(List<String> data) {
        List<T> plants = new ArrayList<>();
        Integer value;
        String operation;
        for (String s : data) {
            T plant = (T) new Plant();
            operation = s.split(",")[OPERATION_POSITION];
            plant.setName(s.split(",")[PLANT_NAME_POSITION]);
            value = Integer.parseInt(s.split(",")[VALUE_POSITION]);

            OperationValidation operationValidator = new OperationValidationImpl();
            operationValidator.isValidOperation(operations, operation);

            if (!plants.contains(plant)) {
                plant.setBalance(value);
                plants.add(plant);
            } else {
                Plant current = plants.get(plants.indexOf(plant));
                current.setBalance(operationStrategy.get(operation)
                        .updateBalance(current.getBalance(), value));
            }
        }
        return plants;
    }
}
