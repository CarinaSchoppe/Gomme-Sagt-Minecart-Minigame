package de.bypixels.teamcreate.game.main;

import de.bypixels.teamcreate.game.commands.*;
import de.bypixels.teamcreate.game.events.*;
import de.bypixels.teamcreate.game.util.*;
import de.bypixels.teamcreate.game.util.api.WinDetection;

import de.bypixels.teamcreate.game.util.api.specialEvents.PlayerWinEvent;
import de.bypixels.teamcreate.game.util.sql.MySQL;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class MinecartRain extends JavaPlugin implements Listener {


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


    private static MinecartRain plugin;

    private static boolean start;


    public static List<Player> getPlayingPlayers() {
        return Playing;
    }

    public static Collection<Minecart> getSpawnedMinecarts() {
        return spawnedMinecarts;
    }

    public static String PREFIX = "§7[§6MinecartRain§7]§f ";

    //List of Player they are Playing
    private static List<Player> Playing = new ArrayList<>();

    //@param Minecart ArrayList of ALL spawned Minecarts
    private static Collection<Minecart> spawnedMinecarts = new ArrayList<>();

    private static List<String> winner = new ArrayList<String>();

    public static List<String> getWinner() {
        return winner;
    }

    @Override
    public void onEnable() {
        plugin = this;
        DataAboutGame.setDataInConfig();
        init(Bukkit.getPluginManager());

        mySQLClass.createFile();
        try {
            for (Entity minecart : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
                if (minecart instanceof Minecart) {
                    minecart.remove();
                }
            }
        } catch (Exception e) {
            MinecartRain.printInConsole("Du musst erst die Welt festlegen!");
        }

        MySQLConnect();
        Bukkit.getConsoleSender().sendMessage(MinecartRain.PREFIX + "§aTh Plugin is: ON!");

    }

    public static MySQL mySQLClass = new MySQL();


    //Some gettters and Setters
    public static MinecartRain getPlugin() {
        return plugin;
    }

    public static String getPREFIX() {
        return PREFIX;
    }

    public static boolean isStart() {
        return start;
    }

    public static void setStart(boolean start) {
        MinecartRain.start = start;
    }

    public static void setPREFIX(String PREFIX) {
        MinecartRain.PREFIX = PREFIX;
    }


    @Override
    public void onDisable() {
        try {
            for (Entity minecart : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
                if (minecart instanceof Minecart) {
                    minecart.remove();
                }
            }
        } catch (Exception e) {

        }
        MySQL.disconnect();
        Bukkit.getConsoleSender().sendMessage(MinecartRain.PREFIX + "§4§aTh Plugin is: §4OFF!");
    }


    private static void MySQLConnect(){
        if (mySQLClass.getCfg().getBoolean("MySQL") == true) {
            MySQL.connect();
        }
    }
    //Methode, welche besondere Daten einfügt
    @SuppressWarnings("deprecation")
    public void init(PluginManager pluginManager) {

        DataAboutGame.setDataInConfig();
        BanishedPlayers.setInConfig();

        setStart(false);




        //Config man kann entscheiden ob jemand raus ist!
        try {
            if (DataAboutGame.isDeathOnDropOnGround()) {
                pluginManager.registerEvents(new PlayerHitGround(), this);
            }
        } catch (NullPointerException e) {
        }

        pluginManager.registerEvents(new WinPlayerMove(), this);
        pluginManager.registerEvents(new MinecartFallSpeed(), this);
        pluginManager.registerEvents(new MinecartDespawnOnGround(), this);
        pluginManager.registerEvents(new MinecartDamage(), this);
        pluginManager.registerEvents(this, this);
        pluginManager.registerEvents(new MinecartJoinEvent(), this);

        MinecartRain.getPlugin().getCommand("start").setExecutor(new CMDstartGame());
        MinecartRain.getPlugin().getCommand("dataofgame").setExecutor(new CMDsetDatasOfGame());
        MinecartRain.getPlugin().getCommand("setarena").setExecutor(new CMDsetArena());
        MinecartRain.getPlugin().getCommand("deathlocation").setExecutor(new CMDsetDeathLocation());
        MinecartRain.getPlugin().getCommand("backinarena").setExecutor(new CMDbackInArena());
        MinecartRain.getPlugin().getCommand("highminecartspawn").setExecutor(new CMDsetMinecartSpawnHigh());
        MinecartRain.getPlugin().getCommand("highminecartdespawn").setExecutor(new CMDsetMinecartDespawnHigh());
        MinecartRain.getPlugin().getCommand("configreload").setExecutor(new CMDreloadConfig());
        MinecartRain.getPlugin().getCommand("stoprain").setExecutor(new CMDstopGame());
        MinecartRain.getPlugin().getCommand("removeminecarts").setExecutor(new CMDremove());

        try {

            DataAboutGame.setPREFIX(ChatColor.translateAlternateColorCodes('&', DataAboutGame.getPREFIX()));

        } catch (Exception e) {

        }

        SortedHashMap sortedHashMap = new SortedHashMap();



    }

    //Methode, welche Text mit @param Text in die Konsole sendet

    public static void printInConsole(String text) {
        Bukkit.getConsoleSender().sendMessage(MinecartRain.PREFIX + text);
    }


    //Methode, welche besonderen Text einem Spieler sendet

    public static void sendPlayerMessage(Player player, String message) {
        player.sendMessage(MinecartRain.PREFIX + message);
    }

    public static void sendAllMessage() {

    }

    public static void sendAllPlayerMessage(String message) {
        for (Player all : Bukkit.getOnlinePlayers())
            all.sendMessage(MinecartRain.PREFIX + message);
    }

    //Removed alle Enititys wenns Minecarts sind!

    @Override
    public void onLoad() {
        try {
            for (Entity entity : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()) {
                if (entity instanceof Minecart) {
                    entity.remove();

                }

            }

        } catch (Exception e) {

        }

    }


    @EventHandler(ignoreCancelled = true)
    public void onDroponGround(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (MinecartRain.getPlayingPlayers().contains(player)) {
            if (MinecartRain.isStart() == true) {
                if (player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR) {
                    Bukkit.getPluginManager().callEvent(new de.bypixels.teamcreate.game.util.api.specialEvents.PlayerDropOnGround(player));

                }
            }

        }

    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onEnterMinecartToWin(VehicleEnterEvent event) {
   Player player = (Player) event.getEntered();
   if (event.getVehicle() instanceof Minecart){
       Minecart mInecart = (Minecart) event.getVehicle();
       if (MinecartRain.spawnedMinecarts.contains(mInecart)){
           if (WinDetection.checkForWin(player) == true){
               if (MinecartRain.getPlayingPlayers().contains(player)){
                   if (MinecartRain.isStart() == true){
                       Bukkit.getPluginManager().callEvent(new PlayerWinEvent(player));
                   }
               }
           }
       }
   }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onPlayerWin(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        if (WinDetection.checkForWin(player) == true) {
            if (MinecartRain.isStart() == true) {
                Bukkit.getPluginManager().callEvent(new PlayerWinEvent(player));
            }

        }

    }


    @EventHandler
    public void onMinecartMoveEvent(VehicleEnterEvent event){
        if (event.getVehicle() instanceof Minecart){
            Minecart minecart = (Minecart) event.getVehicle();


            //Todo:  Event fertig machen!!! Wenn MIneccart über y = ... ist (Wert aus Config auslesen)
        }

    }


}
