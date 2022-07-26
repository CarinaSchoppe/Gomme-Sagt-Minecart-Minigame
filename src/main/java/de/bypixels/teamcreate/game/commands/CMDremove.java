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
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;

public class CMDremove implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
       if (command.getName().equalsIgnoreCase("removeminecarts")){
           if (sender instanceof Player){
               Player player = (Player) sender;
               if (player.hasPermission("removeminecarts")){
                   for (Entity minecart : Bukkit.getWorld(DataAboutArena.getArenaWorldName()).getEntities()){
                       if (minecart instanceof Minecart){
                           minecart.remove();
                       }
                   }
               }else{
                   player.sendMessage(MinecartRain.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
               }
           }
       }

        return false;
    }
}
