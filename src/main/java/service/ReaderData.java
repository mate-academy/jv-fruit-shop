package service;

import java.nio.file.Path;
import java.util.List;

public interface ReaderData {
    List<String> read(Path path);
}
