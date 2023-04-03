package core.basesyntax.service;

public interface ParserService<T, R> {
    T parse(R data);
}
