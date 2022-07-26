package de.bypixels.teamcreate.game.commands;

import de.bypixels.teamcreate.game.main.MinecartRain;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

public class CMDbackInArena implements CommandExecutor {
    
    //Command der die Location setzt wo die Spieler hinkommen nach dem Spiel
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("backinarena")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (player.hasPermission("backinarena")) {
                    DataAboutArena.setBackInArenaX(player);
                    DataAboutArena.setBackInArenaY(player);
                    DataAboutArena.setBackInArenaZ(player);
                    DataAboutArena.setBackInArenaWorldName(player.getWorld().getName());
                    DataAboutArena.setBackInArenaLocInConfig();
                    player.sendMessage(MinecartRain.PREFIX + "§7Du hast die Location wo die Spieler nach dem Spiel hinkommen gesetzt!");
                }else{
                    player.sendMessage(MinecartRain.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }
            }
        }

        return false;
    }
}
