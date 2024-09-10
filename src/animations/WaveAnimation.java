/*
 * 
 * 
 * 
 */
package animations;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.scene.text.Text;
import javafx.util.Duration;
import javafx.animation.Timeline;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


/**
 *
 * @author #Rf922
 */
public class WaveAnimation implements TextAnimationStrategy {

    @Override
    public void animate(Text quote) {
        HBox letters = new HBox();
        letters.setSpacing(5);
        
        
        
        char[] chars =  quote.getText().toCharArray();
      for (int i = 0; i < chars.length; i++) {
            Text letter = new Text(String.valueOf(chars[i]));

            KeyValue startX = new KeyValue(letter.translateXProperty(), 0);
            KeyValue endX = new KeyValue(letter.translateXProperty(), -20+i*2);
            KeyFrame startFrameX = new KeyFrame(Duration.ZERO, startX);
            KeyFrame endFrameX = new KeyFrame(Duration.seconds(0.5), endX);
            

            KeyValue startY = new KeyValue(letter.translateYProperty(), 0);
            KeyValue endY = new KeyValue(letter.translateYProperty(), -20+i*2);
            KeyFrame startFrame = new KeyFrame(Duration.ZERO, startY);
            KeyFrame endFrame = new KeyFrame(Duration.seconds(0.5), endY);

            
            Timeline timeline = new Timeline(startFrame, endFrame);
            Timeline timelineX = new Timeline(startFrameX, endFrameX);

            timelineX.setAutoReverse(true);
            timelineX.setCycleCount(Timeline.INDEFINITE);
            timelineX.play();


            timeline.setAutoReverse(true);
            timeline.setCycleCount(Timeline.INDEFINITE);
            timeline.play();
            
            letters.getChildren().add(letter);
        }
        
        ((StackPane) quote.getParent()).getChildren().setAll(letters);        


        
        
    }
    
}
