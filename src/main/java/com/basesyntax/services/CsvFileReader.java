package com.basesyntax.services;

import java.util.List;

public interface CsvFileReader {
    List<String> getAcceptedFileAsList(String fileName);

}
