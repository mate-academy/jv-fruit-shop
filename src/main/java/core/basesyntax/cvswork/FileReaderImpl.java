package core.basesyntax.cvswork;

import core.basesyntax.model.FruitTransaction;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReaderImpl implements FileRead {
    public List<FruitTransaction> readParser(String csv) {
        List<String> localList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(csv))) {
            String line;
            while ((line = reader.readLine()) != null) {
                localList.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(" Can`t open file " + csv, e);
        } catch (IOException e) {
            throw new RuntimeException(" Can`t read file" + csv, e);
        }
        return parse(localList);
    }

    public List<FruitTransaction> parse(List<String> fruitTransaction) {
        return fruitTransaction.stream()
                .map(str -> str.split(","))
                .map(lis -> new FruitTransaction(FruitTransaction
                        .Operation.fromOperation(lis[0]), lis[1], Integer.parseInt(lis[2])))
                .collect(Collectors.toList());

    }
}
