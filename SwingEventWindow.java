package gui_swing_events;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;

public class SwingEventWindow extends JFrame implements ActionListener, ItemListener {

    private int rdoChecked = 1;

    private JTextField txtNum;
    private JTextField txtResult;
    private JButton btnCalculate;
    private JRadioButton rdoTotal;
    private JRadioButton rdoAverage;
    private JRadioButton rdoMax;
    private JRadioButton rdoMin;
    private ButtonGroup radioGroup;

    public SwingEventWindow() {

        super("Your Window Title");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        txtNum = new JTextField(20);
        txtResult = new JTextField(20);
        btnCalculate = new JButton("Calculate");
        rdoTotal = new JRadioButton("Auto Sum");
        rdoAverage = new JRadioButton("Average");
        rdoMax = new JRadioButton("Maximum");
        rdoMin = new JRadioButton("Minimum");

        radioGroup = new ButtonGroup();
        radioGroup.add(rdoTotal);
        radioGroup.add(rdoAverage);
        radioGroup.add(rdoMax);
        radioGroup.add(rdoMin);

        rdoTotal.addItemListener(this);
        rdoAverage.addItemListener(this);
        rdoMax.addItemListener(this);
        rdoMin.addItemListener(this);
        btnCalculate.addActionListener(this);

        JPanel mainPanel = new JPanel(new GridLayout(6, 1));
        mainPanel.add(new JLabel("Excel Functions"));
        mainPanel.add(new JLabel("Enter your numbers separated by spaces"));
        mainPanel.add(txtNum);

        JPanel radioPanel = new JPanel(new GridLayout(1, 4));
        radioPanel.add(rdoTotal);
        radioPanel.add(rdoAverage);
        radioPanel.add(rdoMax);
        radioPanel.add(rdoMin);

        mainPanel.add(radioPanel);
        mainPanel.add(btnCalculate);

        JPanel resultPanel = new JPanel(new BorderLayout());
        resultPanel.add(new JLabel("Result:"), BorderLayout.WEST);
        resultPanel.add(txtResult, BorderLayout.CENTER);

        mainPanel.add(resultPanel);
        add(mainPanel);

        getContentPane().setBackground(Color.lightGray);

        setVisible(true);
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getSource() == rdoTotal) {
            rdoChecked = 1;
        } else if (e.getSource() == rdoAverage) {
            rdoChecked = 2;
        } else if (e.getSource() == rdoMax) {
            rdoChecked = 3;
        } else if (e.getSource() == rdoMin) {
            rdoChecked = 4;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userInput = txtNum.getText();

        Excel excelObject = new Excel(userInput);

        switch (rdoChecked) {
            case 1:
                txtResult.setText(String.valueOf(excelObject.findTotal()));
                break;
            case 2:
                txtResult.setText(String.valueOf(excelObject.findAvg()));
                break;
            case 3:
                txtResult.setText(String.valueOf(excelObject.findMax()));
                break;
            case 4:
                txtResult.setText(String.valueOf(excelObject.findMin()));
                break;
        }
    }

}
