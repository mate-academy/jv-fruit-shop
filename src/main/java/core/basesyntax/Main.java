package core.basesyntax;

import core.basesyntax.data.processing.DataProcessing;
import core.basesyntax.data.processing.DataProcessingImpl;
import core.basesyntax.file.processing.TextDataReading;
import core.basesyntax.file.processing.TextDataReadingImpl;
import core.basesyntax.file.processing.TextDataWriting;
import core.basesyntax.file.processing.TextDataWritingImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.service.InfoRecord;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.implementations.InfoRecordImpl;
import core.basesyntax.service.implementations.ReportCreatorImpl;
import core.basesyntax.storage.Storage;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int AMOUNT_INDEX = 2;


    public static void main(String[] args) {
        InfoRecord record = new InfoRecordImpl();

        TextDataReading textDataReading = new TextDataReadingImpl();
        List<String> lines = textDataReading.read();

        DataProcessing processing = new DataProcessingImpl();
        List<String[]> fruitInfo = processing.process(lines);

        for (String[] s : fruitInfo) {
            String operationCode = s[OPERATION_INDEX].trim();
            Operation operation = FruitTransaction.findOperation(operationCode);

            FruitTransaction transaction = new FruitTransaction(operation, s[FRUIT_INDEX], Integer.parseInt(s[AMOUNT_INDEX]));
            record.record(transaction);
        }
        System.out.println(Storage.storage.values());
        System.out.println(Storage.storage.keySet());
        System.out.println("her");
        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.create(Storage.storage);

        TextDataWriting writing = new TextDataWritingImpl();
        writing.writing(report);
    }
}
