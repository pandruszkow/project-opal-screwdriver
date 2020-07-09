import domain.Gubbin;
import io.javalin.Javalin;
import io.javalin.http.Context;
import lombok.extern.slf4j.Slf4j;
import persistence.GubbinDao;

import static util.JsonUtil.toJson;

@Slf4j
public class OpalScrewdriver {

	public static final String GET_PATH = "/:gubbin-id";
	private static GubbinDao gubbinDao = new GubbinDao();

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> ctx.result("Hello World"));


		app.post("/create", ctx -> handleNew(ctx));

		app.before(GET_PATH, ctx -> log.info("Request received, parameters: {}", toJson(ctx.pathParamMap())));
		app.get(GET_PATH, ctx -> handleResolveAndGet(ctx));
	}

	private static void handleNew(Context ctx) {


	}

	private static void handleResolveAndGet(Context ctx) {
		Gubbin gub = gubbinDao.load(ctx.pathParam("gubbin-id"));
		log.info("Found gubbin {}", toJson(gub));
		ctx.result(toJson(gub));
	}
}
