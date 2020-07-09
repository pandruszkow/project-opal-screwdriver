package util.persistence;

import data.Gubbin;

import static config.Config.COUCH_DB;

public class GubbinDao {
	public Gubbin findById(String id) {
		return COUCH_DB.find(Gubbin.class, id);
	}

	public Gubbin saveChanges(Gubbin gubbin) {
		COUCH_DB.update(gubbin);
		return findById(gubbin.getId());
	}
}
