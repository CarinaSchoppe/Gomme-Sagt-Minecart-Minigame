package de.bypixels.teamcreate.game.util.api.specialEvents;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

/******************************************************************
 *   Copyright Notice                                             * 
 *   Copyright (c) PixelsDE | Daniel 2018                         *                       
 *   Created: 08.05.2018 / 09:02                                  *
 *   All contents of this source text are protected by copyright. * 
 *   The copyright law, unless expressly indicated otherwise, is  * 
 *   at PixelsDE | Daniel. All rights reserved                    *
 *   Any type of duplication, distribution, rental, sale, award,  *
 *   Public accessibility or other use                            * 
 *   Requires the express written consent of PixelsDE | Daniel.   *
 *****************************************************************/
public class PlayerWinEvent extends org.bukkit.event.Event implements org.bukkit.event.Cancellable {

    public PlayerWinEvent(Player player) {
        this.player = player;
    }

    private Player player;
    public static HandlerList handlers = new HandlerList();
    public boolean cancelled = false;


    public Player getPlayer() {
        return player;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public static HandlerList getHandlerList(){
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }



}
