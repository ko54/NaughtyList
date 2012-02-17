package gmail.MinecraftMondaysDev.NaughtyList.commands;

import java.sql.Timestamp;
import java.util.Date;

import gmail.MinecraftMondaysDev.NaughtyList.NaughtyList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NaughtyListRemove implements CommandExecutor {

	@SuppressWarnings("unused")
	private NaughtyList plugin;

	public NaughtyListRemove(NaughtyList plugin) {
		this.plugin = plugin;
	}
	
	public void removeFromList() {
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Date date = new Date();

		if (cmd.getName().equalsIgnoreCase("nlr") && sender.hasPermission("nl.remove")) {

			if (args.length == 1) {
				System.out.println(sender.getName() + " used /nlr " + args[0] + " at " + new Timestamp(date.getTime()));
				sender.sendMessage("Removing " + args[0] + " from the list.");
				return true;
			}
		}
		return false;
	}

}