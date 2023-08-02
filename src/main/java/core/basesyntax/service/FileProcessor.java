package core.basesyntax.service;

import core.basesyntax.db.FruitsActivitiesBase;
import core.basesyntax.model.Activity;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor { //todo maybe it should be merged with FileService

    private final FileService fileService;

    public FileProcessor(FileService fileService) {
        this.fileService = fileService;
    }

    public void processFile(String fileName) {
        List<String> listOflines = fileService.getLinesFromFile(fileName);
        listOflines.remove(0);
        List<Activity> listOfActivities = new ArrayList<>();
        for (String line : listOflines) {
            listOfActivities.add(new Activity(line));
        }
        FruitsActivitiesBase.listOfOperations.addAll(listOfActivities);
    }
}
