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
	private boolean OpponentTripled = false;   //
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
	private Envt envt;
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
		                    Thread.sleep(random.nextInt(400)); // thread randomly slept
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
					} 
					System.out.println("Thread exit!"); 
					 */
					frame.hide();
					playerSetting.show();
				}else if(JOptionPane.CANCEL_OPTION == option){
					System.exit(0);
				}else {
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
		System.out.println("first.getAtk()"+C.getAtk()+"second.getAtk()"+O.getnAtk());
		System.out.println("first.speed()"+C.getSpd()+"second.speed()"+O.getnSpd());
		System.out.println("first.speed()"+C.getDef()+"second.speed()"+O.getnDef());
		Thread th= new Thread(new Runnable() {
			int r = 0;

			@Override
			public void run() {
				
				if (nHP1 > 0 && nHP2 > 0) { // game continue
					
					
					if ("1".equals(s)) { // player attack
						String tem = O.think();  // get the action value for opponent after thinking
						if ("0".equals(tem)){  //  after thinking, opponent will attack
							
							if (C.getSpd()>=O.getnSpd()){
								r = (C.getAtk() - O.getnDef())<0?0:(C.getAtk() - O.getnDef());
							}else{
								r = (O.getnAtk() - C.getDef())<0?0:(O.getnAtk() - C.getDef());
							}
							
							
							
						if (OpponentTripled){  // check if opponent's attack is tripled
							O.setnAtk(O.getnAtk()/3);
							OpponentTripled=false;
						}
						}else if("1".equals(tem)){  // after thinking, opponent will defense
							r = (C.getAtk() - O.getnDef())<0?0:(int) Math.ceil((C.getAtk() - O.getnDef())/2);
						}else{  //   after thinking, opponent will charge
							O.setnAtk(O.getnAtk()*3);
							OpponentTripled=true;
						}
						if (tripled) {
							C.setAtk(C.getAtk() / 3);
							tripled = false;
						}
					} else if ("2".equals(s)) { // player defend
						String tem = O.think();  // get the action value for opponent after thinking
						if ("0".equals(tem)){
							r = (int) Math.ceil((C.getDef() - O.getnAtk()) / 2);
							if (OpponentTripled){  // check if opponent's attack is tripled
								O.setnAtk(O.getnAtk()/3);
								OpponentTripled=false;
							}
						}else if("2".equals(tem)){
							O.setnAtk(O.getnAtk()*3);
							OpponentTripled=true;
						}
					} else if ("3".equals(s)) { // player charge
						if (!tripled) { // charge button first click
							String tem = O.think();  // get the action value for opponent after thinking
						if("0".equals(tem)){
							r = C.getDef() - O.getnAtk();
							if (OpponentTripled){  // check if opponent's attack is tripled
								O.setnAtk(O.getnAtk()/3);
								OpponentTripled=false;
							}
						}else if("2".equals(tem)){
							O.setnAtk(O.getnAtk()*3);
							OpponentTripled=true;
						}
						

						
							tripled = true;
							C.setAtk(C.getAtk() * 3);
						} else { // charge button click again
							r = 0;
							JOptionPane.showConfirmDialog(ApplicationWindow.this, "player already set to charge!",
									" Notification", JOptionPane.DEFAULT_OPTION);
						}

					}

				} 
				if (r == 0){  // no damage occur
					setHPValue(1, nHP1);
					setHPValue(2, nHP2);
				}else if (r > 0) {  // compute the HP after fighting
					nHP2 -= r;
					nHP2 = nHP2 < 0 ? 0 : nHP2;
					setHPValue(2, nHP2);
				} else {  // defense is less or equal than its opposite attack
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
			l.setForeground(Color.RED);
			l.setFont(new Font("Times New Roman", Font.BOLD, 30));
			labelFire.setVisible(true);
			
			if ("0".equals(s)){  // no text to show
				l.setText("0");
			}else{
				l.setText("-"+s);
			}
			
			
			
			
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
		Envt e= new Envt(1);
		ArrayList<Armor> ArmorList = p.getArmorList();
		ArrayList<Weapon> WeaponList = p.getWeaponList();
		//ArrayList<Opponents> OpponentsList = o.getOpponentsList();
		ArrayList<Envt> EnvtList = e.getEnvtList();
		
		String[] sArmor = new String[ArmorList.size()];
		String[] sWeapon = new String[WeaponList.size()];
		//String[] sOpponent = new String[OpponentsList.size()];
		String[] sEnvt = new String[EnvtList.size()];
		for(int i=0;i<ArmorList.size();i++){
			sArmor[i]=ArmorList.get(i).getsType();
		}
		for(int i=0;i<WeaponList.size();i++){
			sWeapon[i]=WeaponList.get(i).getsType();
		}
		/*for(int i=0;i<OpponentsList.size();i++){
			sOpponent[i]=OpponentsList.get(i).getsType();
		}*/
		for(int i=0;i<EnvtList.size();i++){
			sEnvt[i]=EnvtList.get(i).getsName();
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
		comboBoxOpponent.setModel(new DefaultComboBoxModel(new String[] {"Thief", "Viking", "Minotaur"}));
		comboBoxOpponent.setBounds(185, 134, 158, 20);
		playerSetting.getContentPane().add(comboBoxOpponent);
		
		JLabel lblEnvironment = new JLabel("Environment:");
		lblEnvironment.setBounds(59, 174, 84, 14);
		playerSetting.getContentPane().add(lblEnvironment);
		
		JComboBox comboBoxEnvt = new JComboBox();
		comboBoxEnvt.setModel(new DefaultComboBoxModel(sEnvt));
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
				
				envt= new Envt(indexEnvt);
				if(indexEnvt==1){
					setHPValue(1, (player.getHP()+ envt.getcPenalty()));
					opponent.setnAtk(opponent.getnAtk()+envt.getoPenalty());
				}else if (indexEnvt==2){
					player.setAtk(player.getAtk()+ envt.getcPenalty());
					opponent.setnDef(opponent.getnDef()+envt.getoPenalty());
				}
				
				playerSetting.setVisible(false);
				frame.setVisible(true);
				
				HP1.setMaximum(player.getHP());
				setHPValue(1,player.getHP());
				
				
				HP2.setMaximum(opponent.getnHP());
				setHPValue(2,opponent.getnHP());
				
				testOutput();
			 
				
				/*HP2.setValue(100);
				labelHP_2.setText(opponent.getnHP().toString());*/
			}
		});
		
		
		
		
	}
}
