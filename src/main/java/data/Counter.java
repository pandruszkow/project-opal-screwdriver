package data;

public class Counter {
	public String _id;
	private String _rev;
	public String Namespace;
	public Long ItemCount;

	public String getNamespace() {
		return Namespace;
	}

	public Long getItemCount() {
		return ItemCount;
	}

	public Long incrementLocallyStoredItemCount() {
		return ++ItemCount;
	}
}
