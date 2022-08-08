package core.basesyntax.service.data;

public interface ParserService<T> {
    T parser(String row);
}
