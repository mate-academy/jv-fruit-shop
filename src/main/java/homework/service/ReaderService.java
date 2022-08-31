package homework.service;

import java.nio.file.Path;
import java.util.List;

public interface ReaderService {
    List<String> csvRead(Path path);
}
