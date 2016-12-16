package com.morecommunityminecraft.mcmchat;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class Main extends JavaPlugin {

    private static Main main;
    private final Logger log = Logger.getLogger("Minecraft");
    private Permission perms = null;
    private Chat chat = null;

    public static Main getInstance() {
        return main;
    }

    @Override
    public void onEnable() {
        main = this;
        log.info(getName() + " has been enabled!");
        setupPermissions();
        setupChat();
    }

    @Override
    public void onDisable() {

        log.info(getName() + " has been disabled!");
        main = null;
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> rsp = getServer().getServicesManager().getRegistration(Chat.class);
        chat = rsp.getProvider();
        return chat != null;
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

}
