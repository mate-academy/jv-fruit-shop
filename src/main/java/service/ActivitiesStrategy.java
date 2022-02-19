package service;

import service.activities.ActivityHandler;
import service.activities.TypeOfActivities;

public interface ActivitiesStrategy {
    ActivityHandler get(TypeOfActivities type);
}
