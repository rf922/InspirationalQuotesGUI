/*
 * 
 * 
 * 
 */
package animations;

import java.util.Random;
import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

/**
 *
 * @author Rf922
 * An implementation for a simple animation that rotates the entire text by 
 * some degree.
 */
public class RotationAnimation implements TextAnimationStrategy {
    
    private Random random = new Random();

    @Override
    public Node animate(Node node, Pane container) {
        random = new Random();
        double degree = random.nextDouble(-360, 360);      
        RotateTransition rotateTransition = new RotateTransition(Duration.seconds(5), node);
        rotateTransition.setByAngle(degree);
        rotateTransition.setCycleCount(Animation.INDEFINITE);
        rotateTransition.play();
        return node;
    }

}
