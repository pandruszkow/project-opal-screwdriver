package util.persistence;

import data.Counter;

import static config.Config.COUCH_DB;

public class CounterDao {
	public Counter findByNamespace(String namespace) {
		return COUCH_DB.find(Counter.class, namespace);
	}

	public synchronized Counter increment(Counter counter) {
		counter.incrementLocallyStoredItemCount();
		return update(counter);
	}

	public synchronized Counter update(Counter counter) {
		COUCH_DB.update(counter);
		return findByNamespace(counter.Namespace);
	}
}
