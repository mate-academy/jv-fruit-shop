package service.impl;

import dao.DatabaseDao;
import dao.DatabaseDaoImpl;
import java.util.List;
import java.util.Map;
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
    public void processData(String path) {
        List<FruitTransaction> read = readerService.read(path);
        Map<String, Integer> parse = parseService.parse(read, strategyService);
        dao.addAllFruits(parse);
    }

    @Override
    public void saveReport(String path) {
        writerService.write(path, createReport());
    }

    @Override
    public String createReport() {
        return reportService.generateReport(dao.getAllFruits());
    }
}
