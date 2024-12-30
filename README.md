# Inspirational Quotes JavaFX Application

This project is a JavaFX application that displays inspirational quotes to the user. It was originally developed for the CS211 Advanced Java course taught by Jessica Masters at City College of San Francisco.

## Overview

The application features:

*   **Dynamic Quotes:** Displays a new inspirational quote each time the "Inspire" button is clicked.
*   **Randomized Appearance:** Quotes appear with random colors, fonts, and sizes.
*   **Animated Text:** Utilizes the Strategy Pattern to apply various animations to the quotes.
*   **Sound Effects:** Plays a click sound when the button is pressed.

## Key Features

*   **Strategy Pattern:** The core animation logic uses the Strategy Pattern to easily add and manage different animation effects. The `AnimationContext` class manages a list of `TextAnimationStrategy` implementations. 
    *   Currently implemented animation strategies include:
        *   `WaveAnimation`: animates the text in a wave-like motion.
        *   `FloatingAnimation`: makes the text float up or to the side.
        *   `RotationAnimation`: rotates the text.
*   **Randomization:** A `Random` object is used for various randomizations, including:
    *   Selecting quotes.
    *   Choosing colors and fonts.
    *   Positioning and animating the quote text.
    *   Selecting animation strategies.
*   **JavaFX UI:**
    *   The user interface is built using JavaFX, including a button and a `StackPane` to contain the quote text.
    *   The UI is styled using a custom CSS stylesheet.
*   **Audio Effects:** The `AudioEffect` class plays a sound effect when the button is pressed.
*   **Responsive Layout:** The window has a minimum and maximum size to ensure the content remains visible on the screen.

## Technologies Used

*   **Java:** JDK 20
*   **JavaFX:** Version 21

## Project Structure

The project is organized into the following packages:

*   **`animations`:** Contains the animation strategy interfaces and concrete implementations:
    *   `AnimationContext.java`: Manages animation strategies and selects an active one.
    *   `TextAnimationStrategy.java`: Defines the contract for all text animation strategies.
    *   `FloatingAnimation.java`: Implements a floating animation.
    *   `RotationAnimation.java`: Implements a rotation animation.
    *   `WaveAnimation.java`: Implements a wave animation.
*   **`audioeffects`:** Contains the `AudioEffect.java` class for handling audio.
*   **`fxgui`:**
    *   `InspirationalQuoteEnum.java`: Holds predefined quotes.
    *   `InspirationalQuotes.java`: The main class that runs the JavaFX application.
    *   `QuoteManager.java`: Manages the retrieval and formatting of quotes.
*   **`resources`:**
    *   `css`: Contains `style.css` for styling the application UI.
    *   `sounds`:  Contains the `click.mp3` sound file.
    *   `images`: Contains `icon.png` for the window icon.

## How to Run

1.  **Ensure you have Java JDK 20 and JavaFX 21 installed.**
2.  **Download or clone the project.**
3.  **If using an IDE (like IntelliJ, Eclipse, Apache NetBeans):**
    *   Import the project.
    *   Run the `InspirationalQuotes.java` class.
4.  **If running from the command line:**
    *   Navigate to the project's root directory.
    *   Compile the java files `javac -d ./out/ -cp ".:/path/to/javafx-sdk-21/lib/*" ./src/**/*.java`
    *   Run the application `java --module-path /path/to/javafx-sdk-21/lib --add-modules javafx.controls,javafx.fxml,javafx.media -cp ".:./out" fxgui.InspirationalQuotes`

    *(Replace `/path/to/javafx-sdk-21/lib/` with the actual path to your JavaFX SDK)*
    
    *If using Maven, you can compile and run the project using the appropriate maven commands, for example `mvn compile` and `mvn exec:java -Dexec.mainClass=fxgui.InspirationalQuotes`

## ScreenShots

![image](https://github.com/user-attachments/assets/b134ebc2-76dc-4fa3-932f-d49193323c1a)

![image](https://github.com/user-attachments/assets/4b91f9bb-1515-4836-8bed-376d31545328)

![image](https://github.com/user-attachments/assets/5ccfec9e-a217-470d-9cfc-91fad10c51bc)


## Future Enhancements

*   Add a settings menu to control the animation effects and other user preferences.
*   Allow the user to add their own custom quotes.
*   Implement more animation strategies.
*   Add a larger list of quotes
*   Add more complex layouts and styling.

## Credits

*   This application was developed by Rf922 for the CS211 Advanced Java course at City College of San Francisco.
*   Inspiration and guidance from Jessica Masters.
