package dao;

import dao.validator.ReadValidator;
import dao.validator.WriteValidator;
import java.util.List;

public interface FileOperations extends ReadValidator, WriteValidator {
    List<String> read(String fileName);

    boolean write(String dataToWrite, String path);
}
