package core.basesyntax.service;

import core.basesyntax.model.ItemActivities;
import java.util.List;

public interface ActivitiesService {
    List<ItemActivities> createActivitiesList(List<String> data);
}
