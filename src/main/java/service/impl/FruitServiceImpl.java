package service.impl;

import dao.DatabaseDao;
import dao.DatabaseDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.FruitService;
import service.ParseService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import strategy.StrategyService;

public class FruitServiceImpl implements FruitService {
    private final DatabaseDao dao = new DatabaseDaoImpl();
    private final StrategyService strategyService;
    private final ReaderService readerService = new ReaderServiceImpl();
    private final ReportService reportService = new ReportServiceImpl();
    private final WriterService writerService = new WriterServiceImpl();
    private final ParseService parseService = new ParseServiceImpl();

    public FruitServiceImpl(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public void getData(String path) {
        List<String> readData = readerService.read(path);
        List<FruitTransaction> parsedTransactions = parseService.parse(readData);
        dao.addAllTransaction(parsedTransactions);
    }

    @Override
    public void saveReport(String path) {
        writerService.write(path, getReport());
    }

    private String getReport() {
        return reportService.generateReport(dao.getFruitTransaction(), strategyService);
    }
}
