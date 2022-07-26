package de.bypixels.teamcreate.game.commands;

import de.bypixels.teamcreate.game.main.MinecartRain;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class CMDsetMinecartDespawnHigh implements CommandExecutor {


    //Setzt die höhe wo Minecarts despawnen
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("highminecartdespawn")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("highminecartdespawn")) {

                    DataAboutGame.setHighWhereMinecartsDespawn(player);
                    DataAboutGame.getCfg().set("highWhereMinecartsDespawn", (int) player.getLocation().getY());
                    try {
                        DataAboutGame.getCfg().save(DataAboutGame.getFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    player.sendMessage(MinecartRain.PREFIX+"§7Du hast die Höhe der Minecarts zum Despawnen gesetzt!");
                }else{
                    player.sendMessage(MinecartRain.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }
            }
        }
        return false;

    }
}
