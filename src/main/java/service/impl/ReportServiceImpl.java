package service.impl;

import dao.FruitsDao;
import java.util.Map;
import model.Fruit;
import service.ReportService;
import service.file.FileWriter;

public class ReportServiceImpl implements ReportService {
    public static final String COLUMNS = "type,quantity";
    public static final char COLUMN_SEPARATOR = ',';

    private FileWriter fileWriter;
    private FruitsDao fruitsDao;

    public ReportServiceImpl(FileWriter fileWriter, FruitsDao fruitsDao) {
        this.fileWriter = fileWriter;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void createReport(String filename) {
        fileWriter.writeToFile(filename, COLUMNS);
        for (Map.Entry<Fruit, Integer> entry : fruitsDao.getAll()) {
            String reportLine = System.lineSeparator()
                    + entry.getKey().getType()
                    + COLUMN_SEPARATOR
                    + entry.getValue();
            fileWriter.writeToFile(filename, reportLine);
        }
    }
}
