package resolver;

import domain.Namespace;

import java.util.HashMap;
import java.util.Map;

public class NamespaceResolver {
	private static final Map<String, Namespace> ns = new HashMap<>();

	public static Namespace resolve(String namespace) {
		return ns.computeIfAbsent(
				namespace,
				newNs -> new Namespace(namespace));
	}
}
