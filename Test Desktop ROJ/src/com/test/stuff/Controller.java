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
	private JTextField txtDisconnected;
	private JTextField enabledStatus;
	private JTextField[] ledSolenoid = new JTextField[8];
	
	private  JProgressBar batteryBar;
	private  JProgressBar analogBar_0;
	private  JProgressBar analogBar_1;
	private  JProgressBar analogBar_2;
	private  JProgressBar analogBar_3;
	private  JProgressBar analogBar_4;
	private  JProgressBar analogBar_5;
	private  JProgressBar analogBar_6;
	private  JProgressBar analogBar_7;	
	
	public JButton btnSolenoid_0;
	
	
	private JTextField ledSolenoid_0;
	private JTextField ledSolenoid_1;
	private JTextField ledSolenoid_2;
	private JTextField ledSolenoid_3;
	private JTextField ledSolenoid_4;
	private JTextField ledSolenoid_5;
	private JTextField ledSolenoid_6;
	private JTextField ledSolenoid_7;
	
	private JTextField txtQuad_0;
	private JTextField txtQuad_1;
	private JTextField txtQuad_2;
	private JTextField txtQuad_3;
	
	private JTextField txtVelocity_3;
	private JTextField txtVelocity_2;
	private JTextField txtVelocity_1;
	private JTextField txtVelocity_0;
	private JTextField txtGPIO_DDR;
	
	private RobotOpenRobot ROB;

			
			
			
	public Controller() {
		setTitle("RobotOpen Demo - Java");
		getContentPane().setLayout(null);
		setSize(1030, 514);
		
		
		
		ROB = new RobotOpenRobot();
		
		
		
		
		
		
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
		sliders.setBounds(337, 156, 513, 308);
		getContentPane().add(sliders);
		
		sliders.setLayout(null);
		
		txtDisconnected = new JTextField();
		txtDisconnected.setEnabled(false);
		txtDisconnected.setForeground(Color.LIGHT_GRAY);
		txtDisconnected.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDisconnected.setHorizontalAlignment(SwingConstants.CENTER);
		txtDisconnected.setBackground(Color.GRAY);
		txtDisconnected.setText("DISCONNECTED");
		txtDisconnected.setBounds(135, 92, 19, 20);
		getContentPane().add(txtDisconnected);
		txtDisconnected.setColumns(10);
		
		JPanel relays = new JPanel();
		relays.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		relays.setBackground(Color.WHITE);
		relays.setBounds(23, 156, 109, 308);
		getContentPane().add(relays);
		relays.setLayout(null);
		
		btnSolenoid_0 = new JButton("Solenoid 1");
		btnSolenoid_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_0 
				//Double click to create these
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_0.setBounds(10, 11, 89, 23);
		relays.add(btnSolenoid_0);
		
		JButton btnSolenoid_1 = new JButton("Solenoid 2");
		btnSolenoid_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_1 
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_1.setBounds(10, 45, 89, 23);
		relays.add(btnSolenoid_1);
		
		JButton btnSolenoid_2 = new JButton("Solenoid 3");
		btnSolenoid_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_2
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_2.setBounds(10, 79, 89, 23);
		relays.add(btnSolenoid_2);
		
		JButton btnSolenoid_3 = new JButton("Solenoid 4");
		btnSolenoid_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Toggle Relay_3
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_3.setBounds(10, 113, 89, 23);
		relays.add(btnSolenoid_3);
		
		JButton btnSolenoid_4 = new JButton("Solenoid 5");
		btnSolenoid_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_4.setBounds(10, 147, 89, 23);
		relays.add(btnSolenoid_4);
		
		JButton btnSolenoid_5 = new JButton("Solenoid 6");
		btnSolenoid_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_5.setBounds(10, 180, 89, 23);
		relays.add(btnSolenoid_5);
		
		JButton btnSolenoid_6 = new JButton("Solenoid 7");
		btnSolenoid_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_6.setBounds(10, 214, 89, 23);
		relays.add(btnSolenoid_6);
		
		JButton btnSolenoid_7 = new JButton("Solenoid 8");
		btnSolenoid_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toggleSolenoid(e);	
			}
		});
		btnSolenoid_7.setBounds(10, 248, 89, 23);
		relays.add(btnSolenoid_7);
				
		final JSlider pwm0 = new JSlider();
		pwm0.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 0, pwm0.getValue());				
			}
		});
		pwm0.setBounds(67, 11, 194, 23);
		sliders.add(pwm0);
		
		JLabel lblPwm = new JLabel("PWM 1");
		lblPwm.setBounds(24, 15, 46, 14);
		sliders.add(lblPwm);
		
		
		
		final JSlider pwm1 = new JSlider();
		pwm1.setBounds(67, 45, 194, 23);
		pwm1.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 1, pwm1.getValue());				
			}
		});
		sliders.add(pwm1);
		
		
		
		final JSlider pwm2 = new JSlider();
		pwm2.setBounds(67, 83, 194, 23);
		pwm2.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 2, pwm2.getValue());				
			}
		});
		sliders.add(pwm2);
		
		final JSlider pwm3 = new JSlider();
		pwm3.setBounds(67, 117, 194, 23);
		pwm3.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 3, pwm3.getValue());				
			}
		});
		sliders.add(pwm3);
		
		
		final JSlider pwm4 = new JSlider();
		pwm4.setBounds(67, 151, 194, 23);
		pwm4.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 4, pwm4.getValue());				
			}
		});
		sliders.add(pwm4);		
		
		final JSlider pwm5 = new JSlider();
		pwm5.setBounds(67, 185, 194, 23);
		pwm5.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 5, pwm5.getValue());				
			}
		});
		sliders.add(pwm5);
		
		final JSlider pwm6 = new JSlider();
		pwm6.setBounds(67, 223, 194, 23);
		pwm6.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 6, pwm6.getValue());				
			}
		});
		sliders.add(pwm6);
		
		final JSlider pwm7 = new JSlider();
		pwm7.setBounds(67, 257, 194, 23);
		pwm7.addChangeListener(new ChangeListener(){
			public void stateChanged(ChangeEvent e){
				updatePWM( 7, pwm7.getValue());				
			}
		});
		sliders.add(pwm7);
				
		//Labels
		JLabel lblPwm_1 = new JLabel("PWM 2");
		lblPwm_1.setBounds(24, 49, 46, 14);
		sliders.add(lblPwm_1);
		
		JLabel lblPwm_2 = new JLabel("PWM 3");
		lblPwm_2.setBounds(24, 87, 46, 14);
		sliders.add(lblPwm_2);		
		
		JLabel lblPwm_3 = new JLabel("PWM 4");
		lblPwm_3.setBounds(24, 121, 46, 14);
		sliders.add(lblPwm_3);			
		
		JLabel lblPwm_4 = new JLabel("PWM 5");
		lblPwm_4.setBounds(24, 155, 46, 14);
		sliders.add(lblPwm_4);
		
		JLabel lblPwm_5 = new JLabel("PWM 6");
		lblPwm_5.setBounds(24, 189, 46, 14);
		sliders.add(lblPwm_5);
		
		JLabel lblPwm_6 = new JLabel("PWM 7");
		lblPwm_6.setBounds(24, 227, 46, 14);
		sliders.add(lblPwm_6);
		
		JLabel lblPwm_7 = new JLabel("PWM 8");
		lblPwm_7.setBounds(24, 261, 46, 14);
		sliders.add(lblPwm_7);
		
		analogBar_0 = new JProgressBar();
		analogBar_0.setBounds(355, 15, 146, 14);
		sliders.add(analogBar_0);
		
		analogBar_1 = new JProgressBar();
		analogBar_1.setBounds(355, 49, 146, 14);
		sliders.add(analogBar_1);
		
		analogBar_2 = new JProgressBar();
		analogBar_2.setBounds(355, 87, 146, 14);
		sliders.add(analogBar_2);
		
		analogBar_3 = new JProgressBar();
		analogBar_3.setBounds(355, 121, 146, 14);
		sliders.add(analogBar_3);
		
		analogBar_4 = new JProgressBar();
		analogBar_4.setBounds(355, 155, 146, 14);
		sliders.add(analogBar_4);
		
		analogBar_5 = new JProgressBar();
		analogBar_5.setBounds(355, 189, 146, 14);
		sliders.add(analogBar_5);
		
		analogBar_6 = new JProgressBar();
		analogBar_6.setBounds(355, 227, 146, 14);
		sliders.add(analogBar_6);
		
		analogBar_7 = new JProgressBar();
		analogBar_7.setBounds(355, 261, 146, 14);
		sliders.add(analogBar_7);
		
		
		JLabel lblAnalog_0 = new JLabel("Analog 1");
		lblAnalog_0.setBounds(302, 15, 53, 14);
		sliders.add(lblAnalog_0);
		
		JLabel lblAnalog_1 = new JLabel("Analog 2");
		lblAnalog_1.setBounds(302, 49, 53, 14);
		sliders.add(lblAnalog_1);
		
		JLabel lblAnalog_2 = new JLabel("Analog 3");
		lblAnalog_2.setBounds(302, 87, 53, 14);
		sliders.add(lblAnalog_2);
		
		JLabel lblAnalog_3 = new JLabel("Analog 4");
		lblAnalog_3.setBounds(302, 121, 53, 14);
		sliders.add(lblAnalog_3);
		
		JLabel lblAnalog_4 = new JLabel("Analog 5");
		lblAnalog_4.setBounds(302, 155, 53, 14);
		sliders.add(lblAnalog_4);
		
		JLabel lblAnalog_5 = new JLabel("Analog 6");
		lblAnalog_5.setBounds(302, 189, 53, 14);
		sliders.add(lblAnalog_5);
		
		JLabel lblAnalog_6 = new JLabel("Analog 7");
		lblAnalog_6.setBounds(302, 227, 53, 14);
		sliders.add(lblAnalog_6);
		
		JLabel lblAnalog_7 = new JLabel("Analog 8");
		lblAnalog_7.setBounds(302, 261, 53, 14);
		sliders.add(lblAnalog_7);
		
		
		
		JButton btnEnable = new JButton("Disable");
		btnEnable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ROB.disable();
			}
		});
		btnEnable.setBounds(33, 122, 89, 23);
		getContentPane().add(btnEnable);
		
		enabledStatus = new JTextField();
		enabledStatus.setEditable(false);
		enabledStatus.setForeground(Color.GRAY);
		enabledStatus.setEnabled(false);
		enabledStatus.setBackground(Color.GRAY);
		enabledStatus.setBounds(135, 123, 19, 20);
		getContentPane().add(enabledStatus);
		enabledStatus.setColumns(10);
		
		JButton btnStop = new JButton("STOP");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Stop communications. Kill the program
				dispose();
		        System.exit(0);
			}
		});
		btnStop.setBounds(177, 92, 89, 23);
		getContentPane().add(btnStop);
		
		
		
		
		
		
		JButton btnReset = new JButton("Enable");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				ROB.enable();			
								
				/**/
				pwm0.setValue(50);
				pwm1.setValue(50);
				pwm2.setValue(50);
				pwm3.setValue(50);
				pwm4.setValue(50);
				pwm5.setValue(50);
				pwm6.setValue(50);
				pwm7.setValue(50);				
			}
		});
		btnReset.setBounds(177, 122, 89, 23);
		getContentPane().add(btnReset);
		
		batteryBar = new JProgressBar();
		batteryBar.setBounds(836, 39, 122, 52);
		getContentPane().add(batteryBar);
		batteryBar.setFont(new Font("Tahoma", Font.BOLD, 31));
		batteryBar.setForeground(new Color(51, 204, 51));
		batteryBar.setStringPainted(true);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				String ip_addr = ipAddr.getText();
				System.out.println(ip_addr);
				try {
					
					/*
					joysticks.joy1[0] = 10;
					joysticks.joy1[1] = 10;					
					
					*/
					
					ROB.connect();
					
					System.out.println("Connection Established: 10.10.0.117");
				} catch (Exception e) {					
					e.printStackTrace();
				}					
								
				Timer timer = new Timer();
				timer.schedule(new PeatandRepeat() ,0,200);
				
			}
		});
		btnConnect.setBounds(33, 92, 89, 23);
		getContentPane().add(btnConnect);
		
		JPanel solinoidStatus = new JPanel();
		solinoidStatus.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		solinoidStatus.setBackground(Color.WHITE);
		solinoidStatus.setBounds(135, 156, 46, 308);
		getContentPane().add(solinoidStatus);
		solinoidStatus.setLayout(null);
		
		ledSolenoid_0 = new JTextField();
		ledSolenoid_0.setBounds(10, 12, 19, 20);
		solinoidStatus.add(ledSolenoid_0);
		ledSolenoid_0.setBackground(Color.GRAY);
		ledSolenoid_0.setColumns(10);
		
		ledSolenoid_1 = new JTextField();
		ledSolenoid_1.setColumns(10);
		ledSolenoid_1.setBackground(Color.GRAY);
		ledSolenoid_1.setBounds(10, 46, 19, 20);
		solinoidStatus.add(ledSolenoid_1);
		
		ledSolenoid_2 = new JTextField();
		ledSolenoid_2.setColumns(10);
		ledSolenoid_2.setBackground(Color.GRAY);
		ledSolenoid_2.setBounds(10, 80, 19, 20);
		solinoidStatus.add(ledSolenoid_2);
		
		ledSolenoid_3 = new JTextField();
		ledSolenoid_3.setColumns(10);
		ledSolenoid_3.setBackground(Color.GRAY);
		ledSolenoid_3.setBounds(10, 114, 19, 20);
		solinoidStatus.add(ledSolenoid_3);
		
		ledSolenoid_4 = new JTextField();
		ledSolenoid_4.setColumns(10);
		ledSolenoid_4.setBackground(Color.GRAY);
		ledSolenoid_4.setBounds(10, 148, 19, 20);
		solinoidStatus.add(ledSolenoid_4);
		
		ledSolenoid_5 = new JTextField();
		ledSolenoid_5.setColumns(10);
		ledSolenoid_5.setBackground(Color.GRAY);
		ledSolenoid_5.setBounds(10, 181, 19, 20);
		solinoidStatus.add(ledSolenoid_5);
		
		ledSolenoid_6 = new JTextField();
		ledSolenoid_6.setColumns(10);
		ledSolenoid_6.setBackground(Color.GRAY);
		ledSolenoid_6.setBounds(10, 215, 19, 20);
		solinoidStatus.add(ledSolenoid_6);
		
		ledSolenoid_7 = new JTextField();
		ledSolenoid_7.setColumns(10);
		ledSolenoid_7.setBackground(Color.GRAY);
		ledSolenoid_7.setBounds(10, 249, 19, 20);
		solinoidStatus.add(ledSolenoid_7);
		
		ledSolenoid[0] = ledSolenoid_0;
		ledSolenoid[1] = ledSolenoid_1;
		ledSolenoid[2] = ledSolenoid_2;
		ledSolenoid[3] = ledSolenoid_3;
		ledSolenoid[4] = ledSolenoid_4;
		ledSolenoid[5] = ledSolenoid_5;
		ledSolenoid[6] = ledSolenoid_6;
		ledSolenoid[7] = ledSolenoid_7;
		
		JPanel pnlEncoders = new JPanel();
		pnlEncoders.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlEncoders.setBackground(Color.WHITE);
		pnlEncoders.setBounds(860, 156, 142, 308);
		getContentPane().add(pnlEncoders);
		pnlEncoders.setLayout(null);
		
		JLabel lblQuad_0 = new JLabel("QUAD 1 :");
		lblQuad_0.setBounds(10, 15, 46, 14);
		pnlEncoders.add(lblQuad_0);
		
		JLabel lblQuad_1 = new JLabel("QUAD 2 :");
		lblQuad_1.setBounds(10, 49, 46, 14);
		pnlEncoders.add(lblQuad_1);
		
		JLabel lblQuad_2 = new JLabel("QUAD 3 :");
		lblQuad_2.setBounds(10, 87, 46, 14);
		pnlEncoders.add(lblQuad_2);
		
		JLabel lblQuad_3 = new JLabel("QUAD 4 :");
		lblQuad_3.setBounds(10, 121, 46, 14);
		pnlEncoders.add(lblQuad_3);
		
		txtQuad_0 = new JTextField();
		txtQuad_0.setBounds(66, 12, 46, 20);
		pnlEncoders.add(txtQuad_0);
		txtQuad_0.setColumns(10);
		
		txtQuad_1 = new JTextField();
		txtQuad_1.setColumns(10);
		txtQuad_1.setBounds(66, 46, 46, 20);
		pnlEncoders.add(txtQuad_1);
		
		txtQuad_2 = new JTextField();
		txtQuad_2.setColumns(10);
		txtQuad_2.setBounds(66, 84, 46, 20);
		pnlEncoders.add(txtQuad_2);
		
		txtQuad_3 = new JTextField();
		txtQuad_3.setColumns(10);
		txtQuad_3.setBounds(66, 118, 46, 20);
		pnlEncoders.add(txtQuad_3);
		
		txtVelocity_3 = new JTextField();
		txtVelocity_3.setColumns(10);
		txtVelocity_3.setBounds(66, 260, 46, 20);
		pnlEncoders.add(txtVelocity_3);
		
		JLabel lblVelocity_3 = new JLabel("VEL 4 :");
		lblVelocity_3.setBounds(10, 263, 46, 14);
		pnlEncoders.add(lblVelocity_3);
		
		JLabel lblVelocity_2 = new JLabel("VEL 3 :");
		lblVelocity_2.setBounds(10, 229, 46, 14);
		pnlEncoders.add(lblVelocity_2);
		
		txtVelocity_2 = new JTextField();
		txtVelocity_2.setColumns(10);
		txtVelocity_2.setBounds(66, 226, 46, 20);
		pnlEncoders.add(txtVelocity_2);
		
		txtVelocity_1 = new JTextField();
		txtVelocity_1.setColumns(10);
		txtVelocity_1.setBounds(66, 188, 46, 20);
		pnlEncoders.add(txtVelocity_1);
		
		JLabel lblVelocity_1 = new JLabel("VEL 2 :");
		lblVelocity_1.setBounds(10, 191, 46, 14);
		pnlEncoders.add(lblVelocity_1);
		
		JLabel lblVelocity_0 = new JLabel("VEL 1 :");
		lblVelocity_0.setBounds(10, 157, 46, 14);
		pnlEncoders.add(lblVelocity_0);
		
		txtVelocity_0 = new JTextField();
		txtVelocity_0.setColumns(10);
		txtVelocity_0.setBounds(66, 154, 46, 20);
		pnlEncoders.add(txtVelocity_0);
		
		JPanel pnlRelay = new JPanel();
		pnlRelay.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		pnlRelay.setBackground(Color.WHITE);
		pnlRelay.setBounds(187, 156, 138, 308);
		getContentPane().add(pnlRelay);
		pnlRelay.setLayout(null);
		
		JComboBox cbRelay_0 = new JComboBox();
		cbRelay_0.setModel(new DefaultComboBoxModel(new String[] {"Forward", "Neutral", "Reverse"}));
		cbRelay_0.setBounds(56, 13, 70, 22);
		cbRelay_0.setSelectedIndex(1);		
		cbRelay_0.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {		    	
		        setRelay(e, 1);	   		        
		    }
		});
		
		pnlRelay.add(cbRelay_0);
		
		JComboBox cbRelay_1 = new JComboBox();
		cbRelay_1.setModel(new DefaultComboBoxModel(new String[] {"Forward", "Neutral", "Reverse"}));
		cbRelay_1.setSelectedIndex(1);
		cbRelay_1.setBounds(56, 48, 70, 22);
		cbRelay_1.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {		    	
		        setRelay(e, 2);	   		        
		    }
		});
		pnlRelay.add(cbRelay_1);
		
		
		JComboBox cbRelay_2 = new JComboBox();
		cbRelay_2.setModel(new DefaultComboBoxModel(new String[] {"Forward", "Neutral", "Reverse"}));
		cbRelay_2.setSelectedIndex(1);
		cbRelay_2.setBounds(56, 79, 70, 22);
		cbRelay_2.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {		    	
		        setRelay(e, 3);	   		        
		    }
		});
		pnlRelay.add(cbRelay_2);
		
		JComboBox cbRelay_3 = new JComboBox();
		cbRelay_3.setModel(new DefaultComboBoxModel(new String[]{"Forward", "Neutral", "Reverse"}));
		cbRelay_3.setSelectedIndex(1);
		cbRelay_3.setBounds(56, 114, 70, 22);
		cbRelay_3.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {		    	
		        setRelay(e, 4);	   		        
		    }
		});
		pnlRelay.add(cbRelay_3);		
		
		JLabel lblRelay_0 = new JLabel("Relay 1");
		lblRelay_0.setBounds(12, 17, 46, 14);
		pnlRelay.add(lblRelay_0);
		
		JLabel lblRelay_1 = new JLabel("Relay 2");
		lblRelay_1.setBounds(12, 52, 46, 14);
		pnlRelay.add(lblRelay_1);
		
		JLabel lblRelay_2 = new JLabel("Relay 3");
		lblRelay_2.setBounds(12, 83, 46, 14);
		pnlRelay.add(lblRelay_2);
		
		JLabel lblRelay_3 = new JLabel("Relay 4");
		lblRelay_3.setBounds(12, 118, 46, 14);
		pnlRelay.add(lblRelay_3);
		
		txtGPIO_DDR = new JTextField();
		txtGPIO_DDR.setText("1111");
		txtGPIO_DDR.setHorizontalAlignment(SwingConstants.RIGHT);
		txtGPIO_DDR.setBounds(294, 94, 39, 20);
		getContentPane().add(txtGPIO_DDR);
		txtGPIO_DDR.setColumns(10);
		
		
	}
	
	class PeatandRepeat extends TimerTask{
		public void run(){
			/*
			if (mic.isReceiving()){
				//txtDisconnected.setBackground(Color.GREEN);
				updateThings();			
			}
			*/
		}
		
	}
	
	public void updateThings() {
		/*
		//Quads		
		txtQuad_0.setText(Integer.toString(mic.getQuad(1)));
		txtQuad_1.setText(Integer.toString(mic.getQuad(2)));
		txtQuad_2.setText(Integer.toString(mic.getQuad(3)));
		txtQuad_3.setText(Integer.toString(mic.getQuad(4)));
						
		//Velocities 
		txtVelocity_0.setText(Integer.toString(mic.getVelocity(1)));		 
		txtVelocity_1.setText(Integer.toString(mic.getVelocity(2)));	
		txtVelocity_2.setText(Integer.toString(mic.getVelocity(3)));	
		txtVelocity_3.setText(Integer.toString(mic.getVelocity(4)));
		
		//Analogs
		batteryBar.setValue((int)(100*(mic.GetBatteryVoltage()/13)));
		analogBar_0.setValue((int)(100*(mic.GetVoltage(1)/5)));
		analogBar_1.setValue((int)(100*(mic.GetVoltage(2)/5)));
		analogBar_2.setValue((int)(100*(mic.GetVoltage(3)/5)));
		analogBar_3.setValue((int)(100*(mic.GetVoltage(4)/5)));
		analogBar_4.setValue((int)(100*(mic.GetVoltage(5)/5)));
		analogBar_5.setValue((int)(100*(mic.GetVoltage(6)/5)));
		analogBar_6.setValue((int)(100*(mic.GetVoltage(7)/5)));
		analogBar_7.setValue((int)(100*(mic.GetVoltage(8)/5)));
				
		
		
		//GPIO
		txtGPIO_DDR.setText(String.format("%4s", Integer.toBinaryString(mic.getGpioDDR())).replace(" ","0"));
		
		*/
	}
	
	public void toggleSolenoid (ActionEvent e){
		
		//parm = "ACTION_PERFORMED,cmd=Relay 0,when=1349267678648,modifiers=Button1"
						
		String parm = e.paramString();
		String[] parm_arr = parm.split(",");
		
		//relay = "Relay 0"
		String solenoid = parm_arr[1].replaceAll("cmd=", "");
		
		//relay_num = 0
		int solenoid_num = Integer.parseInt(solenoid.replace("Solenoid ",""));
				
		if (ledSolenoid[solenoid_num -1].getBackground() == Color.GRAY){
			//mic.setSolinoid(solenoid_num, true);
			ledSolenoid[solenoid_num - 1].setBackground(Color.RED);
		}else{
			//mic.setSolinoid(solenoid_num, false);	
			ledSolenoid[solenoid_num - 1].setBackground(Color.GRAY);
		}
					
	}
	
	public void setRelay (ActionEvent e, int channel){
		
		String state;
		state = e.toString().split("selectedItemReminder=")[1];
		state = state.replaceAll("]","");
		
		int state_int;
		
		//System.out.println(relayState.Reverse);
		
		switch(relayState.valueOf(state)){
		
			case Reverse:
				state_int = 2;
				break;
				
			case Neutral:
				state_int = 0;
				break;
				
			case Forward:
				state_int = 1;
				break;
				
			default:
				state_int = 999;
				break;
		
		}
		
		//System.out.println(">" + relayState.valueOf(state));
		
		//mic.setRelay( channel, (byte) state_int);       
	}
	
	public void updatePWM (int pwm_id, int pwm_val){
		
		/*
		double scale = (((double)pwm_val)/100.0) * 8470.0;
		scale += 3200;*/
		
		
		
		//System.out.println("PWM" + pwm_id + " : " + (byte)              ((pwm_val/100.0)*255.0));
		//progressBar.setValue(pwm_val);	
		
		//send 0 - 100. 0 = full reverse, 100 = full forward, 48-52 = neutral
		//mic.setPWM( pwm_id, (short)(pwm_val));
		
		switch(pwm_id){		
		case 0:			
			ROB.joystick1.LeftY = (byte)   ((pwm_val/100.0)*255.0);
			break;
		case 1:			
			ROB.joystick1.RightX = (byte)   ((pwm_val/100.0)*255.0);
			break;		
		}
				
		
			
				
	}
	
	/*public SimpleCrosslinkRobot connectToRobot(InetAddress cur_ip){
	
			//Create new Robot Object
			mic = new SimpleCrosslinkRobot();
			mic.teleop();	
					
			return mic;			
	}
	*/
	public enum relayState{
		Reverse,
		Neutral,
		Forward
		
		;		
		
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
