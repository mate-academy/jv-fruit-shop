package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface FileService { //просто записує і зчитує з файлу будь-яку інфу
    //FileService має використовуватись всередині твого ReportService

    //read data from csv file
    List<String> readDataFromFile(File file);

    //write report to new csv file
    void writeDataToFile(List<String> data, File file);

    File createNewFile(String fileFullPath);
}
