package service;

import storage.Storage;

public class SupplyService implements OperationService {

    @Override
    public void dataProcessing(String key, int value) {
        Storage.getFruitsStorage().merge(key, value, Integer::sum);
    }
}
