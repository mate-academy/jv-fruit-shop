package service;

import java.nio.file.Path;
import java.util.List;

public interface ReaderService {
    List<String> read(Path path);
}
