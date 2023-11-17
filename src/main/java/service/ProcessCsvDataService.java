package service;

import model.FruitTransaction;

import java.util.List;

public interface ProcessCsvDataService {
    void processData(List<String> rawData);
}
