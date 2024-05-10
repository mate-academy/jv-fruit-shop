package service.impl;

import exception.FruitShopException;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import service.FileWriterService;

public class FileWriterServiceImpl implements FileWriterService {
    @Override
    public boolean write(List<String> statistic, String filePath) {
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                boolean created = file.createNewFile();
                if (!created) {
                    throw new FruitShopException("Can't create file:" + filePath);
                }
            }
            try (FileOutputStream fos = new FileOutputStream(filePath);
                    BufferedOutputStream bos = new BufferedOutputStream(fos)) {
                for (String fruitQuantity : statistic) {
                    bos.write((fruitQuantity + System.lineSeparator()).getBytes());
                }
            }
            System.out.println("Data written to file " + filePath + " successfully!");
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
