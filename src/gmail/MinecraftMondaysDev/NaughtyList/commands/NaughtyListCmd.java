package gmail.MinecraftMondaysDev.NaughtyList.commands;

import java.sql.Timestamp;
import java.util.Date;
import java.util.logging.Logger;

import gmail.MinecraftMondaysDev.NaughtyList.NaughtyList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NaughtyListCmd implements CommandExecutor {

	private NaughtyList plugin;
	private Logger logger = Logger.getLogger("Minecraft");

	public NaughtyListCmd(NaughtyList plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {

		Date date = new Date();

		if (cmd.getName().equalsIgnoreCase("nl")) {
			if (args.length == 2) {

				if (args[0].equalsIgnoreCase("add")) {
					System.out.println(sender.getName() + " used /nl add "
							+ args[1] + " at " + new Timestamp(date.getTime()));
					sender.sendMessage("Adding " + args[1] + " to the list.");
					return true;
				}

				else if (args[0].equalsIgnoreCase("remove")) {
					System.out.println(sender.getName() + " used /nl remove "
							+ args[1] + " at " + new Timestamp(date.getTime()));
					System.out.println(sender.getName() + " used /nl add "
							+ args[1]);
					sender.sendMessage("Removing " + args[1]
							+ " from the list.");
					return true;
				}

				else if (args[0].equalsIgnoreCase("check")) {
					sender.sendMessage("Checking");
					return true;
				}
			}
		}
		return false;

	}

}