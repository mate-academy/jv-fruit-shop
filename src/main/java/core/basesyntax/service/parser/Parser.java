package core.basesyntax.service.parser;

public interface Parser<T, U> {
    U parse(T list);
}
