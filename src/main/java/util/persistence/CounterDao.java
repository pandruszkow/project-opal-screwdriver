package util.persistence;

import data.Counter;
import lombok.extern.slf4j.Slf4j;

import static config.Config.COUCH_DB;

@Slf4j
public class CounterDao {
	public Counter findByNamespace(String namespace) {
		return COUCH_DB.find(Counter.class, namespace);
	}

	public synchronized Counter increment(Counter counter) {
		log.info("Incrementing counter for namespace {} to {}", counter.getNamespace(), counter.getItemCount());
		counter.incrementLocallyStoredItemCount();
		return update(counter);
	}

	public synchronized Counter update(Counter counter) {
		log.info("Saving update for counter for namespace {}", counter.getNamespace());
		COUCH_DB.update(counter);
		return findByNamespace(counter.getNamespace());
	}
}
