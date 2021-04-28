package service.impl;

import exception.InvalidInputException;
import service.Activity;
import service.ActivityService;

public class ActivityServiceImpl implements ActivityService {
    @Override
    public Activity getActivity(String string) {
        switch (string) {
            case "b":
                return Activity.BALANCE;
            case "p":
                return Activity.PURCHASE;
            case "s":
                return Activity.SUPPLY;
            case "r":
                return Activity.RETURN;
            default:
                throw new InvalidInputException("Invalid activity passed");
        }
    }
}
