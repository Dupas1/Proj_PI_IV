package com.woodpecker.backend.service;

import com.google.gson.Gson;
import com.woodpecker.backend.dtos.CalculationReviewOrder;
import com.woodpecker.backend.dtos.ExitOrder;
import com.woodpecker.backend.dtos.Order;
import com.woodpecker.backend.model.Partner;
import com.woodpecker.backend.dtos.ResultReview;


import java.io.*;
import java.net.Socket;
import java.time.LocalDate;

public class ReviewService {
    public static final String HOST  = "localhost";
    public static final int PORTA = 3000;
    private Socket connection;
    private PrintWriter transmitter;
    private BufferedReader receiver;
    private Partner server;

    public ReviewService() throws Exception{

        this.connection = new Socket(ReviewService.HOST, ReviewService.PORTA);
        this.transmitter = new PrintWriter(this.connection.getOutputStream());
        this.receiver = new BufferedReader( new InputStreamReader(this.connection.getInputStream()));
        this.server = new Partner(this.connection, this.receiver,this.transmitter);

        HandlerShutDown handlerShutDown = new HandlerShutDown(server);
        handlerShutDown.start();
    }

    public ResultReview calculateReview(String difficulty, int numberReview) throws Exception{

        Gson gson = new Gson();

        try{
            server.receba(gson.toJson(new CalculationReviewOrder(difficulty,numberReview)));
        } catch (Exception erro){
            System.err.println ("Erro de comunicacao com o servidor;");
        }

        Order order;
        do{
            order = gson.fromJson(this.server.espie(),Order.class);
        }while(order == null || !(order.getOrderName().equals("ResultReview")));
        ResultReview resultReview = gson.fromJson(this.server.envie(),ResultReview.class);
        server.receba(gson.toJson(new ExitOrder()));

        return resultReview;
    }

}
