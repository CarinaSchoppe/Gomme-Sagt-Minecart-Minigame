package de.bypixels.teamcreate.game.util.api;
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

import de.bypixels.teamcreate.game.util.DataAboutArena;
import de.bypixels.teamcreate.game.util.DataAboutGame;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

import javax.xml.crypto.Data;

public class RandomLocation {


    /** @param bound of RandomNumber    **/
    public static Location getRandomLocation() {

        double x = DataAboutArena.getArenaBoundX() + Math.random() * 2 * DataAboutGame.getBoundaryOfMinecartSpawn() - DataAboutGame.getBoundaryOfMinecartSpawn();
        double y = DataAboutGame.getHighWhereMinecartsSpawn();
        double z = DataAboutArena.getArenaBoundZ() + Math.random() * 2 * DataAboutGame.getBoundaryOfMinecartSpawn() - DataAboutGame.getBoundaryOfMinecartSpawn();
        World world = Bukkit.getWorld(DataAboutArena.getArenaWorldName());
        return new Location(world, x, y, z);
    }


    public static double getRandomNumber(int bound) {
        return Math.random() * 2 * bound - bound;
    }
}
