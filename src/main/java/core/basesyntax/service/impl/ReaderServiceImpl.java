package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    public static final String FILE_TITLE = "type,fruit,quantity";
    public static final String SPLITTER = ",";

    @Override
    public List<TransactionDto> readData(String filename) {
        List<TransactionDto> transactionDto = new ArrayList<>();
        List<String> stringList = new ArrayList<>();
        String line = new String();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            while ((line = br.readLine()) != null) {
                stringList.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("File can't be read!", e);
        }
        if (!(stringList.get(0).trim().equals(FILE_TITLE))) {
            throw new RuntimeException("File has wrong fields declaration.");
        }
        for (int i = 1; i < stringList.size(); i++) {
            String[] eachEntry = stringList.get(i).trim().split(SPLITTER);
            transactionDto.add(new TransactionDto(Operation.operationCheck(eachEntry[0]),
                    new Fruit(eachEntry[1]), Integer.valueOf(eachEntry[2])));
        }
        return transactionDto;
    }
}

