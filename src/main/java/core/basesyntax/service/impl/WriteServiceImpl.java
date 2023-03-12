package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.WriteService;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class WriteServiceImpl implements WriteService {
    @Override
    public void writeFile(List<FruitTransaction> transactions, File toFile) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(toFile));
            bufferedWriter.write(createReport(transactions).toString());
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file" + toFile, e);
        }
    }

    private StringBuilder createReport(List<FruitTransaction> transactions) {
        StringBuilder stringBuilder = new StringBuilder();
        return null;
    }
}
