package de.bypixels.teamcreate.game.commands;


import de.bypixels.teamcreate.game.util.*;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CMDstartGame implements CommandExecutor {
    private int TaskID;

    //Startet das Spiel
    @Deprecated
    @Override
    public boolean onCommand(final @NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("start")) {
            if (sender instanceof Player player) {
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
                                case 1:
                                case 2:
                                case 5:
                                case 10:
                                case 15:
                                case 20:
                                case 30:
                                case 45:
                                    startMesage(timer);
                                    break;
                                case 4:
                                    startMesage(timer);
                                case 3:
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
        }

    }
}
