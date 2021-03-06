package com.jonahseguin.payload.profile.profile;

import lombok.Data;

import org.bukkit.entity.Player;

@Data
public class SimpleProfilePassable implements ProfilePassable {

    private final String uniqueId;
    private final String name;
    private final String loginIp;

    public static SimpleProfilePassable fromPlayer(Player player) {
        return new SimpleProfilePassable(player.getUniqueId().toString(), player.getName(), player.getAddress().getAddress().toString().split("/")[1]);
    }

}
