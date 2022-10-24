package org.openjfx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.VBox;

import java.io.IOException;
import javafx.scene.layout.VBox;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.NumberAxis;

import java.awt.*;
import java.util.Random;

public class MyChart extends VBox {
    public MyChart() {
        getChildren().add(buildSampleLineChart());
        Button myButton = new Button("Comienza el Thread");

        myButton.setOnAction(new EventHandler<ActionEvent>() {
/*          @Override
           public void handle(ActionEvent actionEvent) { //agregar accion al boton
              for (int i=0; i<20 ; i++){ //cantidad de puntos random

                    Random rand = new Random();
                   double randomX = 5 * rand.nextDouble(); //5* pa que incluya del 1 al 5 y este dentro del grafico
                    double randomY = rand.nextDouble();

                   series.getData().add(new XYChart.Data<>(randomX, randomY));

                  // System.out.println("Valor Agregado"); //el boton escribe
               }


            }
       });*/
@Override
public void handle(ActionEvent actionEvent) {

    Thread thread = new Thread(new Runnable() {
        @Override
        public void run() {
            Runnable updater = new Runnable() {
                @Override
                public void run() {
                    //agregarvalor();
                    series.getData().add(new XYChart.Data<>(5*Math.random(),Math.random()));
                };
            };
            while(true) {
                Platform.runLater(updater);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    });
    thread.setDaemon(true);
    thread.start();
}
        });

        getChildren().add(myButton);
    }
    XYChart.Series<Double, Double> series = new XYChart.Series<>();
    public LineChart buildSampleLineChart() {
        series.getData().add(new XYChart.Data<>(0.0, 0.0));
        series.getData().add(new XYChart.Data<>(0.7, 0.5));
        series.getData().add(new XYChart.Data<>(1.0, 0.632));
        series.getData().add(new XYChart.Data<>(2.0, 0.865));
        series.getData().add(new XYChart.Data<>(3.0, 0.95));
        series.getData().add(new XYChart.Data<>(4.0, 0.982));
        series.getData().add(new XYChart.Data<>(5.0, 0.993));
        LineChart lc = new LineChart(
                new NumberAxis(" Time Constant ", 0.0, 5.0, 1),
                new NumberAxis(" Voltage ( Vs )", 0.0, 1.0, 0.1)
        );
        lc.getData().add(series);
        return lc;
    }
    public void agregarvalor(Double valueOf){
        series.getData().add(new XYChart.Data<>(5*Math.random(),Math.random()));
    }
}


