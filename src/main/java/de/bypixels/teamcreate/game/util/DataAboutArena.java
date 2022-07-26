package de.bypixels.teamcreate.game.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import javax.xml.crypto.Data;
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

public class DataAboutArena {


    private static File file = new File("plugins/Minecart-Rain/location.yml");
    public static YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);


    private static int ArenaBoundZ;
    private static int ArenaBoundX;
    private static int ArenaBoundY;
    private static String ArenaWorld;
    private static String deathWorldName;
    private static int deathWorldX;
    private static int deathWorldY;
    private static int deathWorldZ;
    private static int backInArenaX;
    private static int backInArenaY;
    private static int backInArenaZ;
    private static String backInArenaWorldName;
    private static Location ArenaMiddle;

    public static void setBackInArenaLocInConfig() {
        cfg = YamlConfiguration.loadConfiguration(file);
        cfg.set("BackInArenaX", backInArenaX);
        cfg.set("BackInArenaY", backInArenaY);
        cfg.set("BackInArenaZ", backInArenaZ);
        cfg.set("BackInArenaWorldName", backInArenaWorldName);
        try {
            cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    //Setzt die oben genannten Daten in die Datei
    public static void setArenaInConfig() {
        cfg.set("ArenaBoundX", DataAboutArena.ArenaBoundX);
        cfg.set("ArenaBoundY", DataAboutArena.ArenaBoundY);
        cfg.set("ArenaBoundZ", DataAboutArena.ArenaBoundZ);
        cfg.set("ArenaWorld", DataAboutArena.ArenaWorld);
        try {
            DataAboutArena.cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Setzt die oben genannten Werte der Deathloc in die Config
    public static void setDeathLocInConfig() {
        DataAboutArena.cfg.set("DeathWorldX", deathWorldX);
        DataAboutArena.cfg.set("DeathWorldY", deathWorldY);
        DataAboutArena.cfg.set("DeathWorldZ", deathWorldZ);
        DataAboutArena.cfg.set("DeathWorldName", deathWorldName);
        try {
            DataAboutArena.cfg.save(DataAboutArena.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Some Getters and Setters need @param player

    public static Location getArenaMiddle() {
        World world = Bukkit.getWorld(getArenaWorldName());
        ArenaMiddle = new Location(world, getArenaBoundX(), getArenaBoundY(), getArenaBoundZ());
        return ArenaMiddle;
    }

    public static void setArenaMiddle(Location arenaMiddle) {
        ArenaMiddle = arenaMiddle;
    }

    public static FileConfiguration getCfg() {
        return cfg;
    }

    public static int getArenaBoundZ() {
        return cfg.getInt("ArenaBoundZ");
    }

    public static void setArenaBoundZ(Player player) {
        DataAboutArena.ArenaBoundZ = (int) player.getLocation().getZ();
    }

    public static int getArenaBoundX() {
        return cfg.getInt("ArenaBoundX");
    }

    public static void setArenaBoundX(Player player) {
        DataAboutArena.ArenaBoundX = (int) player.getLocation().getX();
    }

    public static String getArenaWorldName() {
        return cfg.getString("ArenaWorld");
    }

    public static void setArenaWorld(String arenaWorld) {
        DataAboutArena.ArenaWorld = arenaWorld;
    }

    public static String getDeathWorldName() {
        return cfg.getString("DeathWorldName");
    }

    public static void setDeathWorldName(String deathWorldName) {
        DataAboutArena.deathWorldName = deathWorldName;
    }

    public static int getDeathWorldX() {
        return cfg.getInt("DeathWorldX");
    }

    public static void setDeathWorldX(Player player) {
        DataAboutArena.deathWorldX = (int) player.getLocation().getX();
    }

    public static int getDeathWorldY() {
        return cfg.getInt("DeathWorldY");
    }

    public static void setDeathWorldY(Player player) {
        DataAboutArena.deathWorldY = (int) player.getLocation().getY();
    }

    public static int getDeathWorldZ() {
        return cfg.getInt("DeathWorldZ");
    }

    public static void setDeathWorldZ(Player player) {
        DataAboutArena.deathWorldZ = (int) player.getLocation().getZ();
    }

    public static int getBackInArenaX() {
        return cfg.getInt("BackInArenaX");
    }

    public static void setBackInArenaX(Player player) {
        DataAboutArena.backInArenaX = (int) player.getLocation().getX();
    }

    public static int getBackInArenaY() {
        return cfg.getInt("BackInArenaY");
    }

    public static void setBackInArenaY(Player player) {
        DataAboutArena.backInArenaY = (int) player.getLocation().getY();
    }

    public static int getBackInArenaZ() {
        return cfg.getInt("BackInArenaZ");
    }

    public static void setBackInArenaZ(Player player) {
        DataAboutArena.backInArenaZ = (int) player.getLocation().getZ();
    }

    public static String getBackInArenaWorldName() {
        return cfg.getString("BackInArenaWorldName");
    }

    public static void setBackInArenaWorldName(String backInArenaWorldName) {
        DataAboutArena.backInArenaWorldName = backInArenaWorldName;
    }

    public static int getArenaBoundY() {
        return cfg.getInt("ArenaBoundY");
    }

    public static void setArenaBoundY(Player player) {
        ArenaBoundY = (int) player.getLocation().getY();
    }

    public static File getFile() {
        return file;
    }

    public static void setFile(File file) {
        DataAboutArena.file = file;
    }
}


