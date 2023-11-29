package core.basesyntax.service.implementation;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.DataService;
import core.basesyntax.validator.DataValidator;
import java.util.List;

public class DataServiceImpl implements DataService {
    private static final String COMMA = ",";
    private static final int FRUIT_INDEX = 1;
    private final StorageDao storageDao;
    private final DataValidator dataValidator;

    public DataServiceImpl() {
        this.dataValidator = new DataValidator();
        this.storageDao = new StorageDaoImpl();
    }

    @Override
    public void fillFruitStorage(List<String> dataFromFile) {
        dataFromFile.forEach(string -> {
            String fruitName = string.split(COMMA)[FRUIT_INDEX];
            if (!storageDao.contains(fruitName)) {
                storageDao.add(fruitName);
            }
        });
    }

    @Override
    public List<String> formatAndCheckData(List<String> dataFromFile) {
        List<String> formattedData = dataFromFile.stream()
                .skip(1)
                .map(string -> string
                        .replaceAll("\\s", ""))
                .toList();
        dataValidator.validate(formattedData);
        return formattedData;
    }
}
