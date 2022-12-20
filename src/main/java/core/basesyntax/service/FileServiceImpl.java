package core.basesyntax.service;

import core.basesyntax.storageq.StorageInformation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FileServiceImpl implements FileService {
    private static final String directory = "src" + File.separator + "main" + File.separator
            + "sources" + File.separator;

    @Override
    public List<String> readFromFile(String fileName) {
        List<String> transactions = new ArrayList<>();
        Path pathToFile = Paths.get(directory + fileName);

        try (BufferedReader bufferedReader = Files.newBufferedReader(pathToFile)) {
            String line = bufferedReader.readLine();
            while (line != null) {
                transactions.add(line);
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return transactions;
    }

    @Override
    public void writeToFile(String fileName) {
        Path filePath = Paths.get(directory + fileName);
        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(filePath)) {
            bufferedWriter.append("fruit,quantity");
            bufferedWriter.newLine();
            for (Map.Entry<String, Integer> storage
                    : StorageInformation.getShopReport().entrySet()) {
                bufferedWriter.append(storage.getKey() + "," + storage.getValue());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
