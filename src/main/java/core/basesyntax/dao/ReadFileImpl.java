package core.basesyntax.dao;

import core.basesyntax.model.Account;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReadFileImpl implements ReadFile {
    private Account account = new Account();

    @Override
    public String[] read(String nameOfFile) {
        List<String> textInFile = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(nameOfFile))) {
            textInFile = Files.readAllLines(Path.of(nameOfFile));
            return textInFile.stream()
                    .filter(this::startWithLetter)
                    .toArray(String[]::new);
        } catch (IOException e) {
            throw new RuntimeException("Can't read the data from the file " + nameOfFile, e);
        }
    }

    private boolean startWithLetter(String word) {
        if (word.startsWith(Account.Operation.BALANCE.getCode())
                || word.startsWith(Account.Operation.PURCHASE.getCode())
                || word.startsWith(Account.Operation.RETURN.getCode())
                || word.startsWith(Account.Operation.SUPPLY.getCode())) {
            return true;
        }
        return false;
    }
}
