package domain;

public class GubbinId {
	public Prefix prefix;
	public String sequenceNumber;

	//This should be machine-readable for matching to the right namespace by prefix
	public String renderAsString() {
		return new StringBuffer()
				.append(prefix.renderAsString())
				.append(prefix.separatorChar())
				.append(sequenceNumber)
				.toString();
	}

	public Prefix constructFromString() {
		return null;
	}

	@Override
	public String toString() {
		return renderAsString();
	}
}
