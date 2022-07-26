package de.bypixels.teamcreate.game.events;


import de.bypixels.teamcreate.game.main.MinecartRain;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleMoveEvent;

public class MinecartDespawnOnGround implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onVehicleDroponGround(VehicleMoveEvent event) {
        if (event.getVehicle() instanceof Minecart minecart) {
            if (MinecartRain.getSpawnedMinecarts().contains(minecart)) {
                if (event.getTo().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR || minecart.getLocation().getY() <= DataAboutGame.getHighWhereMinecartsDespawn()) {
                    minecart.remove();
                }
            }
        }
    }

}
