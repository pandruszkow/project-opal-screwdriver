package persistence;

import domain.Gubbin;
import domain.GubbinId;
import domain.LocalPrefix;
import domain.Prefix;
import generator.IdGenerator;
import generator.IntegerBasedSerialIdGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class GubbinDao {
	Prefix ns = new LocalPrefix("GUB");
	IdGenerator gen = new IntegerBasedSerialIdGenerator(ns);
	Map<GubbinId, Gubbin> items = new HashMap<>();


	public GubbinDao() {
		IntStream.range(0, 70).forEach((i) ->
		{
			Gubbin created = create(ns);
			items.put(created.id, created);
		});
	}

	public Gubbin load(GubbinId id){
		return items.get(id);
	}

	public void save(Gubbin gubbin){

	}

	public Gubbin create(Prefix ns){
		GubbinId next = gen.next();
		return new Gubbin(next, "Goo");
	}

}
