package service;

import java.util.List;
import java.util.Map;
import strategy.DoActivities;

public interface WriteToDB {
    boolean writeToDB(List<String> data, Map<String, DoActivities> strategy);
}
