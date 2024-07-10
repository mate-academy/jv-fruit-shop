package core.basesyntax.service;

public interface ReaderService<T> {
    T readFromFile(String filepath);
}
