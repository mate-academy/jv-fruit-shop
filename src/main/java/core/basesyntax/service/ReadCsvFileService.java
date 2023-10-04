package core.basesyntax.service;

import java.util.List;

/**
 * Interface responsible for reading data from a CSV file.
 * Contains a method List String readFile(String filename) that reads the contents of a CSV file
 * and returns them as a list of strings.**/
public interface ReadCsvFileService {
    List<String> readFile(String filename);
}
