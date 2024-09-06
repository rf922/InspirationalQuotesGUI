package FxGui;

import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
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
    
    static {// static initializer block to init vars.
        quoteManager = new QuoteManager();
    }

    @Override
    public void start(Stage stage) {
        VBox paneSpace = new VBox();
        paneSpace.setStyle("-fx-background-color: null;");
        paneSpace.setAlignment(Pos.CENTER);
        paneSpace.setPadding(new Insets(60, 20, 50, 20));
        paneSpace.setBorder(new Border(new BorderStroke(Paint.valueOf("Yellow"), BorderStrokeStyle.SOLID, new CornerRadii(0.00), BorderStroke.MEDIUM)));
        paneSpace.setSpacing(90.00);
        this.quote = new Text("Go on and press the button");

        this.quoteButton = new Button("Inspire");

        quoteButton.setVisible(true);

        quoteButton.setOnAction(this::handleButton);
        quoteButton.setAlignment(Pos.CENTER_LEFT);

        quote.setFont(Font.font("Helvetica", 20));
        quote.setFill(Color.CYAN);

        paneSpace.getChildren().add(this.quote);
        paneSpace.getChildren().add(this.quoteButton);

        this.sceneSpace = new Scene(paneSpace, 640, 440, Color.BLACK);

        stage.setTitle("Inspirational Quotes for You");
        stage.setScene(sceneSpace);
        stage.show();

    }

    /**
     * Handles what happens when the button is clicked
     *
     * @param event
     */
    private void handleButton(ActionEvent event) {

/*  Quote Logic */        
        String newQuote = quoteManager.getRandomQuote();
        Color newColor = quoteManager.getRandomColor();
        this.quote.setFill(newColor);
        int fontSize = quoteManager.getFontSize();
        this.quote.setFont(Font
            .font(quoteManager.getFont(), fontSize < 20 ? 23 : fontSize));

/*  Quote Logic */ 
        
        
        
/*  Animation Logic */ 
        this.quote.setRotate(this.quote.getRotate() + 45.00);
        this.quote.setText(newQuote);
        this.quote.setX(this.quote.getX() + 2);



        double sceneWidth = this.sceneSpace.getWidth();
        double quoteWidth = this.quote.getLayoutBounds().getWidth();

        KeyValue start = new KeyValue(this.quote.translateYProperty(), 60.00);
        KeyFrame segment = new KeyFrame(Duration.ZERO, start);

        KeyValue end = new KeyValue(this.quote.translateYProperty(), -1.0
            * quoteWidth);
        KeyFrame endSegment = new KeyFrame(Duration.seconds(2.0), end);

        Timeline time = new Timeline(segment, endSegment);

        Rotate rotation = new Rotate(360 / 20);
        this.quote.getTransforms().add(rotation);

        time.setCycleCount(Timeline.INDEFINITE);
        time.play();
/*  Animation Logic */ 
    }

    public static void main(String[] args) {
        launch(args);

    }

}
