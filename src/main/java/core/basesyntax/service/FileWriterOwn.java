package core.basesyntax.service;

import java.util.List;

public interface FileWriterOwn<T> {
    void write(List<T> data);
}
