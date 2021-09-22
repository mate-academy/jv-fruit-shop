package core.service;

public interface Mapper<T,U> {
    U map(T value);
}
