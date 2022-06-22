package service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import service.ReadTransactions;

public class ReadTransactionsImpl implements ReadTransactions {
    private List<String> information;

    @Override
    public List<String> convertFromFileToList(String path) {
        try {
            information = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Wrong file name!" + e);
        }
        return information;
    }

}
