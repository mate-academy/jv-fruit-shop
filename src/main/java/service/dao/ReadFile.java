package service.dao;

import java.io.File;
import java.util.List;

public interface ReadFile {
    List<String> readFromFileToList(File fileFrom, List<String> report);
}


