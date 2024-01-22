package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SupplyHandler implements OperationHandler {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private FruitDao fruitDao;

    public SupplyHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> processOperation() {
        fruitDao = new FruitDaoImpl();
        Map<String, Integer> salesByFruit = fruitDao.getCsv().stream()
                .filter(s -> s.split(SEPARATOR)[OPERATION].equals("s"))
                .map(s -> s.split(SEPARATOR))
                .collect(Collectors.groupingBy(
                        stringRow -> stringRow[FRUIT],
                        Collectors.summingInt(stringRow -> Integer.parseInt(stringRow[QUANTITY]))
                ));
        return salesByFruit.entrySet().stream()
                .map(entry -> "s," + entry.getKey() + "," + entry.getValue())
                .collect(Collectors.toList());
    }
}
