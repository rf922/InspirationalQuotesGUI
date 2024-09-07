/*
 * 
 * 
 * 
 */
package fxgui;

import javafx.scene.paint.Color;

/**
 * A Enumeration for the possible colors and quote combinations
 */
public enum InspirationalQuoteEnum {
    RED(Color.RED, "You Can Do It !"), GREEN(Color.GREEN, "You're Way Cool !"),
    PURPLE(Color.PURPLE, "Your code is Stellar !"), VIOLET(Color.VIOLET, "You're so Far Out !"),
    PINK(Color.PINK, "You're doing great !"), MAGENTA(Color.MAGENTA, "Go For it !"),
    MAROON(Color.MAROON, "You're so hip !"), CRIMSON(Color.CRIMSON, "Keep On Keepin On"),
    BLUEVIOLET(Color.BLUEVIOLET, "Your work is Killer !"), ORANGERED(Color.ORANGERED, "You're Outta Sight !!");

    private final Color color;
    private final String quote;

    private InspirationalQuoteEnum(Color color, String quote) {
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
