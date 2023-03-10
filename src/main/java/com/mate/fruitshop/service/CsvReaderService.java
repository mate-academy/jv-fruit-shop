package com.mate.fruitshop.service;

import java.util.List;

public interface CsvReaderService {
    List<String> read(String inputFileDir);
}
