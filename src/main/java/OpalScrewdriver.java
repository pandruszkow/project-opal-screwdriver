import com.google.gson.Gson;
import domain.GubbinId;
import io.javalin.Javalin;
import io.javalin.http.Context;
import persistence.GubbinDao;

import java.util.logging.Logger;

public class OpalScrewdriver {

	static Logger logger = Logger.getLogger(OpalScrewdriver.class.getName());

	public static void main(String[] args) {
		Javalin app = Javalin.create().start(7000);
		app.get("/", ctx -> ctx.result("Hello World"));
		app.post("/by-namespace/:namespace", ctx -> handleNew(ctx));
		app.get("/:gubbin-id", ctx -> handleResolveAndGet(ctx));
	}

	private static void handleResolveAndGet(Context ctx) {
		Gson json = new Gson();
		new GubbinDao().load(new GubbinId());
	}

	private static void handleNew(Context ctx) {
	}
}
