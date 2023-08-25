package service;

import java.io.IOException;
import java.util.List;
import model.FruitTransaction;

public interface FileReaderService {
    /**
     * Read data from  CSV-file and return list of lines.
     *
     * @param filePath path to file.
     * @return List of lines.
     * @throws IOException if there is an error with file reading.
     */

    List<FruitTransaction> readFromFile(String filePath) throws IOException;
}
