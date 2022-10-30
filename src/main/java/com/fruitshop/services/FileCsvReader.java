package com.fruitshop.services;

import java.util.List;

public interface FileCsvReader {

    List<String> readFromCsv(String filePath);
}
