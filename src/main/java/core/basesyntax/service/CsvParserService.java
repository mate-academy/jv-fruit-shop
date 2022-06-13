package core.basesyntax.service;

public interface CsvParserService<T> {
    T parse(String line);
}
