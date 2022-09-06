package core.basesyntax.services;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitServiceImpl implements FruitService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String COMMA = ",";
    private final FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();

    @Override
    public List<FruitTransaction> getTransaction(List<String> transaction) {
        return transaction.stream()
                .skip(1)
                .map(s -> s.split(COMMA))
                .map(t -> new FruitTransaction(t[OPERATION_INDEX]
                        , t[FRUIT_NAME_INDEX]
                        , Integer.parseInt(t[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity");
        for (Map.Entry<String, Integer> entry : fruitStorageDao.getDataFromStorage().entrySet()) {
            report.append(System.lineSeparator()).append(entry.getKey())
                    .append(",").append(entry.getValue());
        }
        return report.toString();
    }
}
