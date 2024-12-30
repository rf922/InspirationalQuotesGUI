/*
 * 
 * 
 * 
 */
package animations;

import animations.TextAnimationStrategy;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author #Rf922
 */
public class FloatingAnimation implements TextAnimationStrategy {

    private Direction direction;
    private Random randomSelector = new Random();

    
    public static enum  Direction {
        VERTICAL, HORIZONTAL
    }

    public FloatingAnimation(){
        this.direction = (randomSelector.nextBoolean()) ? Direction.VERTICAL : Direction.HORIZONTAL;
    }
    
    public FloatingAnimation(Direction direction){
        this.direction = direction;
    }
    
    @Override
    public Node animate(Node node, Pane container) {
        KeyValue start, end;
        
        if(this.direction == Direction.VERTICAL){
            start = new KeyValue(node.translateYProperty(), 0);
            end = new KeyValue(node.translateYProperty(), -50);            
        }else{
            start = new KeyValue(node.translateXProperty(), 0);
            end = new KeyValue(node.translateXProperty(), 50);
        }
        
        KeyFrame startFrame = new KeyFrame(Duration.ZERO, start);
        KeyFrame endFrame = new KeyFrame(Duration.seconds(5), end);
        
        Timeline timeline = new Timeline(startFrame, endFrame);
        
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        timeline.play();
        return node;
        
    }
    
}
