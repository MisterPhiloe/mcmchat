package com.morecommunityminecraft.mcmchat;

import com.morecommunityminecraft.mcmchat.events.ChatEvent;
import com.morecommunityminecraft.mcmsql.MySQL;
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

    private MySQL mysql = null;

    public static Main getInstance() {
        return main;
    }

    @Override
    public void onEnable() {
        main = this;
        log.info(getName() + " has been enabled!");
        //setupPermissions();
        //setupChat();
        registerEvents();
    }

    @Override
    public void onDisable() {
        log.info(getName() + " has been disabled!");
        main = null;
    }

    public void registerEvents() {
        getServer().getPluginManager().registerEvents(new ChatEvent(), this);
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

    public Chat getChat() {
        return this.chat;
    }

    public MySQL getMySQL() {
        if (this.mysql == null) {
            this.mysql = com.morecommunityminecraft.mcmsql.Main.getMain().getMySQL();
        }
        return this.mysql;
    }

    public Permission getPermissions() {
        return this.perms;
    }

}
