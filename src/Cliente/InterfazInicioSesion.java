package Cliente;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import Cliente.InterfazCargaRealizarPedido;
import PruebasAntesDeInicio.PruebasLocal.ConexionMySQL;

public class InterfazInicioSesion extends JFrame {

	// VARIABLES

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nombreField;
	private int xMouse, yMouse;

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				InterfazInicioSesion frame = new InterfazInicioSesion();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
////////////////////////////////////////////////////////////////////////////

	// INTERFAZ

	public InterfazInicioSesion() {
		setTitle("BRASAS APP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 487, 367);
		
		//
		
		setUndecorated(true);
		
		// REDIRECCIONAR LA APERTURA DE LA PESTAÑA

		setLocationRelativeTo(null);
				
		// BARRA DE MENU

		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBackground(new Color(255, 255, 255));
		setJMenuBar(menuBar_1);

		// ARRASTRAR BARRA DE MENÚ

		// DETECTOR PARA SABER SI SE AGARRA LA BARRA

		menuBar_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				xMouse = e.getX();
				yMouse = e.getY();
			}
		});

		// REALIZAR EL MOVIMIENTO DE LA BARRA A LA PAR QUE EL RATÓN

		menuBar_1.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen() - xMouse;
				int y = e.getYOnScreen() - yMouse;
				setLocation(x, y);
			}
		});

		// ESPACIADO

		JLabel lblEspacio_5 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5);

		// BOTÓN MINIMIZAR

		JButton btnMinimizar = new JButton(" _ ");
		btnMinimizar.addActionListener(e -> setState(Frame.ICONIFIED));

		JLabel lblEspacio_5_9_1 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_9_1);

		JLabel lblEspacio_5_9 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_9);

		JLabel lblEspacio_5_11 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_11);

		JLabel lblEspacio_5_13 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_13);

		JLabel lblEspacio_5_6_1_1 = new JLabel("BRASAS APP");
		menuBar_1.add(lblEspacio_5_6_1_1);

		JLabel lblEspacio_5_14 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_14);

		JLabel lblEspacio_5_15 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_15);

		JLabel lblEspacio_5_16 = new JLabel("            ");
		menuBar_1.add(lblEspacio_5_16);

		JLabel lblEspacio_5_15_1 = new JLabel("          ");
		menuBar_1.add(lblEspacio_5_15_1);
		menuBar_1.add(btnMinimizar);

		// BOTÓN CERRAR

		JButton btnCerrar = new JButton(" x ");
		btnCerrar.addActionListener(e -> dispose());
		menuBar_1.add(btnCerrar);

		// CONFIGURACIÓN DE CONTENTPANE

		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// TITULO PÁGINA

		JLabel lblTITULO = new JLabel("¡Localiza tu mesa!");
		lblTITULO.setFont(new Font("Arial", Font.PLAIN, 25));
		lblTITULO.setBounds(134, 11, 384, 100);
		contentPane.add(lblTITULO);

		// MENSAJE PARA INTRODUCIR NOMBRE

		JLabel lblNOMBRE = new JLabel("Introduce tu nombre:");
		lblNOMBRE.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNOMBRE.setBounds(86, 108, 176, 14);
		contentPane.add(lblNOMBRE);

		nombreField = new JTextField();
		nombreField.setBounds(230, 105, 201, 20);
		contentPane.add(nombreField);
		nombreField.setColumns(10);

		// MENSAJE PARA INTRODUCIR EL NÚMERO DE LA MESA

		JLabel lblNOMBRE_1 = new JLabel("Introduce el número de tu mesa:");
		lblNOMBRE_1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNOMBRE_1.setBounds(86, 152, 176, 14);
		contentPane.add(lblNOMBRE_1);

		// AÑADIR LOS VALORES DEL DESPLEGABLE

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(
				new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10" }));
		comboBox.setFont(new Font("Arial", Font.PLAIN, 11));
		comboBox.setBounds(375, 150, 56, 18);
		contentPane.add(comboBox);

		// BOTÓN CONFIRMAR

		JButton btnConfirmar = new JButton("Confirmar");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConexionMySQL conexion = new ConexionMySQL("root", "", "pruebas_local");

                try {
                  
                   // CONEXION A LA BASE DE DATOS
                    conexion.conectar();

                    // 3. Crear la sentencia SQL
                    String nombre = nombreField.getText().replace("", "\\"); 
                    String mesa = (String) comboBox.getSelectedItem();
                    String sql = "INSERT INTO clientes (nombre, mesa) VALUES ('" + nombre + "', '" + mesa + "')";

                    // 4. Ejecutar la sentencia
                    int filasAfectadas = conexion.ejecutarInsertDeleteUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Datos guardados: " + filasAfectadas + " fila(s) afectada(s)");

                    // 5. Transición a la siguiente ventana
                    InterfazCargaRealizarPedido a = new InterfazCargaRealizarPedido();
                    a.setVisible(true);
                    dispose();

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error en la base de datos: " + ex.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                } finally {
                    // 6. Desconectar
                    if (conexion != null) {
                        try {
                            conexion.desconectar();
                        } catch (SQLException ex) {
                            JOptionPane.showMessageDialog(null, "Error al cerrar conexión: " + ex.getMessage());
                        }
                    }
                }
			}
		});
		btnConfirmar.setBackground(UIManager.getColor("CheckBox.light"));
		btnConfirmar.setBounds(188, 215, 111, 23);
		contentPane.add(btnConfirmar);

		JMenuBar menuBar_1_1 = new JMenuBar();
		menuBar_1_1.setBackground(Color.WHITE);
		menuBar_1_1.setBounds(0, 0, 540, 25);
		contentPane.add(menuBar_1_1);

		// ESPACIO
		JLabel lblEspacio_4 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_4);

		// MENSAJE DE LOCALIZAR MESA EN MENU

		JLabel lblInicio = new JLabel("Localizar tu mesa");
		menuBar_1_1.add(lblInicio);

		// ESPACIADO

		JLabel lblEspacio = new JLabel("            ");
		menuBar_1_1.add(lblEspacio);

		JLabel lblEspacio_5_4 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_4);

		// CLICKABLE DE REALIZAR PEDIDO

		JLabel lblPedir = new JLabel("Realiza tu pedido");
		menuBar_1_1.add(lblPedir);
		lblPedir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		// ESPACIADO

		JLabel lblEspacio_1 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_1);

		JLabel lblEspacio_5_3 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_3);

		// CLICKABLE DE PAGAR PEDIDO

		JLabel lblPagar = new JLabel("Paga tu pedido");
		menuBar_1_1.add(lblPagar);
		lblPagar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

		JLabel lblEspacio_5_1 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_1);

		JLabel lblEspacio_5_2 = new JLabel("            ");
		menuBar_1_1.add(lblEspacio_5_2);
		lblPagar.addMouseListener(new MouseAdapter() {

			// MUESTRA MENSAJE DE NAVEGACIÓN

			@Override
			public void mouseClicked(MouseEvent e) {

			}

			// CAMBIAR COLOR

			@Override
			public void mouseEntered(MouseEvent e) {
				lblPagar.setForeground(Color.BLUE);
			}

			// RESTAURAR COLOR

			@Override
			public void mouseExited(MouseEvent e) {
				lblPagar.setForeground(Color.BLACK);
			}
		});
		lblPedir.addMouseListener(new MouseAdapter() {
			@Override

			// MUESTRA MENSAJE DE NAVEGACIÓN

			public void mouseClicked(MouseEvent e) {

			}

			// CAMBIAR COLOR

			@Override
			public void mouseEntered(MouseEvent e) {
				lblPedir.setForeground(Color.BLUE);
			}

			// RESTAURAR COLOR

			@Override
			public void mouseExited(MouseEvent e) {
				lblPedir.setForeground(Color.BLACK);
			}
		});
	}

	// GRABADOR DE INTERACCIONES CON EL RATÓN

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}