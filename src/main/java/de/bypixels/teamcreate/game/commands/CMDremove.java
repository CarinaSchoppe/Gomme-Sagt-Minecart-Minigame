package de.bypixels.teamcreate.game.commands;


import de.bypixels.teamcreate.game.main.MinecartRain;
import de.bypixels.teamcreate.game.util.DataAboutArena;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CMDremove implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("removeminecarts")) {
            if (sender instanceof Player player) {
                if (player.hasPermission("removeminecarts")) {
                    for (Entity minecart : Objects.requireNonNull(Bukkit.getWorld(DataAboutArena.getArenaWorldName())).getEntities()) {
                        if (minecart instanceof Minecart) {
                            minecart.remove();
                        }
                    }
                } else {
                    player.sendMessage(MinecartRain.getPREFIX() + "§cDu hast nicht die passenden Rechte um diesen Befehl benutzen!");
                }
            }
       }

        return false;
    }
}
