package com.game;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ApplicationWindow {

	private JFrame frame;
	private JFrame playerSetting;
	private JFrame openging;
	
	private Character player;
	private Opponents opponent;
	
	private JProgressBar HP1;
	private JProgressBar HP2;
	private JLabel labelHP_1;
	private JLabel labelHP_2;
	private static ArrayList<Armor> ArmorList = new ArrayList<Armor>();
	private static ArrayList<Weapon> WeaponList = new ArrayList<Weapon>();
	private static ArrayList<Opponents> OpponentsList = new ArrayList<Opponents>();
	
	static {
		ArmorList.add(new Armor("Light",15,-5));
		ArmorList.add(new Armor("Medium",25,-15));
		ArmorList.add(new Armor("Heavy",35,-25));
		
		WeaponList.add(new Weapon("Dagger",20,0));
		WeaponList.add(new Weapon("Sword",30,10));
		WeaponList.add(new Weapon("Battle Axe",40,20));
		
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
		initialize();
	}

	/**
	 * first loading Interface -> progressBar
	 */
	
	private void firstLoading(JProgressBar progressBar){
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
       
        firstLoading(progressBar);  //function for progressBar to take effect
		
	    //player settings
		playerSetting();
		
	        
		frame = new JFrame();  //Main UI
		frame.setBounds(100, 100, 450, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitle1 = new JLabel("Warrior");
		lblTitle1.setBounds(10, 11, 46, 14);
		frame.getContentPane().add(lblTitle1);
		
		JLabel lblTitle2 = new JLabel("Minotaur");
		lblTitle2.setBounds(278, 11, 46, 14);
		frame.getContentPane().add(lblTitle2);
		
		HP1 = new JProgressBar();
		HP1.setBounds(10, 29, 146, 14);
		frame.getContentPane().add(HP1);
		
		HP2 = new JProgressBar();
		HP2.setBounds(278, 29, 146, 14);
		frame.getContentPane().add(HP2);
		
		JButton button = new JButton("New button");
		button.setBounds(20, 121, 89, 23);
		frame.getContentPane().add(button);
		
		 int testHP1= 10;
		JButton btnNewButton = new JButton("teseting ");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				setHPValue(1,testHP1);
			}
		});
		btnNewButton.setBounds(20, 54, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(20, 87, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		labelHP_1 = new JLabel();
		labelHP_1.setBounds(110, 11, 46, 14);
		frame.getContentPane().add(labelHP_1);
		
		labelHP_2 = new JLabel();
		labelHP_2.setBounds(378, 11, 46, 14);
		frame.getContentPane().add(labelHP_2);
		
		
	}
	
	private void setHPValue(Integer x,Integer nHP){
		if (x==1){
			HP1.setValue(nHP);
			labelHP_1.setText(nHP.toString());
		}else if (x==2){
			HP2.setValue(nHP);
			labelHP_2.setText(nHP.toString());
		}
		
	}
	private void playerSetting() {
		playerSetting = new JFrame();
		playerSetting.setBounds(100, 100, 450, 355);
		playerSetting.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerSetting.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Armor:");
		lblNewLabel.setBounds(70, 54, 73, 14);
		playerSetting.getContentPane().add(lblNewLabel);
		
		JComboBox comboBoxArmor = new JComboBox();
		comboBoxArmor.setModel(new DefaultComboBoxModel(new String[] {ArmorList.get(0).getsType(), ArmorList.get(1).getsType(), ArmorList.get(2).getsType()}));
		comboBoxArmor.setBounds(185, 54, 158, 20);
		playerSetting.getContentPane().add(comboBoxArmor);
		
		JLabel lblWeapon = new JLabel("Weapon:");
		lblWeapon.setBounds(70, 94, 73, 14);
		playerSetting.getContentPane().add(lblWeapon);
		
		
		JComboBox comboBoxWeapon = new JComboBox();
		comboBoxWeapon.setModel(new DefaultComboBoxModel(new String[] {WeaponList.get(0).getsType(),WeaponList.get(1).getsType(),WeaponList.get(2).getsType()}));
		comboBoxWeapon.setBounds(185, 94, 158, 20);
		playerSetting.getContentPane().add(comboBoxWeapon);
		
		JLabel lblOpponent = new JLabel("Opponent:");
		lblOpponent.setBounds(70, 134, 73, 14);
		playerSetting.getContentPane().add(lblOpponent);
		
		JComboBox comboBoxOpponent = new JComboBox();
		comboBoxOpponent.setModel(new DefaultComboBoxModel(new String[] {OpponentsList.get(0).getsType(),OpponentsList.get(1).getsType(),OpponentsList.get(2).getsType()}));
		comboBoxOpponent.setBounds(185, 134, 158, 20);
		playerSetting.getContentPane().add(comboBoxOpponent);
		
		JLabel lblEnvironment = new JLabel("Environment:");
		lblEnvironment.setBounds(70, 174, 73, 14);
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
				
				player = new Character(ArmorList.get(indexArmor),WeaponList.get(indexWeapon));
				opponent= OpponentsList.get(indexOpponent);
				
				System.out.println("HP:"+player.getHP());
				System.out.println("HP:"+opponent.getnHP());
				
				playerSetting.setVisible(false);
				frame.setVisible(true);
				HP1.setIndeterminate(false);
				HP1.setMaximum(player.getHP());
				setHPValue(1,player.getHP());
				
				HP2.setStringPainted(true);
				HP2.setIndeterminate(false);
				HP2.setMaximum(opponent.getnHP());
				setHPValue(1,player.getHP());
				HP2.setValue(100);
				labelHP_2.setText(opponent.getnHP().toString());
			}
		});
		
		
		
		
	}

}
