package design;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Controller implements Initializable {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
    @FXML
    private VBox pnItems = null;
    @FXML
    private Button btnOverview;

    @FXML
    private Button btnOrders;

    @FXML
    private Button btnCustomers;

    @FXML
    private Button btnMenus;

    @FXML
    private Button btnPackages;

    @FXML
    private Button btnSettings;

    @FXML
    private Button btnSignout;

    @FXML
    private Pane pnlCustomer;

    @FXML
    private Pane pnlOrders;

    @FXML
    private Pane pnlOverview;

    @FXML
    private Pane pnlMenus;
    
    @FXML
    private Pane pnlPackages;
    
    @FXML
    private Pane pnlSettings;
    
    @FXML
    private Pane pnlSignout;
    
    @FXML
    private Button btnCloseWindow;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Node[] nodes = new Node[10];
        for (int i = 0; i < nodes.length; i++) {
            try {
                final int j = i;
                nodes[i] = loadFXML("Item");

                //give the items some effect
                nodes[i].setOnMouseEntered(event -> 
                    nodes[j].setStyle("-fx-background-color : #0A0E3F")
                );
                nodes[i].setOnMouseExited(event -> 
                    nodes[j].setStyle("-fx-background-color : #02030A")
                );
                
                pnItems.getChildren().add(nodes[i]);
            } catch (IOException e) {
                logger.error("Error creating items: {}", e);
            }
        }

    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }
    
    public void handleClicks(ActionEvent actionEvent) {
        if (actionEvent.getSource() == btnCustomers) {
            pnlCustomer.toFront();
        } else if (actionEvent.getSource() == btnMenus) {
            pnlMenus.toFront();
        } else if (actionEvent.getSource() == btnOrders) {
            pnlOrders.toFront();
        } else if (actionEvent.getSource() == btnOverview) {
            pnlOverview.toFront();
        } else if (actionEvent.getSource() == btnPackages) {
        	pnlPackages.toFront();
        } else if (actionEvent.getSource() == btnSettings) {
        	pnlSettings.toFront();
        } else if (actionEvent.getSource() == btnSignout) {
        	pnlSignout.toFront();
        }
    }
    
    public void handleCloseWindow() {
    	Platform.exit();
    }
}
