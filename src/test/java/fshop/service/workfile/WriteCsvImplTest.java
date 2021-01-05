package fshop.service.workfile;

import fshop.db.FoodDao;
import fshop.db.FoodDaoImpl;
import fshop.model.Food;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WriteCsvImplTest {
    @Test
    void createObject_null() {
        Assertions.assertThrows(NullPointerException.class, () -> new WriteCsvImpl(null));
    }
    
    @Test
    void setFoodDao_null() {
        FoodDao foodDao = null;
        Assertions.assertThrows(NullPointerException.class,
                () -> new WriteCsvImpl("report.csv").setFoodDao(foodDao));
    }

    @Test
    void write_test1() {
        ReadCsv readCsvFirst = new ReadCsvImpl("file.csv");
        FoodDao foodDaoFirst = new FoodDaoImpl(readCsvFirst);
        foodDaoFirst.addAll();
        foodDaoFirst.updateAll();
        WriteCsv writeCsvFirst = new WriteCsvImpl("report.csv");
        writeCsvFirst.setFoodDao(foodDaoFirst);
        Map<Food, Integer> actual = writeCsvFirst.write();

        Assertions.assertEquals(2, actual.size());
    }

    @Test
    void write_test2() {
        ReadCsv readCsvSecond = new ReadCsvImpl("file2.csv");
        FoodDao foodDaoSecond = new FoodDaoImpl(readCsvSecond);
        foodDaoSecond.addAll();
        foodDaoSecond.updateAll();
        WriteCsv writeCsvSecond = new WriteCsvImpl("report.csv");
        writeCsvSecond.setFoodDao(foodDaoSecond);
        Map<Food, Integer> actual = writeCsvSecond.write();

        Assertions.assertEquals(2, actual.size());
    }
}
