package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.util.List;

public class PlantsDaoImpl implements PlantsDao {
    @Override
    public void setData(List<String> data) {
        Storage.data = data;
    }

    @Override
    public List<String> getData() {
        return Storage.data;
    }
}
