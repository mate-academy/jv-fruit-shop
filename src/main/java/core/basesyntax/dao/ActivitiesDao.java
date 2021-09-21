package core.basesyntax.dao;

import java.util.List;

public interface ActivitiesDao {
    List<String> getActivities(String pathToFile);

    void writeInFile(String pathToFile);
}
