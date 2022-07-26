package de.bypixels.teamcreate.game.commands;


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
import org.jetbrains.annotations.NotNull;

public class CMDreloadConfig implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, Command command, @NotNull String s, String[] strings) {
        if (command.getName().equalsIgnoreCase("configreload")) {
            if (commandSender instanceof Player player) {

                if (player.hasPermission("configreload")) {
                    DataAboutGame.cfg = YamlConfiguration.loadConfiguration(DataAboutGame.getFile());
                    DataAboutArena.cfg = YamlConfiguration.loadConfiguration(DataAboutArena.getFile());
                    BanishedPlayers.cfg = YamlConfiguration.loadConfiguration(BanishedPlayers.getFile());
                    player.sendMessage(MinecartRain.PREFIX + "§7All Files Reloaded");
                } else {
                    player.sendMessage(MinecartRain.getPREFIX() + "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }
            } else {
                DataAboutGame.cfg = YamlConfiguration.loadConfiguration(DataAboutGame.getFile());
                DataAboutArena.cfg = YamlConfiguration.loadConfiguration(DataAboutArena.getFile());
                BanishedPlayers.cfg = YamlConfiguration.loadConfiguration(BanishedPlayers.getFile());
                Bukkit.getConsoleSender().sendMessage(MinecartRain.PREFIX +"§7All Files Reloaded");
            }
        }
        return false;
    }
}
