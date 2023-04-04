package core.basesyntax.service;

public interface FileWriterService<T> {
    void write(T data, String path);
}
