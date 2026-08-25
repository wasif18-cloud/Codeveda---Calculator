import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Calculator {

    int boardWidth = 360;
    int boardHeight = 540;

    Color customLightGray = new Color(212, 212, 210);
    Color customDarkGray = new Color(80, 80, 80);
    Color customBlack = new Color(28, 28, 28);
    Color customOrange = new Color(255, 149, 0);

    String[] buttonValues = {
        "AC", "+/-", "%", "÷",
        "7", "8", "9", "×",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };

    String[] rightSymbols = {"÷", "×", "-", "+", "="};
    String[] topSymbols = {"AC", "+/-", "%"};

    JFrame frame = new JFrame("Calculator");
    JLabel displayLabel = new JLabel();
    JPanel displayPanel = new JPanel();
    JPanel buttonsPanel = new JPanel();

    // A + B, A - B, A * B, A / B
    String A = "0";
    String operator = null;
    String B = null;

    boolean justCalculated = false;

    Calculator() {

        frame.setSize(boardWidth, boardHeight);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Display
        displayLabel.setBackground(customBlack);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 60));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setText("0");
        displayLabel.setOpaque(true);

        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);

        // Buttons
        buttonsPanel.setLayout(new GridLayout(5, 4));
        buttonsPanel.setBackground(customBlack);
        frame.add(buttonsPanel, BorderLayout.CENTER);

        // Create buttons
        for (int i = 0; i < buttonValues.length; i++) {

            String buttonValue = buttonValues[i];

            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.PLAIN, 30));
            button.setText(buttonValue);
            button.setFocusable(false);
            button.setBorder(new LineBorder(customBlack));

            // Top buttons
            if (Arrays.asList(topSymbols).contains(buttonValue)) {
                button.setBackground(customLightGray);
                button.setForeground(customBlack);
            }

            // Right-side operators
            else if (Arrays.asList(rightSymbols).contains(buttonValue)) {
                button.setBackground(customOrange);
                button.setForeground(Color.WHITE);
            }

            // Number and other buttons
            else {
                button.setBackground(customDarkGray);
                button.setForeground(Color.WHITE);
            }

            buttonsPanel.add(button);

            // Button action
            button.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    JButton button = (JButton) e.getSource();
                    String buttonValue = button.getText();

                    // OPERATORS
                    if (Arrays.asList(rightSymbols).contains(buttonValue)) {

                        // Equal
                        if (buttonValue.equals("=")) {

                            if (operator != null) {

                                B = displayLabel.getText();

                                double numA = Double.parseDouble(A);
                                double numB = Double.parseDouble(B);

                                switch (operator) {

                                    case "+":
                                        displayLabel.setText(
                                            removeZeroDecimal(numA + numB)
                                        );
                                        break;

                                    case "-":
                                        displayLabel.setText(
                                            removeZeroDecimal(numA - numB)
                                        );
                                        break;

                                    case "×":
                                        displayLabel.setText(
                                            removeZeroDecimal(numA * numB)
                                        );
                                        break;

                                    case "÷":
                                        if (numB == 0) {
                                            displayLabel.setText("Error");
                                        } else {
                                            displayLabel.setText(
                                                removeZeroDecimal(numA / numB)
                                            );
                                        }
                                        break;
                                }

                                operator = null;
                                A = displayLabel.getText();
                                justCalculated = true;
                            }
                        }

                        // + - × ÷
                        else {

                            A = displayLabel.getText();
                            operator = buttonValue;

                            displayLabel.setText("0");
                            justCalculated = false;
                        }
                    }

                    // TOP SYMBOLS
                    else if (Arrays.asList(topSymbols).contains(buttonValue)) {

                        // AC
                        if (buttonValue.equals("AC")) {

                            clearAll();
                            displayLabel.setText("0");
                        }

                        // +/-
                        else if (buttonValue.equals("+/-")) {

                            double numDisplay =
                                Double.parseDouble(displayLabel.getText());

                            numDisplay *= -1;

                            displayLabel.setText(
                                removeZeroDecimal(numDisplay)
                            );
                        }

                        // %
                        else if (buttonValue.equals("%")) {

                            double numDisplay =
                                Double.parseDouble(displayLabel.getText());

                            numDisplay /= 100;

                            displayLabel.setText(
                                removeZeroDecimal(numDisplay)
                            );
                        }
                    }

                    // SQUARE ROOT
                    else if (buttonValue.equals("√")) {

                        double numDisplay =
                            Double.parseDouble(displayLabel.getText());

                        if (numDisplay < 0) {
                            displayLabel.setText("Error");
                        } else {
                            displayLabel.setText(
                                removeZeroDecimal(Math.sqrt(numDisplay))
                            );
                        }
                    }

                    // DIGITS AND DECIMAL
                    else {

                        // Decimal point
                        if (buttonValue.equals(".")) {

                            if (!displayLabel.getText().contains(".")) {

                                if (justCalculated) {
                                    displayLabel.setText("0.");
                                    justCalculated = false;
                                } else {
                                    displayLabel.setText(
                                        displayLabel.getText() + "."
                                    );
                                }
                            }
                        }

                        // Numbers
                        else if ("0123456789".contains(buttonValue)) {

                            if (justCalculated ||
                                displayLabel.getText().equals("0") ||
                                displayLabel.getText().equals("Error")) {

                                displayLabel.setText(buttonValue);
                                justCalculated = false;
                            } else {

                                displayLabel.setText(
                                    displayLabel.getText() + buttonValue
                                );
                            }
                        }
                    }
                }
            });
        }

        frame.setVisible(true);
    }

    // MAIN METHOD
    public static void main(String[] args) {
        new Calculator();
    }

    // CLEAR CALCULATOR
    void clearAll() {
        A = "0";
        operator = null;
        B = null;
        justCalculated = false;
    }
    
    // REMOVE .0 FROM NUMBER
    String removeZeroDecimal(double numDisplay) {

        if (numDisplay % 1 == 0) {
            return Integer.toString((int) numDisplay);
        }

        return Double.toString(numDisplay);
    }
}