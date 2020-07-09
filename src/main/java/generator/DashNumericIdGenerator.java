package generator;

import config.Config;
import domain.GubbinId;
import domain.Namespace;
import persistence.SerialCounterDao;

public class DashNumericIdGenerator extends IdGenerator {
	private final static SerialCounterDao serialCounterDao = new SerialCounterDao();

	public DashNumericIdGenerator(Namespace namespace) {
		super(namespace);
	}

	@Override
	public GubbinId next() {
		Long nextSerialNumber = serialCounterDao.increment(namespace);
		String nextCompleteId = new StringBuffer()
			.append(namespace)
			.append(Config.NAMESPACE_SEPARATOR_CHAR)
			.append(nextSerialNumber)
			.toString();

		return new GubbinId(nextCompleteId);
	}
}
