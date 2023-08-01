package core.basesyntax.services.impl;

import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.functions.ReadFile;
import core.basesyntax.model.Task;
import core.basesyntax.services.CreateTaskService;
import java.util.ArrayList;
import java.util.List;

public class CreateTaskServiceImpl implements CreateTaskService {
    private static final int INDEX_OF_ACTION = 0;
    private static final int INDEX_OF_NAME = 1;
    private static final int INDEX_OF_VALUE = 2;
    private static final int MAX_SIZE_LINE = 3;

    @Override
    public List<Task> createTasks(ReadFile dataFromFile, String sourceFile) {
        if (dataFromFile == null) {
            throw new ValidationDataException("ReadFile interface function "
                    + "is null! Dont know how to read file");
        }
        List<String[]> readFile = dataFromFile.read(sourceFile);
        if (readFile.isEmpty()) {
            throw new ValidationDataException("File is empty!");
        }
        List<Task> tasks = new ArrayList<>();
        for (String[] readLine : readFile) {
            if (readLine.length != MAX_SIZE_LINE) {
                throw new ValidationDataException("Not valid lines");
            }

            Task.ActionType typeOfTask = null;
            for (Task.ActionType type : Task.ActionType.values()) {
                if (type.getType().equals(readLine[INDEX_OF_ACTION])) {
                    typeOfTask = type;
                    break;
                }
            }
            if (typeOfTask == null) {
                throw new ValidationDataException("Type is not exist");
            }

            String nameOfProduct = readLine[INDEX_OF_NAME];
            if (nameOfProduct == null) {
                throw new ValidationDataException("Name of Product cant be null");
            }

            if (nameOfProduct.isEmpty()) {
                throw new ValidationDataException("Name of Product cant be empty");
            }
            tasks.add(new Task(typeOfTask, nameOfProduct,
                    Integer.parseInt(readLine[INDEX_OF_VALUE])));
        }
        return tasks;
    }
}
