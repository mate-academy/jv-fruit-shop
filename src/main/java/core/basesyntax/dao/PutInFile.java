package core.basesyntax.dao;

import java.io.FileOutputStream;
import java.io.IOException;

public class PutInFile implements IPutInfoDao {
    @Override
    public void putData(String path, String report) {
        try (FileOutputStream fos = new FileOutputStream(path)) {
            byte[] buffer = report.getBytes();
            fos.write(buffer);
        } catch (IOException e) {
            throw new RuntimeException("File not found " + e);
        }
    }
}
