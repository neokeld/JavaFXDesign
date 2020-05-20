package design;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import design.task.BigFileTask;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class Item implements Initializable {

	@FXML
	private HBox itemC;
	
	@FXML
	private Button btnActive;
	
	// Run task
    private Executor exec;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
        exec = Executors.newCachedThreadPool(runnable -> {
            Thread t = new Thread(runnable);
            t.setDaemon(true);
            return t;
        });
	}
    
    public void handleClick() {
    	BigFileTask bft = new BigFileTask(1000000);
    	bft.setOnSucceeded(e -> 
        	btnActive.setStyle("-fx-background-color : #00C781")
        );
    	exec.execute(bft);
    }

}
