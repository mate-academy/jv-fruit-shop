package service;

import storage.Storage;

public class PurchaseService implements OperationService {

    @Override
    public void dataProcessing(String fruitName, int value) {
        Storage.getFruitsStorage().compute(fruitName, (key, existValue) -> {
            if (existValue != null && existValue >= value) {
                return existValue - value;
            } else {
                throw new RuntimeException("You can't sell because"
                        + " there isn't enough");
            }
        });
    }
}
