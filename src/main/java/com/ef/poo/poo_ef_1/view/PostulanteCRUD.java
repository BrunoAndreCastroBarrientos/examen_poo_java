
package com.ef.poo.poo_ef_1.view;
import com.ef.poo.poo_ef_1.controller.*;
import com.ef.poo.poo_ef_1.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PostulanteCRUD extends JFrame {

    private JTextField nombreField, correoField, telefonoField, experienciaField, educacionField, estadoField;
    private JButton crearButton, actualizarButton, eliminarButton, obtenerButton;
    private JTextArea resultadoArea;
    private GestionRRHH gestionRRHH;

    public PostulanteCRUD(GestionRRHH gestionRRHH) {
        this.gestionRRHH = gestionRRHH;
        setTitle("Gestión de Postulante");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos de texto
        nombreField = new JTextField(20);
        correoField = new JTextField(20);
        telefonoField = new JTextField(20);
        experienciaField = new JTextField(20);
        educacionField = new JTextField(20);
        estadoField = new JTextField(20);

        // Botones
        crearButton = new JButton("Crear Postulante");
        actualizarButton = new JButton("Actualizar Postulante");
        eliminarButton = new JButton("Eliminar Postulante");
        obtenerButton = new JButton("Obtener Postulante");

        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);

        // Agregar componentes
        add(new JLabel("Nombre:"));
        add(nombreField);
        add(new JLabel("Correo:"));
        add(correoField);
        add(new JLabel("Teléfono:"));
        add(telefonoField);
        add(new JLabel("Experiencia:"));
        add(experienciaField);
        add(new JLabel("Educación:"));
        add(educacionField);
        add(new JLabel("Estado:"));
        add(estadoField);
        add(crearButton);
        add(actualizarButton);
        add(eliminarButton);
        add(obtenerButton);
        add(new JScrollPane(resultadoArea));

        // Eventos de los botones
        crearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Postulante postulante = new Postulante();
                    postulante.setNombre(nombreField.getText());
                    postulante.setCorreo(correoField.getText());
                    postulante.setTelefono(telefonoField.getText());
                    postulante.setExperiencia(experienciaField.getText());
                    postulante.setEducacion(educacionField.getText());
                    postulante.setEstado(estadoField.getText());
                    if (gestionRRHH.crearPostulante(postulante)) {
                        resultadoArea.setText("Postulante creado exitosamente.");
                    } else {
                        resultadoArea.setText("Error al crear postulante.");
                    }
                } catch (SQLException ex) {
                    resultadoArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        actualizarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del postulante a actualizar:"));
                    Postulante postulante = gestionRRHH.obtenerPostulante(id);
                    if (postulante != null) {
                        postulante.setNombre(nombreField.getText());
                        postulante.setCorreo(correoField.getText());
                        postulante.setTelefono(telefonoField.getText());
                        postulante.setExperiencia(experienciaField.getText());
                        postulante.setEducacion(educacionField.getText());
                        postulante.setEstado(estadoField.getText());
                        if (gestionRRHH.actualizarPostulante(postulante)) {
                            resultadoArea.setText("Postulante actualizado exitosamente.");
                        } else {
                            resultadoArea.setText("Error al actualizar postulante.");
                        }
                    } else {
                        resultadoArea.setText("Postulante no encontrado.");
                    }
                } catch (SQLException ex) {
                    resultadoArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del postulante a eliminar:"));
                    if (gestionRRHH.eliminarPostulante(id)) {
                        resultadoArea.setText("Postulante eliminado exitosamente.");
                    } else {
                        resultadoArea.setText("Error al eliminar postulante.");
                    }
                } catch (SQLException ex) {
                    resultadoArea.setText("Error: " + ex.getMessage());
                }
            }
        });

        obtenerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID del postulante a obtener:"));
                    Postulante postulante = gestionRRHH.obtenerPostulante(id);
                    if (postulante != null) {
                        resultadoArea.setText("ID: " + postulante.getId() + "\n" +
                                              "Nombre: " + postulante.getNombre() + "\n" +
                                              "Correo: " + postulante.getCorreo() + "\n" +
                                              "Teléfono: " + postulante.getTelefono() + "\n" +
                                              "Experiencia: " + postulante.getExperiencia() + "\n" +
                                              "Educación: " + postulante.getEducacion() + "\n" +
                                              "Estado: " + postulante.getEstado());
                    } else {
                        resultadoArea.setText("Postulante no encontrado.");
                    }
                } catch (SQLException ex) {
                    resultadoArea.setText("Error: " + ex.getMessage());
                }
            }
        });
    }
}
