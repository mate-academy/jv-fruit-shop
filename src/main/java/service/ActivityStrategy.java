package service;

import service.actions.ActivityHandler;

public interface ActivityStrategy {
    ActivityHandler get(String action);
}
