package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.service.ProcessWriteDataService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProcessWriteDataServiceImpl implements ProcessWriteDataService {
    private static final String COLUMN_FRUIT = "fruit";
    private static final String COLUMN_QUANTITY = "quantity";
    private FruitDao fruitDao = new FruitDaoImpl();

    @Override
    public List<String[]> transactionDataToWrite() {
        List<String[]> list = new ArrayList<>();
        list.add(new String[]{COLUMN_FRUIT, COLUMN_QUANTITY});
        return fruitDao.getAll().entrySet()
                .stream()
                .map(f -> new String[]{f.getKey(), String.valueOf(f.getValue())})
                .collect(Collectors.toCollection(() -> list));
    }
}
