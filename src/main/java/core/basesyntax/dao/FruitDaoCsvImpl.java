package core.basesyntax.dao;

import java.io.File;

public class FruitDaoCsvImpl implements FruitDao {
    private final String fileName;

    public FruitDaoCsvImpl(String fileName) {

        this.fileName = fileName;
    }

    @Override
    public File get() {
        return new File(fileName);
    }
}
