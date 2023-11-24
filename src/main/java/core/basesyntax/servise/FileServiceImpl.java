package core.basesyntax.servise;

import core.basesyntax.validators.DataValidator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final String REPORT = "Report ";
    private static final String EXTENSION = ".csv";
    private static int reportNumber = 1;
    private static DataValidator dataValidator;
    private static ReportService reportService;

    public FileServiceImpl() {
        dataValidator = new DataValidator();
        reportService = new ReportServiceImpl();
    }

    @Override
    public void makeReport(String fromFileName) {
        File newFile = new File(fromFileName);
        List<String> dataFromFile = readFromFile(newFile);
        createReportFile(dataFromFile);
    }

    private List<String> readFromFile(File newFile) {
        try {
            List<String> dataFromFile = Files.readAllLines(newFile.toPath());
            dataValidator.validate(dataFromFile);
            return dataFromFile;
        } catch (IOException e) {
            throw new RuntimeException("File doesn't exist" + e);
        }
    }

    private void createReportFile(List<String> dataFromFile) {
        File toFile = new File(REPORT + reportNumber + EXTENSION);
        try (FileWriter fileWriter = new FileWriter(toFile)) {
            fileWriter.write(reportService.getReport(dataFromFile));
            reportNumber++;
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong" + e);
        }
    }
}
