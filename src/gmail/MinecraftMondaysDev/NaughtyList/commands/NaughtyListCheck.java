package gmail.MinecraftMondaysDev.NaughtyList.commands;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import gmail.MinecraftMondaysDev.NaughtyList.NaughtyList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NaughtyListCheck implements CommandExecutor {

	@SuppressWarnings("unused")
	private NaughtyList plugin;
	private BufferedReader br;
	private boolean found = false;

	public NaughtyListCheck(NaughtyList plugin) {
		this.plugin = plugin;
	}

	public void checkName(CommandSender sender, String[] args) throws IOException {
		br = new BufferedReader(new FileReader("plugins/NaughtyList/watchlist.yml"));

		ArrayList<String> names = new ArrayList<String>();
		String temp = null;
		while ((temp = br.readLine()) != null) {
			names.add(temp);
		}
		
		for (int i = 0; i < names.size(); i++) {
			if(names.get(i).equalsIgnoreCase(args[0]))
			{
				found = true;
				break;
			}
			else found = false;
		}
		if(found == true) sender.sendMessage(args[0] + " is on the watch list.");
		else sender.sendMessage(args[0] + " is not on the watch list.");
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Date date = new Date();

		if (cmd.getName().equalsIgnoreCase("nlc") && sender.hasPermission("nl.check")) {

			if (args.length == 1) {
				System.out.println(sender.getName() + " used /nlc " + args[0] + " at " + new Timestamp(date.getTime()));
				sender.sendMessage("Checking if " + args[0] + " is on the list.");
				try {
					checkName(sender, args);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

}