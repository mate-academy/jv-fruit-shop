package core.basesyntax;

import core.basesyntax.data.processing.DataProcessing;
import core.basesyntax.data.processing.DataProcessingImpl;
import core.basesyntax.file.processing.TextDataReading;
import core.basesyntax.file.processing.TextDataReadingImpl;
import core.basesyntax.file.processing.TextDataWriting;
import core.basesyntax.file.processing.TextDataWritingImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.StorageLoader;
import core.basesyntax.service.implementations.ReportCreatorImpl;
import core.basesyntax.service.implementations.StorageLoaderImpl;
import core.basesyntax.storage.Storage;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        TextDataReading textDataReading = new TextDataReadingImpl();
        List<String> lines = textDataReading.read();

        DataProcessing processing = new DataProcessingImpl();
        List<String[]> fruitInfo = processing.process(lines);

        StorageLoader loader = new StorageLoaderImpl();
        loader.load(fruitInfo);

        ReportCreator creator = new ReportCreatorImpl();
        String report = creator.create(Storage.storage);

        TextDataWriting writing = new TextDataWritingImpl();
        writing.writing(report);
    }
}
