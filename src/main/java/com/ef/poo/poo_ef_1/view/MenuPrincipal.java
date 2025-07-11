
package com.ef.poo.poo_ef_1.view;
import com.ef.poo.poo_ef_1.controller.*;
import com.ef.poo.poo_ef_1.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    private JButton ofertaLaboralButton, postulanteButton, entrevistaButton;
    private GestionRRHH gestionRRHH;

    public MenuPrincipal(GestionRRHH gestionRRHH) {
        this.gestionRRHH = gestionRRHH;
        setTitle("Menú Principal - Gestión RRHH");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Botones para abrir cada ventana de CRUD
        ofertaLaboralButton = new JButton("Gestión de Oferta Laboral");
        postulanteButton = new JButton("Gestión de Postulante");
        entrevistaButton = new JButton("Gestión de Entrevista");

        // Agregar los botones a la ventana principal
        add(ofertaLaboralButton);
        add(postulanteButton);
        add(entrevistaButton);

        // Evento para abrir la ventana de CRUD para Oferta Laboral
        ofertaLaboralButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new OfertaLaboralCRUD(gestionRRHH).setVisible(true);
            }
        });

        // Evento para abrir la ventana de CRUD para Postulante
        postulanteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PostulanteCRUD(gestionRRHH).setVisible(true);
            }
        });

        // Evento para abrir la ventana de CRUD para Entrevista
        entrevistaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EntrevistaCRUD(gestionRRHH).setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        // Establecer conexión con la base de datos
        try {
        GestionRRHH gestionRRHH = new GestionRRHH("jdbc:postgresql://dpg-d1o6mujipnbc73ek66jg-a.oregon-postgres.render.com/poo_db", "test_1hmb_user", "Wx8tYLT5hJxCmMpvCGgxxO53V8Rd4xxN");    
            // Mostrar el menú principal
            new MenuPrincipal(gestionRRHH).setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al conectar con la base de datos: " + e.getMessage());
        }
    }
}

