package core.basesyntax.service;

import java.util.List;
import java.util.stream.Collectors;

public class GetListOfActivityImpl implements GetListOfActivity {
    private static final int ACTIVITIES_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 2;

    @Override
    public List<String> getListOfActivity(List<String> listFromFile, String activity) {
        return listFromFile.stream()
                .filter(s -> s.split(",")[ACTIVITIES_INDEX].equals(activity))
                .map(s -> s.substring(FRUIT_NAME_INDEX))
                .collect(Collectors.toList());
    }
}
