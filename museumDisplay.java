import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



class museumDisplay{
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;



	private JFrame startFrame;
	private JLabel welcomeText;

	public museumDisplay() {
		startFrame = new JFrame("Image Example");
		startFrame.setSize(800, 300);
		startFrame.setLayout(null);

		welcomeText = new JLabel("Welcome to the Image Example", JLabel.CENTER);

		startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

        startFrame.add(welcomeText);
        

        JButton oneButton = new JButton("one");
        oneButton.setActionCommand("ONE");
        oneButton.addActionListener(new ButtonClickListener());
        oneButton.setBounds(50, 150, 100, 40);
        startFrame.add(oneButton);

        JButton twoButton = new JButton("two");
        twoButton.setActionCommand("TWO");
        twoButton.addActionListener(new ButtonClickListener());
        twoButton.setBounds(200, 150, 100, 40);
        startFrame.add(twoButton);

        JButton threeButton = new JButton("three");
        threeButton.setActionCommand("THREE");
        threeButton.addActionListener(new ButtonClickListener());
        threeButton.setBounds(350, 150, 100, 40);
        startFrame.add(threeButton);

        JButton fourButton = new JButton("four");
        fourButton.setActionCommand("FOUR");
        fourButton.addActionListener(new ButtonClickListener());
        fourButton.setBounds(500, 150, 100, 40);
        startFrame.add(fourButton);

        JButton fiveButton = new JButton("five");
        fiveButton.setActionCommand("FIVE");
        fiveButton.addActionListener(new ButtonClickListener());
        fiveButton.setBounds(650, 150, 100, 40);
        startFrame.add(fiveButton);
        startFrame.setVisible(true);
	}

	public static void main(String[] args) {
		museumDisplay mWin = new museumDisplay();


	}

	 private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
         
            if(command.equals("ONE"))  {

            JFrame f = new JFrame();
			JPanel p = new JPanel();
			ImageIcon icon = new ImageIcon("One.jpeg");
			JLabel lab = new JLabel(icon);
			f.add(p);
			p.add(lab);
			f.pack();
			f.setVisible(true);

               
            } else if(command.equals("TWO"))  {

            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("two.jpeg");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				f.setVisible(true);

			} else if(command.equals("THREE"))  {

            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("Three.JPG");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				f.setVisible(true);


			} else if(command.equals("FOUR"))  {

            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("Four.jpeg");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				f.setVisible(true);


			} else if(command.equals("FIVE"))  {

            	JFrame f = new JFrame();
				JPanel p = new JPanel();
				ImageIcon icon = new ImageIcon("Five.jpeg");
				JLabel lab = new JLabel(icon);
				f.add(p);
				p.add(lab);
				f.pack();
				f.setVisible(true);


            } 
      }     

	}
}
