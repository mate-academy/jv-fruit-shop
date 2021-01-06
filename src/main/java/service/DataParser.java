package service;

import model.FruitTransactionDto;

public interface DataParser {
    FruitTransactionDto parse(String dataToParse);
}
