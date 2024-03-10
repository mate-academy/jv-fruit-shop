package core.basesyntax;

import core.basesyntax.service.IFileReader;
import core.basesyntax.service.IFileWriter;
import core.basesyntax.service.impl.EventHandler;
import core.basesyntax.service.impl.FileReaderCvs;
import core.basesyntax.service.impl.FileWriterCvs;

public class Main {
    public static void main(String[] args) {
        IFileReader cvsReader = new FileReaderCvs();
        IFileWriter cvsWriter = new FileWriterCvs();
        EventHandler eventHandler = new EventHandler();

        var list = cvsReader.read("src/main/java/core/basesyntax/resources/activities.csv");
        eventHandler.convertList(list);
        cvsWriter.write("src/main/java/core/basesyntax/resources/report.csv");
    }
}
