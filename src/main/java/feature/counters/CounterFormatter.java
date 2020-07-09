package feature.counters;

import config.Config;
import data.Counter;
import lombok.Builder;

import java.util.function.Function;

@Builder
public class CounterFormatter {
	String namespacePrefix;
	String namespaceSeparator = Config.NAMESPACE_SEPARATOR_CHAR;
	String numberPrefix;
	Function<Long, String> formatCounterValue;
	String numberSuffix;

	public String format(Counter counter){
		Long itemCount = counter.getItemCount();
		return new StringBuffer()
			.append(namespacePrefix)
			.append(namespaceSeparator)
			.append(numberPrefix)
			.append(formatCounterValue.apply(itemCount))
			.append(numberSuffix)
			.toString();
	}
}
