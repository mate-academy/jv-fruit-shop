package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.Activities;
import core.basesyntax.model.ItemActivities;
import core.basesyntax.service.ActivitiesService;
import java.util.List;
import java.util.stream.Collectors;

public class ActivitiesServiceImpl implements ActivitiesService {
    private static final String SEPARATOR = ",";
    private static final int ACTIVITIES_INDEX = 0;
    private static final int ITEM_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<ItemActivities> createActivitiesList(List<String> data) {
        return data.subList(1, data.size()).stream()
                .map(this::setActivities)
                .collect(Collectors.toList());
    }

    private ItemActivities setActivities(String record) {
        String[] line = record.split(SEPARATOR);
        return new ItemActivities(Activities.fromValue(line[ACTIVITIES_INDEX]),
                line[ITEM_INDEX], Integer.parseInt(line[QUANTITY_INDEX]));
    }
}
