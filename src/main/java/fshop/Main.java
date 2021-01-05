package fshop;

import fshop.db.FoodDao;
import fshop.db.FoodDaoImpl;
import fshop.service.workfile.ReadCsv;
import fshop.service.workfile.ReadCsvImpl;
import fshop.service.workfile.WriteCsv;
import fshop.service.workfile.WriteCsvImpl;

public class Main {
    public static void main(String[] args) {
        ReadCsv readCsvFirst = new ReadCsvImpl("file.csv");
        FoodDao foodDaoFirst = new FoodDaoImpl(readCsvFirst);
        foodDaoFirst.addAll();
        foodDaoFirst.updateAll();
        WriteCsv writeCsvFirst = new WriteCsvImpl("report.csv");
        writeCsvFirst.setFoodDao(foodDaoFirst);
        writeCsvFirst.write();

        ReadCsv readCsvSecond = new ReadCsvImpl("file2.csv");
        FoodDao foodDaoSecond = new FoodDaoImpl(readCsvSecond);
        foodDaoSecond.addAll();
        foodDaoSecond.updateAll();
        WriteCsv writeCsvSecond = new WriteCsvImpl("report.csv");
        writeCsvSecond.setFoodDao(foodDaoSecond);
        writeCsvSecond.write();
    }
}
