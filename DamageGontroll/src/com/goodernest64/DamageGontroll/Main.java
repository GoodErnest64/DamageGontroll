package com.goodernest64.DamageGontroll;

import com.goodernest64.DamageGontroll.commands.DMGGNTRLCommands;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    ConsoleCommandSender console = getServer().getConsoleSender();

    @Override
    public void onEnable(){
        DMGGNTRLCommands commands = new DMGGNTRLCommands();
        getCommand("dmg").setExecutor(commands);
        getCommand("hheal").setExecutor(commands);

        console.sendMessage(ChatColor.GREEN + "[DMGGNTRL]: DamageGontroll Plugin Enabled !");
    }
    @Override
    public void onDisable(){
        console.sendMessage(ChatColor.RED + "[DMGGNTRL]: DamageGontroll Plugin Disabled !");
    }
}
