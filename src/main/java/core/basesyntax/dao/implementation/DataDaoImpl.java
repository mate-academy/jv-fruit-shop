package core.basesyntax.dao.implementation;

import core.basesyntax.dao.DataDao;
import core.basesyntax.db.DataStorage;
import java.util.HashSet;
import java.util.List;

public class DataDaoImpl implements DataDao {
    private static final DataStorage DATA_STORAGE = new DataStorage();

    @Override
    public boolean contains(List<String> dataFromFile) {
        return new HashSet<>(DATA_STORAGE.getListOfData())
                .containsAll(dataFromFile);
    }

    @Override
    public void add(List<String> dataFromFile) {
        DATA_STORAGE.getListOfData()
                .addAll(dataFromFile);
    }

    @Override
    public List<String> getData() {
        return DATA_STORAGE.getListOfData();
    }

    @Override
    public void update(List<String> formattedData) {
        DATA_STORAGE.getListOfData().clear();
        add(formattedData);
    }
}
