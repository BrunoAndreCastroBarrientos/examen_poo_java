
package com.ef.poo.poo_ef_1.controller;
import com.ef.poo.poo_ef_1.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestionRRHH {

    private Connection conexion;

    // Constructor que establece la conexión a la base de datos
    public GestionRRHH(String url, String usuario, String clave) throws SQLException {
        try {
            // Establece la conexión con PostgreSQL
            this.conexion = DriverManager.getConnection(url, usuario, clave);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    // Método para cerrar la conexión
    public void cerrarConexion() throws SQLException {
        if (conexion != null && !conexion.isClosed()) {
            conexion.close();
        }
    }

    // MÉTODOS CRUD PARA OFERTA LABORAL
    public boolean crearOfertaLaboral(OfertaLaboral oferta) throws SQLException {
        String sql = "INSERT INTO ofertas_laborales (titulo, descripcion, area, estado) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, oferta.getTitulo());
            stmt.setString(2, oferta.getDescripcion());
            stmt.setString(3, oferta.getArea());
            stmt.setString(4, oferta.getEstado());
            return stmt.executeUpdate() > 0;
        }
    }

    public OfertaLaboral obtenerOfertaLaboral(int id) throws SQLException {
        String sql = "SELECT * FROM ofertas_laborales WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    OfertaLaboral oferta = new OfertaLaboral();
                    oferta.setId(rs.getInt("id"));
                    oferta.setTitulo(rs.getString("titulo"));
                    oferta.setDescripcion(rs.getString("descripcion"));
                    oferta.setArea(rs.getString("area"));
                    oferta.setEstado(rs.getString("estado"));
                    return oferta;
                }
            }
        }
        return null;
    }

    public boolean actualizarOfertaLaboral(OfertaLaboral oferta) throws SQLException {
        String sql = "UPDATE ofertas_laborales SET titulo = ?, descripcion = ?, area = ?, estado = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, oferta.getTitulo());
            stmt.setString(2, oferta.getDescripcion());
            stmt.setString(3, oferta.getArea());
            stmt.setString(4, oferta.getEstado());
            stmt.setInt(5, oferta.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminarOfertaLaboral(int id) throws SQLException {
        String sql = "DELETE FROM ofertas_laborales WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    // MÉTODOS CRUD PARA POSTULANTE
    public boolean crearPostulante(Postulante postulante) throws SQLException {
        String sql = "INSERT INTO postulantes (nombre, correo, telefono, experiencia, educacion, cv, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, postulante.getNombre());
            stmt.setString(2, postulante.getCorreo());
            stmt.setString(3, postulante.getTelefono());
            stmt.setString(4, postulante.getExperiencia());
            stmt.setString(5, postulante.getEducacion());
            stmt.setBytes(6, postulante.getCv());
            stmt.setString(7, postulante.getEstado());
            return stmt.executeUpdate() > 0;
        }
    }

    public Postulante obtenerPostulante(int id) throws SQLException {
        String sql = "SELECT * FROM postulantes WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Postulante postulante = new Postulante();
                    postulante.setId(rs.getInt("id"));
                    postulante.setNombre(rs.getString("nombre"));
                    postulante.setCorreo(rs.getString("correo"));
                    postulante.setTelefono(rs.getString("telefono"));
                    postulante.setExperiencia(rs.getString("experiencia"));
                    postulante.setEducacion(rs.getString("educacion"));
                    postulante.setCv(rs.getBytes("cv"));
                    postulante.setEstado(rs.getString("estado"));
                    return postulante;
                }
            }
        }
        return null;
    }

    public boolean actualizarPostulante(Postulante postulante) throws SQLException {
        String sql = "UPDATE postulantes SET nombre = ?, correo = ?, telefono = ?, experiencia = ?, educacion = ?, cv = ?, estado = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, postulante.getNombre());
            stmt.setString(2, postulante.getCorreo());
            stmt.setString(3, postulante.getTelefono());
            stmt.setString(4, postulante.getExperiencia());
            stmt.setString(5, postulante.getEducacion());
            stmt.setBytes(6, postulante.getCv());
            stmt.setString(7, postulante.getEstado());
            stmt.setInt(8, postulante.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminarPostulante(int id) throws SQLException {
        String sql = "DELETE FROM postulantes WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }

    // MÉTODOS CRUD PARA ENTREVISTA
    public boolean crearEntrevista(Entrevista entrevista) throws SQLException {
        String sql = "INSERT INTO entrevistas (postulante_id, fecha, tipo, puntaje, comentarios) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, entrevista.getPostulanteId());
            stmt.setString(2, entrevista.getFecha());
            stmt.setString(3, entrevista.getTipo());
            stmt.setDouble(4, entrevista.getPuntaje());
            stmt.setString(5, entrevista.getComentarios());
            return stmt.executeUpdate() > 0;
        }
    }

    public Entrevista obtenerEntrevista(int id) throws SQLException {
        String sql = "SELECT * FROM entrevistas WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Entrevista entrevista = new Entrevista();
                    entrevista.setId(rs.getInt("id"));
                    entrevista.setPostulanteId(rs.getInt("postulante_id"));
                    entrevista.setFecha(rs.getString("fecha"));
                    entrevista.setTipo(rs.getString("tipo"));
                    entrevista.setPuntaje(rs.getDouble("puntaje"));
                    entrevista.setComentarios(rs.getString("comentarios"));
                    return entrevista;
                }
            }
        }
        return null;
    }

    public boolean actualizarEntrevista(Entrevista entrevista) throws SQLException {
        String sql = "UPDATE entrevistas SET postulante_id = ?, fecha = ?, tipo = ?, puntaje = ?, comentarios = ? WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, entrevista.getPostulanteId());
            stmt.setString(2, entrevista.getFecha());
            stmt.setString(3, entrevista.getTipo());
            stmt.setDouble(4, entrevista.getPuntaje());
            stmt.setString(5, entrevista.getComentarios());
            stmt.setInt(6, entrevista.getId());
            return stmt.executeUpdate() > 0;
        }
    }

    public boolean eliminarEntrevista(int id) throws SQLException {
        String sql = "DELETE FROM entrevistas WHERE id = ?";
        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, id);
            return stmt.executeUpdate() > 0;
        }
    }
}
