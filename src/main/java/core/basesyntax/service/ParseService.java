package core.basesyntax.service;

public interface ParseService<T> {
    T parse(String line);
}
