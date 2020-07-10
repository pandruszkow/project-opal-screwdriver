package feature.create;

import data.Counter;
import data.Gubbin;
import feature.counters.CounterFormatter;
import feature.counters.CounterFormatterFactory;
import util.network.CreationRequest;

import static config.Config.COUNTER_DAO;
import static config.Config.GUBBIN_DAO;
import static data.CounterType.ISSUE_NUMBER;

public class Creator {
	public static Gubbin createFromRequest(CreationRequest request) {
		Counter counter = COUNTER_DAO.findByNamespace(request.Namespace);
		COUNTER_DAO.increment(counter);
		CounterFormatter counterFormatter = CounterFormatterFactory.get(ISSUE_NUMBER, request.Namespace);
		final String newId = counterFormatter.format(counter);
		Gubbin newItem = new Gubbin();
		newItem.setId(newId);
		newItem.setText(request.Text);
		newItem = GUBBIN_DAO.createNew(newItem);
		return newItem;
	}
}
