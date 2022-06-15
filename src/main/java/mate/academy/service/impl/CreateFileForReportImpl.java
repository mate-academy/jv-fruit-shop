package mate.academy.service.impl;

import java.io.File;
import java.io.IOException;
import mate.academy.service.CreateFileForReport;

public class CreateFileForReportImpl implements CreateFileForReport {

    @Override
    public void createFileForReport(String pathName) {
        File report = new File(pathName);
        try {
            report.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file in:" + pathName, e);
        }
    }
}
