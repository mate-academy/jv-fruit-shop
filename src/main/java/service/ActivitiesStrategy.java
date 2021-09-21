package service;

import service.activities.Activities;
import service.activities.TypeOfActivities;

public interface ActivitiesStrategy {
    Activities get(TypeOfActivities type);

}
