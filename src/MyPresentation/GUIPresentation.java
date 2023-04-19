package MyPresentation;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;

public class GUIPresentation extends JFrame {

    private Escucha escucha;
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
        escucha = new Escucha();
        myPhoto = new JButton("my photo");
        myHobby = new JButton("this is my hobby");
        myExpectations = new JButton("click m to view my expectations");
        myExpectations.setFocusable(false);
        containerButtons = new JPanel();
        containerButtons.addKeyListener(escucha);
        containerButtons.setFocusable(true);
        containerIMages = new JPanel();
        containerIMages.addKeyListener(escucha);
        containerIMages.setFocusable(true);
//        listener = new Listener();
        imageLabel = new JLabel();
        expectativesText = new JTextArea(12, 12);

        containerIMages.setBorder(BorderFactory.createTitledBorder(null, "about me",
                TitledBorder.CENTER, TitledBorder.DEFAULT_JUSTIFICATION,
                new Font(Font.MONOSPACED, Font.PLAIN, 20), Color.BLACK));

        containerIMages.add(imageLabel);
        containerButtons.add(myPhoto);
        containerButtons.add(myHobby);

        containerButtons.add(myExpectations);
        myHobby.addMouseListener(escucha);
        myHobby.setFocusable(false);
        myPhoto.addMouseListener(escucha);
        myPhoto.setFocusable(false);
//        myPhoto.addActionListener(listener);
//        myHobby.addActionListener(listener);
//        myExpectations.addActionListener(listener);

        this.add(title, BorderLayout.NORTH);
        this.add(containerButtons, BorderLayout.SOUTH);
        this.add(containerIMages, BorderLayout.CENTER);
    }

    private  JButton myPhoto, myHobby, myExpectations;
    private Title title;
    private JPanel containerButtons, containerIMages;

//    private Listener listener;

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

    /*private class Listener implements ActionListener{
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
            else if(e.getSource() == myHobby && e.c)
            {
                System.out.println("Hobby Button Pressed");
                this.image = new ImageIcon(getClass().getResource("/resources/hobby.jpg"));
                imageLabel.setIcon(this.image);
            }
            revalidate();
            repaint();
        }
    }*/

    /**
     * inner class that extends an Adapter Class or implements Listeners used by GUI class
     */
    private class Escucha implements MouseListener, MouseMotionListener, KeyListener {

        private ImageIcon image;
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            imageLabel.setIcon(null);
            System.out.println("key M is Pressed");
            expectativesText.setText("My expectation is to be an innovative programmer, with extensive scientific knowledge");
            expectativesText.setBackground(null);
            expectativesText.setForeground(Color.black);
            containerIMages.add(expectativesText);
            revalidate();
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1 && e.getSource() == myHobby) {
                System.out.println("Hobby DOUBLIC CLICK BUTTON ACTIVATE");
                this.image = new ImageIcon(getClass().getResource("/resources/hobby.jpg"));
                imageLabel.setIcon(this.image);
            } else if (e.getSource() == myPhoto) {
                System.out.println("Photo Button Pressed");
                this.image = new ImageIcon(getClass().getResource("/resources/foto.jpg"));
                imageLabel.setIcon(this.image);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {


        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {


        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        public void mouseDragged(MouseEvent e) {

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }

    }


}