package core.basesyntax.service;

import java.io.File;
import java.io.FileNotFoundException;

public interface ReaderService {
    void readCSV(File file) throws FileNotFoundException;
}
