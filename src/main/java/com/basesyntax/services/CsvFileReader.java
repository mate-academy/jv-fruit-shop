package com.basesyntax.services;

import java.util.List;

public interface CsvFileReader {
    void acceptFile(String pathName);

    List<String> getAcceptedFileAsList();

}
