/*
 * 
 * 
 * 
 */
package animations;

import animations.TextAnimationStrategy;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

/**
 *
 * @author Rf922
 * An implementation for a simple animation that rotates the entire text by 
 * some degree.
 */
public class RotationAnimation implements TextAnimationStrategy {

    @Override
    public void animate(Text quote) {
        Rotate rotation = new Rotate(360 / 20);
        quote.getTransforms().add(rotation);
    }
    
}
