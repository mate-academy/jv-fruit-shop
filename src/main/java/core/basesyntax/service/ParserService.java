package core.basesyntax.service;

public interface ParserService<T> {
    T parse(String line);
}
