package core.basesyntax.service.strategy;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BalanceHandler implements OperationHandler {
    private static final String SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private FruitDao fruitDao;

    public BalanceHandler(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    public List<String> processOperation() {
        fruitDao = new FruitDaoImpl();
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> csvData = fruitDao.getCsv();
        Map<String, Integer> resultMap = csvData.stream()
                .map(s -> s.split(SEPARATOR))
                .collect(Collectors.groupingBy(
                        stringRow -> stringRow[FRUIT],
                        Collectors.summingInt(stringRow -> {
                            int quantity = Integer.parseInt(stringRow[QUANTITY]);
                            return "p".equals(stringRow[OPERATION]) ? -quantity : quantity;
                        })
                ));

        List<String> newCsvData = resultMap.entrySet().stream()
                .map(entry -> "b" + SEPARATOR + entry.getKey() + SEPARATOR + entry.getValue())
                .collect(Collectors.toList());
        return newCsvData;
    }
}
