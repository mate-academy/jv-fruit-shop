package core.basesyntax.service.csv;

public abstract class CsvService {

    protected final String path;

    protected CsvService(String path) {
        this.path = path;
    }
}
