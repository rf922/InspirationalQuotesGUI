package animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.scene.text.Font;
import javafx.scene.paint.Paint;
import javafx.util.Duration;
import javafx.scene.Node;
import javafx.scene.Group;

/**
 *
 * @author Rf922
 */
public class WaveAnimation implements TextAnimationStrategy {

    @Override
    public Node animate(Node node, Pane container) {
        if (!(node instanceof Text)) {
            return node;
        }
        Text quote = (Text) node;

        // Store original properties
        Font originalFont = quote.getFont();
        Paint originalFill = quote.getFill();

        // Create TextFlow to hold individual letters
        TextFlow textFlow = new TextFlow();
        textFlow.setLineSpacing(0);

        String textContent = quote.getText();

        for (int i = 0; i < textContent.length(); i++) {
            char c = textContent.charAt(i);
            Text letter = new Text(String.valueOf(c));

            // Set original properties
            letter.setFont(originalFont);
            letter.setFill(originalFill);

            // Create animation for the letter
            Timeline timeline = new Timeline();

            // Wave effect by animating translateYProperty
            KeyValue kvUp = new KeyValue(letter.translateYProperty(), -20);
            KeyValue kvDown = new KeyValue(letter.translateYProperty(), 0);
            KeyFrame kfUp = new KeyFrame(Duration.seconds(0.5), kvUp);
            KeyFrame kfDown = new KeyFrame(Duration.seconds(1), kvDown);

            timeline.getKeyFrames().addAll(kfUp, kfDown);

            // Set delay for wave effect
            timeline.setDelay(Duration.seconds(i * 0.1));
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();

            textFlow.getChildren().add(letter);
        }

        // Replace the quote node with textFlow in the container
        int index = container.getChildren().indexOf(quote);
        if (index != -1) {
            container.getChildren().set(index, textFlow);
        } else {
            container.getChildren().add(textFlow);
        }

        return textFlow;
    }
}
