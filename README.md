# 🧮 Java Calculator

A clean and functional **Java GUI Calculator** built using **Java Swing**. This project was created as a Level 1 (Basic) task to demonstrate Java fundamentals, GUI development, event handling, and basic arithmetic operations.

![Java](https://img.shields.io/badge/Java-17%2B-orange?style=for-the-badge&logo=openjdk)
![Swing](https://img.shields.io/badge/GUI-Java%20Swing-blue?style=for-the-badge)
![Level](https://img.shields.io/badge/Level-1%20%7C%20Basic-success?style=for-the-badge)

---

## 📌 Project Overview

This calculator provides a simple desktop interface for performing common mathematical operations. It uses **Java Swing components** such as `JFrame`, `JLabel`, `JPanel`, and `JButton`, with event listeners to handle user interaction.

The interface is inspired by a modern desktop calculator layout and includes a dedicated display area, number keys, arithmetic operators, and utility functions.

---

## ✨ Features

- ➕ Addition
- ➖ Subtraction
- ✖️ Multiplication
- ➗ Division
- `%` Percentage calculation
- `+/-` Positive/negative number toggle
- `√` Square root
- `.` Decimal number support
- `AC` Clear/reset
- `=` Calculate result
- ⚠️ Division-by-zero error handling
- ⚠️ Square root of negative numbers handled safely
- 🖥️ User-friendly graphical interface
- 🎨 Calculator-style dark and orange operator theme
- 🔢 Automatic removal of unnecessary `.0` from whole-number results

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Java** | Core programming language |
| **Java Swing** | Graphical user interface |
| **AWT** | Layouts, colors, fonts, and event handling |
| **ActionListener** | Handles button click events |
| **GridLayout** | Arranges calculator buttons |
| **Git & GitHub** | Version control and project hosting |

---

## 📂 Project Structure

```text
Java-Calculator/
│
├── Calculator.java
├── screenshots/
│   └── calculator.png
└── README.md
```

## 🧠 How It Works

The program creates a `JFrame` as the main calculator window and uses a `JLabel` as the display. Buttons are generated from an array of calculator symbols and arranged using a `GridLayout`.

When a button is clicked, an `ActionListener` determines the selected operation:

```text
User Input
    ↓
Button Click
    ↓
ActionListener
    ↓
Identify Operation
    ↓
Perform Calculation
    ↓
Display Result
```

The calculator stores the first number in `A`, the selected operator in `operator`, and the second number in `B`.

---

## 🧮 Supported Operations

| Operation | Example | Result |
|---|---:|---:|
| Addition | `10 + 5` | `15` |
| Subtraction | `10 - 5` | `5` |
| Multiplication | `10 × 5` | `50` |
| Division | `10 ÷ 5` | `2` |
| Percentage | `50 %` | `0.5` |
| Square Root | `√25` | `5` |
| Sign Change | `+/- 10` | `-10` |

---

## ⚠️ Error Handling

The calculator includes basic edge-case handling:

- **Division by zero** → displays `Error`
- **Square root of a negative number** → displays `Error`
- **Invalid repeated decimal point** → prevented by the input logic

## 🎯 Learning Objectives

This project demonstrates:

- Java class and object concepts
- Swing GUI development
- Event-driven programming
- Button and layout management
- Arithmetic operations
- Conditional statements
- `switch` statements
- Input validation
- Basic error handling
- Working with Git and GitHub

## 📚 Task Context

**Level:** 1 — Basic  
**Task:** Basic Calculator

The task focuses on creating a calculator capable of performing basic arithmetic operations and handling edge cases such as division by zero.

## 🔮 Future Improvements

Possible upgrades for a future version:

- ⌨️ Keyboard input support
- 🧾 Calculation history
- 🌓 Light/Dark theme switch
- 🔢 Scientific calculator mode
- 📋 Copy/paste result support
- 🎨 Improved responsive UI
- 💾 Save calculation history

If you find this project useful, consider giving the repository a ⭐ on GitHub!
