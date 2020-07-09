package feature.counters;

import config.Config;
import data.CounterType;

import java.text.DecimalFormat;

public class CounterFormatterFactory {

	public static CounterFormatter get(CounterType type, String namespace) {
		switch (type) {
			case ISSUE_NUMBER:
				createIssueNumber(namespace);
			default:
				throw new IllegalArgumentException("Unknown counter type");
		}
	}

	private static CounterFormatter createIssueNumber(String namespace) {
		return CounterFormatter.builder()
			.namespacePrefix(namespace)
			.namespaceSeparator(Config.NAMESPACE_SEPARATOR_CHAR)
			.formatCounterValue((itemCount) ->
				new DecimalFormat("0000").format(itemCount)
			)
			.build();
	}
}
