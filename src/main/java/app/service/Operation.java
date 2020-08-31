package app.service;

import app.model.SupplyFruitBatch;

public interface Operation {
    void execute(SupplyFruitBatch currentBatch);
}
