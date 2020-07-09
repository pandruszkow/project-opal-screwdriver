package domain;

import java.util.Objects;

public class Namespace {
	private final String namespacePrefix;

	public Namespace(String namespacePrefix) {
		this.namespacePrefix = namespacePrefix;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Namespace) {
			return this.namespacePrefix.equals(((Namespace) obj).namespacePrefix);
		} else {
			return super.equals(obj);
		}
	}

	@Override
	public String toString() {
		return namespacePrefix;
	}

	@Override
	public int hashCode() {
		return Objects.hash(namespacePrefix);
	}
}
