package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.dto.FruitDataDto;
import core.basesyntax.operations.Operation;
import core.basesyntax.operations.Operations;
import core.basesyntax.service.FruitService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String TITLE_LINE = "fruit,quantity" + System.lineSeparator();
    private static final String CONCATENATING_CHARACTER = ",";
    private final Map<Operations, Operation> chooseOperation;

    public FruitServiceImpl(Map<Operations, Operation> chooseOperation) {
        this.chooseOperation = chooseOperation;
    }

    @Override
    public void applyOperationsOnFruitsDto(List<FruitDataDto> fruitDataDtoList) {

        for (FruitDataDto fruitDataDto : fruitDataDtoList) {
            chooseOperation
                    .get(fruitDataDto.getOperationType())
                    .apply(fruitDataDto.getFruit(),
                            fruitDataDto.getFruitQuantity());
        }
    }

    @Override
    public String generateReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        return TITLE_LINE + fruitDao.getFruits().stream()
                .map(fruit -> fruit.getName() + CONCATENATING_CHARACTER + fruitDao.get(fruit).get())
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
