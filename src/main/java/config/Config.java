package config;

import org.lightcouch.CouchDbClient;

public class Config {
	public static final CouchDbClient COUCH_DB = new CouchDbClient();

	public static final String NAMESPACE_SEPARATOR_CHAR = "-";
}
