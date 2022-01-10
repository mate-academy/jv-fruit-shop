package core.basesyntax.service;

import java.io.File;

public class InputOutputServiceImpl implements InputOutputService {

    public static final String INPUT_FILENAME_SUFFIX = " input file.csv";
    public static final String REPORT_FILENAME_SUFFIX = " report file.csv";
    public static final String REPORTS_FOLDER_PATH = getReportsFolderPath();

    @Override
    public File getInputFile(String dateOfFile) {
        String inputFileName = dateOfFile + INPUT_FILENAME_SUFFIX;
        String inputFileFullPath = REPORTS_FOLDER_PATH + File.separator + inputFileName;
        File file = new File(inputFileFullPath);
        return file;
    }

    //поскольку этого файла еще не существует то этот метод возвращает только полный путь
    //где его должен будет создать fileService.createNewFile(reportFullPath);
    @Override
    public String getReportFullPath(String dateOfReport) {
        String reportFileName = dateOfReport + REPORT_FILENAME_SUFFIX;
        String reportFileFullPath = REPORTS_FOLDER_PATH + File.separator + reportFileName;
        return reportFileFullPath;
    }

    private static String getReportsFolderPath() {
        String projectPath = System.getProperty("user.dir");
        String reportsPath = projectPath + File.separator + "reports";
        return reportsPath;
    }

}
