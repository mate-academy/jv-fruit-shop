package core.basesyntax.dao.impl;

import static core.basesyntax.db.Storage.storage;

import core.basesyntax.dao.ReportSupplierDao;
import core.basesyntax.dao.ReportWriterDao;
import core.basesyntax.model.Fruit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class ReportSupplierDaoImpl implements ReportSupplierDao, ReportWriterDao {

    @Override
    public List<String> get() {
        return storage.stream()
                .map(Fruit::getStock)
                .collect(Collectors.toList());
    }

    @Override
    public void createReport() {
        String fileName = "report.csv";
        File reportFile = new File("./src/main/java/core/basesyntax/resources/" + fileName
        );
        try {
            reportFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("FAILED TO CREATE: cant create new file: " + fileName);
        }
        writeStringToFile(reportFile, ("fruit,quantity" + System.lineSeparator()));
        get().forEach(line -> writeStringToFile(reportFile, (line + System.lineSeparator())));
    }

    private void writeStringToFile(File file, String line) {
        try {
            Files.write(file.toPath(), line.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("FAILED TO WRITE: cant write line: "
                    + line + ", to file: " + file.getName());
        }

    }
}
