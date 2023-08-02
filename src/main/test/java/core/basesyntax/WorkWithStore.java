package core.basesyntax;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import core.basesyntax.dao.StoreDao;
import core.basesyntax.dao.StoreDaoImpl;
import core.basesyntax.exception.ValidationDataException;
import core.basesyntax.model.Task;
import core.basesyntax.services.ActionStrategy;
import core.basesyntax.services.ProcessStoreService;
import core.basesyntax.services.actions.*;
import core.basesyntax.services.impl.ActionStrategyImpl;
import core.basesyntax.services.impl.CreateTaskServiceImpl;
import core.basesyntax.services.impl.ProcessStoreServiceImpl;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WorkWithStore {
    private static final int LINE_IN_FILE_1 = 0;
    private static final int INDEX_ACTION = 0;
    private static final int INDEX_NAME = 1;
    private static final int INDEX_VALUE = 2;
    private static Map<Task.ActionType, ActionHandler> actionHandlerMapTest;
    private static ActionStrategy actionStrategyTest;
    private static ProcessStoreService handleTasksTest;
    private static StoreDao dao;

    @BeforeAll
    static void createHandleStrategy() {
        actionHandlerMapTest = new HashMap<>();
        actionHandlerMapTest.put(Task.ActionType.BALANCE, new BalanceActionHandler());
        actionHandlerMapTest.put(Task.ActionType.SUPPLY, new SupplyActionHandler());
        actionHandlerMapTest.put(Task.ActionType.PURCHASE, new PurchaseActionHandler());
        actionHandlerMapTest.put(Task.ActionType.RETURN, new ReturnActionHandler());
        actionStrategyTest = new ActionStrategyImpl(actionHandlerMapTest);
        dao = new StoreDaoImpl();
        handleTasksTest = new ProcessStoreServiceImpl(dao, actionStrategyTest);
    }

    @BeforeEach
    void cleanStorage() {
        dao.clean();
    }

    @Test
    void isPathEmpty_inputFile() {
        assertThrows(ValidationDataException.class, () -> new CreateTaskServiceImpl()
                    .createTasks(path -> new ArrayList<>(), ""));
    }

    @Test
    void isInterfaceFunction_null() {
        assertThrows(ValidationDataException.class, () -> new CreateTaskServiceImpl()
                .createTasks(null, "inputFile.csv"));
    }

    @Test
    void isOneCorrectLine_ok() {
        List<Task> tasks = new CreateTaskServiceImpl()
                .createTasks(path -> readFileHelper(path), "testFiles/inputFileTestOneCrtLine.csv");
        handleTasksTest.processAction(tasks);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", 30);
        Map<String, Integer> actual = dao.getStorage();
        assertEquals(expected, actual);
    }

    @Test
    void isManyCorrectLine_ok() {
        List<Task> tasks = new CreateTaskServiceImpl()
                .createTasks(path -> readFileHelper(path), "testFiles/inputFileTestCorrectLines.csv");
        handleTasksTest.processAction(tasks);
        Map<String, Integer> expected = new HashMap<>();
        expected.put("banana", 140);
        expected.put("apple", 80);
        Map<String, Integer> actual = dao.getStorage();
        assertEquals(expected, actual);
    }

    @Test
    void isWrongLine_notOk() {
        assertThrows(ValidationDataException.class, () -> {
            new CreateTaskServiceImpl()
                    .createTasks(path -> readFileHelper(path), "testFiles/inputFileTestWrongLine.csv");
        });
    }

    @Test
    void isNumNegative_notOk() {
        assertThrows(ValidationDataException.class, () -> {
            new CreateTaskServiceImpl()
                    .createTasks(path -> readFileHelper(path), "testFiles/inputFileTestNumNegative.csv");
        });
    }

    @Test
    void isFileEmpty_notOk() {
        assertThrows(ValidationDataException.class, () -> {
            new CreateTaskServiceImpl()
                    .createTasks(path -> readFileHelper(path), "testFiles/inputFileTestEmpty.csv");
        });
    }

    private List<String[]> readFileHelper(String path) {
        List<String[]> strLines = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(path))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                strLines.add(nextLine);
            }
        } catch (IOException e) {
            System.out.println("Cant open the file!");
            e.printStackTrace();
        } catch (CsvValidationException e) {
            System.out.println("CSV file is incorrect!");
            e.printStackTrace();
        }
        return strLines;
    }
}
