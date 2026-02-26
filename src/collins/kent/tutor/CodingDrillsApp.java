package collins.kent.tutor;

import collins.kent.tutor.arithmetic.DoubleAdditionProblem;
import collins.kent.tutor.arithmetic.DoubleDivisionProblem;
import collins.kent.tutor.arithmetic.IntegerAdditionProblem;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;

public class CodingDrillsApp extends JFrame {

    private JTree problemTree;
    private DefaultMutableTreeNode root;
    private JTextArea questionArea;
    private JTextField responseField;
    private JButton submitButton;
    private JButton nextButton;
    private ArrayList<Problem> problems;
    private int currentProblemIndex;
    private Random random;

    public CodingDrillsApp() {
        // Initialize components
        root = new DefaultMutableTreeNode("Select Problem Types");
        problemTree = new JTree(root);
        problemTree.setRootVisible(false);

        // Add problem types to the tree
        addProblemTypes();

        // Create GUI components
        questionArea = new JTextArea(10, 30);
        responseField = new JTextField(20);
        submitButton = new JButton("Submit");
        nextButton = new JButton("Next");

        // Layout components
        JPanel treePanel = new JPanel();
        treePanel.add(new JScrollPane(problemTree));

        JPanel questionPanel = new JPanel();
        questionPanel.add(new JScrollPane(questionArea));

        JPanel responsePanel = new JPanel();
        responsePanel.add(responseField);
        responsePanel.add(submitButton);
        responsePanel.add(nextButton);

        // Add action listeners
        submitButton.addActionListener(new SubmitActionListener());
        nextButton.addActionListener(new NextActionListener());
        responseField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    submitButton.doClick(); // Simulate the submit button click
                }
            }
        });

        // Set up frame
        add(treePanel, BorderLayout.WEST);
        add(questionPanel, BorderLayout.CENTER);
        add(responsePanel, BorderLayout.SOUTH);

        // Initialize problem list and random generator
        problems = new ArrayList<>();
        random = new Random();
    }

    private void addProblemTypes() {
        // Example: Adding some problem types
        DefaultMutableTreeNode arithmetic = new DefaultMutableTreeNode("Arithmetic");
        root.add(arithmetic);
        arithmetic.add(new DefaultMutableTreeNode("Double Addition"));
        arithmetic.add(new DefaultMutableTreeNode("Double Division"));
        arithmetic.add(new DefaultMutableTreeNode("Integer Addition"));
        // Add more problem types as needed
    }

    private class SubmitActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentProblemIndex < problems.size()) {
                Problem currentProblem = problems.get(currentProblemIndex);
                String response = responseField.getText();
                if (currentProblem.isCorrect(response)) {
                    JOptionPane.showMessageDialog(CodingDrillsApp.this, "Correct!");
                } else {
                    JOptionPane.showMessageDialog(CodingDrillsApp.this, "Incorrect: " + currentProblem.getFeedback(response));
                }
            }
        }
    }

    private class NextActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (currentProblemIndex < problems.size()) {
                currentProblemIndex++;
                if (currentProblemIndex < problems.size()) {
                    Problem nextProblem = problems.get(currentProblemIndex);
                    questionArea.setText(nextProblem.getStatement());
                    responseField.setText("");
                } else {
                    JOptionPane.showMessageDialog(CodingDrillsApp.this, "No more questions.");
                }
            }
        }
    }

    public void generateProblems() {
        // Example: Generate problems based on selected types
        // For simplicity, let's assume we generate all types
        for (int i = 0; i < 3; i++) {
            problems.add(new DoubleAdditionProblem().generate(random));
            problems.add(new DoubleDivisionProblem().generate(random));
            problems.add(new IntegerAdditionProblem().generate(random));
            // Add more problem types as needed
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CodingDrillsApp app = new CodingDrillsApp();
            app.generateProblems();
            app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            app.pack();
            app.setVisible(true);
        });
    }
}