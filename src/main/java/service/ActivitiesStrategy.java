package service;

import service.activities.ActivitiesHandler;

public interface ActivitiesStrategy {
    ActivitiesHandler get(String firstChar);
}
