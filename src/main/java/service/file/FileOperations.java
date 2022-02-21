package service.file;

import java.util.List;
import service.file.validator.ReadValidator;
import service.file.validator.WriteValidator;

public interface FileOperations extends ReadValidator, WriteValidator {
    List<String> read(String fileName);

    boolean write(String dataToWrite, String path);
}
