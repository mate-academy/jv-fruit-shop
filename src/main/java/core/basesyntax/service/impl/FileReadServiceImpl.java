package core.basesyntax.service.impl;

import core.basesyntax.Transaction;
import core.basesyntax.service.FileReadService;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReadServiceImpl implements FileReadService {
    @Override
    public List<Transaction> readFile(String filePath) {
        List<Transaction> lines = new ArrayList<>();
        Path path = Paths.get(filePath);

        try (Scanner scanner = new Scanner(path)) {
            while (scanner.hasNext()) {
                String[] parts = scanner.nextLine().split(",");
                if (!parts[0].equals("type")) {
                    lines.add(new Transaction(parts[0], parts[1], parts[2], parts[3]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("File is not exist");
        }

        if (lines.size() == 0) {
            throw new RuntimeException("File is empty");
        }

        return lines;
    }
}
