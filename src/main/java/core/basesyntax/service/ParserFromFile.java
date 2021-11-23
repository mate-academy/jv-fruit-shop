package core.basesyntax.service;

public interface ParserFromFile<T> {
    T parseLine(String data);
}
