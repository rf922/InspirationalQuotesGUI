/*
 * 
 * 
 * 
 */
package fxgui;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 * A quote manager class to handle the retrieving of quotes and colors
 *
 * @author Rf922
 */
public class QuoteManager {

    private final List<InspirationalQuoteEnum> quotes;
    private final Random randomSelector;
    private final int MAX_FONT_SIZE = 50;

    public QuoteManager() {
        quotes = Arrays.asList(InspirationalQuoteEnum.values());
        randomSelector = new Random();
    }

    public void getQuote(Text quote, Pane quoteContainer) {
        String quoteText = getQuoteText();
        Color quoteColor = getRandomColor();
        int fontSize = getFontSize();

        quote.setFill(quoteColor);
        quote.setFont(Font
            .font(getFont(), fontSize));
        quote.setFill(quoteColor);
        quote.setText(quoteText);
        quoteContainer.getChildren().add(quote);
    }

    private String getQuoteText() {
        return quotes.get(randomSelector.nextInt(quotes.size())).getQuote();
    }

    private Color getRandomColor() {
        return quotes.get(randomSelector.nextInt(quotes.size())).getColor();
    }

    private String getFont() {
        return Font
            .getFontNames()
            .get(randomSelector.nextInt(Font
                .getFontNames()
                .size()));
    }

    private int getFontSize() {
        return randomSelector.nextInt(MAX_FONT_SIZE);
    }
}
