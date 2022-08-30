package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;

import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
	private static final String HEADER = "fruit,quantity";
	@Override
	public String getReport() {
		return HEADER + System.lineSeparator() +
				Storage.storage
				.entrySet()
				.stream()
				.map(f -> f.getKey().getName() + "," + f.getValue())
				.map((f) -> f + System.lineSeparator())
				.collect(Collectors.joining());
	}
}
