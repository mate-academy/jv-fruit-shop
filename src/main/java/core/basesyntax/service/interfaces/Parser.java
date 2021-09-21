package core.basesyntax.service.interfaces;

public interface Parser<T, U> {
    U parse(T value);
}
