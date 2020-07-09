package domain;

import java.util.Objects;

public class GubbinId {
	private final String wrappedString;

	public GubbinId(String wrappedString) {
		this.wrappedString = wrappedString;
	}

	@Override
	public String toString() {
		return wrappedString;
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof GubbinId) {
			return ((GubbinId) o).wrappedString.equals(this.wrappedString);
		} else {
			return Objects.equals(this, o);
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(wrappedString);
	}
}
