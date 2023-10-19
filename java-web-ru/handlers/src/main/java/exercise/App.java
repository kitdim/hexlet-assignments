package exercise;

import com.fasterxml.jackson.databind.json.JsonMapper;
import io.javalin.Javalin;

import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

public final class App {

    public static Javalin getApp() {

        // BEGIN
        List<String> phones = Data.getPhones();
        List<String> domains = Data.getDomains();
        ObjectMapper mapper = new JsonMapper();

        var app = Javalin.create(config -> {
            config.plugins.enableDevLogging();
        });
        app.get("/phones", ctx -> ctx.result(mapper.writeValueAsString(phones)));
        app.get("/domains", ctx -> ctx.result(mapper.writeValueAsString(domains)));
        return app;
        // END
    }

    public static void main(String[] args) {
        Javalin app = getApp();
        app.start(7070);
    }
}
