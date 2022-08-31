package homework.dao;

import java.nio.file.Path;
import java.util.List;

public interface ReadService {
    List<String> csvRead(Path path);
}
