package design.task;

import javafx.concurrent.Task;

/**
 * See: https://openjfx.io/javadoc/14/javafx.graphics/javafx/concurrent/Task.html
 * Read it. From top to bottom. It's a good doc. You will learn something.
 * @author aduforat
 *
 */
public class BigFileTask extends Task<Integer> {
	private final int totalIterations;
	
	/**
	 * A Task Which Takes Parameters
	 */
	public BigFileTask(int totalIterations) {
		super();
		this.totalIterations = totalIterations;
	}
	
	@Override
	protected Integer call() throws Exception {
        int iteration;
        // A Simple Loop With Progress Notification
        for (iteration = 0; iteration < totalIterations; iteration++) {
            if (isCancelled()) {
                updateMessage("Cancelled");
                break;
            }
            updateMessage("Iteration " + iteration);
            updateProgress(iteration, totalIterations);
        }
        return iteration;
	}

    @Override protected void succeeded() {
        super.succeeded();
        updateMessage("Big File Processed!");
    }
    
    @Override protected void failed() {
        super.failed();
        updateMessage("Failed!");
    }
	
}
