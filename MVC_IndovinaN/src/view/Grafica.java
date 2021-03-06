package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import controller.Controller;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;

public class Grafica {

	private JFrame frame;
	private JButton btnInvia;
	private JButton btnReset;
	private JButton btnLog;
	private JLabel lblTentativi;
	private JLabel lblTesto;
	private JLabel lblScore;
	private JTextField txtNumero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Grafica window = new Grafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Grafica() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 248, 255));
		frame.setBounds(100, 100, 270, 199);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		txtNumero = new JTextField();
		txtNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtNumero.setBounds(68, 64, 35, 30);
		frame.getContentPane().add(txtNumero);
		txtNumero.setColumns(10);

		lblTentativi = new JLabel("Tentativi");
		lblTentativi.setBounds(137, 39, 55, 14);
		frame.getContentPane().add(lblTentativi);

		btnInvia = new JButton("Invia");
		btnInvia.setBackground(new Color(173, 255, 47));
		btnInvia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInvia.setBounds(10, 128, 70, 23);
		frame.getContentPane().add(btnInvia);

		lblTesto = new JLabel("");
		lblTesto.setForeground(new Color(0, 0, 128));
		lblTesto.setBounds(10, 11, 236, 19);
		frame.getContentPane().add(lblTesto);

		lblScore = new JLabel("");
		lblScore.setForeground(Color.RED);
		lblScore.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setBounds(137, 64, 48, 30);
		frame.getContentPane().add(lblScore);

		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReset.setBackground(new Color(250, 128, 114));
		btnReset.setBounds(90, 128, 70, 23);
		frame.getContentPane().add(btnReset);
		
		btnLog = new JButton("Log");
		btnLog.setBackground(Color.ORANGE);
		btnLog.setBounds(169, 128, 71, 23);
		frame.getContentPane().add(btnLog);

	}

	public JLabel getLblTesto() {
		return lblTesto;
	}

	public void setLblTesto(JLabel lblTesto) {
		this.lblTesto = lblTesto;
	}

	public JLabel getLblScore() {
		return lblScore;
	}

	public void setLblScore(JLabel lblScore) {
		this.lblScore = lblScore;
	}

	public JTextField getTxtNumero() {
		return txtNumero;
	}

	public void setTxtNumero(JTextField txtNumero) {
		this.txtNumero = txtNumero;
	}

	public JButton getBtnInvia() {
		return btnInvia;
	}

	public void setBtnInvia(JButton btnInvia) {
		this.btnInvia = btnInvia;
	}

	public void registraController(Controller controller) {
		btnInvia.addActionListener(controller);
		btnReset.addActionListener(controller);
		btnLog.addActionListener(controller);
	}

	public void setVisible(boolean bho) {
		frame.setVisible(bho);
	}
}
