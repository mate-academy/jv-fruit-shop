package core.basesyntax.dao;

import core.basesyntax.model.Activity;
import core.basesyntax.model.TypeActivity;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityDaoCsvImpl implements ActivityDaoCsv {
    private static final int INDEX_CHAR_ACTIVITY = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_COUNT = 2;
    private static final String CSV_SEPARATOR = ",";
    private static final String RESOURCES_PATH = "src" + File.separator + "main" + File.separator
            + "resources" + File.separator;

    @Override
    public List<Activity> getAll(String fileName) {
        try {
            return Files.readAllLines(Path.of(RESOURCES_PATH + fileName)).stream()
                .filter(l -> l != null && TypeActivity.getByLabel(l.substring(0,1)) != null)
                .map(this::parseActivity)
                .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException("File not found " + fileName);
        }
    }

    public Activity parseActivity(String string) {
        String[] array = string.split(CSV_SEPARATOR);
        return new Activity(
                TypeActivity.getByLabel(array[INDEX_CHAR_ACTIVITY]),
                array[INDEX_FRUIT],
                Integer.parseInt(array[INDEX_COUNT])
        );
    }
}
