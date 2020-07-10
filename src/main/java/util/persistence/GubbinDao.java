package util.persistence;

import data.Gubbin;
import lombok.extern.slf4j.Slf4j;

import static config.Config.COUCH_DB;

@Slf4j
public class GubbinDao {
	public Gubbin findById(String id) {
		return COUCH_DB.find(Gubbin.class, id);
	}

	public Gubbin createNew(Gubbin gubbin) {
		log.info("Creating new item with ID {}", gubbin.getId());
		COUCH_DB.post(gubbin);
		return findById(gubbin.getId());
	}

	public Gubbin saveChanges(Gubbin gubbin) {
		log.info("Saving changes to item with ID {}", gubbin.getId());
		COUCH_DB.update(gubbin);
		return findById(gubbin.getId());
	}
}
