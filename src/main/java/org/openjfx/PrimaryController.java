package org.openjfx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {
    @FXML
    MyChart myChart = new MyChart();
    @FXML
    private void initialize() {
        ChartUpdater server = new ChartUpdater(myChart);
        server.setDaemon(true);
        server.start();
    }
   // public Button primaryButton;

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
}

