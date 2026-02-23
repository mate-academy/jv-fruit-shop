package dao;

import java.util.List;
import model.Activity;

public interface ActivityDao {
    List<Activity> getActivities(String filePath);

    void saveActivities(String filePath);
}
