package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public List<String> readFile(String filePath) {
        Scanner scanner;
        try {
            scanner = new Scanner(new File(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            list.add(scanner.next());
        }
        scanner.close();
        return list;
    }
}
