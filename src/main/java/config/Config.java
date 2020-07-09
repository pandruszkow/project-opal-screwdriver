package config;

import org.lightcouch.CouchDbClient;
import util.persistence.CounterDao;
import util.persistence.GubbinDao;

public class Config {
	public static final CouchDbClient COUCH_DB = new CouchDbClient();
	public static final GubbinDao GUBBIN_DAO = new GubbinDao();
	public static final CounterDao COUNTER_DAO = new CounterDao();

	public static final String NAMESPACE_SEPARATOR_CHAR = "-";
}
