package core.basesyntax.service.implementation;

import core.basesyntax.dao.DataDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.implementation.DataDaoImpl;
import core.basesyntax.dao.implementation.FruitDaoImpl;
import core.basesyntax.service.DataService;
import core.basesyntax.validator.DataValidator;
import java.util.List;

public class DataServiceImpl implements DataService {
    private static final String COMMA = ",";
    private static final int FRUIT_INDEX = 1;
    private final FruitDao fruitDao;
    private final DataDao dataDao;
    private final DataValidator dataValidator;

    public DataServiceImpl() {
        this.dataValidator = new DataValidator();
        this.fruitDao = new FruitDaoImpl();
        this.dataDao = new DataDaoImpl();
    }

    @Override
    public void fillDataStorage(List<String> dataFromFile) {
        if (!dataDao.contains(dataFromFile)) {
            dataDao.add(dataFromFile);
        }
        formatAndCheckData();
    }

    @Override
    public void fillFruitStorage() {
        dataDao.getData().forEach(string -> {
            String fruitName = string.split(COMMA)[FRUIT_INDEX];
            if (!fruitDao.contains(fruitName)) {
                fruitDao.add(fruitName);
            }
        });
    }

    private void formatAndCheckData() {
        List<String> formattedData = dataDao.getData().stream()
                .skip(1)
                .map(string -> string
                        .replaceAll("\\s", ""))
                .toList();
        dataValidator.validate(formattedData);
        dataDao.update(formattedData);
    }
}
