package com.test.stuff;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JProgressBar;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import RobotOpen.RobotOpenRobot;



@SuppressWarnings("serial")
public class Controller extends JFrame{
	
	private JTextField ipAddr;
	private JTextField[] ledSolenoid = new JTextField[8];
	
	private CrabRobot ROB;

			
			
			
	public Controller() {
		setTitle("RobotOpen Demo - Java");
		getContentPane().setLayout(null);
		setSize(520, 514);
		
		
		
		ROB = new CrabRobot();
		
		
		
		
		
		
		JLabel lblIp = new JLabel("IP :");
		lblIp.setBounds(10, 54, 46, 14);
		getContentPane().add(lblIp);
		
		ipAddr = new JTextField();
		ipAddr.setEnabled(false);
		ipAddr.setBounds(33, 51, 86, 20);
		getContentPane().add(ipAddr);
		ipAddr.setColumns(10);
		
		final JPanel sliders = new JPanel();
		sliders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		sliders.setBackground(Color.WHITE);
		sliders.setBounds(33, 156, 461, 308);
		getContentPane().add(sliders);
		
		sliders.setLayout(null);
				
		final JSlider pwm0 = new JSlider();
		pwm0.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 0, pwm0.getValue());				
			}
		});
		pwm0.setBounds(141, 15, 310, 23);
		sliders.add(pwm0);
		
		JLabel lblPwm = new JLabel("Front Right Heading");
		lblPwm.setBounds(24, 15, 107, 14);
		sliders.add(lblPwm);
		
		
		
		final JSlider pwm1 = new JSlider();
		pwm1.setBounds(141, 49, 310, 23);
		pwm1.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 1, pwm1.getValue());				
			}
		});
		sliders.add(pwm1);
		
		
		
		final JSlider pwm2 = new JSlider();
		pwm2.setBounds(141, 87, 310, 23);
		pwm2.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 2, pwm2.getValue());				
			}
		});
		sliders.add(pwm2);
		
		final JSlider pwm3 = new JSlider();
		pwm3.setBounds(141, 121, 310, 23);
		pwm3.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 3, pwm3.getValue());				
			}
		});
		sliders.add(pwm3);
		
		
		final JSlider pwm4 = new JSlider();
		pwm4.setBounds(141, 155, 310, 23);
		pwm4.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 4, pwm4.getValue());				
			}
		});
		sliders.add(pwm4);		
		
		final JSlider pwm5 = new JSlider();
		pwm5.setBounds(141, 189, 310, 23);
		pwm5.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 5, pwm5.getValue());				
			}
		});
		sliders.add(pwm5);
		
		final JSlider pwm6 = new JSlider();
		pwm6.setBounds(141, 227, 310, 23);
		pwm6.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 6, pwm6.getValue());				
			}
		});
		sliders.add(pwm6);
		
		final JSlider pwm7 = new JSlider();
		pwm7.setBounds(141, 261, 310, 23);
		pwm7.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 7, pwm7.getValue());				
			}
		});
		sliders.add(pwm7);
				
		//Labels
		JLabel lblPwm_1 = new JLabel("Front Right Velocity");
		lblPwm_1.setBounds(24, 49, 101, 14);
		sliders.add(lblPwm_1);
		
		JLabel lblPwm_2 = new JLabel("Front Left Heading");
		lblPwm_2.setBounds(24, 87, 107, 14);
		sliders.add(lblPwm_2);		
		
		JLabel lblPwm_3 = new JLabel("Front Left Velocity");
		lblPwm_3.setBounds(24, 121, 101, 14);
		sliders.add(lblPwm_3);			
		
		JLabel lblPwm_4 = new JLabel("Back Right Heading");
		lblPwm_4.setBounds(24, 155, 101, 14);
		sliders.add(lblPwm_4);
		
		JLabel lblPwm_5 = new JLabel("Back Right Velocity");
		lblPwm_5.setBounds(24, 189, 101, 14);
		sliders.add(lblPwm_5);
		
		JLabel lblPwm_6 = new JLabel("Back Left Heading");
		lblPwm_6.setBounds(24, 227, 107, 14);
		sliders.add(lblPwm_6);
		
		JLabel lblPwm_7 = new JLabel("Back Left Velocity");
		lblPwm_7.setBounds(24, 261, 101, 14);
		sliders.add(lblPwm_7);
		
		
		
		JButton btnEnable = new JButton("Disable");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ROB.disable();
			}
		});
		btnEnable.setBounds(167, 122, 89, 23);
		getContentPane().add(btnEnable);
		
		JButton btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Stop communications. Kill the program
				dispose();
		        System.exit(0);
			}
		});
		btnStop.setBounds(33, 122, 89, 23);
		getContentPane().add(btnStop);
		
		
		
		
		
		
		JButton btnReset = new JButton("Enable");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				ROB.enable();									
				/**/
				pwm0.setValue(50);
				pwm1.setValue(0);
				pwm2.setValue(50);
				pwm3.setValue(0);
				pwm4.setValue(50);
				pwm5.setValue(0);
				pwm6.setValue(50);
				pwm7.setValue(0);				
			}
		});
		btnReset.setBounds(167, 92, 89, 23);
		getContentPane().add(btnReset);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String ip_addr = ipAddr.getText();
				System.out.println(ip_addr);
				try {					

					ROB.connect();	
					
				} catch (Exception e) {					
					e.printStackTrace();
				}					

			}
		});
		btnConnect.setBounds(33, 92, 89, 23);
		getContentPane().add(btnConnect);

		
	}
	

	
	public void updatePWM (int pwm_id, int pwm_val){
				
		switch(pwm_id){		
		case 0:			
			ROB.front_right.setHeading(((pwm_val/100.0)*360.0));			
			break;
		case 1:			
			ROB.front_right.setVelocity((byte)((pwm_val/100.0)*255.0));
			break;		
		case 2:			
			ROB.front_left.setHeading(((pwm_val/100.0)*360.0));			
			break;
		case 3:			
			ROB.front_left.setVelocity((byte)((pwm_val/100.0)*255.0));
			break;		
		case 4:			
			ROB.back_right.setHeading(((pwm_val/100.0)*360.0));			
			break;
		case 5:			
			ROB.back_right.setVelocity((byte)((pwm_val/100.0)*255.0));
			break;		
		case 6:			
			ROB.back_left.setHeading(((pwm_val/100.0)*360.0));			
			break;
		case 7:			
			ROB.front_left.setVelocity((byte)((pwm_val/100.0)*255.0));
			break;		
		}
				
		
			
				
	}
	
	
	public static void main(String args[]) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					} catch (ClassNotFoundException e) {
					} catch (InstantiationException e) {
					} catch (IllegalAccessException e) {
					} catch (UnsupportedLookAndFeelException e) {
					}
					
					new Controller().setVisible(true);
					
				
					
					
				}
			});
		}
}
