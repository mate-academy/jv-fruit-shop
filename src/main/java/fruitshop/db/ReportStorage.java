package fruitshop.db;

import java.util.ArrayList;
import java.util.List;

public class ReportStorage {
    private static final List<String> storage = new ArrayList<>();

    public void add(String processLine) {
        storage.add(processLine);
    }

    public String get(int index) {
        return storage.get(index);
    }

    public int size() {
        return storage.size();
    }

    public List<String> getAll() {
        return storage;
    }
}
