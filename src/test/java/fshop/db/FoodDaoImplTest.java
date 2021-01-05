package fshop.db;

import static junit.framework.TestCase.assertEquals;

import fshop.model.Food;
import fshop.service.workfile.ReadCsv;
import fshop.service.workfile.ReadCsvImpl;
import java.util.Map;
import org.junit.Test;

public class FoodDaoImplTest {
    @Test(expected = NullPointerException.class)
    public void createObject_null() {
        new FoodDaoImpl(null);
    }

    @Test(expected = NullPointerException.class)
    public void getValue_null() {
        FoodDao foodDao = new FoodDaoImpl(new ReadCsvImpl("file.csv"));
        foodDao.addAll();
        foodDao.get(null);
    }

    @Test
    public void getValue_test1_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 100);
        foodDao.addAll();
        assertEquals(Integer.valueOf(100), foodDao.get(actual));
    }

    @Test
    public void getValue_test2_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 20);
        foodDao.addAll();
        assertEquals(Integer.valueOf(20), foodDao.get(actual));
    }

    @Test
    public void getValue_test3_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 150);
        foodDao.addAll();
        assertEquals(Integer.valueOf(150), foodDao.get(actual));
    }

    @Test
    public void getValue_test4_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 80);
        foodDao.addAll();
        assertEquals(Integer.valueOf(80), foodDao.get(actual));
    }

    @Test
    public void getValue_test1_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 130);
        foodDao.addAll();
        assertEquals(null, foodDao.get(actual));
    }

    @Test
    public void getValue_test2_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 10);
        foodDao.addAll();
        assertEquals(null, foodDao.get(actual));
    }

    @Test
    public void getValue_test3_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 2000);
        foodDao.addAll();
        assertEquals(null, foodDao.get(actual));
    }

    @Test
    public void getValue_test4_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 5);
        foodDao.addAll();
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

        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        foodDao.addAll();
        foodDao.updateAll();

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

        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        foodDao.addAll();
        foodDao.updateAll();

        for (Map.Entry<Food, Integer> entry : foodDao.getDataOfBalance().entrySet()) {
            actual.append(entry.getKey().getName()).append(" = ")
                    .append(entry.getValue()).append(System.lineSeparator());
        }
        assertEquals(expected.toString(), actual.toString());
    }
}
