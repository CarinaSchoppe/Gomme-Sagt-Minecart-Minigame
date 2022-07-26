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


import de.bypixels.teamcreate.game.util.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CMDstartGame implements CommandExecutor {
    private int TaskID;

    //Startet das Spiel
    @Deprecated
    @Override
    public boolean onCommand(final CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("start")) {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (!BanishedPlayers.getBanishedPlayers().contains(all.getName()) && all.getGameMode() != GameMode.ADVENTURE) {
                            de.bypixels.teamcreate.game.main.MinecartRain.getPlayingPlayers().add(all);
                            all.sendMessage(de.bypixels.teamcreate.game.main.MinecartRain.PREFIX + "§aDas Spiel hat begonnen viel Glück!");
                            all.teleport(DataAboutArena.getArenaMiddle());
                            de.bypixels.teamcreate.game.main.MinecartRain.setStart(false);
                        }
                    }
                    MinecartsFallFromSky.startMinecartRain();
                    TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(de.bypixels.teamcreate.game.main.MinecartRain.getPlugin(), new Runnable() {
                        int timer = DataAboutGame.getTimeBeforeSetInMinecart();

                        @Override
                        public void run() {
                            switch (timer) {
                                case 60:
                                    startMesage(timer);
                                    break;
                                case 45:
                                    startMesage(timer);
                                    break;
                                case 30:
                                    startMesage(timer);
                                    break;
                                case 20:
                                    startMesage(timer);
                                    break;
                                case 15:
                                    startMesage(timer);
                                    break;
                                case 10:
                                    startMesage(timer);
                                    break;
                                case 5:
                                    startMesage(timer);
                                    break;
                                case 4:
                                    startMesage(timer);
                                case 3:
                                    startMesage(timer);
                                    break;
                                case 2:
                                    startMesage(timer);
                                    break;
                                case 1:
                                    startMesage(timer);
                                    break;
                                case 0:
                                    de.bypixels.teamcreate.game.main.MinecartRain.setStart(true);
                                    for (Player all : Bukkit.getOnlinePlayers()) {
                                        all.sendMessage(de.bypixels.teamcreate.game.main.MinecartRain.getPREFIX() + "§7Das Spiel beginnt. Viel Glück!");
                                        if (!BanishedPlayers.getBanishedPlayers().contains(all.getName())) {
                                            if (all.getGameMode() != GameMode.SPECTATOR) {
                                                new SetPlayerInMinecart(all);
                                            }
                                        }
                                    }
                                    Bukkit.getScheduler().cancelTask(TaskID);
                                    break;
                                default:
                                    break;
                            }
                            timer -= 1;
                        }
                    }, 20, 20);
                }else{
                    player.sendMessage(de.bypixels.teamcreate.game.main.MinecartRain.getPREFIX()+ "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }

            }
        }
        return false;
    }


    private void startMesage(int timer) {
        if (timer > 1) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendMessage(de.bypixels.teamcreate.game.main.MinecartRain.getPREFIX() + "§7Das Spiel startet in: §6" + timer + " §7Sekunden!");
                all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 2, 2);
            }

        } else if (timer == 1) {
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.sendMessage(de.bypixels.teamcreate.game.main.MinecartRain.getPREFIX() + "§7Das Spiel startet in: §6" + timer + " §7Sekunde!");
                all.playSound(all.getLocation(), Sound.BLOCK_LAVA_POP, 2, 2);
            }
        } else {

        }

    }
}
