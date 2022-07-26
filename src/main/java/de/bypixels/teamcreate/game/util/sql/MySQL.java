package de.bypixels.teamcreate.game.util.sql;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.sql.*;
/******************************************************************
 *   Copyright Notice                                                                *
 *   Copyright (c) PixelsDE | Daniel 2018                                    *
 *   Created: 14.06.2018 / 15:51                                                 *
 *   All contents of this source text are protected by copyright.  *
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                               *
 *   Any type of duplication, distribution, rental, sale, award,      *
 *   Public accessibility or other use                                          *
 *   Requires the express written consent of PixelsDE | Daniel.    *
 ******************************************************************/



public class MySQL {

    private static File file = new File("plugins/Minecart-Rain/MySQL.yml");
    private static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);

    public  void createFile(){

        cfg.addDefault("MySQL", false);
        cfg.addDefault("port", "3306");
        cfg.addDefault("database", "testbase");
        cfg.addDefault("host", "localhost");
        cfg.addDefault("password", "testpassword");
        cfg.addDefault("username", "root");

        cfg.options().copyDefaults(true);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static String port = "3306";
    private static String database = "testbase";
    private static String host = "localhost";
    private static String password = "testpassword";
    private static String username = "root";
    private static Connection connection;




    public static void connect() {
        port = cfg.getString("port");
        database = cfg.getString("database");
        host = cfg.getString("host");
        password = cfg.getString("password");
        username = cfg.getString("username");

        if (!isConnected()) {
            try {
                connection = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/" + database, username, password);
                System.out.println("[MySQL] Verbindung ist aufgebaut!");
            } catch (SQLException e) {
                System.out.println("[MySQL] ERROR beim Verbinden!");
            }
        }

    }


    public static void disconnect() {
        if (isConnected()) {
            try {
                connection.close();
                System.out.println("[MySQL] Verbindung ist beendet!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }

    public  File getFile() {
        return file;
    }

    public  FileConfiguration getCfg() {
        return cfg;
    }

    public  String getPort() {
        return port;
    }

    public  String getDatabase() {
        return database;
    }

    public  String getHost() {
        return host;
    }

    public  String getPassword() {
        return password;
    }

    public  String getUsername() {
        return username;
    }

    public   Connection getConnection() {
        return connection;
    }

    private static   boolean isConnected() {

        return (connection == null ? false : true);
    }
}

