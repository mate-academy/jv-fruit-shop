package core.basesyntax.dao;

import core.basesyntax.exceptions.InvalidLineException;
import core.basesyntax.exceptions.NullFileNameException;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.service.impl.OperationHandler;
import core.basesyntax.service.impl.OperationStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FruitFileReader implements FruitDataReader {
    private static final int NECESSARY_LINE_ELEMENT_NUMBER = 3;
    private static final String EMPTY_LINE = "";
    private final String fileName;
    private final OperationStrategy operationStrategy;

    public FruitFileReader(String fileName) {
        if (fileName == null) {
            throw new NullFileNameException("Can't get a file with NULL name");
        }
        this.fileName = fileName;
        operationStrategy = new OperationStrategyImpl(new OperationHandler().getOperations());
    }

    @Override
    public void read() {
        try (BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(fileName))) {
            bufferedReader.readLine();
            while (bufferedReader.ready()) {
                readLineAndDoTransaction(bufferedReader.readLine());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't find the file " + fileName, e);
        }
    }

    private void readLineAndDoTransaction(String line) {
        if (line.equals(EMPTY_LINE)) {
            throw new InvalidLineException("Can't read empty line inside the file");
        }
        String[] lineElements = line.split(",");
        if (lineElements.length != NECESSARY_LINE_ELEMENT_NUMBER) {
            throw new InvalidLineException();
        }
        FruitTransaction transaction = new FruitTransaction(lineElements, operationStrategy);
        transaction.doTransaction();
    }
}
