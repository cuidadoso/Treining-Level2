package demoswing3;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import javax.swing.border.*;
import javax.swing.plaf.metal.*;

public class MyCalcFrame extends JFrame {

	private JPanel jContentPane = null;
	private JPanel screenPanel = null;
	private JPanel otherPanel = null;
	private JPanel decorPanel = null;
	private JLabel screenLabel = null;
	private JPanel cbPanel = null;
	private JMenuBar cMenuBar = null;
	private JMenu lfMenu = null;
	private JMenuItem wsMenuItem = null;
	private JMenuItem motifsMenuItem = null;
	private JMenuItem metalsMenuItem = null;
	private JPanel operPanel = null;
	private JPanel numPanel = null;
        
        private static Font boldFont = new Font("Dialog", Font.BOLD, 18);

	private JButton clearButton = new JButton("C");
	private JButton backspaceButton = new JButton("Backspace");
	private JButton addButton = new JButton("+");
	private JButton subButton = new JButton("-");
	private JButton mulButton = new JButton("*");
	private JButton divButton = new JButton("/");
	private JButton equalButton = new JButton("=");
	private JButton oneButton = new JButton("1");
	private JButton twoButton = new JButton("2");
	private JButton threeButton = new JButton("3");
	private JButton fourButton = new JButton("4");
	private JButton fiveButton = new JButton("5");
	private JButton sixButton = new JButton("6");
	private JButton sevenButton = new JButton("7");
	private JButton eightButton = new JButton("8");
	private JButton nineButton = new JButton("9");
	private JButton zeroButton = new JButton("0");
	private JButton signButton = new JButton("+/-");
	private JButton sepButton = new JButton(",");

	public MyCalcFrame() {
		super();
		initialize();
	}
	public JLabel getCalcScreen () {
		return screenLabel;
	}
	private void initialize() {
		this.setContentPane(getJContentPane());
		this.setJMenuBar(getCMenuBar());
		this.setTitle("Калькулятор");
		this.setName("myFrame");
		this.setBounds(new Rectangle(0, 0, 300, 450));
                this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getScreenPanel(), BorderLayout.NORTH);
			jContentPane.add(getOtherPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	private JPanel getScreenPanel() {
		if (screenPanel == null) {
			screenPanel = new JPanel();
			screenPanel.setLayout(new FlowLayout());
			screenPanel.setPreferredSize(new Dimension(40, 40));
			screenPanel.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
			screenPanel.add(getDecorPanel(), null);
		}
		return screenPanel;
	}
	private JPanel getOtherPanel() {
		if (otherPanel == null) {
			otherPanel = new JPanel();
			otherPanel.setLayout(new BorderLayout());
			otherPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
			otherPanel.add(getCbPanel(), BorderLayout.NORTH);
			otherPanel.add(getOperPanel(), BorderLayout.EAST);
			otherPanel.add(getNumPanel(), BorderLayout.CENTER);
		}
		return otherPanel;
	}
	private JPanel getDecorPanel() {
		if (decorPanel == null) {
			screenLabel = new JLabel();
			screenLabel.setText("0");
			screenLabel.setHorizontalTextPosition(SwingConstants.RIGHT);
			screenLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			screenLabel.setBackground(Color.white);
			screenLabel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			screenLabel.setFont(new Font("Dialog", Font.BOLD, 14));
			screenLabel.setName("scrLabel");

			decorPanel = new JPanel();
			decorPanel.setLayout(new BorderLayout());
			decorPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			decorPanel.setPreferredSize(new Dimension(270, 28));
			decorPanel.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
			decorPanel.add(screenLabel, BorderLayout.CENTER);
		}
		return decorPanel;
	}
	private JPanel getCbPanel() {
		if (cbPanel == null) {
			cbPanel = new JPanel();
			cbPanel.setLayout(new FlowLayout());
			cbPanel.setPreferredSize(new Dimension(0, 60));
			cbPanel.setName("servPanel");
			cbPanel.add(getClearButton(), null);
			cbPanel.add(getBackspaceButton(), null);
		}
		return cbPanel;
	}
	private JMenuBar getCMenuBar() {
		if (cMenuBar == null) {
			cMenuBar = new JMenuBar();
			cMenuBar.add(getLfMenu());
		}
		return cMenuBar;
	}
	private JMenu getLfMenu() {
		if (lfMenu == null) {
			lfMenu = new JMenu();
			lfMenu.setActionCommand("LookAndFeel");
			lfMenu.setText("Look & Feel");
			lfMenu.add(getWsMenuItem());
			lfMenu.add(getMotifsMenuItem());
			lfMenu.add(getMetalsMenuItem());
		}
		return lfMenu;
	}
	private JMenuItem getWsMenuItem() {
		if (wsMenuItem == null) {
			wsMenuItem = new JMenuItem();
			wsMenuItem.setText("Windows");
			wsMenuItem.setName("wsMI");
			wsMenuItem.setActionCommand("WindowsStyle");
			wsMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
						SwingUtilities.updateComponentTreeUI(MyApplication.frame);
					} 
					catch (Exception excep) { excep.printStackTrace(); }	
				}
			});
		}
		return wsMenuItem;
	}
	private JMenuItem getMotifsMenuItem() {
		if (motifsMenuItem == null) {
			motifsMenuItem = new JMenuItem();
			motifsMenuItem.setActionCommand("MotifStyle");
			motifsMenuItem.setName("motifsMI");
			motifsMenuItem.setText("Motif");
			motifsMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					try {
						UIManager.setLookAndFeel(new MotifLookAndFeel());
						SwingUtilities.updateComponentTreeUI(MyApplication.frame);
					} 
					catch (Exception excep) { excep.printStackTrace(); }	
				}
			});
		}
		return motifsMenuItem;
	}
	private JMenuItem getMetalsMenuItem() {
		if (metalsMenuItem == null) {
			metalsMenuItem = new JMenuItem();
			metalsMenuItem.setActionCommand("MetalStyle");
			metalsMenuItem.setText("Metal");
			metalsMenuItem.setName("metalsMI");
			metalsMenuItem.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
                                        try {
						UIManager.setLookAndFeel(new MetalLookAndFeel());
						SwingUtilities.updateComponentTreeUI(MyApplication.frame);
					} 
					catch (Exception excep) { excep.printStackTrace(); }	
				}
			});
		}
		return metalsMenuItem;
	}
	private JPanel getOperPanel() {
		if (operPanel == null) {
			GridLayout gridLayout = new GridLayout();
			gridLayout.setRows(5);
			gridLayout.setVgap(4);
			gridLayout.setHgap(4);
			gridLayout.setColumns(1);
			operPanel = new JPanel();
			operPanel.setLayout(gridLayout);
			operPanel.setPreferredSize(new Dimension(60, 0));
			operPanel.add(getAddButton(), null);
			operPanel.add(getSubButton(), null);
			operPanel.add(getDivButton(), null);
			operPanel.add(getMulButton(), null);
			operPanel.add(getEqualjButton(), null);
		}
		return operPanel;
	}
	private JPanel getNumPanel() {
		if (numPanel == null) {
			GridLayout gridLayout1 = new GridLayout();
			gridLayout1.setRows(4);
			gridLayout1.setHgap(10);
			gridLayout1.setVgap(10);
			gridLayout1.setColumns(3);
			numPanel = new JPanel();
			numPanel.setName("numPanel");
			numPanel.setLayout(gridLayout1);
			numPanel.add(getOneButton(), null);
			numPanel.add(getTwoButton(), null);
			numPanel.add(getThreeButton(), null);
			numPanel.add(getFourButton(), null);
			numPanel.add(getFiveButton(), null);
			numPanel.add(getSixButton(), null);
			numPanel.add(getSevenButton(), null);
			numPanel.add(getEightButton(), null);
			numPanel.add(getNineButton(), null);
			numPanel.add(getZeroButton(), null);
			numPanel.add(getSignButton(), null);
			numPanel.add(getSepButton(), null);
		}
		return numPanel;
	}

	private JButton getClearButton() {
                        clearButton.setMnemonic(KeyEvent.VK_C);
			clearButton.setPreferredSize(new Dimension(50, 50));
			clearButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MyEvaluation.sendPressedKey('C');
				}
			});
		return clearButton;
	}
	private JButton getBackspaceButton() {
                        backspaceButton.setMnemonic(KeyEvent.VK_B);
			backspaceButton.setPreferredSize(new Dimension(150, 50));
			backspaceButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					MyEvaluation.sendPressedKey('B');
				}
			});
		return backspaceButton;
	}
	private JButton getAddButton() {
			addButton.setFont(boldFont);
                        addButton.setMnemonic(KeyEvent.VK_ADD);
		return addButton;
	}
	private JButton getSubButton() {
			subButton.setFont(boldFont);
                        subButton.setMnemonic(KeyEvent.VK_MINUS);
		return subButton;
	}
	private JButton getMulButton() {
			mulButton.setFont(boldFont);
                        mulButton.setMnemonic(KeyEvent.VK_MULTIPLY);
		return mulButton;
	}
	private JButton getDivButton() {
			divButton.setFont(boldFont);
                        divButton.setMnemonic(KeyEvent.VK_SEMICOLON);
		return divButton;
	}
	private JButton getEqualjButton() {
			equalButton.setFont(boldFont);
                        equalButton.setMnemonic(KeyEvent.VK_EQUALS);
		return equalButton;
	}
	private JButton getOneButton() {
			oneButton.setFont(boldFont);
			oneButton.setMnemonic(KeyEvent.VK_1);
			oneButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
 					MyEvaluation.sendPressedKey('1');
				}
			});
		return oneButton;
	}
	private JButton getTwoButton() {
			twoButton.setFont(boldFont);
			twoButton.setMnemonic(KeyEvent.VK_2);
                        twoButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
 					MyEvaluation.sendPressedKey('2');
                                }
                        });
		return twoButton;
	}
	private JButton getThreeButton() {
			threeButton.setFont(boldFont);
			threeButton.setMnemonic(KeyEvent.VK_3);
		return threeButton;
	}
	private JButton getFourButton() {
			fourButton.setFont(boldFont);
                        fourButton.setMnemonic(KeyEvent.VK_4);
		return fourButton;
	}
	private JButton getFiveButton() {
			fiveButton.setFont(boldFont);
                        fiveButton.setMnemonic(KeyEvent.VK_5);
		return fiveButton;
	}
	private JButton getSixButton() {
			sixButton.setFont(boldFont);
			sixButton.setMnemonic(KeyEvent.VK_6);
		return sixButton;
	}
	private JButton getSevenButton() {
			sevenButton.setFont(boldFont);
                        sevenButton.setMnemonic(KeyEvent.VK_7);
		return sevenButton;
	}
	private JButton getEightButton() {
			eightButton.setFont(boldFont);
                        eightButton.setMnemonic(KeyEvent.VK_8);
		return eightButton;
	}
	private JButton getNineButton() {
			nineButton.setFont(boldFont);
                        nineButton.setMnemonic(KeyEvent.VK_9);
		return nineButton;
	}
	private JButton getZeroButton() {
			zeroButton.setFont(boldFont);
                        zeroButton.setMnemonic(KeyEvent.VK_0);
		return zeroButton;
	}
	private JButton getSignButton() {
			signButton.setFont(boldFont);
                        signButton.setMnemonic(KeyEvent.VK_NUMBER_SIGN);
		return signButton;
	}
	private JButton getSepButton() {
			sepButton.setFont(boldFont);
                        sepButton.setMnemonic(KeyEvent.VK_COMMA);
		return sepButton;
	}
}
