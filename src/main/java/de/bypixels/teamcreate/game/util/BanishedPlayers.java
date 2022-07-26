package de.bypixels.teamcreate.game.util;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 09.05.2018 / 19:26                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/


public class BanishedPlayers {


    public BanishedPlayers() {
    }

    private static File file = new File("plugins/Minecart-Rain/banished.yml");
    public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    private static Collection<String> banishedPlayers = new ArrayList<>();


    public static void setInConfig(){
        banishedPlayers.add("TestName1");
        banishedPlayers.add("TestName2");
        cfg.addDefault("banishedPlayers", banishedPlayers);
        cfg.options().copyDefaults(true);
        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> getBanishedPlayers() {
        return cfg.getStringList("banishedPlayers");
    }

    public static File getFile() {
        return file;
    }

    public static FileConfiguration getCfg() {
        return cfg;
    }

    public static void setCfg(FileConfiguration cfg) {
        BanishedPlayers.cfg = cfg;
    }
}
