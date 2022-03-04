package ga.mmbh.cfgs.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import ga.mmbh.cfgs.NetflixApp;
import ga.mmbh.cfgs.managers.UserManager;

public class RegisterView {

	private final NetflixApp netflixApp;
	
	private JFrame frame;
	private JLabel welcomeLabel, usernameLabel;
	private JTextField usernameField;
	private JPasswordField passwordField, password2Field;
	private JLabel passwordLabel, password2Label, labelPickachuImage, errorLabel;
	private JButton registerButton, backButton;
	
	public RegisterView(NetflixApp pokedexApp) {
		this.netflixApp = pokedexApp;
		initialize();
		setListeners();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setFont(new Font("SansSerif", Font.PLAIN, 11));
		
		frame.setFont(new Font("Bahnschrift", Font.PLAIN, 12));
		frame.getContentPane().setBackground(new Color(39, 45, 54));
		frame.getContentPane().setLayout(null);
		
		welcomeLabel = new JLabel("REGISTRO");
		welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		welcomeLabel.setForeground(new Color(255, 255, 255));
		welcomeLabel.setFont(new Font("Rubik", Font.BOLD, 22));
		welcomeLabel.setBounds(107, 25, 244, 30);
		frame.getContentPane().add(welcomeLabel);
		
		usernameLabel = new JLabel("Usuario");
		usernameLabel.setFont(new Font("SansSerif", Font.BOLD, 12));
		usernameLabel.setForeground(new Color(255, 255, 255));
		usernameLabel.setBounds(107, 107, 244, 20);
		frame.getContentPane().add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(107, 138, 244, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		registerButton = new JButton("Registrarme");
		registerButton.setBackground(new Color(176, 196, 222));
		registerButton.setForeground(new Color(0, 0, 0));
		registerButton.setFont(new Font("SansSerif", Font.PLAIN, 10));
		registerButton.setBounds(107, 358, 244, 23);
		frame.getContentPane().add(registerButton);
		
		passwordLabel = new JLabel("Contraseña");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setBounds(107, 183, 244, 20);
		frame.getContentPane().add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(107, 214, 244, 20);
		frame.getContentPane().add(passwordField);
		
		password2Label = new JLabel("Repetir contraseña");
		password2Label.setForeground(Color.WHITE);
		password2Label.setBounds(107, 261, 244, 20);
		frame.getContentPane().add(password2Label);
		
		password2Field = new JPasswordField();
		password2Field.setColumns(10);
		password2Field.setBounds(107, 292, 244, 20);
		frame.getContentPane().add(password2Field);
		
		labelPickachuImage = new JLabel("");
		labelPickachuImage.setIcon(new ImageIcon(new File("resources/pikachu.png").getAbsolutePath()));
		labelPickachuImage.setBounds(331, 11, 93, 93);
		frame.getContentPane().add(labelPickachuImage);
		
		backButton = new JButton("");
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				frame.dispose();
				new LoginView(netflixApp);
			}
		});
		
		backButton.setEnabled(false);
		backButton.setOpaque(false);
		backButton.setBorder(BorderFactory.createEmptyBorder());
<<<<<<< HEAD
		backButton.setIcon(new ImageIcon(new File("resources/return.png").getAbsolutePath()));
=======
		backButton.setIcon(new ImageIcon(RegisterView.class.getResource("/ga/mmbh/cfgs/resources/return.png")));
>>>>>>> 0907103bd480206f97739f58bedcd04f948e9b0a
		backButton.setBounds(10, 22, 38, 33);
		frame.getContentPane().add(backButton);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(107, 420, 244, 14);
		frame.getContentPane().add(errorLabel);
		
		frame.setBounds(100, 100, 450, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void setListeners() {
		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new LoginView(netflixApp);
			}
		});
		
		registerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				String username = usernameField.getText();
				String password = new String(passwordField.getPassword());
				String password2 = new String(password2Field.getPassword());
				
				UserManager userManager = netflixApp.getUserManager();
				
				if (!password.equals(password2)) {
					errorLabel.setText("Las contraseñas no coinciden");
					return;
				}
				
				if (!userManager.isValidLength(password)) {
					errorLabel.setText("La contraseña debe de ser entre 8 y 15 carácteres");
					return;
				}
				
				if (!userManager.hasUpperCase(password)) {
					errorLabel.setText("La contraseña debe contener al menos una mayúscula");
					return;
				}
				
				if (!userManager.hasLowerCase(password)) {
					errorLabel.setText("La contraseña debe contener al menos una minúscula");
					return;
				}
				
				if (!userManager.hasNumber(password)) {
					errorLabel.setText("La contraseña debe contener al menos un número");
					return;
				}
				
				if (!userManager.hasSpecialCharacter(password)) {
					errorLabel.setText("La contraseña debe contener un carácter especial '@' '#' '$' ó '%'");
					return;
				}
				
				if (!userManager.register(username, password)) {
					errorLabel.setText("Ese usuario ya existe");
					return;
				}
				
				frame.dispose();
				new LoginView(netflixApp);
			}
		});
	}
}
