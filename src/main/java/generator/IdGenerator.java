package generator;

import domain.GubbinId;
import domain.Namespace;

public abstract class IdGenerator {
	protected final Namespace namespace;

	public IdGenerator(Namespace namespace){
		this.namespace = namespace;
	};

	public abstract GubbinId next();
}
