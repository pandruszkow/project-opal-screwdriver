import data.Counter;
import data.Gubbin;
import feature.counters.CounterFormatterFactory;
import io.javalin.Javalin;
import io.javalin.http.Context;
import lombok.extern.slf4j.Slf4j;
import util.network.CreationRequest;

import static config.Config.COUNTER_DAO;
import static config.Config.GUBBIN_DAO;
import static data.CounterType.ISSUE_NUMBER;
import static util.JsonUtil.fromJson;
import static util.JsonUtil.toJson;

@Slf4j
public class OpalScrewdriver {

	public static final String GET_PATH = "/:gubbin-id";

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> ctx.result("Hello World"));
		app.post("/", ctx -> create(ctx));

		app.before(GET_PATH, ctx -> log.info("Request received, parameters: {}", toJson(ctx.pathParamMap())));
		app.get(GET_PATH, ctx -> retrieve(ctx));
	}

	private static void create(Context ctx) {
		CreationRequest request = fromJson(ctx.body(), CreationRequest.class);
		Counter counter = COUNTER_DAO.findByNamespace(request.Namespace);
		COUNTER_DAO.increment(counter);
		final String newId = CounterFormatterFactory.get(ISSUE_NUMBER, request.Namespace).format(counter);
		final Gubbin newItem = new Gubbin();
		newItem.setId(newId);
		newItem.setText(request.Text);

		ctx.result(toJson(GUBBIN_DAO.createNew(newItem)));
	}

	private static void retrieve(Context ctx) {
	}
}
