import data.Gubbin;
import io.javalin.Javalin;
import io.javalin.http.Context;
import lombok.extern.slf4j.Slf4j;

import static config.Config.COUCH_DB;
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

		Gubbin gub = new Gubbin();
		gub.setId("GUB-10");
		gub.setText("CouchDBfromJava");
		COUCH_DB.post(gub);
		Gubbin found = COUCH_DB.find(Gubbin.class, "GUB-1");
		log.info(toJson(found));
	}

	private static void create(Context ctx) {


	}

	private static void retrieve(Context ctx) {
	}
}
