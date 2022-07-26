package de.bypixels.teamcreate.game.util;


import de.bypixels.teamcreate.game.main.MinecartRain;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

/******************************************************************
 *   Copyright Notice                                             *
 *   Copyright (c) PixelsDE | Daniel 2018                         *
 *   Created: 05.05.2018 / 11:59                                  *
 *   All contents of this source text are protected by copyright. *
 *   The copyright law, unless expressly indicated otherwise, is  *
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            *
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class DataAboutGame {


    public DataAboutGame() {
    }


    public static File file = new File("plugins/Minecart-Rain/config.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    private static boolean deathOnDropOnGround;
    private static int boundaryOfMinecartSpawn;
    private static int highToWinGame;
    private static int timeBetweenMinecartSpawn;
    private static float fallSpeedOfMinecart;
    private static int highWhereMinecartsSpawn;
    private static int highWhereMinecartsDespawn;

    private static int timeBeforeSetInMinecart;
    private static String PREFIX;
    private static int amountOfPlayerToStop;


    //Setzt die Daten in die Datei
    public static void setDataInConfig() {
        cfg = YamlConfiguration.loadConfiguration(file);
        cfg.addDefault("boundaryOfMinecartSpawn", 15);
        cfg.addDefault("highToWinGame", 50);
        cfg.addDefault("fallSpeedOfMinecart", 0.5);
        cfg.addDefault("timeBetweenMinecartSpawn", 1);
        cfg.addDefault("Prefix","&7[&6MinecartRain&7]&f ");
        cfg.addDefault("timeBeforeSetInMinecart", 20);
        cfg.addDefault("amountOfPlayerToStop", 3);
        cfg.addDefault("deathOnDropOnGround", false);
        cfg.addDefault("highWhereMinecartsSpawn", 130);
        cfg.addDefault("highWhereMinecartsDespawn", 70);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(DataAboutGame.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Setzt die oben genannten Daten in die Datei
    public static void setMinecartSpawnHighInConfig() {
        DataAboutGame.cfg.addDefault("highWhereMinecartsSpawn", highWhereMinecartsSpawn);
        DataAboutGame.cfg.options().copyDefaults(true);
        try {
            DataAboutGame.cfg.save(DataAboutGame.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Setzt die oben genannten Daten in die Datei
    public static void setMinecartsDespawnHighInConfig() {
        DataAboutGame.cfg.addDefault("highWhereMinecartsDespawn", highWhereMinecartsDespawn);
        DataAboutGame.cfg.options().copyDefaults(true);
        try {
            DataAboutGame.cfg.save(DataAboutGame.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Some Getters and Setters


    public static boolean isDeathOnDropOnGround() {
        return cfg.getBoolean("deathOnDropOnGround");
    }

    public static void setDeathOnDropOnGround(boolean deathOnDropOnGround) {
        DataAboutGame.deathOnDropOnGround = deathOnDropOnGround;
    }

    public static String getPREFIX() {
        return ChatColor.translateAlternateColorCodes('&', cfg.getString("Prefix"));
    }

    public static void setPREFIX(String PREFIX) {
        DataAboutGame.PREFIX = PREFIX;
        MinecartRain.setPREFIX(getPREFIX());
    }

    public static int getAmountOfPlayerToStop() {
        return (int) cfg.getInt("amountOfPlayerToStop");
    }

    public static void setAmountOfPlayerToStop(int amountOfPlayerToStop) {
        DataAboutGame.amountOfPlayerToStop = amountOfPlayerToStop;
    }

    public static int getTimeBeforeSetInMinecart() {
        return cfg.getInt("timeBeforeSetInMinecart");
    }

    public static void setTimeBeforeSetInMinecart(int timeBeforeSetInMinecart) {
        DataAboutGame.timeBeforeSetInMinecart = timeBeforeSetInMinecart;
    }



    public static int getBoundaryOfMinecartSpawn() {
        return cfg.getInt("boundaryOfMinecartSpawn");
    }

    public static void setBoundaryOfMinecartSpawn(int boundaryOfMinecartSpawn) {
        DataAboutGame.boundaryOfMinecartSpawn = boundaryOfMinecartSpawn;
    }

    public static int getHighToWinGame() {
        return cfg.getInt("highToWinGame");
    }

    public static void setHighToWinGame(int highToWinGame) {
        DataAboutGame.highToWinGame = highToWinGame;
    }

    public static FileConfiguration getCfg() {
        return cfg;
    }

    public static File getFile() {
        return file;
    }

    public static float getFallSpeedOfMinecart() {
        return (float) cfg.getDouble("fallSpeedOfMinecart");
    }

    public static void setFallSpeedOfMinecart(float fallSpeedOfMinecart) {
        DataAboutGame.fallSpeedOfMinecart = fallSpeedOfMinecart;
    }

    public static int getTimeBetweenMinecartSpawn() {
        return cfg.getInt("timeBetweenMinecartSpawn");
    }

    public static void setTimeBetweenMinecartSpawn(int timeBetweenMinecartSpawn) {
        DataAboutGame.timeBetweenMinecartSpawn = timeBetweenMinecartSpawn;
    }

    public static void setCfg(FileConfiguration cfg) {
        DataAboutGame.cfg = cfg;
    }

    public static int getHighWhereMinecartsSpawn() {
        return cfg.getInt("highWhereMinecartsSpawn");
    }

    public static void setHighWhereMinecartsSpawn(Player player) {
        DataAboutGame.highWhereMinecartsSpawn = (int) player.getLocation().getY();
    }

    public static int getHighWhereMinecartsDespawn() {
        return cfg.getInt("highWhereMinecartsDespawn");
    }

    public static void setHighWhereMinecartsDespawn(Player player) {
        DataAboutGame.highWhereMinecartsDespawn = (int) player.getLocation().getY();
    }

}


