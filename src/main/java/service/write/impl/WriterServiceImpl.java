package service.write.impl;

import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import service.write.ReportService;
import service.write.WriterService;

public class WriterServiceImpl implements WriterService {
    private static final String DIRECTORY_PATH = "src/main/resources/";
    private static final String CANT_WRITE_MESSAGE = "Can't write to file: ";
    private ReportService reportService = new ReportServiceImpl();
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public void writeToFile(String filename, String report) {
        File file = new File(DIRECTORY_PATH + filename);
        try {
            Files.write(file.toPath(), report.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(CANT_WRITE_MESSAGE + file);
        }
    }
}
