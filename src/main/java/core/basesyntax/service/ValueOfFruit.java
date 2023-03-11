package core.basesyntax.service;

@FunctionalInterface
public interface ValueOfFruit<T> {
    T valueOf(String fruit, int amount);
}
