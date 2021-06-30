package core.basesyntax.services.impl;

import core.basesyntax.services.interfaces.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    private static final String CREATE_FILE_EXCEPTION_MESSAGE = "Can't create new file ";
    private static final String WRITE_FILE_EXCEPTION_MESSAGE = "Can't write file";

    @Override
    public boolean write(String dataToWrite, String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(CREATE_FILE_EXCEPTION_MESSAGE + fileName);
            }
        }
        try (BufferedWriter bufferedWriter = new BufferedWriter(new java.io.FileWriter(fileName))) {
            bufferedWriter.write(dataToWrite);
        } catch (IOException e) {
            throw new RuntimeException(WRITE_FILE_EXCEPTION_MESSAGE + fileName);
        }
        return true;
    }
}
