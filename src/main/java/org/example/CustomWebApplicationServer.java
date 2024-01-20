package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class CustomWebApplicationServer {
    private final int port;

    private final ExecutorService executorService = Executors.newFixedThreadPool(10); // threadPool

    public static final Logger logger = LoggerFactory.getLogger(CustomWebApplicationServer.class);

    public CustomWebApplicationServer(int port) {
        this.port = port;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            logger.info("[CustomWebApplicationServer] started {} port", port);

            Socket clientSocket;
            logger.info("[CustomWebApplicationServer] wating for client");

            while ((clientSocket = serverSocket.accept()) != null) {
                logger.info("[CustomWebApplicationServer] client connected");
                executorService.execute(new ClientRequestHandler(clientSocket));
                // 각 connection 마다 쓰레드 생성 => 독립적 스택 메모리 할당 => cpu 컨텍스트 스위칭 횟수 증가 : 비싼 작업
//                new Thread(new ClientRequestHandler(clientSocket)).start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
