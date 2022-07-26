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
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.IOException;

public class CMDsetMinecartSpawnHigh implements CommandExecutor {

    //Command der die Höhe der Minecarts zum Spawnen setzt
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("highminecartspawn")){
            if (commandSender instanceof Player){
                Player player = (Player) commandSender;
                if (player.hasPermission("highminecartspawn")) {

                    DataAboutGame.setHighWhereMinecartsSpawn(player);
                    DataAboutGame.getCfg().set("highWhereMinecartsSpawn", (int) player.getLocation().getY());
                    try {
                        DataAboutGame.getCfg().save(DataAboutGame.getFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                        player.sendMessage(MinecartRain.PREFIX+"§7Du hast die Höhe der Minecarts zum Spawnen gesetzt!");
                    }else{
                    player.sendMessage(MinecartRain.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }
                }
            }


        return false;
    }
}
