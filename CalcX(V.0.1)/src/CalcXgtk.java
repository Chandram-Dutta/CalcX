import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;

public class CalcXgtk implements ActionListener{
			
	String s0, s1, s2;
	
	JFrame mainFrame;
	JFrame aboutFrame;
	JFrame themeFrame;
	JLabel titleLabel;
	JLabel creditLabel;
	Font titleFont;
	Font displayFont;
	Font numberFont;
	JTextField displayTextField;
	ImageIcon titleIcon;
	ImageIcon titleButtonIcon;
	JButton titleButton;
	JPopupMenu titlebuttonmenu;
	JMenuItem advancedMenuItem;
	JMenuItem aboutAppMenuItem;
	JMenuItem themeMenuItem;
	JLabel aboutLogoLabel;
	JLabel aboutLabel;
	JButton oneButton;
	JButton twoButton;
	JButton threeButton;
	JButton fourButton;
	JButton fiveButton;
	JButton sixButton;
	JButton sevenButton;
	JButton eightButton;
	JButton nineButton;
	JButton zeroButton;
	JButton equalButton;
	JButton plusButton;
	JButton minusButton;
	JButton divideButton;
	JButton multiplyButton;
	JButton dotButton;
	JButton clrButton;
	JButton delButton;
	JRadioButton gtkRadioButton, winRadioButton;

	int i;

	
	CalcXgtk(){
		titleFont = new Font("Cantarell" ,Font.BOLD, 45);
		displayFont = new Font("SF UI Text Regular" ,Font.ITALIC, 30);
		numberFont  = new Font("SF UI Text Regular" ,Font.BOLD , 52);

		titleIcon = new ImageIcon("/home/chandramdutta/CalcX/Icons/Calc X Logo(48).png");
		titleButtonIcon = new ImageIcon("/home/chandramdutta/CalcX/Icons/title3bars.png");
		
		titlebuttonmenu = new JPopupMenu("Main Menu");
		titlebuttonmenu.setSize(50,55);
		titlebuttonmenu.setBorder(BorderFactory.createLineBorder(Color.black,2));
		
		advancedMenuItem = new JMenuItem("Advanced Mode");
		advancedMenuItem.setSize(50, 15);
		advancedMenuItem.setBorder(BorderFactory.createLineBorder(Color.black,2));

		aboutAppMenuItem = new JMenuItem("About & Credits");
		aboutAppMenuItem.setSize(50, 15);
		aboutAppMenuItem.setBorder(BorderFactory.createLineBorder(Color.black,2));
		aboutAppMenuItem.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				aboutFrame.setVisible(true);
			}  
		});  

		themeMenuItem = new JMenuItem("Change Theme");
		themeMenuItem.setSize(50, 15);
		themeMenuItem.setBorder(BorderFactory.createLineBorder(Color.black,2));
		themeMenuItem.addActionListener(new ActionListener(){  
			@Override
			public void actionPerformed(ActionEvent e) {
				themeFrame.setVisible(true);
			}  
		});  
		
		titlebuttonmenu.add(aboutAppMenuItem);
//		titlebuttonmenu.add(advancedMenuItem);
		titlebuttonmenu.add(themeMenuItem);
		
		
		titleButton = new JButton();
		titleButton.setBounds(358, 8, 35, 35);
//		titleButton.setBorder(BorderFactory.createLineBorder(Color.red,2));
		titleButton.setIcon(titleButtonIcon);
		titleButton.setComponentPopupMenu(titlebuttonmenu);
		titleButton.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                titlebuttonmenu.show(e.getComponent(), e.getX(), e.getY());
            }
        });
		
		
		
		displayTextField = new JTextField();
//		displayTextField.setBackground(Color.black);
//		displayTextField.setForeground(Color.red);
		displayTextField.setBounds(0, 52, 400, 50);
//		displayTextField.setEditable(false);
//		displayTextField.setBorder(BorderFactory.createLineBorder(Color.red,5));
		displayTextField.setFont(displayFont);
		
		titleLabel = new JLabel("CALC X");
//		titleLabel.setBackground(Color.black);
//		titleLabel.setForeground(Color.white);
		titleLabel.setBounds(0, 0, 358, 50);
		titleLabel.setOpaque(true);
		titleLabel.setFont(titleFont);
		titleLabel.setHorizontalAlignment(JLabel.CENTER);
//		titleLabel.setBorder(BorderFactory.createLineBorder(Color.red,5));
		
		creditLabel = new JLabel("DAEDALUS SOFTWARE © 2021                                     V.0.1");
//		creditLabel.setBackground(Color.black);
//		creditLabel.setForeground(Color.red);
		creditLabel.setBounds(0, 635, 400, 20);
		creditLabel.setOpaque(true);
//		creditLabel.setBorder(BorderFactory.createLineBorder(Color.red,1));

		aboutLogoLabel = new JLabel(new ImageIcon("/home/chandramdutta/CalcX/Icons/Calc X Logo(200).png"));
		aboutLogoLabel.setBounds(0, 0, 200, 200);
		
		String s = "<html><p style = \"font-family:SF  UI;font-size:9px;font-style:bold;\">"
				+ "<font color=\"black\"> CALC X<br>THE NEX GEN CALCULATOR<br>"
				+ "DAEDALUS SOFTWARE © 2021<br>Version - 0.1(Dev)(Linux)";
		aboutLabel =new JLabel(s);
		aboutLabel.setBounds(210, 0, 200, 190);

		
		aboutFrame = new JFrame();
		aboutFrame.setLayout(null);
		aboutFrame.setSize(400, 230);
		aboutFrame.setTitle("About Calc X");
		aboutFrame.getContentPane().setBackground(Color.lightGray);
		aboutFrame.setIconImage(titleIcon.getImage());
		aboutFrame.setResizable(false);
		aboutFrame.validate();
        
		aboutFrame.add(aboutLogoLabel);
		aboutFrame.add(aboutLabel);
		
		gtkRadioButton = new JRadioButton("GTK Theme");
		gtkRadioButton.setBounds(25,20,200,100);
		gtkRadioButton.addActionListener(
				  new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	try {
							UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
						} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
								| UnsupportedLookAndFeelException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						SwingUtilities.updateComponentTreeUI(mainFrame);
						SwingUtilities.updateComponentTreeUI(themeFrame);
						SwingUtilities.updateComponentTreeUI(aboutFrame);
				    }
				  }
				);

		gtkRadioButton.setIcon(new ImageIcon("/home/chandramdutta/CalcX/Icons/gnome.png"));
		gtkRadioButton.setSelected(true);

		winRadioButton = new JRadioButton("Windows Theme");
		winRadioButton.setBounds(25, 120, 300, 100);
		winRadioButton.setIcon(new ImageIcon("/home/chandramdutta/CalcX/Icons/windows.png"));
		winRadioButton.addActionListener(
				  new ActionListener() {
				    public void actionPerformed(ActionEvent e) {
				    	try {
						    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						        if ("Nimbus".equals(info.getName())) {
						            UIManager.setLookAndFeel(info.getClassName());
						            UIManager.put("nimbusBase", new Color(i));
						            break;
						        }
						    }
						    
						} catch (Exception el) {
						    // If Nimbus is not available, you can set the GUI to another look and feel.
						}
							SwingUtilities.updateComponentTreeUI(mainFrame);
							SwingUtilities.updateComponentTreeUI(themeFrame);
							SwingUtilities.updateComponentTreeUI(aboutFrame);
							mainFrame.setVisible(true);
							themeFrame.setVisible(true);
						}
				    
				  }
				);
	
		
		ButtonGroup themGroup = new ButtonGroup();    
		themGroup.add(gtkRadioButton);
		themGroup.add(winRadioButton);  
		
		themeFrame = new JFrame();
		themeFrame.setLayout(null);
		themeFrame.setSize(300, 300);
		themeFrame.setTitle("Change Calc X Theme");
		themeFrame.setIconImage(titleIcon.getImage());	
		themeFrame.setResizable(false);
		themeFrame.validate();
		
		themeFrame.add(gtkRadioButton);
		themeFrame.add(winRadioButton);
		
		nineButton = new JButton("9");
		nineButton.setBounds(0, 110, 100, 100);
		nineButton.setFont(numberFont);
		nineButton.setHorizontalAlignment(JLabel.CENTER);
//		nineButton.setBackground(Color.darkGray);
//		nineButton.setForeground(Color.white);
//		nineButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		eightButton = new JButton("8");
		eightButton.setBounds(100, 110, 100, 100);
		eightButton.setFont(numberFont);
		eightButton.setHorizontalAlignment(JLabel.CENTER);
//		eightButton.setBackground(Color.darkGray);
//		eightButton.setForeground(Color.white);
//		eightButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		sevenButton = new JButton("7");
		sevenButton.setBounds(200, 110, 100, 100);
		sevenButton.setFont(numberFont);
		sevenButton.setHorizontalAlignment(JLabel.CENTER);
//		sevenButton.setBackground(Color.darkGray);
//		sevenButton.setForeground(Color.white);
//		sevenButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		plusButton = new JButton("+");
		plusButton.setBounds(300, 110, 100, 100);
		plusButton.setFont(numberFont);
		plusButton.setHorizontalAlignment(JLabel.CENTER);
//		plusButton.setBackground(Color.black);
//		plusButton.setForeground(Color.white);
//		plusButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));
		
		sixButton = new JButton("6");
		sixButton.setBounds(0, 215, 100, 100);
		sixButton.setFont(numberFont);
		sixButton.setHorizontalAlignment(JLabel.CENTER);
//		sixButton.setBackground(Color.darkGray);
//		sixButton.setForeground(Color.white);
//		sixButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		fiveButton = new JButton("5");
		fiveButton.setBounds(100, 215, 100, 100);
		fiveButton.setFont(numberFont);
		fiveButton.setHorizontalAlignment(JLabel.CENTER);
//		fiveButton.setBackground(Color.darkGray);
//		fiveButton.setForeground(Color.white);
//		fiveButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		fourButton = new JButton("4");
		fourButton.setBounds(200, 215, 100, 100);
		fourButton.setFont(numberFont);
		fourButton.setHorizontalAlignment(JLabel.CENTER);
//		fourButton.setBackground(Color.darkGray);
//		fourButton.setForeground(Color.white);
//		fourButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		minusButton = new JButton("-");
		minusButton.setBounds(300, 215, 100, 100);
		minusButton.setFont(numberFont);
		minusButton.setHorizontalAlignment(JLabel.CENTER);
//		minusButton.setBackground(Color.black);
//		minusButton.setForeground(Color.white);
//		minusButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));
		
		threeButton = new JButton("3");
		threeButton.setBounds(0, 320, 100, 100);
		threeButton.setFont(numberFont);
		threeButton.setHorizontalAlignment(JLabel.CENTER);
//		threeButton.setBackground(Color.darkGray);
//		threeButton.setForeground(Color.white);
//		threeButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
//		
		twoButton = new JButton("2");
		twoButton.setBounds(100, 320, 100, 100);
		twoButton.setFont(numberFont);
		twoButton.setHorizontalAlignment(JLabel.CENTER);
//		twoButton.setBackground(Color.darkGray);
//		twoButton.setForeground(Color.white);
//		twoButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		oneButton = new JButton("1");
		oneButton.setBounds(200, 320, 100, 100);
		oneButton.setFont(numberFont);
		oneButton.setHorizontalAlignment(JLabel.CENTER);
//		oneButton.setBackground(Color.darkGray);
//		oneButton.setForeground(Color.white);
//		oneButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		equalButton = new JButton("=");
		equalButton.setBounds(300, 320, 100, 205);
		equalButton.setFont(numberFont);
		equalButton.setHorizontalAlignment(JLabel.CENTER);
//		equalButton.setBackground(Color.black);
//		equalButton.setForeground(Color.white);
//		equalButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));
	

		
		zeroButton = new JButton("0");
		zeroButton.setBounds(100, 425, 100, 100);
		zeroButton.setFont(numberFont);
		zeroButton.setHorizontalAlignment(JLabel.CENTER);
//		zeroButton.setBackground(Color.darkGray);
//		zeroButton.setForeground(Color.white);
//		zeroButtonButton.setBorder(BorderFactory.createLineBorder(Color.red,1));
		
		multiplyButton = new JButton("×");
//		clrButton.setIcon((new ImageIcon("/home/chandramdutta/CalcX/Icons/clr.png")));
		multiplyButton.setBounds(0, 425, 100, 100);
		multiplyButton.setFont(numberFont);
		multiplyButton.setHorizontalAlignment(JLabel.CENTER);
//		clrButton.setBackground(Color.black);
//		clrButton.setForeground(Color.white);
//		clrButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));
		
		divideButton = new JButton("÷");
//		delButton.setIcon((new ImageIcon("/home/chandramdutta/CalcX/Icons/del.png")));
		divideButton.setBounds(200, 425, 100, 100);
		divideButton.setFont(numberFont);
		divideButton.setHorizontalAlignment(JLabel.CENTER);
//		delButton.setBackground(Color.black);
//		delButton.setForeground(Color.white);
//		delButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));
		
		delButton = new JButton("DEL");
		delButton.setBounds(0, 530, 150, 100);
		delButton.setFont(numberFont);
		delButton.setHorizontalAlignment(JLabel.CENTER);
//		multiplyButton.setBackground(Color.black);
//		multiplyButton.setForeground(Color.white);
//		multiplyButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));
	
		clrButton = new JButton("CLR");
		clrButton.setBounds(150, 530, 150, 100);
		clrButton.setFont(numberFont);
		clrButton.setHorizontalAlignment(JLabel.CENTER);
//		divideButton.setBackground(Color.black);
//		divideButton.setForeground(Color.white);
//		divideButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));
		
		dotButton = new JButton(".");
		dotButton.setBounds(300, 530, 100, 100);
		dotButton.setFont(numberFont);
		dotButton.setHorizontalAlignment(JLabel.CENTER);
//		dotButton.setBackground(Color.black);
//		dotButton.setForeground(Color.white);
//		dotButton.setBorder(BorderFactory.createLineBorder(Color.orange,1));

		mainFrame = new JFrame();
		mainFrame.setLayout(null);
		mainFrame.setSize(400, 700);
		if (i==0) {
			i++;
			mainFrame.setVisible(true);
		}
		else 
			mainFrame.setVisible(false);
		mainFrame.setTitle("CALC X - V.0.1(DSC INC. © 2021)");
//		mainFrame.getContentPane().setBackground(Color.black);
		mainFrame.setIconImage(titleIcon.getImage());
		mainFrame.validate();
		mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
       
        
        mainFrame.add(titleLabel);
        mainFrame.add(creditLabel);
        mainFrame.add(displayTextField);
        mainFrame.add(titleButton);
        mainFrame.add(nineButton);
        mainFrame.add(eightButton);
        mainFrame.add(sevenButton);
        mainFrame.add(plusButton);
        mainFrame.add(sixButton);
        mainFrame.add(fiveButton);
        mainFrame.add(fourButton);
        mainFrame.add(minusButton);
        mainFrame.add(threeButton);
        mainFrame.add(twoButton);
        mainFrame.add(oneButton);
        mainFrame.add(equalButton);
        mainFrame.add(multiplyButton);
        mainFrame.add(divideButton);
        mainFrame.add(zeroButton);
        mainFrame.add(clrButton);
        mainFrame.add(delButton);
        mainFrame.add(dotButton);
        
        s0 = s1 = s2 = "";
        
        nineButton.addActionListener(this);
        eightButton.addActionListener(this);
        sevenButton.addActionListener(this);
        sixButton.addActionListener(this);
        fiveButton.addActionListener(this);
        fourButton.addActionListener(this);
        threeButton.addActionListener(this);
        twoButton.addActionListener(this);
        oneButton.addActionListener(this);
        zeroButton.addActionListener(this);
        plusButton.addActionListener(this);
        minusButton.addActionListener(this);
        clrButton.addActionListener(this);
        delButton.addActionListener(this);
        equalButton.addActionListener(this);
        dotButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);


	
	}
	
	
	
	public static void main(String[] arg){
			try {
	            // Set System L&F
	        UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }
		new CalcXgtk();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String s = e.getActionCommand();
		 
        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!s1.equals(""))
                s2 = s2 + s;
            else
                s0 = s0 + s;
 
            // set the value of text
            displayTextField.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'C') {
            // clear the one letter
            s0 = s1 = s2 = "";
 
            // set the value of text
            displayTextField.setText(s0 + s1 + s2);
        }
        else if (s.charAt(0) == 'D') {
            StringBuffer tempString= new StringBuffer(s0 + s1 + s2); 
            tempString.deleteCharAt(tempString.length()-1);  
            String str = tempString.toString();            // set the value of text
            displayTextField.setText(str);
            s0 = str;
            s = str;
        }
        else if (s.charAt(0) == '=') {
 
            double te;
 
            // store the value in 1st
            if (s1.equals("+"))
                te = (Double.parseDouble(s0) + Double.parseDouble(s2));
            else if (s1.equals("-"))
                te = (Double.parseDouble(s0) - Double.parseDouble(s2));
            else if (s1.equals("/"))
                te = (Double.parseDouble(s0) / Double.parseDouble(s2));
            else
                te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
            // set the value of text
            displayTextField.setText(s0 + s1 + s2 + "=" + te);
 
            // convert it to string
            s0 = Double.toString(te);
 
            s1 = s2 = "";
        }
        else {
            // if there was no operand
            if (s1.equals("") || s2.equals(""))
                s1 = s;
            // else evaluate
            else {
                double te;
 
                // store the value in 1st
                if (s1.equals("+"))
                    te = (Double.parseDouble(s0) + Double.parseDouble(s2));
                else if (s1.equals("-"))
                    te = (Double.parseDouble(s0) - Double.parseDouble(s2));
                else if (s1.equals("/"))
                    te = (Double.parseDouble(s0) / Double.parseDouble(s2));
                else
                    te = (Double.parseDouble(s0) * Double.parseDouble(s2));
 
                // convert it to string
                s0 = Double.toString(te);
 
                // place the operator
                s1 = s;
 
                // make the operand blank
                s2 = "";
            }
 
            // set the value of text
            displayTextField.setText(s0 + s1 + s2);
        }
		
	}

	
}
