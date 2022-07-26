package de.bypixels.teamcreate.game.events;


import de.bypixels.teamcreate.game.main.MinecartRain;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class MinecartFallSpeed implements Listener {


    //Event, was die Minecart geschwindigkeit festlegt
    @EventHandler(ignoreCancelled = true, priority = EventPriority.HIGH)
    public void onMinecartMove(VehicleMoveEvent event) {
        if (event.getVehicle() instanceof Minecart minecart) {
            if (MinecartRain.getSpawnedMinecarts().contains(minecart)) {
                minecart.setGravity(true);
                minecart.setVelocity(minecart.getVelocity().multiply(DataAboutGame.getFallSpeedOfMinecart()));
            }
        }
    }
}
