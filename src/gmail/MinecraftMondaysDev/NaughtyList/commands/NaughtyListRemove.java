package gmail.MinecraftMondaysDev.NaughtyList.commands;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import gmail.MinecraftMondaysDev.NaughtyList.NaughtyList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class NaughtyListRemove implements CommandExecutor {

	@SuppressWarnings("unused")
	private NaughtyList plugin;
	private BufferedReader br;
	private BufferedWriter bw;

	public NaughtyListRemove(NaughtyList plugin) {
		this.plugin = plugin;
	}

	public void removeFromList(CommandSender sender, String[] args) throws IOException {
		br = new BufferedReader(new FileReader("plugins/NaughtyList/watchlist.yml"));

		ArrayList<String> names = new ArrayList<String>();
		String temp = null;
		while ((temp = br.readLine()) != null) {
			names.add(temp);
		}
		br.close();
		for (int i = 0; i < names.size(); i++) {
			if(names.get(i).equalsIgnoreCase(args[0]))
			{
				names.remove(i);
				sender.sendMessage("Removed " + args[0] + " from the list.");
			}
		}
		bw = new BufferedWriter(new FileWriter("plugins/NaughtyList/watchlist.yml", false));
		for (int i = 0; i < names.size(); i++) {
			bw.write(names.get(i));
			bw.newLine();
		}
		bw.close();
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Date date = new Date();

		if (cmd.getName().equalsIgnoreCase("nlr") && sender.hasPermission("nl.remove")) {

			if (args.length == 1) {
				System.out.println(sender.getName() + " used /nlr " + args[0] + " at " + new Timestamp(date.getTime()));
				sender.sendMessage("Removing " + args[0] + " from the list.");
				try {
					removeFromList(sender, args);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

}