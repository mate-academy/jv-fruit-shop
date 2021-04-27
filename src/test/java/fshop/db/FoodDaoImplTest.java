package fshop.db;

import static junit.framework.TestCase.assertEquals;

import fshop.model.Food;
import fshop.service.workfile.ReadCsv;
import fshop.service.workfile.ReadCsvImpl;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class FoodDaoImplTest {
    @Test(expected = NullPointerException.class)
    public void getValue_null() {
        FoodDao foodDao = new FoodDaoImpl();
        foodDao.addAll(new ReadCsvImpl().read("file.csv"));
        foodDao.get(null);
    }

    @Test
    public void getValue_test1_ok() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("apple", 100);
        foodDao.addAll(new ReadCsvImpl().read("file.csv"));
        assertEquals(Integer.valueOf(100), foodDao.get(actual));
    }

    @Test
    public void getValue_test2_ok() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("banana", 20);
        foodDao.addAll(new ReadCsvImpl().read("file.csv"));
        assertEquals(Integer.valueOf(20), foodDao.get(actual));
    }

    @Test
    public void getValue_test3_ok() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("apple", 150);
        foodDao.addAll(new ReadCsvImpl().read("file2.csv"));
        assertEquals(Integer.valueOf(150), foodDao.get(actual));
    }

    @Test
    public void getValue_test4_ok() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("banana", 80);
        foodDao.addAll(new ReadCsvImpl().read("file2.csv"));
        assertEquals(Integer.valueOf(80), foodDao.get(actual));
    }

    @Test
    public void getValue_test1_notOk() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("banana", 130);
        foodDao.addAll(new ReadCsvImpl().read("file.csv"));
        assertEquals(null, foodDao.get(actual));
    }

    @Test
    public void getValue_test2_notOk() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("apple", 10);
        foodDao.addAll(new ReadCsvImpl().read("file2.csv"));
        assertEquals(null, foodDao.get(actual));
    }

    @Test
    public void getValue_test3_notOk() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("banana", 2000);
        foodDao.addAll(new ReadCsvImpl().read("file2.csv"));
        assertEquals(null, foodDao.get(actual));
    }

    @Test
    public void getValue_test4_notOk() {
        FoodDao foodDao = new FoodDaoImpl();
        Food actual = new Food("apple", 5);
        foodDao.addAll(new ReadCsvImpl().read("file.csv"));
        assertEquals(null, foodDao.get(actual));
    }

    @Test
    public void updateAll_test1() {
        StringBuilder expected = new StringBuilder();
        StringBuilder actual = new StringBuilder();
        expected.append("banana").append(" = ")
                .append("152").append(System.lineSeparator())
                .append("apple").append(" = ")
                .append("90").append(System.lineSeparator());

        ReadCsv readCsv = new ReadCsvImpl();
        FoodDao foodDao = new FoodDaoImpl();

        List<String> fileLines = readCsv.read("file.csv");
        foodDao.addAll(fileLines);
        foodDao.updateAll(fileLines);

        for (Map.Entry<Food, Integer> entry : foodDao.getDataOfBalance().entrySet()) {
            actual.append(entry.getKey().getName()).append(" = ")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        assertEquals(expected.toString(), actual.toString());
    }

    @Test
    public void updateAll_test2() {
        StringBuilder expected = new StringBuilder();
        StringBuilder actual = new StringBuilder();
        expected.append("banana").append(" = ")
                .append("192").append(System.lineSeparator())
                .append("apple").append(" = ")
                .append("140").append(System.lineSeparator());

        ReadCsv readCsv = new ReadCsvImpl();
        FoodDao foodDao = new FoodDaoImpl();

        List<String> fileLines = readCsv.read("file2.csv");
        foodDao.addAll(fileLines);
        foodDao.updateAll(fileLines);

        for (Map.Entry<Food, Integer> entry : foodDao.getDataOfBalance().entrySet()) {
            actual.append(entry.getKey().getName()).append(" = ")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        assertEquals(expected.toString(), actual.toString());
    }
}
