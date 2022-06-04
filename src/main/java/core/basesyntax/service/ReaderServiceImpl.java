package core.basesyntax.service;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Record;
import java.util.LinkedList;
import java.util.Queue;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public Queue<Record> read(String fileName) {
        // TODO do read from file
        Queue<Record> records = new LinkedList<>();
        records.add(new Record(Operation.BALANCE, "banana", 20));
        records.add(new Record(Operation.BALANCE, "apple", 100));
        records.add(new Record(Operation.SUPPLY, "banana", 100));
        records.add(new Record(Operation.PURCHASE, "banana", 13));
        records.add(new Record(Operation.RETURN, "apple", 10));
        records.add(new Record(Operation.PURCHASE, "apple", 20));
        records.add(new Record(Operation.PURCHASE, "banana", 5));
        records.add(new Record(Operation.SUPPLY, "banana", 50));
        return records;
    }
}
