package gmail.MinecraftMondaysDev.NaughtyList.commands;

import java.sql.Timestamp;
import java.util.Date;

import gmail.MinecraftMondaysDev.NaughtyList.NaughtyList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NaughtyListAdd implements CommandExecutor {

	@SuppressWarnings("unused")
	private NaughtyList plugin;

	public NaughtyListAdd(NaughtyList plugin) {
		this.plugin = plugin;
	}
	
	public void addToList(CommandSender sender, String[] args) {
		if (args[0].equalsIgnoreCase("add")) {
			
		}
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Date date = new Date();

		if (cmd.getName().equalsIgnoreCase("nla") && sender.hasPermission("nl.add")) {

			if (args.length == 1) {
				System.out.println(sender.getName() + " used /nl add " + args[0] + " at " + new Timestamp(date.getTime()));
				sender.sendMessage("Adding " + args[0] + " to the list.");
				return true;
			}
		}
		return false;
	}

}