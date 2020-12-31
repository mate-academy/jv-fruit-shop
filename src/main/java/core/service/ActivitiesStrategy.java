package core.service;

import core.activities.ActivitiesHandler;

public interface ActivitiesStrategy {
    ActivitiesHandler get(String typeOfActivity);
}
