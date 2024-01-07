package core.basesyntax.service.impl;

import core.basesyntax.enums.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderCsvImpl implements Reader {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    private String filename;
    private Parser parser;

    public ReaderCsvImpl(String filename) {
        this.filename = filename;
        this.parser = new ParserCsvImpl();
    }

    @Override
    public List<FruitTransaction> read() {
        List<FruitTransaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            br.readLine();

            String line;
            while ((line = br.readLine()) != null) {
                List<String> parsedLine = parser.parseLine(line);
                FruitTransaction transaction = new FruitTransaction(
                        Operation.fromCode(parsedLine.get(OPERATION_INDEX).toLowerCase()),
                        parsedLine.get(FRUIT_INDEX),
                        Integer.parseInt(parsedLine.get(QUANTITY_INDEX)));
                transactions.add(transaction);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filename, e);
        } catch (IOException e) {
            throw new RuntimeException("Catch IOException: " + e);
        }
        return transactions;
    }
}
