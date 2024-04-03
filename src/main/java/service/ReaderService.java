package service;

import model.FruitTransaction;

import java.util.List;

public interface ReaderService {
    public List<String> readFromFilesContents(String inputFile);
}
