package com.wwcd.RandoPrize.commands;

import com.wwcd.RandoPrize.RandoPrize;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class RandoPrizeCommand implements CommandExecutor {

	private RandoPrize plugin;
	protected FileConfiguration config;

	public RandoPrizeCommand(RandoPrize plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if((sender.isOp() || sender.hasPermission("rp.op")) && args.length >= 1)
		{
			
			if(args[0].equalsIgnoreCase("setitem"))
			{
				if(args.length == 2)
				{
					try
					{
						int temp = Integer.parseInt(args[1]);
						plugin.getConfig().set("prize-id", args[1]);
						sender.sendMessage("[RandoPrize] Item set to: " + temp);
						plugin.saveConfig();
						return true;
					}
					catch(NumberFormatException e)
					{
						sender.sendMessage("[RandoPrize] Number must be integer.");
						return false;
					}
				}
				else
				{
					sender.sendMessage("[RandoPrize] Usage: /rp setitem <integer>");
					return true;
				}
			}
			
			else if(args[0].equalsIgnoreCase("getitem"))
			{
				sender.sendMessage("[RandoPrize] Item: " + plugin.getConfig().getString("prize-id"));
				return true;
			}
			
			else if(args[0].equalsIgnoreCase("setdamage"))
			{
				if(args.length == 2)
				{
					try
					{
						int temp = Integer.parseInt(args[1]);
						plugin.getConfig().set("prize-damage-value", temp);
						sender.sendMessage("[RandoPrize] Damage set to: " + temp);
						plugin.saveConfig();
						return true;
					}
					catch(NumberFormatException e)
					{
						sender.sendMessage("[RandoPrize] Number must be integer.");
						return false;
					}
				}
				else
				{
					sender.sendMessage("[RandoPrize] Usage: /rp setdamage <integer>");
					return true;
				}
			}
			
			else if(args[0].equalsIgnoreCase("getdamage"))
			{
				sender.sendMessage("[RandoPrize] Damage: " + plugin.getConfig().getString("prize-damage-value"));
				return true;
			}
			
			else if(args[0].equalsIgnoreCase("setdelay"))
			{
				if(args.length == 2)
				{
					try
					{
						int temp = Integer.parseInt(args[1]);
						plugin.getConfig().set("prize-timer", temp);
						sender.sendMessage("[RandoPrize] Delay set to: " + temp);
						plugin.saveConfig();
						plugin.silentReload();
						return true;
					}
					catch(NumberFormatException e)
					{
						sender.sendMessage("[RandoPrize] Number must be integer.");
						return false;
					}
				}
				else
				{
					sender.sendMessage("[RandoPrize] Usage: /rp setdelay <time in seconds>");
					return true;
				}
			}
			
			else if(args[0].equalsIgnoreCase("getdelay"))
			{
				sender.sendMessage("[RandoPrize] Delay: " + plugin.getConfig().getString("prize-timer"));
				return true;
			}
			
			else if(args[0].equalsIgnoreCase("setlength"))
			{
				if(args.length == 2)
				{
					try
					{
						int temp = Integer.parseInt(args[1]);
						plugin.getConfig().set("prize-hash", temp);
						sender.sendMessage("[RandoPrize] Length set to: " + temp);
						plugin.saveConfig();
						return true;
					}
					catch(NumberFormatException e)
					{
						sender.sendMessage("[RandoPrize] Number must be integer.");
						return false;
					}
				}
				else
				{
					sender.sendMessage("[RandoPrize] Usage: /rp setlength <integer>");
					return true;
				}
			}
			
			else if(args[0].equalsIgnoreCase("getlength"))
			{
				sender.sendMessage("[RandoPrize] Length: " + plugin.getConfig().getString("prize-hash"));
				return true;
			}
			
			else if(args[0].equalsIgnoreCase("reload"))
			{
				plugin.reload();
				sender.sendMessage("[RandoPrize] Reload complete");
				return true;
			}
			
			else
			{
				//sender.sendMessage("[RandoPrize] Usage: /rpo getdelay | setdelay | getitem | setitem | getdamage | setdamage | force");
			}
			
		}
		return false;

	}

}