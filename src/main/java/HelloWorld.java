import io.vertx.core.Vertx;

public class HelloWorld {
    public static void main(String[] args) {
        Vertx vert = Vertx.vertx();
        vert.deployVerticle(new HttpServerVertical());
    }
}
