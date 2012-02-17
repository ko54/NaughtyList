package gmail.MinecraftMondaysDev.NaughtyList.commands;

import java.sql.Timestamp;
import java.util.Date;

import gmail.MinecraftMondaysDev.NaughtyList.NaughtyList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NaughtyListCheck implements CommandExecutor {

	@SuppressWarnings("unused")
	private NaughtyList plugin;

	public NaughtyListCheck(NaughtyList plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Date date = new Date();

		if (cmd.getName().equalsIgnoreCase("nlc") && sender.hasPermission("nl.check")) {

			if (args.length == 1) {
				System.out.println(sender.getName() + " used /nlc " + args[0] + " at " + new Timestamp(date.getTime()));
				sender.sendMessage("Checking if " + args[0] + " is on the list.");
				return true;
			}
		}
		return false;
	}

}