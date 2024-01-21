package service;

import storage.Storage;

public class ReturnService implements OperationService {
    @Override
    public void dataProcessing(String key, int value) {
        Storage.getFruitsStorage().merge(key, value, Integer::sum);
    }
}
