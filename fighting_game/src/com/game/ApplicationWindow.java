package com.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class ApplicationWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2151022639739728226L;
	private boolean tripled = false;   //
	private JFrame frame;
	private JFrame playerSetting;
	private JFrame openging;
	private JProgressBar HP1;
	private JProgressBar HP2;
	private JLabel labelHP_1;
	private JLabel labelHP_2;
	private JLabel labelFire;
	private JLabel show1;
	private JLabel show2;
	private Character player;
	private Opponents opponent;
	private int nHP1;
	private int nHP2;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.openging.setVisible(true);
					window.playerSetting.setVisible(false);
					window.frame.setVisible(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor. Create the application.
	 */
	public ApplicationWindow() {
		initialize();  //loading UI
	}

	/**
	 * first loading Interface -> progressBar
	 */
	
	private void firstLoading(){
		//Loading UI
		openging = new JFrame();
		openging.setBounds(100, 100, 450, 355);
		openging.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		openging.getContentPane().setLayout(null);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(155, 146, 146, 14);
		openging.getContentPane().add(progressBar);
        
        JLabel lblLoading = new JLabel("Loading...");
        lblLoading.setBounds(191, 121, 64, 14);
        openging.getContentPane().add(lblLoading);
		        
		progressBar.setStringPainted(true);
	    progressBar.setIndeterminate(false);
	    
		Random random = new Random();
       Thread th = new Thread(new Runnable() {
        	int progress = 0;
			@Override
			public void run() {
				   while (progress < 100) {
		                progress += random.nextInt(15);
		                progressBar.setValue(progress);
		                try {
		                    Thread.sleep(random.nextInt(800)); // thread randomly slept
		                } catch (InterruptedException ignore) {
		                }finally{
		                	if (progress>=100){ // progress bar finished
		                		openging.setVisible(false);
		                		playerSetting.setVisible(true);
		                	}
		                }
		            }
			}

		});

		th.start();// Thread started
	}
	
	 
	/**
	 * Initialize the contents of the UI.
	 */
	private void initialize() {
        firstLoading();  //function for progressBar to take effect
		
	    //player settings
		playerSetting();
		
	        
		frame = new JFrame();  //Main UI
		frame.setBounds(300, 100, 550, 455);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		ImageIcon background = new ImageIcon("img/bg.jpg");//background image
		JLabel label = new JLabel(background);// bg picture 
		label.setBounds(0, 0, 550, 455);  // set size of the label
		JPanel imagePanel = (JPanel) frame.getContentPane();
		imagePanel.setOpaque(false);
		// set default container as BorderLayout
		imagePanel.setLayout(null);
		frame.getLayeredPane().setLayout(null);
		// set background image
		frame.getLayeredPane().add(label, new Integer(Integer.MIN_VALUE));
		frame.setResizable(false);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// "X" pressed
				int option = JOptionPane.showConfirmDialog(ApplicationWindow.this, "Are you sure to go back?",
						" Notification", JOptionPane.OK_CANCEL_OPTION);
				if (JOptionPane.OK_OPTION == option) {
					// conform button clicked,then exit 
					/*// for Thread to stop
					 * exit = true;
					try {
						th.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} */
			         System.out.println("Thread exit!"); 
					frame.hide();
					playerSetting.show();
				} else {
					ApplicationWindow.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		JLabel lblTitle1 = new JLabel("Warrior");
		lblTitle1.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblTitle1);
		
		
		HP1 = new JProgressBar();
		HP1.setBounds(10, 29, 146, 14);
		HP1.setIndeterminate(false);
		HP1.setStringPainted(true);
		frame.getContentPane().add(HP1);
		
		HP2 = new JProgressBar();
		HP2.setBounds(388, 29, 146, 14);
		HP2.setIndeterminate(false);
		HP2.setStringPainted(true);
		frame.getContentPane().add(HP2);
		
		
		 int testHP1= 10;
		JButton btnAttack = new JButton("ATTACK");
		btnAttack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				fightingResult(player,opponent,"1");
			}
		});
		btnAttack.setBounds(20, 50, 101, 23);
		frame.getContentPane().add(btnAttack);
		
		JButton btnDefend = new JButton("DEFEND");
		btnDefend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fightingResult(player,opponent,"2");
			}
		});
		btnDefend.setBounds(20, 80, 101, 23);
		frame.getContentPane().add(btnDefend);
		
		JButton btnCharge = new JButton("CHARGE");
		btnCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fightingResult(player,opponent,"3");
			}
		});
		btnCharge.setBounds(20, 110, 101, 23);
		frame.getContentPane().add(btnCharge);
		
		labelHP_1 = new JLabel();
		labelHP_1.setBounds(110, 11, 46, 14);
		frame.getContentPane().add(labelHP_1);
		
		labelHP_2 = new JLabel();
		labelHP_2.setBounds(488, 11, 46, 14);
		frame.getContentPane().add(labelHP_2);
		
		show1 = new JLabel();
		show1.setBounds(45, 165, 67, 56);
		frame.getContentPane().add(show1);
		
		show2 = new JLabel();
		show2.setBounds(427, 90, 67, 56);
		frame.getContentPane().add(show2);
		
		//for fighting effect
		labelFire = new JLabel();
		labelFire.setBounds(0, 0, 550, 450);
		labelFire.setIcon(new ImageIcon("img/elec.png"));
		frame.getContentPane().add(labelFire);
		
		
	}
	
	// fighting procedure to accept actions and  control the fighting data
	private void fightingResult(Character C,Opponents O,String s){
		
		nHP1=C.getHP();
		nHP2=O.getnHP();
		System.out.println("first.getAtk()"+C.getAtk());
		Thread th= new Thread(new Runnable() {
			int r = 0;

			@Override
			public void run() {

				if (nHP1 > 0 && nHP2 > 0) { // game continue
					if ("1".equals(s)) { // player attack
						r = C.getAtk() - O.getnDef();
						if (tripled) {
							C.setAtk(C.getAtk() / 3);
							tripled = false;
						}

					} else if ("2".equals(s)) { // player defend
						r = (int) Math.ceil((C.getDef() - O.getnAtk()) / 2);
					} else if ("3".equals(s)) { // player charge
						r = C.getDef() - O.getnAtk();

						if (!tripled) { // charge button first click
							tripled = true;
							C.setAtk(C.getAtk() * 3);
						} else { // charge button click again
							r = 0;
							JOptionPane.showConfirmDialog(ApplicationWindow.this, "player already set to charge!",
									" Notification", JOptionPane.DEFAULT_OPTION);
						}

					}

				} 

				if (r > 0) {  // compute the HP after fighting
					nHP2 -= r;
					nHP2 = nHP2 < 0 ? 0 : nHP2;
					setHPValue(2, nHP2);
				} else {
					nHP1 += r;
					nHP1 = nHP1 < 0 ? 0 : nHP1;
					setHPValue(1, nHP1);
				}
				
				if (nHP1<=0 || nHP2<=0){  // game over if one of them has no HP
					JOptionPane.showConfirmDialog(ApplicationWindow.this, "Game Over!", " Notification",
							JOptionPane.DEFAULT_OPTION);
					frame.hide();
					playerSetting.show();
				}
			}});
		th.start();
	}
	
	// print for testing
	private void testOutput(){
		System.out.println("player HP:"+player.getHP());
		System.out.println("player Atk:"+player.getAtk());
		System.out.println("player Def:"+player.getDef());
		System.out.println("player Speed:"+player.getSpd());
		
		System.out.println("opponent HP:"+opponent.getnHP());
		System.out.println("opponent Atk:"+opponent.getnAtk());
		System.out.println("opponent Def:"+opponent.getnDef());
		System.out.println("opponent Speed:"+opponent.getnSpd());
		
	}
	//show text
	private void showText(JLabel l,String s){
		if (s.length() < 10) {
			if ("0".equals(s)){  // no text to show
				return;
			}
			l.setForeground(Color.RED);
			l.setFont(new Font("Times New Roman", Font.BOLD, 30));
			l.setText("-"+s);
			labelFire.setVisible(true);
			
			Thread t = new Thread();
			
			try {
				t.sleep(500);
				l.setText("");
				labelFire.setVisible(false);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			t.start();
			
		} else {
			// test message
			l.setText(s);
		}

	}
	private void setHPValue(Integer x,Integer nHP){
		if (x==1){
			HP1.setValue(nHP);
			labelHP_1.setText(nHP.toString());
			showText(show1,String.valueOf(player.getHP()-nHP));
			player.setHP(nHP);  //update HP
		}else if (x==2){
			HP2.setValue(nHP);
			labelHP_2.setText(nHP.toString());
			showText(show2,String.valueOf(opponent.getnHP()-nHP));
			opponent.setnHP(nHP);  //update HP
		}
		
	}
	private void playerSetting() {
		playerSetting = new JFrame();
		playerSetting.setBounds(100, 100, 450, 355);
		playerSetting.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		playerSetting.getContentPane().setLayout(null);
		
		//playerSetting exit event
		playerSetting.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// "X" pressed
				int option = JOptionPane.showConfirmDialog(ApplicationWindow.this, "Are you sure to exit?",
						" Notification", JOptionPane.OK_CANCEL_OPTION);
				if (JOptionPane.OK_OPTION == option) {
					// conform button clicked,then exit 
					System.exit(0);
				} else {
					ApplicationWindow.this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		
		//get string from object lists
		Character p = new Character(1,1);
		Opponents o = new Opponents(1);
		ArrayList<Armor> ArmorList = p.getArmorList();
		ArrayList<Weapon> WeaponList = p.getWeaponList();
		ArrayList<Opponents> OpponentsList = o.getOpponentsList();
		String[] sArmor = new String[ArmorList.size()];
		String[] sWeapon = new String[WeaponList.size()];
		String[] sOpponent = new String[OpponentsList.size()];
		for(int i=0;i<ArmorList.size();i++){
			sArmor[i]=ArmorList.get(i).getsType();
		}
		for(int i=0;i<WeaponList.size();i++){
			sWeapon[i]=WeaponList.get(i).getsType();
		}
		for(int i=0;i<OpponentsList.size();i++){
			sOpponent[i]=OpponentsList.get(i).getsType();
		}
		
		JLabel lblNewLabel = new JLabel("Armor:");
		lblNewLabel.setBounds(59, 54, 84, 14);
		playerSetting.getContentPane().add(lblNewLabel);
		
	
		JComboBox comboBoxArmor = new JComboBox();
		comboBoxArmor.setModel(new DefaultComboBoxModel(sArmor));
		comboBoxArmor.setBounds(185, 54, 158, 20);
		playerSetting.getContentPane().add(comboBoxArmor);
		
		JLabel lblWeapon = new JLabel("Weapon:");
		lblWeapon.setBounds(59, 94, 84, 14);
		playerSetting.getContentPane().add(lblWeapon);
		
		
		JComboBox comboBoxWeapon = new JComboBox();
		comboBoxWeapon.setModel(new DefaultComboBoxModel(sWeapon));
		comboBoxWeapon.setBounds(185, 94, 158, 20);
		playerSetting.getContentPane().add(comboBoxWeapon);
		
		JLabel lblOpponent = new JLabel("Opponent:");
		lblOpponent.setBounds(59, 134, 84, 14);
		playerSetting.getContentPane().add(lblOpponent);
		
		JComboBox comboBoxOpponent = new JComboBox();
		comboBoxOpponent.setModel(new DefaultComboBoxModel(sOpponent));
		comboBoxOpponent.setBounds(185, 134, 158, 20);
		playerSetting.getContentPane().add(comboBoxOpponent);
		
		JLabel lblEnvironment = new JLabel("Environment:");
		lblEnvironment.setBounds(59, 174, 84, 14);
		playerSetting.getContentPane().add(lblEnvironment);
		
		JComboBox comboBoxEnvt = new JComboBox();
		comboBoxEnvt.setModel(new DefaultComboBoxModel(new String[] {"Arena", "Swamp", "Colosseum"}));
		comboBoxEnvt.setBounds(185, 174, 158, 20);
		playerSetting.getContentPane().add(comboBoxEnvt);
		
		
		JButton btnNewButton = new JButton("Start");
		btnNewButton.setBounds(185, 268, 89, 23);
		playerSetting.getContentPane().add(btnNewButton);
		
		//Start button click function, initiate data after setting
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// find armor index
				int indexArmor=0;
				for (int i=0;i<ArmorList.size();i++){
					if (i==comboBoxArmor.getSelectedIndex()){
						indexArmor=i;
						break;
					}
				};
				
				//find weapon index
				int indexWeapon=0;
				for (int i=0;i<WeaponList.size();i++){
					if (i==comboBoxWeapon.getSelectedIndex()){
						indexWeapon=i;
						break;
					}
				};
				
				// find opponent index
				int indexOpponent=0;
				for (int i=0;i<WeaponList.size();i++){
					if (i==comboBoxOpponent.getSelectedIndex()){
						indexOpponent=i;
						break;
					}
				};
				
				player = new Character(indexArmor,indexWeapon);
				opponent= new Opponents(indexOpponent);
				
				JLabel lblTitle2 = new JLabel();
				lblTitle2.setBounds(388, 11, 62, 14);
				frame.getContentPane().add(lblTitle2);
				lblTitle2.setText(opponent.getsType()); //set name for opponent
				
				//take effects from the environment 
				int indexEnvt=0;
				for (int i=0;i<3;i++){
					if (i==comboBoxEnvt.getSelectedIndex()){
						indexEnvt=i;
						break;
					}
				};
				if(indexEnvt==1){
					player.setHP(player.getHP()-1);
					opponent.setnAtk(opponent.getnAtk()+1);
				}else if (indexEnvt==2){
					player.setAtk(player.getAtk()+1);
					opponent.setnDef(opponent.getnDef()-1);
				}
				
				playerSetting.setVisible(false);
				frame.setVisible(true);
				
				HP1.setMaximum(player.getHP());
				setHPValue(1,player.getHP());
				
				
				HP2.setMaximum(opponent.getnHP());
				setHPValue(2,opponent.getnHP());
				
				testOutput();
				fightingResult(player,opponent,"2");
			 
				
				/*HP2.setValue(100);
				labelHP_2.setText(opponent.getnHP().toString());*/
			}
		});
		
		
		
		
	}
	/** 
	 * @uml.property name="character"
	 * @uml.associationEnd aggregation="composite" inverse="appWindow:com.game.Character"
	 */
	private Character character;


	/** 
	 * Getter of the property <tt>character</tt>
	 * @return  Returns the character.
	 * @uml.property  name="character"
	 */
	public Character getCharacter() {
		return character;
	}

	/** 
	 * Setter of the property <tt>character</tt>
	 * @param character  The character to set.
	 * @uml.property  name="character"
	 */
	public void setCharacter(Character character) {
		this.character = character;
	}
	/** 
	 * @uml.property name="o"
	 * @uml.associationEnd aggregation="composite" inverse="app:com.game.Opponents"
	 */
	private Opponents opponents;


	/**
	 * Getter of the property <tt>o</tt>
	 * @return  Returns the opponents.
	 * @uml.property  name="o"
	 */
	public Opponents getO() {
		return opponents;
	}

	/**
	 * Setter of the property <tt>o</tt>
	 * @param o  The opponents to set.
	 * @uml.property  name="o"
	 */
	public void setO(Opponents o) {
		opponents = o;
	}
}
