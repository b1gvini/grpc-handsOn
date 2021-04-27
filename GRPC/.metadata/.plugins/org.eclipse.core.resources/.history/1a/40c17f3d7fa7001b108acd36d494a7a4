package grpc;

import java.io.IOException;
import java.util.logging.Logger;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import service.UserService;

public class ApplicationServer {
    private static final Logger logger = Logger.getLogger(ApplicationServer.class.getName());

    public static void main(String args[]) throws IOException, InterruptedException {

        Server server = ServerBuilder.forPort(50051).addService(new UserService()).build();

        server.start();

        logger.info("Serve started on " + server.getPort());

        server.awaitTermination();

    }
}