package core.basesyntax.service.impl;

import core.basesyntax.service.FileReportCreator;
import java.io.File;

public class FileReportCreatorImpl implements FileReportCreator {

    @Override
    public File createReportFile(String filePath) {
        return new File(filePath);
    }
}
