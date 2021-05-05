package core.basesyntax.service.fruitservice;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.handlers.AddOperationStrategy;
import core.basesyntax.service.handlers.FruitOperationStrategy;
import core.basesyntax.service.handlers.RemoveOperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final String HEADLINE = "fruit,quantity" + System.lineSeparator();
    private final FruitDao fruitDao;

    public FruitServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void saveData(List<FruitRecordDto> fruitRecordDto) {
        Map<Operation, FruitOperationStrategy> strategyMap = createStrategyMap(fruitDao);
        for (FruitRecordDto recordDto : fruitRecordDto) {
            strategyMap
                    .get(recordDto.getOperationType())
                    .applyAction(recordDto);
        }
    }

    @Override
    public String createReport() {
        return HEADLINE + fruitDao.getAll().entrySet()
                .stream()
                .map(currentKey -> currentKey.getKey().getName() + ","
                        + currentKey.getValue() + System.lineSeparator())
                .collect(Collectors.joining());
    }

    private static Map<Operation, FruitOperationStrategy> createStrategyMap(FruitDao fruitDao) {
        Map<Operation, FruitOperationStrategy> fruitOperationHandler = new HashMap<>();
        fruitOperationHandler.put(Operation.getOperationByLetter("s"),
                new AddOperationStrategy(fruitDao));
        fruitOperationHandler.put(Operation.getOperationByLetter("r"),
                new AddOperationStrategy(fruitDao));
        fruitOperationHandler.put(Operation.getOperationByLetter("b"),
                new AddOperationStrategy(fruitDao));
        fruitOperationHandler.put(Operation.getOperationByLetter("p"),
                new RemoveOperationStrategy(fruitDao));
        return fruitOperationHandler;
    }
}
