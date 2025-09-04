import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Toast {

    public static void makeText(Stage ownerStage, String message, int durationMillis) {
        Popup popup = new Popup();

        Label label = new Label(message);
        label.setStyle("-fx-background-color: black; -fx-text-fill: white; -fx-padding: 10px; -fx-border-radius: 5px; -fx-background-radius: 5px;");
        popup.getContent().add(label);
        popup.setAutoHide(true);

        popup.show(ownerStage);

        Timeline timeline = new Timeline(new KeyFrame(
                Duration.millis(durationMillis),
                ae -> popup.hide()));
        timeline.play();
    }
}
