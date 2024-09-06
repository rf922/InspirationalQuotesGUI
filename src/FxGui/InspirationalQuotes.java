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

    Button quoteButton;
    Text quote;
    Scene sceneSpace;

    /**
     * A Enumeration for the possible colors and quote combinations
     */
    public enum randomOut {
        RED(Color.RED, "You Can Do It !"), GREEN(Color.GREEN, "You're Way Cool !"),
        PURPLE(Color.PURPLE, "Your code is Stellar !"), VIOLET(Color.VIOLET, "You're so Far Out !"),
        PINK(Color.PINK, "You're doing great !"), MAGENTA(Color.MAGENTA, "Go For it !"),
        MAROON(Color.MAROON, "You're so hip !"), CRIMSON(Color.CRIMSON, "Keep On Keepin On"),
        BLUEVIOLET(Color.BLUEVIOLET, "Your work is Killer !"), ORANGERED(Color.ORANGERED, "You're Outta Sight !!");

        private final Color color;
        private final String quote;

        private randomOut(Color color, String quote) {
            this.color = color;
            this.quote = quote;
        }

        public Color getColor() {
            return color;
        }

        public String getQuote() {
            return quote;
        }

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
        ;
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

        Random randomPick = new Random();
        List<randomOut> colors = new ArrayList<>();
        Arrays.stream(randomOut.values()).forEach(colors::add);
        Color colorOut = colors.get(randomPick.nextInt(colors.size())).getColor();
        Color current = colorOut.equals(this.quote.getFill()) ? Color.AQUA : colorOut;
        String quoteOut = colors.get(randomPick.nextInt(colors.size())).getQuote();
        String currentQuote = quoteOut.equals(this.quote.getText()) ? colors.get(randomPick.nextInt(colors.size())).getQuote() : quoteOut;
        this.quote.setFill(current);
        int fontSize = randomPick.nextInt(50);
        this.quote.setFont(Font.font(Font.getFontNames().get(randomPick.nextInt(Font.getFontNames().size())), fontSize < 20 ? 23 : fontSize));
        this.quote.setRotate(this.quote.getRotate() + 45.00);
        this.quote.setText(currentQuote);
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

    }

    public static void main(String[] args) {
        launch(args);

    }

}
