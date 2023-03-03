package core.basesyntax.service.fileservice;

import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileWriterImpl implements FileWriter {
    private final Validator validator;

    public FileWriterImpl() {
        this.validator = new ValidatorImpl();
    }

    public void write(String fileName, String inputData) {
        validator.checkFileName(fileName);
        try {
            Files.write(new File(fileName).toPath(), inputData.getBytes());
        } catch (IOException e) {
            throw new RuntimeException("Can`t write to file " + fileName, e);
        }
    }
}
