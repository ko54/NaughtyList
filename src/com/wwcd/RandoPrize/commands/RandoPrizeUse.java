package com.wwcd.RandoPrize.commands;

import com.wwcd.RandoPrize.RandoPrize;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class RandoPrizeUse implements CommandExecutor {

	private RandoPrize plugin;
	protected FileConfiguration config;
	public RandoPrize rp = new RandoPrize();
	private int status = 0;

	public RandoPrizeUse(RandoPrize plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1 && args[0].matches(rp.getHashString()))
		{
			if(status == 0)
			{
				int item = Integer.parseInt(plugin.getConfig().getString("prize-id"));
				//short damage = (short) plugin.getConfig().getInt("prize-damage-value");
				
				status = 1;
				String winner = sender.getName();
				Bukkit.broadcastMessage("[RandoPrize] " + winner + " has gotten the prize this round!");
				PlayerInventory pI = Bukkit.getPlayer(winner).getInventory();
				//pI.addItem(new ItemStack(item, 1, damage));
				pI.addItem(new ItemStack(item, 1));
				
				return true;
			}
			else
			{
				sender.sendMessage("[RandoPrize] Sorry this round has ended.");
				return true;
			}
		}
		else
		{
			sender.sendMessage("[RandoPrize] Usage: /rp " + rp.getHashString());
			return true;
		}
		//return false;
	}
	
	public int getStatus()
	{
		if(status == 1) return 1;
		else return 0;
	}
	
	public void resetStatus()
	{
		status = 0;
	}

}