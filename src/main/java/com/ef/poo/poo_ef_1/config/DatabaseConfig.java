
package com.ef.poo.poo_ef_1.config;

    import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DatabaseConfig {
    private static final String CONFIG_FILE = "/database.properties";
    private static Properties props;
    private static Connection connection;
    
    static {
        loadProperties();
    }
    
    private static void loadProperties() {
        props = new Properties();
        try (InputStream input = DatabaseConfig.class.getResourceAsStream(CONFIG_FILE)) {
            if (input != null) {
                props.load(input);
            } else {
                // Configuración por defecto si no existe el archivo
                props.setProperty("db.url", "jdbc:postgresql://localhost:5432/rrhh_reclutamiento");
                props.setProperty("db.username", "app_rrhh_user");
                props.setProperty("db.password", "rrhh_app_2024");
                props.setProperty("db.driver", "org.postgresql.Driver");
            }
        } catch (IOException e) {
            System.err.println("Error cargando configuración de base de datos: " + e.getMessage());
            // Configuración por defecto
            props.setProperty("db.url", "jdbc:postgresql://localhost:5432/rrhh_reclutamiento");
            props.setProperty("db.username", "app_rrhh_user");
            props.setProperty("db.password", "rrhh_app_2024");
            props.setProperty("db.driver", "org.postgresql.Driver");
        }
    }
    
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName(props.getProperty("db.driver"));
                connection = DriverManager.getConnection(
                    props.getProperty("db.url"),
                    props.getProperty("db.username"),
                    props.getProperty("db.password")
                );
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver PostgreSQL no encontrado", e);
            }
        }
        return connection;
    }
    
    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                System.err.println("Error cerrando conexión: " + e.getMessage());
            }
        }
    }
    
    public static boolean testConnection() {
        try (Connection testConn = getConnection()) {
            return testConn != null && !testConn.isClosed();
        } catch (SQLException e) {
            System.err.println("Error probando conexión: " + e.getMessage());
            return false;
        }
    }
}
