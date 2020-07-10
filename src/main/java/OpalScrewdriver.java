import data.Gubbin;
import feature.create.Creator;
import io.javalin.Javalin;
import io.javalin.http.Context;
import lombok.extern.slf4j.Slf4j;
import util.network.CreationRequest;

import static util.JsonUtil.fromJson;
import static util.JsonUtil.toJson;

@Slf4j
public class OpalScrewdriver {

	public static final String GET_PATH = "/:gubbin-id";

	public static void main(String[] args) {
		//todo find a config-based way to do this. This is here only to silence lightcouch and I don't know how else to do it.
		System.setProperty("org.apache.commons.logging.Log",
			"org.apache.commons.logging.impl.NoOpLog");

		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> ctx.result("Hello World"));
		app.post("/", ctx -> create(ctx));

		app.before(GET_PATH, ctx -> log.info("Request received, parameters: {}", toJson(ctx.pathParamMap())));
		app.get(GET_PATH, ctx -> retrieve(ctx));

		log.info("Project Opal Screwdriver ready.");
	}

	private static void create(Context ctx) {
		String requestBody = ctx.body();
		log.info("Received request with following body: {}", requestBody);
		CreationRequest request = fromJson(requestBody, CreationRequest.class);
		Gubbin newItem = Creator.createFromRequest(request);
		String newItemJson = toJson(newItem);
		log.info("Finished creating item with following data: {}", newItemJson);
		ctx.result(newItemJson);
	}

	private static void retrieve(Context ctx) {
	}
}
