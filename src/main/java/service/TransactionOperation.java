package service;

import dao.FruitStorageDao;
import java.util.ArrayList;
import model.InputDataType;

public interface TransactionOperation {
    void execute(ArrayList<InputDataType> inputData, FruitStorageDao storage);
}
