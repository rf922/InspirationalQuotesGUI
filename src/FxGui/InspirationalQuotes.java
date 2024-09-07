package FxGui;

import animations.FloatingAnimation;
import animations.RotationAnimation;
import animations.TextAnimationStrategy;
import javafx.util.Duration;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.paint.*;
import javafx.scene.control.Button;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/*
 * A fun little program that displays inspirational quotes as a button is clicked
 * 
 * 
 */
/**
 *
 * @author Rafael
 */
public class InspirationalQuotes extends Application {

    private Button quoteButton;
    private Text quote;
    private Scene sceneSpace;
    private static QuoteManager quoteManager;
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
        quoteButton.getStyleClass().add("button");
        quote.getStyleClass().add("text");

        Region spacer = new Region();
        VBox.setVgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        quoteButton.setVisible(true);
        quoteButton.setOnAction(this::handleButton);

        paneSpace.getChildren().add(this.quote);
        paneSpace.getChildren().add(spacer);
        paneSpace.getChildren().add(this.quoteButton);

        this.sceneSpace = new Scene(paneSpace, 640, 440);
        sceneSpace.getStylesheets().add(getClass().getResource("/resources/css/style.css").toExternalForm());
        sceneSpace.getRoot().getStyleClass().add("scene");

        stage.setTitle("Inspirational Quotes for You");
        stage.setScene(sceneSpace);

        Image icon = new Image(getClass().getResourceAsStream("/resources/images/icon.png"));
        stage.getIcons().add(icon);

        stage.show();

    }

    /**
     * Handles what happens when the button is clicked
     *
     * @param event
     */
    private void handleButton(ActionEvent event) {

        quoteManager.getQuote(quote);

        /*  Animation Logic */
        TextAnimationStrategy floatOff = new FloatingAnimation(FloatingAnimation.Direction.VERTICAL);
        this.textAnimationStrategy = new RotationAnimation();
        floatOff.animate(quote);
        textAnimationStrategy.animate(quote);
        /*  Animation Logic */
    }

    public static void main(String[] args) {
        launch(args);

    }

}
