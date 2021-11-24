package core.basesyntax.service;

public interface ParserService<T> {
    T parseLine(String line);
}
