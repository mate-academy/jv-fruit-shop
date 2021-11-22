package service;

import dao.ReportCsvDaoImpl;
import dao.ReportLocalDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import service.action.type.ActionStrategyHandler;

public class CreationReportServiceImpl implements CreationReportService {
    private final ReportCsvDaoImpl reportCsvDao = new ReportCsvDaoImpl();
    private final ValidatorServiceImpl validator = new ValidatorServiceImpl();
    private final ActionStrategyImpl actionStrategy = new ActionStrategyImpl();
    private final ReportLocalDaoImpl reportLocalDao = new ReportLocalDaoImpl();

    @Override
    public void createReportOfDay() {
        List<String> listInput = reportCsvDao.getActionsOfDay();

        validator.isValidate(listInput);

        for (String data : listInput) {
            String[] dataArray = data.split(",");
            ActionStrategyHandler action = actionStrategy.get(dataArray[0]);
            action.doing(dataArray);
        }

        List<Fruit> listOfFruit = reportLocalDao.getListRemainder();
        List<String> listReport = new ArrayList<>();
        listReport.add("fruit,quantity");
        for (Fruit fruit : listOfFruit) {
            listReport.add(fruit.getName() + "," + fruit.getCount());
        }

        reportCsvDao.setReport(listReport);
    }
}
