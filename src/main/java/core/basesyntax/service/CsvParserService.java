package core.basesyntax.service;

public interface CsvParserService<T> {
    T parseLine(String line);
}
