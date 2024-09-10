/*
 * 
 * 
 * 
 */
package animations;

import animations.TextAnimationStrategy;
import java.util.Random;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Rf922
 * An implementation for a simple animation that rotates the entire text by 
 * some degree.
 */
public class RotationAnimation implements TextAnimationStrategy {
    
    private Random random;

    @Override
    public void animate(Text quote) {
        random = new Random();
        int direction = random.nextBoolean() ? -1 : 1;
        double degree = random.nextDouble(-360, 360);
        
        
        
        Rotate rotation = new Rotate(degree);
        quote.getTransforms().add(rotation);
    }
    
}
