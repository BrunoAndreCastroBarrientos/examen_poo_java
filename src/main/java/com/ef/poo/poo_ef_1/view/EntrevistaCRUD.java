
package com.ef.poo.poo_ef_1.view;
import com.ef.poo.poo_ef_1.controller.*;
import com.ef.poo.poo_ef_1.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class EntrevistaCRUD extends JFrame {

    private JTextField postulanteIdField, fechaField, tipoField, puntajeField, comentariosField;
    private JButton crearButton, actualizarButton, eliminarButton, obtenerButton;
    private JTextArea resultadoArea;
    private GestionRRHH gestionRRHH;

    public EntrevistaCRUD(GestionRRHH gestionRRHH) {
        this.gestionRRHH = gestionRRHH;
        setTitle("Gestión de Entrevista");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos de texto
        postulanteIdField = new JTextField(20);
        fechaField = new JTextField(20);
        tipoField = new JTextField(20);
        puntajeField = new JTextField(20);
        comentariosField = new JTextField(20);

        // Botones
        crearButton = new JButton("Crear Entrevista");
        actualizarButton = new JButton("Actualizar Entrevista");
        eliminarButton = new JButton("Eliminar Entrevista");
        obtenerButton = new JButton("Obtener Entrevista");

        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);

        // Agregar componentes
        add(new JLabel("Postulante ID:"));
        add(postulanteIdField);
        add(new JLabel("Fecha:"));
        add(fechaField);
        add(new JLabel("Tipo:"));
        add(tipoField);
        add(new JLabel("Puntaje:"));
        add(puntajeField);
        add(new JLabel("Comentarios:"));
        add(comentariosField);
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
                    Entrevista entrevista = new Entrevista();
                    entrevista.setPostulanteId(Integer.parseInt(postulanteIdField.getText()));
                    entrevista.setFecha(fechaField.getText());
                    entrevista.setTipo(tipoField.getText());
                    entrevista.setPuntaje(Double.parseDouble(puntajeField.getText()));
                    entrevista.setComentarios(comentariosField.getText());
                    if (gestionRRHH.crearEntrevista(entrevista)) {
                        resultadoArea.setText("Entrevista creada exitosamente.");
                    } else {
                        resultadoArea.setText("Error al crear entrevista.");
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
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la entrevista a actualizar:"));
                    Entrevista entrevista = gestionRRHH.obtenerEntrevista(id);
                    if (entrevista != null) {
                        entrevista.setPostulanteId(Integer.parseInt(postulanteIdField.getText()));
                        entrevista.setFecha(fechaField.getText());
                        entrevista.setTipo(tipoField.getText());
                        entrevista.setPuntaje(Double.parseDouble(puntajeField.getText()));
                        entrevista.setComentarios(comentariosField.getText());
                        if (gestionRRHH.actualizarEntrevista(entrevista)) {
                            resultadoArea.setText("Entrevista actualizada exitosamente.");
                        } else {
                            resultadoArea.setText("Error al actualizar entrevista.");
                        }
                    } else {
                        resultadoArea.setText("Entrevista no encontrada.");
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
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la entrevista a eliminar:"));
                    if (gestionRRHH.eliminarEntrevista(id)) {
                        resultadoArea.setText("Entrevista eliminada exitosamente.");
                    } else {
                        resultadoArea.setText("Error al eliminar entrevista.");
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
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la entrevista a obtener:"));
                    Entrevista entrevista = gestionRRHH.obtenerEntrevista(id);
                    if (entrevista != null) {
                        resultadoArea.setText("ID: " + entrevista.getId() + "\n" +
                                              "Postulante ID: " + entrevista.getPostulanteId() + "\n" +
                                              "Fecha: " + entrevista.getFecha() + "\n" +
                                              "Tipo: " + entrevista.getTipo() + "\n" +
                                              "Puntaje: " + entrevista.getPuntaje() + "\n" +
                                              "Comentarios: " + entrevista.getComentarios());
                    } else {
                        resultadoArea.setText("Entrevista no encontrada.");
                    }
                } catch (SQLException ex) {
                    resultadoArea.setText("Error: " + ex.getMessage());
                }
            }
        });
    }
}

