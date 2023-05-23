package core.basesyntax.dao;

public abstract class CsvDao {

    protected final String path;

    protected CsvDao(String path) {
        this.path = path;
    }
}
