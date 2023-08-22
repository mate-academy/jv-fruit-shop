package service;

import java.util.List;
import model.Activity;

public interface ActivityParserService {
    List<Activity> getActivityList(String[] data);
}
