package core.basesyntax.dao;

import core.basesyntax.service.Parser;

public abstract class CsvDao {

    protected final String path;
    protected final Parser parser;

    protected CsvDao(String path, Parser parser) {
        this.path = path;
        this.parser = parser;
    }
}
