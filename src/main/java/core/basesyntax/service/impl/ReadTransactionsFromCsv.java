package core.basesyntax.service.impl;

import core.basesyntax.service.ReadTransactions;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

public class ReadTransactionsFromCsv implements ReadTransactions {
    @Override
    public List<String> toList(String source) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
            return bufferedReader.lines()
                    .skip(1)
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find this file " + source, e);
        }
    }
}
