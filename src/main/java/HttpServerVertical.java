import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServer;
import io.vertx.core.json.JsonObject;
import io.vertx.ext.web.Route;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.StaticHandler;

public class HttpServerVertical extends AbstractVerticle {


    @Override
    public void start() {
        Router router = Router.router(vertx);

        Route messageRoute = router.get("/api/message");
        messageRoute.handler(rq -> {
            System.out.println(rq.request());
            JsonObject json = new JsonObject();
            json.put("id", 123);
            json.put("name", "kim");
            rq.response().end(json.toString());
        });
        router.get().handler(StaticHandler.create());
        HttpServer server = vertx.createHttpServer();
        server.requestHandler(router).listen(8080);

//      간단한 port server 띄우기
//        HttpServer server = vertx.createHttpServer();
//        server.requestHandler(req -> {
//            HttpServerResponse res = req.response();
//            res.end("Hello World");
//
//        });
//        server.listen(8080);
        System.out.println("listen in 8080");
    }


    @Override
    public void stop() throws Exception {
        super.stop();
    }
}
