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

public class CMDsetDatasOfGame implements CommandExecutor {
    //Setzt einige Daten über die Arena
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (command.getName().equalsIgnoreCase("DataOfGame")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;
                if (player.hasPermission("dataofgame")) {
                    if (args.length == 2) {
                        if (args[0].equalsIgnoreCase("boundaryOfMinecartSpawn")) {
                            DataAboutGame.setBoundaryOfMinecartSpawn(Integer.valueOf(args[1]));
                            DataAboutGame.getCfg().set("boundaryOfMinecartSpawn", Integer.valueOf(args[1]));
                            try {
                                DataAboutGame.getCfg().save(DataAboutGame.getFile());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MinecartRain.PREFIX + "Du hast die Boundary der Minecarts auf: " + args[1] + " gesetzt!");
                        } else if (args[0].equalsIgnoreCase("highToWinGame")) {
                            DataAboutGame.setHighToWinGame(Integer.valueOf(args[1]));
                            DataAboutGame.getCfg().set("highToWinGame", Integer.valueOf(args[1]));
                            try {
                                DataAboutGame.getCfg().save(DataAboutGame.getFile());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MinecartRain.PREFIX + "Du hast die höhe zum Gewinnen auf: " + args[1] + " gesetzt!");
                        } else if (args[0].equalsIgnoreCase("timeBetweenMinecartSpawn")) {
                            DataAboutGame.setTimeBetweenMinecartSpawn(Integer.valueOf(args[1]));
                            DataAboutGame.getCfg().set("timeBetweenMinecartSpawn", Integer.valueOf(args[1]));
                            try {
                                DataAboutGame.getCfg().save(DataAboutGame.getFile());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MinecartRain.PREFIX + "Du hast die Boundary der Minecarts auf: " + args[1] + " gesetzt!");
                        } else if (args[0].equalsIgnoreCase("fallSpeedOfMinecart")) {
                            DataAboutGame.setFallSpeedOfMinecart(Float.valueOf(args[1]));
                            DataAboutGame.getCfg().set("fallSpeedOfMinecart", Float.valueOf(args[1]));
                            try {
                                DataAboutGame.getCfg().save(DataAboutGame.getFile());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MinecartRain.PREFIX + "Du hast die Fallgeschwindigkeit der Minecarts auf: " + args[1] + " gesetzt!");
                        } else  if (args[0].equalsIgnoreCase("timeBeforeSetInMinecart")) {
                            DataAboutGame.setTimeBeforeSetInMinecart(Integer.valueOf(args[1]));
                            DataAboutGame.getCfg().set("timeBeforeSetInMinecart", Integer.valueOf(args[1]));
                            try {
                                DataAboutGame.getCfg().save(DataAboutGame.getFile());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            player.sendMessage(MinecartRain.PREFIX + "Du hast die Zeit vor dem Start auf: " + args[1] + " gesetzt!");

                        }else{
                            player.sendMessage(MinecartRain.PREFIX + "Bitte benutze /dataofgame [timeBeforeSetInMinecart ,boundaryOfMinecartSpawn, highToWinGame, timeBetweenMinecartSpawn, fallSpeedOfMinecart] + WERT (Bei fallSpeedOfMinecart handelt es sich um einen float!) ");

                        }

                    } else {
                        player.sendMessage(MinecartRain.PREFIX + "Bitte benutze /dataofgame [boundaryOfMinecartSpawn, highToWinGame, timeBetweenMinecartSpawn, fallSpeedOfMinecart] + WERT (Bei fallSpeedOfMinecart handelt es sich um einen float!) ");

                    }
                }else{
                    player.sendMessage(MinecartRain.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }
            }
        }
        return false;
    }
}
