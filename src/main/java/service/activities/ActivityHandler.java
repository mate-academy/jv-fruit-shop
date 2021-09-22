package service.activities;

import service.fruitrecord.FruitRecord;

public interface ActivityHandler {
    void apply(FruitRecord record);
}
