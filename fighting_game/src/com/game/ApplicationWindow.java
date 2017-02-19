package com.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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

public class ApplicationWindow extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2151022639739728226L;
	public volatile boolean exit = false;   //
	private JFrame frame;
	private JFrame playerSetting;
	private JFrame openging;
	private JProgressBar HP1;
	private JProgressBar HP2;
	private JLabel labelHP_1;
	private JLabel labelHP_2;
	private JLabel show1;
	private JLabel show2;
	private Character player;
	private Opponents opponent;
	private int nHP1;
	private int nHP2;
	private ArrayList<Armor> ArmorList = new ArrayList<Armor>();
	private ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();
	private ArrayList<Opponents> OpponentsList = new ArrayList<Opponents>();
	
	Thread th;
	
	private void dataInitial(){
		ArmorList.add(new Armor("Light",15,-5));
		ArmorList.add(new Armor("Medium",25,-15));
		ArmorList.add(new Armor("Heavy",35,-25));
		
		WeaponList.add(new Weapon("Dagger",20,0));
		WeaponList.add(new Weapon("Sword",30,-10));
		WeaponList.add(new Weapon("Battle Axe",40,-20));
		
		OpponentsList.add(new Opponents("Thief",150,20,10,40,""));
		OpponentsList.add(new Opponents("Viking",250,30,20,30,""));
		OpponentsList.add(new Opponents("Minotaur",350,40,30,20,""));
		
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					//window.openging.setVisible(true);
					window.playerSetting.setVisible(true);
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
		dataInitial();  //loading data
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
        th = new Thread(new Runnable() {
        	int progress = 0;
			@Override
			public void run() {
				   while (progress < 100) {
		                progress += random.nextInt(15);
		                progressBar.setValue(progress);
		                try {
		                    Thread.sleep(random.nextInt(500)); // thread randomly slept
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
       // firstLoading();  //function for progressBar to take effect
		
	    //player settings
		playerSetting();
		
	        
		frame = new JFrame();  //Main UI
		frame.setBounds(100, 100, 450, 355);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// "X" pressed
				int option = JOptionPane.showConfirmDialog(ApplicationWindow.this, "Are you sure to go back?",
						" Notification", JOptionPane.OK_CANCEL_OPTION);
				if (JOptionPane.OK_OPTION == option) {
					// conform button clicked,then exit 
					exit = true;
					try {
						th.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					} 
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
		
		JLabel lblTitle2 = new JLabel("Minotaur");
		lblTitle2.setBounds(278, 11, 62, 14);
		frame.getContentPane().add(lblTitle2);
		
		HP1 = new JProgressBar();
		HP1.setBounds(10, 29, 146, 14);
		HP1.setIndeterminate(false);
		HP1.setStringPainted(true);
		frame.getContentPane().add(HP1);
		
		HP2 = new JProgressBar();
		HP2.setBounds(278, 29, 146, 14);
		HP2.setIndeterminate(false);
		HP2.setStringPainted(true);
		frame.getContentPane().add(HP2);
		
		
		 int testHP1= 10;
		JButton btnAttack = new JButton("ATTACK");
		btnAttack.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				setHPValue(1,testHP1);
				testOutput();
			}
		});
		btnAttack.setBounds(20, 50, 80, 23);
		frame.getContentPane().add(btnAttack);
		
		JButton btnDefend = new JButton("DEFEND");
		btnDefend.setBounds(20, 80, 80, 23);
		frame.getContentPane().add(btnDefend);
		
		JButton btnCharge = new JButton("CHARGE");
		btnCharge.setBounds(20, 110, 80, 23);
		frame.getContentPane().add(btnCharge);
		
		labelHP_1 = new JLabel();
		labelHP_1.setBounds(110, 11, 46, 14);
		frame.getContentPane().add(labelHP_1);
		
		labelHP_2 = new JLabel();
		labelHP_2.setBounds(378, 11, 46, 14);
		frame.getContentPane().add(labelHP_2);
		
		show1 = new JLabel("New label");
		show1.setBounds(110, 149, 46, 14);
		frame.getContentPane().add(show1);
		
		show2 = new JLabel("New label");
		show2.setBounds(278, 114, 46, 14);
		frame.getContentPane().add(show2);
		
		
	}
	
	// phase i, auto attack by Minotaur
	public int fightingResult(Character first,Opponents second){
		int r =0;
		nHP1=first.getHP();
		nHP2=second.getnHP();
		
         th= new Thread(new Runnable() {
			@Override
			public void run(){
				  while (nHP1 > 0 && nHP2 > 0 &&(!exit)) {
					   int nO2P= second.getnAtk()-first.getDef(); 
					   int nP2O = first.getAtk()-second.getnDef();
					   System.out.print("opponent attacks player:"+nO2P+">player attacks opponent:"+nP2O);
					  /* if (nP2O>0){  // player attacks opponent
						   nHP2-=nP2O;
						   nHP2=nHP2<0?0:nHP2;
					   }else */if (nO2P>0){  // opponent attacks player
						   nHP1-=nO2P;
						   nHP1=nHP1<0?0:nHP1;
					   }/*else if (nO2P<=0){  
						   nHP1-=1;
						   nHP1=nHP1<0?0:nHP1;
						   
						   nHP2-=1;
						   nHP2=nHP2<0?0:nHP2;
					   }*/
					  
					   setHPValue(1,nHP1);
					   setHPValue(2,nHP2);

					  try {
						Thread.sleep(800);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
		           }				
			}
        	
        });
		th.start();// Thread started
		
		  
		return r;
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
		l.setText("0".equals(s)?"":("-"+s));
		
		  Thread t=new Thread();
		  t.start();
				 try {
					t.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 l.setText("");
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
		
		JLabel lblNewLabel = new JLabel("Armor:");
		lblNewLabel.setBounds(59, 54, 84, 14);
		playerSetting.getContentPane().add(lblNewLabel);
		
		JComboBox comboBoxArmor = new JComboBox();
		comboBoxArmor.setModel(new DefaultComboBoxModel(new String[] {ArmorList.get(0).getsType(), ArmorList.get(1).getsType(), ArmorList.get(2).getsType()}));
		comboBoxArmor.setBounds(185, 54, 158, 20);
		playerSetting.getContentPane().add(comboBoxArmor);
		
		JLabel lblWeapon = new JLabel("Weapon:");
		lblWeapon.setBounds(59, 94, 84, 14);
		playerSetting.getContentPane().add(lblWeapon);
		
		
		JComboBox comboBoxWeapon = new JComboBox();
		comboBoxWeapon.setModel(new DefaultComboBoxModel(new String[] {WeaponList.get(0).getsType(),WeaponList.get(1).getsType(),WeaponList.get(2).getsType()}));
		comboBoxWeapon.setBounds(185, 94, 158, 20);
		playerSetting.getContentPane().add(comboBoxWeapon);
		
		JLabel lblOpponent = new JLabel("Opponent:");
		lblOpponent.setBounds(59, 134, 84, 14);
		playerSetting.getContentPane().add(lblOpponent);
		
		JComboBox comboBoxOpponent = new JComboBox();
		comboBoxOpponent.setModel(new DefaultComboBoxModel(new String[] {OpponentsList.get(0).getsType(),OpponentsList.get(1).getsType(),OpponentsList.get(2).getsType()}));
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
				
				dataInitial();
				player = new Character(ArmorList.get(indexArmor),WeaponList.get(indexWeapon));
				opponent= OpponentsList.get(indexOpponent);
				
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
				exit=false;
				fightingResult(player,opponent);
			 
				
				/*HP2.setValue(100);
				labelHP_2.setText(opponent.getnHP().toString());*/
			}
		});
		
		
		
		
	}
}
