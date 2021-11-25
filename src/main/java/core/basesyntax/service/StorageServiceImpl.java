package core.basesyntax.service;

import core.basesyntax.dao.InputDao;
import core.basesyntax.service.activities.Handler;
import core.basesyntax.strategy.StoreStrategy;
import core.basesyntax.strategy.StoreStrategyImpl;
import java.util.Map;

public class StorageServiceImpl implements StorageService {
    private static final int FIRST_CELL_NUMBER = 0;
    private InputDao inputDao;
    private CsvFileReader reader;

    public StorageServiceImpl(InputDao inputDao, CsvFileReader reader) {
        this.inputDao = inputDao;
        this.reader = reader;
    }

    @Override
    public void putDataToStorage(Map<String, Handler> map) {
        FileValidator validator = new FileValidatorImpl();
        StoreStrategy strategy = new StoreStrategyImpl(map);
        for (String[] value : reader.getDataFromFile()) {
            validator.validate(value);
            inputDao.add(strategy.get(value[FIRST_CELL_NUMBER]).createFruitObject(value));
        }
    }
}
