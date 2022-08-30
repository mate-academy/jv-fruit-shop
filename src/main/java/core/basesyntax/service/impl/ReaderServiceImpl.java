package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
	@Override
	public List<String> readFromFile(String fileName) {
		File file = new File(fileName);
		StringBuilder stringBuilder = new StringBuilder();
		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
			String value = bufferedReader.readLine();
			while (value != null) {
				stringBuilder.append(value).append(System.lineSeparator());
				value = bufferedReader.readLine();
			}
		} catch (IOException e) {
			throw new RuntimeException("Can't read file", e);
		}
		String[] result = stringBuilder.toString().split(System.lineSeparator());
		return Arrays.asList(result);
	}
}
