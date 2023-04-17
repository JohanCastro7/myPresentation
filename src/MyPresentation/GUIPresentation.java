package MyPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUIPresentation extends JFrame {
    public GUIPresentation(){
        initGUI();
        this.setTitle("My presentation");
        this.setSize(600, 400);
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initGUI() {
        title = new Title("Johan presentation", Color.gray);
        myPhoto = new JButton("my photo");
        myHobby = new JButton("this ismy hobby");
        myExpectations = new JButton("this are my expectations");
        containerButtons = new JPanel();
        containerIMages = new JPanel();
        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(12, 12);

        containerIMages.setBorder(BorderFactory.createTitledBorder(null, "about me",
                TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,
                new Font(Font.MONOSPACED, Font.PLAIN, 20), Color.BLACK));

        containerIMages.add(imageLabel);
        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);

        containerButtons.add(myExpectations);
        myPhoto.addActionListener(listener);
        myHobby.addActionListener(listener);
        myExpectations.addActionListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerIMages, BorderLayout.CENTER);
    }

    private  JButton myPhoto, myHobby, myExpectations;
    private Title title;
    private JPanel containerButtons, containerIMages;

    private Listener listener;

    private JLabel imageLabel;

    private JTextArea expectativesText;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run(){
                GUIPresentation myGui = new GUIPresentation();
            }
        });
    }

    private class Listener implements ActionListener{
        private ImageIcon image;
        @Override
        public void actionPerformed(ActionEvent e){
            imageLabel.setIcon(null);
            if(e.getSource() == myPhoto)
            {
                System.out.println("Photo Button Pressed");
                this.image = new ImageIcon(getClass().getResource("/resources/foto.jpg"));
                imageLabel.setIcon(this.image);
            }
            else if(e.getSource() == myHobby)
            {
                System.out.println("Hobby Button Pressed");
                this.image = new ImageIcon(getClass().getResource("/resources/hobby.jpg"));
                imageLabel.setIcon(this.image);
            }
            else if(e.getSource() == myExpectations)
            {
                System.out.println("Expectations Button Pressed");
                expectativesText.setText("My expectation is to be an innovative programmer, with extensive scientific knowledge");
                expectativesText.setBackground(null);
                expectativesText.setForeground(Color.black);
                containerIMages.add(expectativesText);
            }
            revalidate();
            repaint();
        }
    }


}