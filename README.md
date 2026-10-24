# Lab_5_JavaFX_and_MVC_Pattern

# JavaFX MVC Registration Form

A simple JavaFX desktop application that collects a user's **Name, Age and Email**, validates the input, and shows the submitted details in a pop-up dialog. The project follows the **Model-View-Controller (MVC)** architecture.

Built as part of **Lab 5: JavaFX and Scene Builder**.

---

## Features

- Registration form with Name, Age and Email fields
- Input validation with clear error messages
- Live feedback: red border for invalid input, green border for valid input
- Age field accepts digits only (maximum 3 digits)
- Styled pop-up that displays the submitted details
- Clear button to reset the form
- Modern UI styled with CSS
- FXML layout, editable in Scene Builder

---

## Validation Rules

| Field | Rules |
|---|---|
| **Name** | Required, 2 to 50 characters, letters only (spaces, `.`, `'`, `-` allowed between words) |
| **Age** | Required, whole number between 1 and 120, digits only |
| **Email** | Required, no spaces, must be a valid format (e.g. `name@example.com`) |

---

## Project Structure (MVC)

```
Lab5/
├── pom.xml
└── src/main/
    ├── java/com/mycompany/lab5/
    │   ├── MainApp.java                    # Entry point
    │   ├── model/
    │   │   └── Person.java                 # MODEL: data + validation rules
    │   └── controller/
    │       └── PersonController.java       # CONTROLLER: handles events, shows pop-up
    └── resources/com/mycompany/lab5/
        ├── view/
        │   └── PersonForm.fxml             # VIEW: UI layout
        └── css/
            └── style.css                   # Styling
```

| Layer | File | Responsibility |
|---|---|---|
| Model | `Person.java` | Holds the data and the validation logic |
| View | `PersonForm.fxml`, `style.css` | Defines the UI only, with no logic |
| Controller | `PersonController.java` | Handles button actions, calls the Model to validate, shows the pop-up |

---

## Technologies Used

- Java 17
- JavaFX 17.0.10
- Maven
- Scene Builder (FXML design)
- Apache NetBeans IDE

---

## Prerequisites

- JDK 17 or later
- Maven (bundled with NetBeans)
- Internet connection for the first build, to download the JavaFX libraries

---

## How to Run

### Using NetBeans
1. Open the project: **File → Open Project → select `Lab5`**.
2. Right-click the project and choose **Clean and Build**.
3. Right-click the project, choose **Run Maven → Goals…**, enter `javafx:run`, and click **OK**.
---

## How to Use

1. Enter your **Name**, **Age** and **Email**.
2. Click **Submit**.
3. If all fields are valid, a pop-up shows the entered details.
4. If a field is invalid, an error message appears under it.
5. Click **Clear** to reset the form.

---

## Test Cases

| Input | Expected Result |
|---|---|
| All fields empty | "Required" errors under all fields |
| Name = `John123` | "Use letters only" error |
| Age = `abc` | Typing is blocked (digits only) |
| Age = `150` | "Age must be between 1 and 120" error |
| Email = `john@` | "Enter a valid email" error |
| Valid name, age and email | Pop-up shows the details |
