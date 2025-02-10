import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

class imageEditor {
	private JFrame startFrame;
	private JLabel welcomeText;
	public ImageIcon icon;
	public JLabel pixelCol;
	public BufferedImage im;
	public BufferedImage tempIm;
	public JButton daisyButton;
	public JTextField xCoord;
	public JTextField yCoord;
	public JButton change;
	public JButton highlight;
	public JButton zoom;
	public JButton edge;
    public JButton rotate;
	public JFrame f;
	public JPanel p;
	public JLabel lab;
	public JButton resetButton;

	public imageEditor() {
		startFrame = new JFrame("Image Example");
		startFrame.setSize(1200, 400);
		welcomeText = new JLabel("Welcome to the Image Example", JLabel.CENTER);
		welcomeText.setBounds(100, 50, 200, 40);

		startFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent){
                System.exit(0);
            }        
        });

        startFrame.add(welcomeText);
        startFrame.setLayout(null);
       

        daisyButton = new JButton("daisy!");
        daisyButton.setActionCommand("DAISY");
        daisyButton.addActionListener(new ButtonClickListener());
        daisyButton.setBounds(50, 150, 100, 40);
        startFrame.add(daisyButton);

        pixelCol = new JLabel("");
        pixelCol.setBounds(100, 20, 250, 40);
        startFrame.add(pixelCol);


        change = new JButton("contrast");
        change.setActionCommand("CONTRAST");
        change.addActionListener(new ButtonClickListener());
        change.setBounds(100, 270, 100, 30);
        startFrame.add(change);

        highlight = new JButton("highlight");
        highlight.setActionCommand("HIGHLIGHT");
        highlight.addActionListener(new ButtonClickListener());
        highlight.setBounds(260, 270, 100, 30);
        startFrame.add(highlight);

        edge = new JButton("edge");
        edge.setActionCommand("EDGE");
        edge.addActionListener(new ButtonClickListener());
        edge.setBounds(360, 270, 100, 30);
        startFrame.add(edge);

        rotate = new JButton("rotate");
        rotate.setActionCommand("ROTATE");
        rotate.addActionListener(new ButtonClickListener());
        rotate.setBounds(560, 270, 100, 30);
        startFrame.add(rotate);

        zoom = new JButton("zoom");
        zoom.setActionCommand("ZOOM");
        zoom.addActionListener(new ButtonClickListener());
        zoom.setBounds(460, 270, 100, 30);
        startFrame.add(zoom);

        resetButton = new JButton("reset");
        resetButton.setActionCommand("RESET");
        resetButton.addActionListener(new ButtonClickListener());
        resetButton.setBounds(200, 270, 60, 30);
        startFrame.add(resetButton);


        icon = new ImageIcon("Two.jpeg");
        try {
        	im = ImageIO.read(new File("Two.jpeg"));
        	tempIm = ImageIO.read(new File("Two.jpeg"));
        }
        catch(IOException e) {
        	System.out.println("Error reading image: " + e.getMessage());
        }

        f = new JFrame();
		p = new JPanel();
		lab = new JLabel(icon);

        startFrame.setVisible(true);
	}

	public static void main(String[] args) {
		imageEditor mWin = new imageEditor();
	}

	private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();  
         
            if(command.equals("DAISY"))  {
				f.add(p);
				p.add(lab);
				f.pack();
				f.setVisible(true);
         	} 

            if(command.equals("RESET"))  {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

 						im.setRGB(i, j, tempIm.getRGB(i,j));

 					}

 				}
 			icon = new ImageIcon(im);
         	lab.setIcon(icon);
         	lab.repaint();
         
         	
        } 
         	

         	if (command.equals("CONTRAST")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0xFF0000) >> 16;
         				int g = (rgb & 0x00FF00) >> 8;
         				int b = rgb & 0x000000FF;

                        int sum = r + g + b;

                        if (sum>383) {

                            r= r + 10;
                            g = g + 10;
                            b = b + 10;
                        }
                        else{

                            r= r - 10;
                            g = g - 10;
                            b = b - 10;

                        }

         				if (r > 255){
         					r = 255;
         				}

         				if (g > 255){
         					g = 255;
         				}
         				if (b > 255){
         					b = 255;
         				}

         				if (r < 0){
         					r = 0;
         				}

         				if (g < 0){
         					g = 0;
         				}
         				if (b < 0){
         					b = 0;
         				}

         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
 						im.setRGB(i, j, col);
         			}
         		}
         	}

    

            if (command.equals("HIGHLIGHT")) {
         		int width = im.getWidth();
         		int height = im.getHeight();
         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int average = 0;

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0xFF0000) >> 16;
         				int g = (rgb & 0x00FF00) >> 8;
         				int b = rgb & 0x000000FF;
         				
         				if (r < 150 || g > 150 || b > 150){
         					average = r + g + b;
         					average = average / 3;
         					r = average;
         					g = average;
         					b = average;

         					}

         					int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
 							im.setRGB(i, j, col);


         				}


         			}

                }
         			
         		

         	if (command.equals("ZOOM")) {
                int width = im.getWidth();
                int height = im.getHeight();

                ArrayList<Integer> redArray = new ArrayList();
                ArrayList<Integer> blueArray = new ArrayList();
                ArrayList<Integer> greenArray = new ArrayList();


                for (int i = 0; i < width; i++) {
                    for (int j = 0; j < height; j++) {

                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0xFF0000) >> 16;
                        int g = (rgb & 0x00FF00) >> 8;
                        int b = rgb & 0x000000FF;

                        redArray.add(r); 
                        greenArray.add(g); 
                        blueArray.add(b); 
                    }

                }
                    BufferedImage newIm = new BufferedImage(width, height, im.getType());

                    int startX = width / 4;
                    int startY = height / 4;
                    int regionWidth = width / 2;
                    int regionHeight = height / 2;

                    for (int x = 0; x < regionWidth; x++) {
                        for (int y = 0; y < regionHeight; y++) {

                            int oldX = startX + x;
                            int oldY = startY + y;

                            int index = oldX * height + oldY;


                            int r = redArray.get(index);
                            int g = greenArray.get(index);
                            int b = blueArray.get(index);
                            int color = (0xFF << 24) | (r << 16) | (g << 8) | b;


                            int newX = 2 * x;
                            int newY = 2 * y;

                            newIm.setRGB(newX, newY, color);
                            newIm.setRGB(newX + 1, newY, color);
                            newIm.setRGB(newX, newY + 1, color);
                            newIm.setRGB(newX + 1, newY + 1, color);

                        }

                            im = newIm;
                            icon = new ImageIcon(im);
                            lab.setIcon(icon);
                            lab.repaint();
                   }


             }

   
   	          if (command.equals("ROTATE")) {
         		int width = im.getWidth();
         		int height = im.getHeight();

         		ArrayList<Integer> redArray = new ArrayList();
         		ArrayList<Integer> blueArray = new ArrayList();
         		ArrayList<Integer> greenArray = new ArrayList();


         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int rgb = im.getRGB(i,j);
         				int r = (rgb & 0xFF0000) >> 16;
         				int g = (rgb & 0x00FF00) >> 8;
         				int b = rgb & 0x000000FF;

         				redArray.add(r); 
         				greenArray.add(g); 
         				blueArray.add(b); 
         			}

         		}

         		int count = redArray.size() -1;

         		for (int i = 0; i < width; i++) {
         			for (int j = 0; j < height; j++) {

         				int r =  redArray.get(count);
         				int g =  greenArray.get(count);
         				int b =  blueArray.get(count);

         			
         				int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
 						im.setRGB(i, j, col);


 						count = count - 1; 






         				}
         			}


         		}

                if (command.equals("EDGE")) {
                int width = im.getWidth();
                int height = im.getHeight();

                for (int i = 0; i < width-1; i++) {
                    for (int j = 0; j < height; j++) {

                        int sum = 0;
                        int sum1 = 0;

                        int rgb = im.getRGB(i,j);
                        int r = (rgb & 0xFF0000) >> 16;
                        int g = (rgb & 0x00FF00) >> 8;
                        int b = rgb & 0x000000FF;

                        sum = r + g + b;

                        int rgb1 = im.getRGB((i+1),(j));
                        int r1 = (rgb1 & 0xFF0000) >> 16;
                        int g1 = (rgb1 & 0x00FF00) >> 8;
                        int b1 = rgb1 & 0x000000FF;

                        sum1 = r1 + g1 +b1;


                        if(Math.abs(sum - sum1) < 20){

                            r = 255;
                            g = 255;
                            b = 255;


                        } else {

                            r=0;
                            g = 0;
                            b = 0;
                        }


                        int col = (0xFF << 24) | (r << 16) | (g << 8) | b;
                        im.setRGB(i, j, col);


                    }
                }

            }


      	
				icon = new ImageIcon(im);
         		lab.setIcon(icon);
         		lab.repaint();


   	
         	}

        }

    }
      


   

