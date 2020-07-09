package persistence;

import domain.Namespace;
import resolver.NamespaceResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class SerialCounterDao {
	Map<Namespace, Long> lastGeneratedNumberByNamespace = new HashMap<>();

	public SerialCounterDao() {
		Stream.of(
			"GUB",
			"TX",
			"FD"
		)
			.map(NamespaceResolver::resolve)
			.forEach((ns) ->
				lastGeneratedNumberByNamespace.put(ns, 0L)
			);
	}

	public Long load(Namespace ns) {
		return lastGeneratedNumberByNamespace.get(ns);
	}

	public Long increment(Namespace ns) {
		return lastGeneratedNumberByNamespace.compute(ns,
			(namespace, serialCount) ->
				++serialCount
		);
	}
}
