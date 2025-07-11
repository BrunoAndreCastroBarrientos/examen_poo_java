
package com.ef.poo.poo_ef_1.view;
import com.ef.poo.poo_ef_1.controller.*;
import com.ef.poo.poo_ef_1.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class OfertaLaboralCRUD extends JFrame {

    private JTextField tituloField, descripcionField, areaField, estadoField;
    private JButton crearButton, actualizarButton, eliminarButton, obtenerButton;
    private JTextArea resultadoArea;
    private GestionRRHH gestionRRHH;

    public OfertaLaboralCRUD(GestionRRHH gestionRRHH) {
        this.gestionRRHH = gestionRRHH;
        setTitle("Gestión de Oferta Laboral");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Campos de texto
        tituloField = new JTextField(20);
        descripcionField = new JTextField(20);
        areaField = new JTextField(20);
        estadoField = new JTextField(20);

        // Botones
        crearButton = new JButton("Crear Oferta");
        actualizarButton = new JButton("Actualizar Oferta");
        eliminarButton = new JButton("Eliminar Oferta");
        obtenerButton = new JButton("Obtener Oferta");

        // Área de texto para mostrar resultados
        resultadoArea = new JTextArea(10, 30);
        resultadoArea.setEditable(false);

        // Agregar componentes
        add(new JLabel("Título:"));
        add(tituloField);
        add(new JLabel("Descripción:"));
        add(descripcionField);
        add(new JLabel("Área:"));
        add(areaField);
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
                    OfertaLaboral oferta = new OfertaLaboral();
                    oferta.setTitulo(tituloField.getText());
                    oferta.setDescripcion(descripcionField.getText());
                    oferta.setArea(areaField.getText());
                    oferta.setEstado(estadoField.getText());
                    if (gestionRRHH.crearOfertaLaboral(oferta)) {
                        resultadoArea.setText("Oferta creada exitosamente.");
                    } else {
                        resultadoArea.setText("Error al crear oferta.");
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
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la oferta a actualizar:"));
                    OfertaLaboral oferta = gestionRRHH.obtenerOfertaLaboral(id);
                    if (oferta != null) {
                        oferta.setTitulo(tituloField.getText());
                        oferta.setDescripcion(descripcionField.getText());
                        oferta.setArea(areaField.getText());
                        oferta.setEstado(estadoField.getText());
                        if (gestionRRHH.actualizarOfertaLaboral(oferta)) {
                            resultadoArea.setText("Oferta actualizada exitosamente.");
                        } else {
                            resultadoArea.setText("Error al actualizar oferta.");
                        }
                    } else {
                        resultadoArea.setText("Oferta no encontrada.");
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
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la oferta a eliminar:"));
                    if (gestionRRHH.eliminarOfertaLaboral(id)) {
                        resultadoArea.setText("Oferta eliminada exitosamente.");
                    } else {
                        resultadoArea.setText("Error al eliminar oferta.");
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
                    int id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la oferta a obtener:"));
                    OfertaLaboral oferta = gestionRRHH.obtenerOfertaLaboral(id);
                    if (oferta != null) {
                        resultadoArea.setText("ID: " + oferta.getId() + "\n" +
                                              "Título: " + oferta.getTitulo() + "\n" +
                                              "Descripción: " + oferta.getDescripcion() + "\n" +
                                              "Área: " + oferta.getArea() + "\n" +
                                              "Estado: " + oferta.getEstado());
                    } else {
                        resultadoArea.setText("Oferta no encontrada.");
                    }
                } catch (SQLException ex) {
                    resultadoArea.setText("Error: " + ex.getMessage());
                }
            }
        });
    }
}

