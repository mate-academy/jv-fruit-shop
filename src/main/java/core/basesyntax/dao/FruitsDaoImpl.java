package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.List;

public class FruitsDaoImpl implements FruitsDao {

    @Override
    public void setData(List<String> data) {
        Storage.data = data;
    }

    @Override
    public List<String> getData() {
        return Storage.data;
    }
}
