/*
 * 
 * 
 * 
 */
package animations;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;


/**
 *
 * @author rf922
 */
public interface TextAnimationStrategy {
    public Node animate(Node node, Pane container);
}
