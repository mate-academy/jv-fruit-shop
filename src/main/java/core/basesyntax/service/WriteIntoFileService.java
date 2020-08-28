package core.basesyntax.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteIntoFileService {
    private String filePath = "storageContent.csv";

    public void write(String storageContent) {
        try {
            BufferedWriter out = new BufferedWriter(
                    new FileWriter(filePath, true));
            out.write(storageContent + "\n");
            out.close();
        } catch (IOException e) {
            throw new RuntimeException("Wrong path");
        }
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
