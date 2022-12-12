package service;

import java.nio.file.Path;

public interface WriterService {
    boolean write(String transactions, Path path);
}
