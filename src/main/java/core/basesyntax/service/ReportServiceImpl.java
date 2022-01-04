package core.basesyntax.service;

import core.basesyntax.dao.ReportsDao;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    private final String balance = "b"; //the remnants of fruits at the beginning of the working day
    private final String supply = "s"; //means you are receiving new fruits from suppliers
    private final String purchase = "p"; //means someone has bought some fruit
    private final String returN = "r"; //means someone who have bought the fruits now returns them
    // back
    private final ReportsDao reportsDao;
    private final FileService fileService;

    public ReportServiceImpl(ReportsDao reportsDao, FileService fileService) {
        this.reportsDao = reportsDao;
        this.fileService = fileService;
    }

    @Override
    public File createNewReport(String date) {
        String reportFullPath = reportsDao.getReportFullPath(date);
        return fileService.createNewFile(reportFullPath);
    }

    @Override
    public List<String> doReport(List<String> records) {
        List<String> listReport = new ArrayList<>();
        listReport.add("fruit,quantity");
        if (records.get(0).equals("type,fruit,quantity")) {
            List<String> recordsSubList = records.subList(1, records.size());
            Map<String, List<String[]>> groupedRecords = recordsSubList.stream()
                    .map(s -> s.split(","))
                    .collect(Collectors.groupingBy(a -> a[1]));
            for (Map.Entry<String, List<String[]>> entry : groupedRecords.entrySet()) {
                int quantity = 0;
                for (String[] array : entry.getValue()) { //перебираем все массивы в списке
                    // array[0]=type
                    if (array[0].equals(balance)
                            || array[0].equals(supply)
                            || array[0].equals(returN)) {
                        quantity += Integer.parseInt(array[2]);
                    } else if (array[0].equals(purchase)) {
                        quantity -= Integer.parseInt(array[2]);
                    }
                }
                listReport.add(entry.getKey() + "," + quantity);
            }
        }
        return listReport;
    }

    @Override
    public void generateReport(String dateOfReport) {
        File inputFile = reportsDao.getInputFile(dateOfReport);
        List<String> data = fileService.readDataFromFile(inputFile);
        List<String> report = doReport(data);
        File reportFile = createNewReport(dateOfReport);
        fileService.writeDataToFile(report, reportFile);
    }

}
