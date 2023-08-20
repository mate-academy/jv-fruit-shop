package core.basesyntax.services.impl;

import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.services.WriteFileService;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFileServiceImpl implements WriteFileService {

    @Override
    public boolean writeToFile(String[] result, String fileName) {
        validateData(result, fileName);
        try (FileWriter writer = new FileWriter(fileName)) {
            for (String strResult : result) {
                writer.write(strResult);
            }
        } catch (IOException e) {
            throw new ValidationDataException("Can't write the data to the file " + fileName, e);
        }
        return true;
    }

    private void validateData(String[] result, String fileName) {
        if (result == null) {
            throw new ValidationDataException("Can't write data to file, "
                    + "result data can't be null");
        }
        if (result.length == 0) {
            throw new ValidationDataException("Can't write data to file, "
                    + "result data can't be empty");
        }
        if (fileName == null) {
            throw new ValidationDataException("Can't write data to file, "
                    + "path to file can't be null");
        }
        if (fileName.isEmpty()) {
            throw new ValidationDataException("Can't write data to file, "
                    + "path to file can't be empty");
        }
    }
}
