package com.morecommunityminecraft.mcmchat.events;

import com.morecommunityminecraft.mcmchat.Main;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        Player player = e.getPlayer();
        Permission perms = Main.getInstance().getPermissions();
        if (perms != null) {
            if (perms.has(player, "mcmchat.admin") || player.isOp()) {
                e.setFormat("§c" + player.getDisplayName() + ":§f" + e.getMessage());
            } else if (perms.has(player, "mcmchat.mod")) {
                e.setFormat("§3" + player.getDisplayName() + ":§f" + e.getMessage());
            } else {
                e.setFormat("§7" + player.getDisplayName() + ":" + e.getMessage());
            }
        } else {
            e.setFormat("§7" + player.getDisplayName() + ":" + e.getMessage());
        }
    }
}
