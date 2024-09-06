/*
 * 
 * 
 * 
 */
package FxGui;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * A quote manager class to handle the retrieving of quotes and colors
 *
 * @author Rf922
 */
public class QuoteManager {

    private List<InspirationalQuoteEnum> quotes;
    private Random randomSelector;
    private final int MAX_FONT_SIZE = 50;

    public QuoteManager() {
        quotes = Arrays.asList(InspirationalQuoteEnum.values());
        randomSelector = new Random();
    }

    public String getRandomQuote() {
        return quotes.get(randomSelector.nextInt(quotes.size())).getQuote();
    }

    public Color getRandomColor() {
        return quotes.get(randomSelector.nextInt(quotes.size())).getColor();
    }

    public String getFont() {
        return Font
            .getFontNames()
            .get(randomSelector.nextInt(Font
                .getFontNames()
                .size()));
    }

    public int getFontSize() {
        return randomSelector.nextInt(MAX_FONT_SIZE);
    }
}
