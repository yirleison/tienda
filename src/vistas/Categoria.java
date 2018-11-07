package vistas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controllador.CategoriaController;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Categoria extends JFrame {

	private static final long serialVersionUID = 4801308384436315192L;
	private JPanel contentPane;
	private JTextField textnombreCategoria;
	private JTextField textdescripcion;

	modelo.Categoria categoria = new modelo.Categoria();
	controllador.CategoriaController categoriaController = new CategoriaController();
	String mensaje = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Categoria frame = new Categoria();
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
	public Categoria() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1028, 533);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel JPCategorias = new JPanel();
		JPCategorias.setBackground(Color.WHITE);
		JPCategorias.setBounds(0, 0, 391, 494);
		contentPane.add(JPCategorias);
		JPCategorias.setLayout(null);

		JLabel lblnombreCategoria = new JLabel("Nombre ctegoria");
		lblnombreCategoria.setBounds(10, 84, 90, 30);
		JPCategorias.add(lblnombreCategoria);

		JLabel lbldesccripcion = new JLabel("Descripcion");
		lbldesccripcion.setBounds(36, 121, 90, 30);
		JPCategorias.add(lbldesccripcion);

		textnombreCategoria = new JTextField();
		textnombreCategoria.setBounds(110, 89, 271, 20);
		JPCategorias.add(textnombreCategoria);
		textnombreCategoria.setColumns(10);

		textdescripcion = new JTextField();
		textdescripcion.setBounds(10, 162, 371, 144);
		JPCategorias.add(textdescripcion);
		textdescripcion.setColumns(10);

		JPanel JPtituloCategorias = new JPanel();
		JPtituloCategorias.setBounds(10, 0, 371, 41);
		JPCategorias.add(JPtituloCategorias);
		JPtituloCategorias.setLayout(null);

		JLabel lbltituloCategoria = new JLabel("Categorias");
		lbltituloCategoria.setBounds(154, 11, 80, 19);
		JPtituloCategorias.add(lbltituloCategoria);

		JButton btncrearCategoria = new JButton("Gardar");

		btncrearCategoria.setBounds(10, 395, 163, 23);
		JPCategorias.add(btncrearCategoria);

		JButton btnlistarCategorias = new JButton("Listar");
		btnlistarCategorias.setBounds(193, 395, 163, 23);
		JPCategorias.add(btnlistarCategorias);

		JLabel lblmensaje = new JLabel("");
		lblmensaje.setVisible(false);
		lblmensaje.setBounds(36, 338, 300, 30);
		JPCategorias.add(lblmensaje);

		btncrearCategoria.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				categoria.setNombre(textnombreCategoria.getText());
				categoria.setDescripcion(textdescripcion.getText());

				if (categoriaController.crear(categoria) > 0) {
					lblmensaje.setText("Registro realizado exitosamente !!");
					lblmensaje.setVisible(true);
						try {
							TimeUnit.SECONDS.wait(2);
							lblmensaje.setVisible(false);
							limpiasCajas();
						} catch (InterruptedException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
				} else {
					lblmensaje.setText("No se ha podido realizar el registro");
					lblmensaje.setVisible(true);
				}
			}
		});
	}

	public void limpiasCajas() {
		textnombreCategoria.setText("");
		textdescripcion.setText("");
		textnombreCategoria.requestFocus();
	}

	public void inicializarCampos(JLabel campo) {
		campo.setVisible(false);
	}

	// Pendiente validar campos
	public void validarCampos() {

	}

	public void mostrarMensaje(JLabel campo) throws InterruptedException {
		campo.setVisible(true);
		TimeUnit.SECONDS.wait(3);
		campo.setVisible(false);
	}
}
