package de.bypixels.teamcreate.game.commands;
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


import de.bypixels.teamcreate.game.main.MinecartRain;
import de.bypixels.teamcreate.game.util.BanishedPlayers;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class CMDreloadConfig implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("configreload")){
            if (commandSender instanceof Player){
                Player player = (Player) commandSender;

                if (player.hasPermission("configreload")) {
                    DataAboutGame.cfg = YamlConfiguration.loadConfiguration(DataAboutGame.getFile());
                    DataAboutArena.cfg = YamlConfiguration.loadConfiguration(DataAboutArena.getFile());
                    BanishedPlayers.cfg = YamlConfiguration.loadConfiguration(BanishedPlayers.getFile());
                    player.sendMessage(MinecartRain.PREFIX + "§7All Files Reloaded");
                }else{
                    player.sendMessage(MinecartRain.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }
            }else{
                DataAboutGame.cfg = YamlConfiguration.loadConfiguration(DataAboutGame.getFile());
                DataAboutArena.cfg = YamlConfiguration.loadConfiguration(DataAboutArena.getFile());
                BanishedPlayers.cfg = YamlConfiguration.loadConfiguration(BanishedPlayers.getFile());
                Bukkit.getConsoleSender().sendMessage(MinecartRain.PREFIX +"§7All Files Reloaded");
            }
        }
        return false;
    }
}
