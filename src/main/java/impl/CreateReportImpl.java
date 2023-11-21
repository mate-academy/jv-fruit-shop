package impl;

import dao.AccountDao;
import dao.AccountDaoImpl;
import java.util.Map;
import service.CreateReportService;

public class CreateReportImpl implements CreateReportService {
    private static final String HEADER = "fruit,quantity";
    private static final String COMA = ",";
    private final AccountDao accountDao = new AccountDaoImpl();

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(HEADER);
        for (Map.Entry<String, Integer> entry : accountDao.getAll().entrySet()) {
            stringBuilder.append(System.lineSeparator())
                    .append(entry.getKey()).append(COMA).append(entry.getValue());
        }
        return stringBuilder.toString();
    }
}
