package de.bypixels.teamcreate.game.events;


import de.bypixels.teamcreate.game.main.MinecartRain;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;

public class MinecartDamage implements Listener {


    //Event wenn das Minecraft Grade zerstörtz wird dann wird das  EVENT Gecancelt ist also wirklich wichtig!
    @EventHandler(ignoreCancelled = true)
    public void onVehicleDamage(VehicleDamageEvent event) {
        if (event.getVehicle() instanceof Minecart minecart) {
            if (MinecartRain.getSpawnedMinecarts().contains(minecart)) {
                event.setCancelled(true);
                minecart.setDamage(0);
            }
        }
    }
}

