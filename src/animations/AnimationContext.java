/*
 * 
 * 
 * 
 */
package animations;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * Context class for managing animation strategies.
 * @author Rf922
 */
public class AnimationContext {
    private final Random random;
    private final List<TextAnimationStrategy> strategies = new ArrayList<>();
    private TextAnimationStrategy activeStrategy;

    public AnimationContext(Random random){
        this.random = random;
    }
    
    /**
     * Adds a text animation strategy to the lists of available animations
     * @param strategy 
     */
    public void addStrategy(TextAnimationStrategy strategy) {
        System.out.println(" [ ADD STRATEGY ] : adding strategy ");
        strategies.add(strategy);
        if(activeStrategy == null ){
            activeStrategy = strategy;
        }
    }

    /**
     * Clears the list of stored animations
     */
    public void clearStrategies() {
        strategies.clear();
    }
    
    /**
     * Randomly selects a text animation strategy
     */
    private void setRandomStrategy(){
        if(!strategies.isEmpty()){
            int x =Math.abs( random.nextInt() % strategies.size());
            activeStrategy = strategies.get(x);            
        }else{
            System.out.println(" [ SET RANDOM STRATEGY ] : Strategies empty");
        }

    }
    
    /**
     * Executes the active text animation.
     * @param node
     * @param container
     * @return 
     */
    public Node executeStrategy(Node node, Pane container) {
        setRandomStrategy();
        node =activeStrategy.animate(node, container);
        return node;
    }

    
    /**
     * Executes each text animation from the stored list 
     * @param node
     * @param container
     * @return 
     */
    public Node executeStrategies(Node node, Pane container) {
        for (TextAnimationStrategy strategy : strategies) {
            node =strategy.animate(node, container);
        }
        return node;
    }
}
