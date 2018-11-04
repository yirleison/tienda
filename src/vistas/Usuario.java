package vistas;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import DB.Conexion;
import controllador.UsuarioController;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import javax.swing.JPasswordField;


public class Usuario extends JFrame {

	private JPanel contentPane;
	private static JTextField textNombre;
	private JTextField textPrimerApellido;
	private JTextField textSegundoApellido;
	private JTextField textTelefono;
	private JTextField textDireccion;
	private JTextField textEmail;
	private JTextField textUsuario;
	
	modelo.Usuario modeloUsuario = new modelo.Usuario();
	controllador.UsuarioController usuarioController = new UsuarioController();
	Conexion cnn = new Conexion();
	private JPasswordField textClave;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				  textNombre.requestFocus();
				try {
					Usuario frame = new Usuario();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Usuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1053, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel usuario = new JPanel();
		usuario.setBorder(new LineBorder(Color.GRAY));
		usuario.setForeground(Color.WHITE);
		usuario.setBackground(Color.WHITE);
		usuario.setBounds(0, 0, 1091, 537);
		contentPane.add(usuario);
		usuario.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1033, 61);
		usuario.add(panel);
		panel.setLayout(null);
		
		JLabel USUARIO = new JLabel("Usuario");
		USUARIO.setBounds(504, 11, 132, 30);
		panel.add(USUARIO);
		
		JLabel lbNombre = new JLabel("Nombre");
		lbNombre.setBackground(new Color(238, 112, 82));
		lbNombre.setBounds(83, 137, 46, 14);
		usuario.add(lbNombre);
		
		JLabel lblPapellido = new JLabel("Primer apellido");
		lblPapellido.setBounds(60, 172, 102, 26);
		lblPapellido.setBackground(new Color(238, 112, 82));
		usuario.add(lblPapellido);
		
		JLabel lblSegundoApellido = new JLabel("Segundo Apellido");
		lblSegundoApellido.setBounds(48, 209, 123, 20);
		usuario.add(lblSegundoApellido);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(83, 249, 46, 14);
		usuario.add(lblTelefono);
		
		JLabel lblDireccion = new JLabel("Direccion");
		lblDireccion.setBounds(83, 285, 46, 14);
		usuario.add(lblDireccion);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(98, 310, 31, 29);
		usuario.add(lblEmail);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(83, 350, 46, 26);
		usuario.add(lblUsuario);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(93, 387, 46, 18);
		usuario.add(lblClave);
		
		JLabel lblRespuesta = new JLabel("");
		lblRespuesta.setToolTipText("lblRespuesta");
		lblRespuesta.setBounds(426, 91, 280, 14);
		usuario.add(lblRespuesta);
		setLocationRelativeTo(null);
		setSize(1050,576);
		setVisible(false);
		
		textNombre = new JTextField();
		textNombre.setBounds(200, 134, 745, 20);
		usuario.add(textNombre);
		textNombre.setColumns(10);
		
		
		textPrimerApellido = new JTextField();
		textPrimerApellido.setBounds(200, 175, 745, 20);
		usuario.add(textPrimerApellido);
		textPrimerApellido.setColumns(10);
		
		textSegundoApellido = new JTextField();
		textSegundoApellido.setBounds(200, 209, 745, 20);
		usuario.add(textSegundoApellido);
		textSegundoApellido.setColumns(10);
		
		textTelefono = new JTextField();
		textTelefono.setBounds(200, 246, 745, 20);
		usuario.add(textTelefono);
		textTelefono.setColumns(10);
		
		textDireccion = new JTextField();
		textDireccion.setBounds(200, 282, 745, 20);
		usuario.add(textDireccion);
		textDireccion.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(200, 313, 745, 20);
		usuario.add(textEmail);
		textEmail.setColumns(10);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(200, 351, 745, 20);
		usuario.add(textUsuario);
		textUsuario.setColumns(10);
		
		textClave = new JPasswordField();
		textClave.setBounds(200, 385, 745, 20);
		usuario.add(textClave);
			
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addMouseListener(new MouseAdapter() {
			@SuppressWarnings("deprecation")
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				modeloUsuario.setNombre(textNombre.getText());
				modeloUsuario.setPrimerApellido(textPrimerApellido.getText());
				modeloUsuario.setSegundoApellido(textSegundoApellido.getText());
				modeloUsuario.setDireccion(textDireccion.getText());
				modeloUsuario.setTelefono(textTelefono.getText());
				modeloUsuario.setEmail(textEmail.getText());
				modeloUsuario.setUsuario(textUsuario.getText());
				modeloUsuario.setClave(textClave.getText());
				
				int resp = usuarioController.crearUsuario(cnn, modeloUsuario);
				
				if(resp > 0) {
					lblRespuesta.setVisible(true);
				    lblRespuesta.setText("Usuario registrado exitosamente !!");
				    limpiarCampos();
				    textNombre.requestFocus();
				}
				else {
					lblRespuesta.setVisible(true);
					lblRespuesta.setForeground(new Color(123, 34, 23));
				    lblRespuesta.setText("No ha sido posible el registro !!");
				    
				}
			}
		});
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnRegistrar.setToolTipText("btnRegistrar");
		btnRegistrar.setBounds(407, 431, 325, 34);
		usuario.add(btnRegistrar);
		
	}
	
	public void limpiarCampos() {
		
		textNombre.setText("");
		textPrimerApellido.setText("");
		textSegundoApellido.setText("");
		textDireccion.setText("");
		textTelefono.setText("");
		textEmail.setText("");
		textUsuario.setText("");
		textClave.setText("");
		
	}
}
