import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MyGUI {
    private JPanel MyPanel;
    private JButton One;
    private JButton Seven;
    private JButton Four;
    private JButton Eight;
    private JButton Five;
    private JButton Nine;
    private JButton Six;
    private JButton Three;
    private JButton Mul;
    private JButton Sub;
    private JButton Sum;
    private JButton Two;
    private JButton Zero;
    private JButton Equal;
    private JButton Div;
    private JLabel Story;
    private JButton Reset;
    private JTextField Current;
    private JButton Backspace;
    private JButton ResetCurrent;
    private JButton Sign;
    private SmallInteger HistorySI, CurrentSI, ResultSI;
    private int operation = 0;

    public void MReset() {
        HistorySI.setValue(0);
        CurrentSI.setValue(0);
        ResultSI.setValue(0);
        operation = 0;
        Current.setText(String.valueOf(CurrentSI.getValue()));
        Story.setText("Values were cleared");
    }

    public void MNumber(int i) {
        SmallInteger BackUpSI = new SmallInteger(CurrentSI.getValue());
        try {
            SmallInteger TempSI = new SmallInteger(10);
            CurrentSI = CurrentSI.multiply(TempSI);
            TempSI.setValue(i);
            CurrentSI = CurrentSI.summarize(TempSI);
            Current.setText(String.valueOf(CurrentSI.getValue()));
        } catch (IllegalArgumentException e) {
            CurrentSI.setValue(BackUpSI.getValue());
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void MSum() {
        MEq();
        HistorySI.setValue(CurrentSI.getValue());
        CurrentSI.setValue(0);
        Current.setText(String.valueOf(CurrentSI.getValue()));
        Story.setText(String.valueOf(HistorySI.getValue()) + "+");
        operation = 1;
    }

    public void MSub() {
        MEq();
        HistorySI.setValue(CurrentSI.getValue());
        CurrentSI.setValue(0);
        Current.setText(String.valueOf(CurrentSI.getValue()));
        Story.setText(String.valueOf(HistorySI.getValue()) + "-");
        operation = 2;
    }

    public void MMul() {
        MEq();
        HistorySI.setValue(CurrentSI.getValue());
        CurrentSI.setValue(0);
        Current.setText(String.valueOf(CurrentSI.getValue()));
        Story.setText(String.valueOf(HistorySI.getValue()) + "*");
        operation = 3;
    }

    public void MDiv() {
        MEq();
        HistorySI.setValue(CurrentSI.getValue());
        CurrentSI.setValue(0);
        Current.setText(String.valueOf(CurrentSI.getValue()));
        Story.setText(String.valueOf(HistorySI.getValue()) + "/");
        operation = 4;
    }

    public void MEq() {
        try {
            switch (operation) {
                case 1:
                    ResultSI = HistorySI.summarize(CurrentSI);
                    Story.setText(String.valueOf(HistorySI.getValue()) + "+" + String.valueOf(CurrentSI.getValue()) + "=" + String.valueOf(ResultSI.getValue()));
                    CurrentSI.setValue(ResultSI.getValue());
                    ResultSI.setValue(0);
                    Current.setText(String.valueOf(CurrentSI.getValue()));
                    break;
                case 2:
                    ResultSI = HistorySI.subtract(CurrentSI);
                    Story.setText(String.valueOf(HistorySI.getValue()) + "-" + String.valueOf(CurrentSI.getValue()) + "=" + String.valueOf(ResultSI.getValue()));
                    CurrentSI.setValue(ResultSI.getValue());
                    ResultSI.setValue(0);
                    Current.setText(String.valueOf(CurrentSI.getValue()));
                    break;
                case 3:
                    ResultSI = HistorySI.multiply(CurrentSI);
                    Story.setText(String.valueOf(HistorySI.getValue()) + "*" + String.valueOf(CurrentSI.getValue()) + "=" + String.valueOf(ResultSI.getValue()));
                    CurrentSI.setValue(ResultSI.getValue());
                    ResultSI.setValue(0);
                    Current.setText(String.valueOf(CurrentSI.getValue()));
                    break;
                case 4:
                    ResultSI = HistorySI.divide(CurrentSI);
                    Story.setText(String.valueOf(HistorySI.getValue()) + "/" + String.valueOf(CurrentSI.getValue()) + "=" + String.valueOf(ResultSI.getValue()));
                    CurrentSI.setValue(ResultSI.getValue());
                    ResultSI.setValue(0);
                    Current.setText(String.valueOf(CurrentSI.getValue()));
                    break;
            }
            operation = 0;
        }
        catch (ArithmeticException e)
        {
            Story.setText("Division by zero occurred");
            HistorySI.setValue(0);
            CurrentSI.setValue(0);
            ResultSI.setValue(0);
            operation = 0;
            Current.setText(String.valueOf(CurrentSI.getValue()));
        }
        catch (IllegalArgumentException e)
        {
            Story.setText("An overflow occurred");
            HistorySI.setValue(0);
            CurrentSI.setValue(0);
            ResultSI.setValue(0);
            operation = 0;
            Current.setText(String.valueOf(CurrentSI.getValue()));
        }

    }

    public void MBack() {
        try {
            SmallInteger TempSI = new SmallInteger(10);
            CurrentSI = CurrentSI.divide(TempSI);
            Current.setText(String.valueOf(CurrentSI.getValue()));
        } catch (IllegalArgumentException e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void MSign() {
        try {
            SmallInteger TempSI = new SmallInteger(-1);
            CurrentSI = CurrentSI.multiply(TempSI);
            Current.setText(String.valueOf(CurrentSI.getValue()));
        } catch (IllegalArgumentException e) {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    public void MCReset() {
        Toolkit.getDefaultToolkit().beep();
        CurrentSI.setValue(0);
        Current.setText(String.valueOf(CurrentSI.getValue()));
    }

    public MyGUI() {

        CurrentSI = new SmallInteger(0);
        HistorySI = new SmallInteger(0);
        ResultSI = new SmallInteger(0);

        MyPanel = new JPanel();
        MyPanel.setLayout(new GridBagLayout());
        MyPanel.setMaximumSize(new Dimension(346, 199));

        GridBagConstraints Const = new GridBagConstraints();
        Const.fill = GridBagConstraints.HORIZONTAL;
        Const.gridwidth = 2;

        Const.gridy = (6);
        Const.gridx = (0);
        Zero = new JButton();
        Zero.setText("0");
        MyPanel.add(Zero,Const);

        Const.gridwidth = 1;
        Const.gridy = (5);
        One = new JButton();
        One.setText("1");
        MyPanel.add(One,Const);

        Const.gridy = (5);
        Const.gridx = (1);
        Two = new JButton();
        Two.setText("2");
        MyPanel.add(Two,Const);

        Const.gridx = (2);
        Three = new JButton();
        Three.setText("3");
        MyPanel.add(Three,Const);

        Const.gridy = (4);
        Const.gridx = (0);
        Four = new JButton();
        Four.setText("4");
        MyPanel.add(Four,Const);

        Const.gridx = (1);
        Five = new JButton();
        Five.setText("5");
        MyPanel.add(Five,Const);

        Const.gridx = (2);
        Six = new JButton();
        Six.setText("6");
        MyPanel.add(Six,Const);

        Const.gridy = (3);
        Const.gridx = (0);
        Seven = new JButton();
        Seven.setText("7");
        MyPanel.add(Seven, Const);

        Const.gridx = (1);
        Eight = new JButton();
        Eight.setText("8");
        MyPanel.add(Eight, Const);

        Const.gridx = (2);
        Nine = new JButton();
        Nine.setText("9");
        MyPanel.add(Nine, Const);

        Const.gridy = (0);
        Const.gridx = (0);
        Const.gridwidth = 4;
        Const.fill = GridBagConstraints.NONE;
        Story = new JLabel();
        Story.setText("Here you will see history.");
        MyPanel.add(Story, Const);

        Const.gridy = (1);
        Const.fill = GridBagConstraints.HORIZONTAL;
        Current = new JTextField();
        Current.setEnabled(false);
        Current.setText("0");
        Current.setDisabledTextColor(new Color(0x000000));
        MyPanel.add(Current, Const);

        Const.gridy = (2);
        Const.gridwidth = 1;
        Backspace = new JButton();
        Backspace.setText("←");
        MyPanel.add(Backspace, Const);

        Const.gridx = (1);
        ResetCurrent = new JButton();
        ResetCurrent.setText("CE");
        MyPanel.add(ResetCurrent, Const);

        Const.gridy = (6);
        Const.gridx = (2);
        Equal = new JButton();
        Equal.setText("=");
        MyPanel.add(Equal, Const);

        Const.gridy = (2);
        Reset = new JButton();
        Reset.setText("C");
        MyPanel.add(Reset, Const);

        Const.gridy = (2);
        Const.gridx = (3);
        Sign = new JButton();
        Sign.setText("±");
        MyPanel.add(Sign, Const);

        Const.gridy = (3);
        Sum = new JButton();
        Sum.setText("+");
        MyPanel.add(Sum,Const);

        Const.gridy = (4);
        Sub = new JButton();
        Sub.setText("-");
        MyPanel.add(Sub, Const);

        Const.gridy = (5);
        Mul = new JButton();
        Mul.setText("*");
        MyPanel.add(Mul, Const);

        Const.gridy = (6);
        Div = new JButton();
        Div.setText("/");
        MyPanel.add(Div, Const);

        Action AСReset = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MCReset();
            }
        };
        ResetCurrent.addActionListener(AСReset);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("DELETE"), "del");
        MyPanel.getActionMap().put("del", AСReset);

        Action ASign = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MSign();
            }
        };
        Sign.addActionListener(ASign);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("INSERT"), "sign");
        MyPanel.getActionMap().put("sign", ASign);

        Action ABack = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MBack();
            }
        };
        Backspace.addActionListener(ABack);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("BACK_SPACE"), "back");
        MyPanel.getActionMap().put("back", ABack);

        Action AReset = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MReset();
            }
        };
        Reset.addActionListener(AReset);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("R"), "pressed");
        MyPanel.getActionMap().put("pressed", AReset);

        Action ASum = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MSum();
            }
        };
        Sum.addActionListener(ASum);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('+'), "+");
        MyPanel.getActionMap().put("+", ASum);

        Action ASub = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MSub();
            }
        };

        Sub.addActionListener(ASub);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('-'), "-");
        MyPanel.getActionMap().put("-", ASub);

        Action AMul = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MMul();
            }
        };
        Mul.addActionListener(AMul);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('*'), "*");
        MyPanel.getActionMap().put("*", AMul);

        Action ADiv = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MDiv();
            }
        };
        Div.addActionListener(ADiv);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('/'), "/");
        MyPanel.getActionMap().put("/", ADiv);

        Action AEq = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MEq();
            }
        };
        Equal.addActionListener(AEq);
        MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "=");
        MyPanel.getActionMap().put("=", AEq);

        JButton[] Numbers = {Zero, One, Two, Three, Four, Five, Six, Seven, Eight, Nine};
        for (int i = 0; i < 10; i++) {
            Action ANumber = new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MNumber(Integer.valueOf(e.getActionCommand()));
                }
            };

            String t = String.valueOf(i);
            Numbers[i].addActionListener(ANumber);
            MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("NUMPAD" + t), t);
            MyPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(t), t);
            MyPanel.getActionMap().put(t, ANumber);
        }
    }

    public void init() {
        JFrame frame = new JFrame("Calculatron Git");
        frame.setContentPane(new MyGUI().MyPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setResizable(false);
    }

}
