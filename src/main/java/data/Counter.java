package data;

public class Counter {
	private String _id;
	private String _rev;
	private String Namespace;
	private Long ItemCount;

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
