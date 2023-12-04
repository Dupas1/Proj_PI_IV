package com.woodpecker.backend.service;

import com.woodpecker.Teclado;
import com.woodpecker.backend.dtos.CalculationReviewOrder;
import com.woodpecker.backend.dtos.ExitOrder;
import com.woodpecker.backend.model.Difficulty;
import com.woodpecker.backend.model.Order;
import com.woodpecker.backend.model.Partner;
import com.woodpecker.backend.model.ResultReview;
import org.springframework.cglib.core.Local;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.LocalDate;
import java.util.Date;

public class ReviewService {
    public static final String HOST  = "localhost";
    public static final int PORTA = 3000;
    private Socket connection;
    private ObjectOutputStream transmitter;
    private ObjectInputStream receiver;
    private Partner server;

    public ReviewService() throws Exception{

        this.connection = new Socket(ReviewService.HOST, ReviewService.PORTA);
        this.transmitter = new ObjectOutputStream(this.connection.getOutputStream());
        this.receiver = new ObjectInputStream(this.connection.getInputStream());
        this.server = new Partner(this.connection, this.receiver,this.transmitter);

        HandlerShutDown handlerShutDown = new HandlerShutDown(server);
        handlerShutDown.start();
    }

    public LocalDate calculateReview(String difficulty, int numberReview) throws Exception{

        try{
            server.receba(new CalculationReviewOrder(difficulty.toUpperCase(), numberReview));
        } catch (Exception erro){
            System.err.println ("Erro de comunicacao com o servidor;");
        }
        Order order = null;
        ResultReview resultReview = (ResultReview) this.server.envie();
        server.receba(new ExitOrder());
        return resultReview.getFinalDate();
    }

}
