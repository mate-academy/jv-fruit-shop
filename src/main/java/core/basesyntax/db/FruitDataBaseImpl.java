package core.basesyntax.db;

import core.basesyntax.services.ReadDataImp;
import java.util.List;

public class FruitDataBaseImpl implements FruitDataBase {
    private final ReadDataImp readDataImp;

    public FruitDataBaseImpl(ReadDataImp readDataImp) {
        this.readDataImp = readDataImp;
    }

    @Override
    public List<String> getData() {
        return readDataImp.read();
    }
}
