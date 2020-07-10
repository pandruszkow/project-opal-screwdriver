package feature.counters;

import config.Config;
import data.Counter;
import lombok.Builder;
import org.apache.commons.lang3.StringUtils;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Builder
public class CounterFormatter {
	String namespacePrefix;
	String namespaceSeparator = Config.NAMESPACE_SEPARATOR_CHAR;
	String numberPrefix;
	Function<Long, String> formatCounterValue;
	String numberSuffix;

	public String format(Counter counter){
		Long itemCount = counter.getItemCount();
		var elements = Stream.of(
			namespacePrefix,
			namespaceSeparator,
			numberPrefix,
			formatCounterValue.apply(itemCount),
			numberSuffix
		);

		return elements
			.map(element -> StringUtils.defaultIfEmpty(element, ""))
			.collect(Collectors.joining());
	}
}
