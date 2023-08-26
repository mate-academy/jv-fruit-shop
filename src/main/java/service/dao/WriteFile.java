package service.dao;

import java.io.File;
import java.util.List;

public interface WriteFile {
    void writeListToFile(List<String> repport, File file);
}
