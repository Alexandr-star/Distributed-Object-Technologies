import io.undertow.Undertow;
import io.undertow.server.HttpHandler;
import io.undertow.server.HttpServerExchange;
import io.undertow.util.Headers;

public class NameHttpServer {
    public static void main(final String[] args) {
        Undertow server = Undertow.builder()
                .addHttpListener(8000, "localhost")
                .setHandler(new HttpHandler() {
                    @Override
                    public void handleRequest(final HttpServerExchange exchange) throws Exception {
                        exchange.getResponseHeaders().put(Headers.CONTENT_TYPE, "text/plain;charset=utf-8");
                        exchange.getResponseSender().send("Aleksandr Skvortsov (Александр Скворцов)");
                    }
                }).build();
        server.start();
    }
}
