package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Activity;
import model.ActivityType;
import service.ActivityParserService;

public class ActivityParserServiceImpl implements ActivityParserService {

    @Override
    public List<Activity> getActivityList(String[] input) {
        List<Activity> activityList = new ArrayList<>();
        String[] data;
        for (String line : input) {
            data = line.split(",");
            activityList.add(new Activity(
                    ActivityType.fromCode(data[0]),
                    data[1],
                    Integer.parseInt(data[2])));
        }
        return activityList;
    }
}
