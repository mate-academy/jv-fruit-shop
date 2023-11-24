package service;

import model.FruitTransaction;

import java.util.List;

public interface FileReader {
    List<FruitTransaction> read(String inputFileName);
}
