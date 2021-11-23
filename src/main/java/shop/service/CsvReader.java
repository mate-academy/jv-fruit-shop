package shop.service;

import java.util.List;

public interface CsvReader {
    List<String> read(String fileName);
}
