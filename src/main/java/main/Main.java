package main;

import dao.ActivityDao;
import dao.ActivityDaoImpl;
import java.util.List;
import model.Activity;
import service.ActivityService;
import service.StrategyProvider;

public class Main {
    public static void main(String[] args) {
        ActivityDao activityDao = new ActivityDaoImpl();
        List<Activity> activities = activityDao.getActivities("src/main/resources"
                + "/activitiesBefore.txt");

        StrategyProvider strategyProvider = new StrategyProvider();
        ActivityService activityService = new ActivityService(strategyProvider);
        activityService.process(activities);

        activityDao.saveActivities("src/main/resources/activitiesAfter.txt");
    }
}
