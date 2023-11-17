package service;

import model.FruitTransaction;

import java.util.List;

public interface ProcessCsvDataService {
    List<FruitTransaction> processData(List<String> rawData);
}
