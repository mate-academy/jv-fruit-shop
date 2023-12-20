package core.basesyntax.service;

import core.basesyntax.service.file.FileWriterHandler;
import core.basesyntax.service.file.FileWriterHandlerImpl;

public class RaportCreator {
    private final FileWriterHandler fileWriterHandler = new FileWriterHandlerImpl();

    public void createRaport(String raport) {
        if (!raport.isEmpty()) {
            fileWriterHandler.writeToFile(raport);
        }
    }

}
