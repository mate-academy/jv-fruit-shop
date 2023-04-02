package core.basesyntax.service;

public interface FileWriter<T> {
    void write(T data, String path);
}
