package service;

import storage.Storage;

public class BalanceService implements OperationService {

    @Override
    public void dataProcessing(String key, int value) {
        Storage.getFruitsStorage().put(key, value);
    }
}
