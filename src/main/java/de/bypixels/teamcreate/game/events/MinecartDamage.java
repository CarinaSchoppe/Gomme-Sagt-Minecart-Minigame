package de.bypixels.teamcreate.game.events;
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


import de.bypixels.teamcreate.game.main.MinecartRain;
import org.bukkit.entity.Minecart;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDamageEvent;

public class MinecartDamage implements Listener {


    //Event wenn das Minecraft Grade zerstörtz wird dann wird das  EVENT Gecancelt ist also wirklich wichtig!
    @EventHandler(ignoreCancelled = true)
    public void onVehicleDamage(VehicleDamageEvent event) {
        if (event.getVehicle() instanceof Minecart) {
            Minecart minecart = (Minecart) event.getVehicle();
            if (MinecartRain.getSpawnedMinecarts().contains(minecart)) {
                event.setCancelled(true);
                minecart.setDamage(0);
            }
        }
    }
}

