package fxgui;

import animations.FloatingAnimation;
import animations.RotationAnimation;
import animations.TextAnimationStrategy;
import animations.WaveAnimation;
import audioeffects.AudioEffect;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
    private final static QuoteManager quoteManager;
    private TextAnimationStrategy textAnimationStrategy;

    static {// static initializer block to init vars.
        quoteManager = new QuoteManager();
    }

    @Override
    public void start(Stage stage) {
        VBox paneSpace = new VBox();
        this.quote = new Text("Go on and press the button");
        this.quoteButton = new Button("Inspire");

        paneSpace.getStyleClass().add("vbox");
        StackPane quoteContainer = new StackPane();
        
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

        quoteManager.getQuote(quote);

        /*  Animation Logic */
        TextAnimationStrategy floatOff = new FloatingAnimation();
        TextAnimationStrategy wave = new WaveAnimation();
//        this.textAnimationStrategy = new RotationAnimation();
      //  floatOff.animate(quote);
        wave.animate(quote);
        //textAnimationStrategy.animate(quote);
        /*  Animation Logic */
    }

    public static void main(String[] args) {
        launch(args);

    }

}
