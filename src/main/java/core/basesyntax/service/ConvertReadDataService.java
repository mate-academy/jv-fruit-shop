package core.basesyntax.service;

import core.basesyntax.model.Transaction;

import java.util.List;

public interface ConvertReadDataService {
    public List<Transaction> convertDataFromFile (List<String> dataFromFile);
}
