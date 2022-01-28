package com.goodernest64.DamageGontroll.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class DMGGNTRLCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("dmg")) {
            if (args.length == 2) {
                try {
                    String p2name = args[1];
                    Player p2 = Bukkit.getPlayer(p2name);
                    double amount = Double.parseDouble(args[0]);
                    p2.damage(amount);
                    p.sendMessage(ChatColor.GOLD + Double.toString(amount) + "(!) Damage has been dealt to player " + p2name + " .");
                } catch (IllegalArgumentException e) {
                    p.sendMessage(ChatColor.RED + "The command is not correct !");
                }

            } else if (args.length == 1) {

                double amount = Double.parseDouble(args[0]);
                p.damage(amount);
                p.sendMessage(ChatColor.GOLD + "(!) " + amount + " Damage has been dealt to you ! ");
            } else {
                p.sendMessage(ChatColor.RED + "/<commands> <amount> [player]");
            }

            //9rhg9ejv0ijeiv0jri0ejige0jng0pjg0ejsmz0sjge

        } else if (cmd.getName().equalsIgnoreCase("hheal")) {
            if (args.length == 2) {
                try {
                        double amount = Double.parseDouble(args[0]);
                        String p2name = args[1];
                        Player p2 = Bukkit.getPlayer(p2name);
                        double p2health = p2.getHealth();
                        double sethealth = amount + p2health;

                        p2.setHealth(sethealth);

                    p.sendMessage(ChatColor.GOLD + "(!) Player " + p2name + " has been healed by " + amount + " half hearts !");
                } catch (IllegalArgumentException e) {
                    p.sendMessage(ChatColor.RED + "The command is wrong !");
                }
            } else if (args.length == 1) {
                try {
                    double amount = Double.parseDouble(args[0]);
                    double health = p.getHealth();
                    double sethealth = amount + health;
                    p.setHealth(sethealth);
                    p.sendMessage(ChatColor.GOLD + "(!) You have been healed by " + amount + " half hearts !");
                } catch (IllegalArgumentException e) {
                    p.sendMessage(ChatColor.RED + "The command is wrong !");
                }
            } else {
                p.sendMessage(ChatColor.RED + "/<commands> <amount> [player]");
            }
        }
        return true;
    }
}
