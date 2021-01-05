package fshop;

import fshop.db.FoodDao;
import fshop.db.FoodDaoImpl;
import fshop.service.workfile.ReadCsv;
import fshop.service.workfile.ReadCsvImpl;
import fshop.service.workfile.WriteCsv;
import fshop.service.workfile.WriteCsvImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadCsv readCsvFirst = new ReadCsvImpl();
        FoodDao foodDaoFirst = new FoodDaoImpl();
        List<String> fileLinesFirst = readCsvFirst.read("file.csv");
        foodDaoFirst.addAll(fileLinesFirst);
        foodDaoFirst.updateAll(fileLinesFirst);
        WriteCsv writeCsvFirst = new WriteCsvImpl("report.csv");
        writeCsvFirst.write(foodDaoFirst.getDataOfBalance());

        ReadCsv readCsvSecond = new ReadCsvImpl();
        FoodDao foodDaoSecond = new FoodDaoImpl();
        List<String> fileLinesSecond = readCsvSecond.read("file2.csv");
        foodDaoSecond.addAll(fileLinesSecond);
        foodDaoSecond.updateAll(fileLinesSecond);
        WriteCsv writeCsvSecond = new WriteCsvImpl("report.csv");
        writeCsvSecond.write(foodDaoFirst.getDataOfBalance());
    }
}
