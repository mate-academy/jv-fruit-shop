package service.impl;

import model.ActivityType;
import service.ActivityChecker;

public class ActivityCheckerImpl implements ActivityChecker {
    @Override
    public String checkActivity(String activity) {
        for (ActivityType activityType : ActivityType.values()) {
            if (activityType.getActivity().equals(activity)) {
                return activity;
            }
        }
        throw new RuntimeException("There is no such activity" + activity);
    }
}
