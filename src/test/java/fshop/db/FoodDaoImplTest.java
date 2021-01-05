package fshop.db;

import fshop.model.Food;
import fshop.service.workfile.ReadCsv;
import fshop.service.workfile.ReadCsvImpl;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FoodDaoImplTest {
    @Test
    void createObject_null() {
        Assertions.assertThrows(NullPointerException.class,
                () -> new FoodDaoImpl(null));
    }

    @Test
    void getValue_null() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        foodDao.addAll();
        Assertions.assertThrows(NullPointerException.class, () -> foodDao.get(null));
    }

    @Test
    void getValue_test1_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 100);
        foodDao.addAll();
        Assertions.assertEquals(100, foodDao.get(actual));
    }

    @Test
    void getValue_test2_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 20);
        foodDao.addAll();
        Assertions.assertEquals(20, foodDao.get(actual));
    }

    @Test
    void getValue_test3_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 150);
        foodDao.addAll();
        Assertions.assertEquals(150, foodDao.get(actual));
    }

    @Test
    void getValue_test4_ok() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 80);
        foodDao.addAll();
        Assertions.assertEquals(80, foodDao.get(actual));
    }

    @Test
    void getValue_test1_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 130);
        foodDao.addAll();
        Assertions.assertEquals(null, foodDao.get(actual));
    }

    @Test
    void getValue_test2_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file2.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 10);
        foodDao.addAll();
        Assertions.assertEquals(null, foodDao.get(actual));
    }

    @Test
    void getValue_test3_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("banana", 2000);
        foodDao.addAll();
        Assertions.assertEquals(null, foodDao.get(actual));
    }

    @Test
    void getValue_test4_notOk() {
        ReadCsv readCsv = new ReadCsvImpl("file.csv");
        FoodDao foodDao = new FoodDaoImpl(readCsv);
        Food actual = new Food("apple", 5);
        foodDao.addAll();
        Assertions.assertEquals(null, foodDao.get(actual));
    }

    @Test
    void updateAll_test1() {
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
        Assertions.assertEquals(expected.toString(), actual.toString());
    }

    @Test
    void updateAll_test2() {
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
        Assertions.assertEquals(expected.toString(), actual.toString());
    }
}
