package core.basesyntax.service.data;

public interface Parser<T> {
    T parser(String row);
}
