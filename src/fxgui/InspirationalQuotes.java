package fxgui;

import animations.AnimationContext;
import animations.FloatingAnimation;
import animations.RotationAnimation;
import animations.TextAnimationStrategy;
import animations.WaveAnimation;
import audioeffects.AudioEffect;
import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/*
 * A fun little program that displays inspirational quotes as a button is clicked
 * 
 * 
 */
/**
 *
 * @author Rf922
 */
public class InspirationalQuotes extends Application {

    private Button quoteButton;
    private Text quote;
    private Scene sceneSpace;
    private StackPane quoteContainer;
    private final static QuoteManager quoteManager;
//    private static final Map<String, TextAnimationStrategy> textAnimationStrategies;
    private  static final AnimationContext animationContext;
    private final static Random random;

    static {// static initializer block to init vars.
        random = new Random();
        quoteManager = new QuoteManager();
        animationContext = new AnimationContext(random);
        animationContext.addStrategy(new WaveAnimation());
        animationContext.addStrategy(new FloatingAnimation());
        animationContext.addStrategy(new RotationAnimation());
//        textAnimationStrategies = new HashMap<>();
//        textAnimationStrategies.put("WAVE", new WaveAnimation());
//        textAnimationStrategies.put("FLOATING", new FloatingAnimation());
//        textAnimationStrategies.put("ROTATE", new RotationAnimation());
    }

    @Override
    public void start(Stage stage) {
        VBox paneSpace = new VBox();
        this.quote = new Text("Go on and press the button");
        this.quoteButton = new Button("Inspire");

        paneSpace.getStyleClass().add("vbox");
        this.quoteContainer = new StackPane();

        quoteContainer.setPrefSize(400, 350);
        quoteContainer.setMinSize(200, 250);
        quoteContainer.setMaxSize(500, 750);

        quoteContainer.getStyleClass().add("quote-container");
        quoteContainer.setVisible(true);

        quoteButton.getStyleClass().add("button");
        quote.getStyleClass().add("text");

        quoteButton.setVisible(true);
        quoteButton.setOnAction(this::handleButton);

        quoteContainer.getChildren().add(this.quote);
//        paneSpace.getChildren().add(this.quote);
        paneSpace.getChildren().add(quoteContainer);
//        paneSpace.getChildren().add(spacer);
        paneSpace.getChildren().add(this.quoteButton);

        this.sceneSpace = new Scene(paneSpace, 540, 440);
        sceneSpace.getStylesheets()
                .add(getClass()
                        .getResource("/resources/css/style.css")
                        .toExternalForm());
        sceneSpace.getRoot().getStyleClass().add("scene");

        stage.setTitle("Inspirational Quotes for You");
        stage.setScene(sceneSpace);

        Image icon = new Image(getClass().getResourceAsStream("/resources/images/icon.png"));
        stage.getIcons().add(icon);

        stage.setMinHeight(450);
        stage.setMinWidth(300);
        stage.show();

    }

    /**
     * Handles what happens when the button is clicked
     *
     * @param event
     */
    private void handleButton(ActionEvent event) {
        AudioEffect audioEffect = new AudioEffect();
        audioEffect.playClick();
        quoteContainer.getChildren().clear();
        quoteManager.getQuote(quote, quoteContainer);

        double x = Math.max(0, random.nextDouble() * (quoteContainer.getWidth() - quote.getLayoutBounds().getWidth()));
        double y = Math.max(0, random.nextDouble() * (quoteContainer.getHeight() - quote.getLayoutBounds().getHeight()));

        quote.setTranslateX(x);
        quote.setTranslateY(y);

//        List<TextAnimationStrategy> strategyList = new ArrayList<>(textAnimationStrategies.values());
  //      TextAnimationStrategy selectedStrategy = strategyList.get(random.nextInt(strategyList.size()));

     //   animationContext.addStrategy(selectedStrategy);
        Node node = animationContext.executeStrategy(quote, quoteContainer);

        System.out.println(" [ HANDLE BUTTON : Executing strategy  ] ");
   }

    public static void main(String[] args) {
        launch(args);

    }

}
