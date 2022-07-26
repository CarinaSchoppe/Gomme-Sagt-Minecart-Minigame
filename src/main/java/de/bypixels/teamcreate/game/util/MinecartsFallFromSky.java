package de.bypixels.teamcreate.game.util;

import de.bypixels.teamcreate.game.util.api.RandomLocation;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Minecart;

import java.util.List;

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

public class MinecartsFallFromSky {

    private static World world = Bukkit.getWorld(DataAboutArena.getArenaWorldName());
    public static int TaskID;
    private static List<Entity> nearMinecarts = DataAboutArena.getArenaMiddle().getWorld().getEntities();
    private static Minecart minecart;

    //Spawned die Minecarts
    public static void startMinecartRain() {
        TaskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(de.bypixels.teamcreate.game.main.MinecartRain.getPlugin(), new Runnable() {
            @Override
            public void run() {
                minecart = world.spawn(RandomLocation.getRandomLocation(), Minecart.class);
                de.bypixels.teamcreate.game.main.MinecartRain.getSpawnedMinecarts().add(minecart);
            }
        },  DataAboutGame.getTimeBetweenMinecartSpawn(), DataAboutGame.getTimeBetweenMinecartSpawn());

    }

}
