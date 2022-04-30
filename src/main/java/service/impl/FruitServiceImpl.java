package service.impl;

import dao.DatabaseDao;
import dao.DatabaseDaoImpl;
import service.FruitService;
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

    public FruitServiceImpl(StrategyService strategyService) {
        this.strategyService = strategyService;
    }

    @Override
    public void read(String path) {
        readerService.read(path);
    }

    @Override
    public void write(String path) {
        writerService.write(path, doReport());
    }

    private String doReport() {
        return reportService.doReport(dao.getFruitTransaction(), strategyService);
    }
}
