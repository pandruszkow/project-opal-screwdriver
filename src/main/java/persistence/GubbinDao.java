package persistence;

import domain.Gubbin;
import domain.GubbinId;
import generator.DashNumericIdGenerator;
import resolver.NamespaceResolver;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class GubbinDao {
	DashNumericIdGenerator gen = new DashNumericIdGenerator(NamespaceResolver.resolve("GUB"));
	Map<GubbinId, Gubbin> items = new HashMap<>();


	public GubbinDao() {
		IntStream.range(0, 70).forEach((i) ->
		{
			GubbinId id = gen.next();
			Gubbin item = new Gubbin(id, "Blahfoo" + i);
			items.put(id, item);
		});
	}

	public Gubbin load(String id) {
		return load(new GubbinId(id));
	}

	public Gubbin load(GubbinId id) {
		return items.get(id);
	}

	public void save(Gubbin gubbin) {
		items.put(gubbin.id, gubbin);
	}
}
