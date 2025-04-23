package PHPMYADMIN_A_ORACLEBBDD;


import javax.swing.*;
import DATOS_CONEXION.ConexionMySQL;
import DATOS_CONEXION.ConexionOracle;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MainFrame extends JFrame {

    private JTextField txtField1;
    private JTextField txtField2;
    private JTextField txtField3;

    public MainFrame() {
        setTitle("Ingresar Datos");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        panel.add(new JLabel("Campo 1:"));
        txtField1 = new JTextField();
        panel.add(txtField1);

        panel.add(new JLabel("Campo 2:"));
        txtField2 = new JTextField();
        panel.add(txtField2);

        panel.add(new JLabel("Campo 3:"));
        txtField3 = new JTextField();
        panel.add(txtField3);

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });
        panel.add(btnGuardar);

        add(panel);
    }

    private void guardarDatos() {
        String campo1 = txtField1.getText();
        String campo2 = txtField2.getText();
        String campo3 = txtField3.getText();

        try {
            // Conectar a la base de datos MySQL
            ConexionMySQL mysqlConn = new ConexionMySQL("tu_usuario_mysql", "tu_contraseña_mysql", "tu_base_de_datos_mysql");
            mysqlConn.conectar();

            // Insertar datos en MySQL
            String mysqlQuery = "INSERT INTO tu_tabla_mysql (column1, column2, column3) VALUES ('" + campo1 + "', '" + campo2 + "', '" + campo3 + "')";
            mysqlConn.ejecutarInsertDeleteUpdate(mysqlQuery);
            mysqlConn.desconectar();

            // Conectar a la base de datos Oracle
            ConexionOracle oracleConn = new ConexionOracle("tu_usuario_oracle", "tu_contraseña_oracle", "g5020d31b0a2c19_g1amjfiw9h77sib1_tp");
            oracleConn.conectar();

            // Insertar datos en Oracle
            String oracleQuery = "INSERT INTO tu_tabla_oracle (column1, column2, column3) VALUES ('" + campo1 + "', '" + campo2 + "', '" + campo3 + "')";
            oracleConn.ejecutarInsertDeleteUpdate(oracleQuery);
            oracleConn.desconectar();

            JOptionPane.showMessageDialog(this, "Datos guardados y transferidos exitosamente.");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los datos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new MainFrame().setVisible(true);
        });
    }
}
