package de.bypixels.teamcreate.game.util.api;

import de.bypixels.teamcreate.game.main.MinecartRain;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collection;

public class WinDetection {

    private static final Collection<Player> winners = new ArrayList<>();

    //Method that gives you the winning Player if the Player is above a special location it returns true
    public static boolean checkForWin(Player player) {
        if (MinecartRain.getPlayingPlayers().contains(player)) {
            if (MinecartRain.isStart()) {
                if (player.getLocation().getY() >= DataAboutGame.getHighToWinGame()) {
                    if (!winners.contains(player)) {
                        if (player.getGameMode() != GameMode.SPECTATOR) {
                            winners.add(player);
                            MinecartRain.getPlayingPlayers().remove(player);
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        } else {
            return false;
        }
        return false;
    }
}




