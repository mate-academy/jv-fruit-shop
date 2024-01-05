package core.basesyntax.service;

public interface Mapper<T> {
    T getMappedObject(String[] data);
}
