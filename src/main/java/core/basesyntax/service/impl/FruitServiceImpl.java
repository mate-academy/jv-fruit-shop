package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.operations.AddOperation;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;
import core.basesyntax.operations.SubtractOperation;
import core.basesyntax.service.FruitService;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String TITLE_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String CONCATENATING_CHARACTER = ",";

    @Override
    public void applyCorrectOperationImpl(FruitDataDto fruitDataDto) {
        Operation operation;
        if (fruitDataDto.getOperationType().equals(Operations.PURCHASE.getOperation())) {
            operation = new SubtractOperation();
        } else {
            operation = new AddOperation();
        }
        operation.apply(new Fruit(fruitDataDto.getFruitName()), fruitDataDto.getFruitQuantity());
    }

    @Override
    public String getReportFromDB() {
        FruitDao fruitDao = new FruitDaoImpl();
        return TITLE_LINE + fruitDao.getFruits().stream()
                .map(fruit -> fruit.getName() + CONCATENATING_CHARACTER + fruitDao.get(fruit))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
