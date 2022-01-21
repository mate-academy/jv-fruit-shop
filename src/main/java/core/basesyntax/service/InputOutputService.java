package core.basesyntax.service;

import java.io.File;

public interface InputOutputService {

    File getInputFile(String dateOfFile);

    String getReportFullPath(String dateOfReport);
    //поскольку этого файла еще не существует то этот метод возвращает
    //только полный путь где его должен будет создать fileService.createNewFile(reportFullPath);
}
