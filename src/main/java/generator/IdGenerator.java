package generator;

import domain.GubbinId;
import domain.Prefix;

public abstract class IdGenerator {
	protected final Prefix prefix;

	public IdGenerator(Prefix prefix){
		this.prefix = prefix;
	};

	public abstract GubbinId next();
}
