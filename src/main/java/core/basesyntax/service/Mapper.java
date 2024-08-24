package core.basesyntax.service;

public interface Mapper<T, S> {
    T toObject(S source);
}
