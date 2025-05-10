package service.impl;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public boolean write(List<String> statistic, String filePath) {
        try (FileOutputStream fos = new FileOutputStream(filePath);
                BufferedOutputStream bos = new BufferedOutputStream(fos)) {
            for (String fruitQuantity : statistic) {
                bos.write((fruitQuantity + System.lineSeparator()).getBytes());
            }
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
