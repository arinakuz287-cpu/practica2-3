package practica2_3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Lab3_3 {
    public Lab3_3() {
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            while(true) {
                System.out.println("\nВЫБЕРИТЕ ЗАДАНИЕ");
                System.out.println("1 - Задание 1");
                System.out.println("2 - Задание 2");
                System.out.println("3 - Задание 3");
                System.out.println("4 - Задание");
                System.out.println("0 - Выход");
                System.out.print("Выбор: ");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 0:
                        System.out.println("Выход...");
                        System.exit(0);
                    default:
                        System.out.println("Нет такого пункта.");
                        break;
                    case 1:
                        SwingUtilities.invokeLater(() -> {
                            new Task1_Calculator();
                        });
                        break;
                    case 2:
                        SwingUtilities.invokeLater(() -> {
                            new Task2_Countries();
                        });
                        break;
                    case 3:
                        SwingUtilities.invokeLater(() -> {
                            new Task3_MenuAndButtons();
                        });
                        break;
                    case 4:
                        SwingUtilities.invokeLater(() -> {
                            new Task4_GridCalculator();
                        });
                }
            }
        }
    }

    static class Task4_GridCalculator extends JFrame {
        JTextField display;
        double num1 = 0.0;
        String operator = "";

        public Task4_GridCalculator() {
            super("Simple Calculator");
            this.setSize(300, 400);
            this.setDefaultCloseOperation(2);
            this.setLayout(new BorderLayout());
            this.display = new JTextField();
            this.display.setEditable(false);
            this.display.setHorizontalAlignment(4);
            this.display.setFont(new Font("Arial", 1, 24));
            this.add(this.display, "North");
            JPanel buttonPanel = new JPanel();
            buttonPanel.setLayout(new GridLayout(4, 4, 5, 5));
            String[] buttons = new String[]{"7", "8", "9", "/", "4", "5", "6", "*", "1", "2", "3", "-", "0", ".", "=", "+"};
            ActionListener listener = (e) -> {
                String cmd = e.getActionCommand();
                if (cmd.matches("[0-9\\.]")) {
                    JTextField var10000 = this.display;
                    String var10001 = this.display.getText();
                    var10000.setText(var10001 + cmd);
                } else if (cmd.equals("=")) {
                    double num2 = Double.parseDouble(this.display.getText());
                    double res = 0.0;
                    switch (this.operator) {
                        case "+" -> res = this.num1 + num2;
                        case "-" -> res = this.num1 - num2;
                        case "*" -> res = this.num1 * num2;
                        case "/" -> res = this.num1 / num2;
                    }

                    this.display.setText(String.valueOf(res));
                    this.operator = "";
                } else {
                    this.num1 = Double.parseDouble(this.display.getText());
                    this.operator = cmd;
                    this.display.setText("");
                }

            };
            String[] var4 = buttons;
            int var5 = buttons.length;

            for(int var6 = 0; var6 < var5; ++var6) {
                String text = var4[var6];
                JButton btn = new JButton(text);
                btn.setFont(new Font("Arial", 1, 18));
                btn.addActionListener(listener);
                buttonPanel.add(btn);
            }

            this.add(buttonPanel, "Center");
            this.setVisible(true);
        }
    }

    static class Task3_MenuAndButtons extends JFrame {
        public Task3_MenuAndButtons() {
            super("Hello Swing");
            this.setSize(400, 300);
            this.setDefaultCloseOperation(2);
            JMenuBar menuBar = new JMenuBar();
            JMenu fileMenu = new JMenu("File");
            fileMenu.add(new JMenuItem("Save"));
            fileMenu.add(new JMenuItem("Exit"));
            JMenu editMenu = new JMenu("Edit");
            editMenu.add(new JMenuItem("Copy"));
            editMenu.add(new JMenuItem("Cut"));
            editMenu.add(new JMenuItem("Paste"));
            JMenu helpMenu = new JMenu("Help");
            menuBar.add(fileMenu);
            menuBar.add(editMenu);
            menuBar.add(helpMenu);
            this.setJMenuBar(menuBar);
            JPanel mainPanel = new JPanel();
            mainPanel.setLayout(new FlowLayout());
            JTextField textField = new JTextField(20);
            JButton btn1 = new JButton("Button 1");
            JButton btn2 = new JButton("Button 2");
            mainPanel.add(btn1);
            mainPanel.add(btn2);
            mainPanel.add(textField);
            this.add(mainPanel);
            this.setVisible(true);
        }
    }

    static class Task2_Countries extends JFrame {
        JComboBox<String> countries;
        JLabel infoLabel;

        public Task2_Countries() {
            super("Hello Swing");
            this.setSize(300, 200);
            this.setLayout(new FlowLayout());
            this.setDefaultCloseOperation(2);
            String[] countryList = new String[]{"Australia", "China", "England", "Russia"};
            this.countries = new JComboBox(countryList);
            this.infoLabel = new JLabel("Выберите страну");
            this.add(this.countries);
            this.add(this.infoLabel);
            this.countries.addActionListener((e) -> {
                switch ((String)this.countries.getSelectedItem()) {
                    case "Australia" -> this.infoLabel.setText("Столица: Канберра");
                    case "China" -> this.infoLabel.setText("Столица: Пекин");
                    case "England" -> this.infoLabel.setText("Столица: Лондон");
                    case "Russia" -> this.infoLabel.setText("Столица: Москва");
                }

            });
            this.setVisible(true);
        }
    }

    static class Task1_Calculator extends JFrame {
        JTextField num1 = new JTextField(10);
        JTextField num2 = new JTextField(10);
        JTextField result = new JTextField(15);
        JButton btnAdd = new JButton("+");
        JButton btnSub = new JButton("-");
        JButton btnMul = new JButton("*");
        JButton btnDiv = new JButton("/");

        public Task1_Calculator() {
            super("Калькулятор");
            this.setSize(400, 200);
            this.setLayout(new FlowLayout());
            this.setDefaultCloseOperation(2);
            this.add(new JLabel("Число 1:"));
            this.add(this.num1);
            this.add(new JLabel("Число 2:"));
            this.add(this.num2);
            this.add(new JLabel("Результат:"));
            this.add(this.result);
            this.result.setEditable(false);
            this.add(this.btnAdd);
            this.add(this.btnSub);
            this.add(this.btnMul);
            this.add(this.btnDiv);
            ActionListener calcAction = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    try {
                        double a = Double.parseDouble(Task1_Calculator.this.num1.getText().trim());
                        double b = Double.parseDouble(Task1_Calculator.this.num2.getText().trim());
                        double res = 0.0;
                        if (e.getSource() == Task1_Calculator.this.btnAdd) {
                            res = a + b;
                        } else if (e.getSource() == Task1_Calculator.this.btnSub) {
                            res = a - b;
                        } else if (e.getSource() == Task1_Calculator.this.btnMul) {
                            res = a * b;
                        } else if (e.getSource() == Task1_Calculator.this.btnDiv) {
                            if (b == 0.0) {
                                Task1_Calculator.this.result.setText("Деление на 0!");
                                return;
                            }

                            res = a / b;
                        }

                        Task1_Calculator.this.result.setText(String.valueOf(res));
                    } catch (NumberFormatException var8) {
                        JOptionPane.showMessageDialog((Component)null, "Ошибка ввода!", "Ошибка", 0);
                    }

                }
            };
            this.btnAdd.addActionListener(calcAction);
            this.btnSub.addActionListener(calcAction);
            this.btnMul.addActionListener(calcAction);
            this.btnDiv.addActionListener(calcAction);
            this.setVisible(true);
        }
    }
}
