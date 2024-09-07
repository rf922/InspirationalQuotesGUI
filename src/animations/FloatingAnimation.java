/*
 * 
 * 
 * 
 */
package animations;

import animations.TextAnimationStrategy;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.text.Text;
import javafx.util.Duration;

/**
 *
 * @author #Your Name <your.name at your.org>
 */
public class FloatingAnimation implements TextAnimationStrategy {

    private Direction direction;
    
    public static enum  Direction {
        VERTICAL, HORIZONTAL
    }

    public FloatingAnimation(Direction direction){
        this.direction = direction;
    }
    
    @Override
    public void animate(Text quote) {
        KeyValue start, end;
        
        if(this.direction == Direction.VERTICAL){
            start = new KeyValue(quote.translateYProperty(), 0);
            end = new KeyValue(quote.translateYProperty(), -50);            
        }else{
            start = new KeyValue(quote.translateXProperty(), 0);
            end = new KeyValue(quote.translateXProperty(), 50);
        }
        
        KeyFrame startFrame = new KeyFrame(Duration.ZERO, start);
        KeyFrame endFrame = new KeyFrame(Duration.seconds(5), end);
        
        Timeline timeline = new Timeline(startFrame, endFrame);
        
        timeline.setAutoReverse(true);
        timeline.setCycleCount(Timeline.INDEFINITE);
        
        timeline.play();
        
        
    }
    
}
