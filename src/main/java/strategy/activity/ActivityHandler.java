package strategy.activity;

import model.Record;

public interface ActivityHandler {
    void apply(Record record);
}
