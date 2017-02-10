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
import java.util.Random;

import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ApplicationWindow {

	private JFrame frame;
	private JFrame openging;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApplicationWindow window = new ApplicationWindow();
					window.frame.setVisible(false);
					window.openging.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ApplicationWindow() {
		initialize();
	}

	/**
	 * first loading Interface -> progressBar
	 */
	
	private void firstLoading(JProgressBar progressBar){
		progressBar.setStringPainted(true);
	    progressBar.setIndeterminate(true);
	    
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
		                		System.out.println("aaa");  // for debugging
		                		openging.setVisible(false);
		                		frame.setVisible(true);
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

        firstLoading(progressBar);
		
	        
	        //Main UI
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 355);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(29, 40, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(29, 73, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
	}
}
