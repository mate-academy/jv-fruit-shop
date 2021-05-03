package service;

import dao.FruitDao;
import java.util.Map;
import model.Fruit;
import service.file.FileWriter;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String COMMA = ",";
    public static final String NEW_LINE = "\n";
    public static final String FILE_START = "fruit, quantity";
    private FileWriter fileWriter;
    private FruitDao fruitDao;

    public ReportGeneratorImpl(FileWriter fileWriter, FruitDao fruitDao) {
        this.fileWriter = fileWriter;
        this.fruitDao = fruitDao;
    }

    @Override
    public void generateReport(String fileName) {
        StringBuilder report = new StringBuilder();
        report.append(FILE_START);
        for (Map.Entry<Fruit, Integer> entry: fruitDao.getDB().entrySet()) {
            report.append(NEW_LINE)
                    .append(entry.getKey().getName())
                    .append(COMMA)
                    .append(entry.getValue().toString());
        }
        fileWriter.writeToFile(fileName, report.toString());
    }
}
