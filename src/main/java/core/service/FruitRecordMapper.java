package core.service;

import core.model.FruitRecord;

public class FruitRecordMapper implements Mapper<String, FruitRecord> {

    @Override
    public FruitRecord map(String value) {
        String[] data = value.split(",");
        return new FruitRecord(data[0], data[1], Integer.parseInt(data[2]));
    }
}
