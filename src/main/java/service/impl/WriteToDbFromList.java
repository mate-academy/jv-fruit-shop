package service.impl;

import java.util.List;
import java.util.Map;
import service.WriteToDB;
import strategy.DoActivities;

public class WriteToDbFromList implements WriteToDB {
    private static final int INDEX_OF_HEADER = 0;
    private static final int INDEX_OF_ACTIVITY = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_NUMBER = 2;
    private String spliterator;

    public WriteToDbFromList(String spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public boolean writeToDB(List<String> data, Map<String, DoActivities> strategy) {
        if (data == null) {
            return false;
        }
        data.remove(INDEX_OF_HEADER);
        data.stream()
                .map(s -> s.split(spliterator))
                .forEach(s -> strategy.get(s[INDEX_OF_ACTIVITY]).doActivity(s[INDEX_OF_FRUIT],
                        Integer.parseInt(s[INDEX_OF_NUMBER])));
        return true;
    }
}
