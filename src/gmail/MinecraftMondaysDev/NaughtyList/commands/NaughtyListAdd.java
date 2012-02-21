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

public class NaughtyListAdd implements CommandExecutor {

	@SuppressWarnings("unused")
	private NaughtyList plugin;
	private BufferedReader br;
	private boolean exist = false;

	public NaughtyListAdd(NaughtyList plugin) {
		this.plugin = plugin;
	}

	public void addToList(CommandSender sender, String[] args) throws IOException {

		br = new BufferedReader(new FileReader("plugins/NaughtyList/watchlist.yml"));
		ArrayList<String> names = new ArrayList<String>();
		String temp = null;
		while ((temp = br.readLine()) != null) {
			names.add(temp);
		}

		if (names.contains(args[0]))
			exist = true;
		else
			exist = false;

		if (exist == true) {
			sender.sendMessage(args[0] + " is already on the list.");
		} else {
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter("plugins/NaughtyList/watchlist.yml", true));
				bw.write(args[0]);
				bw.newLine();
				bw.close();
				sender.sendMessage("Added " + args[0] + " to the list.");

			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

		Date date = new Date();

		if (cmd.getName().equalsIgnoreCase("nla") && sender.hasPermission("nl.add")) {

			if (args.length == 1) {
				System.out.println(sender.getName() + " used /nla " + args[0] + " at " + new Timestamp(date.getTime()));
				sender.sendMessage("Adding " + args[0] + " to the list.");
				try {
					addToList(sender, args);
				} catch (IOException e) {
					e.printStackTrace();
				}
				return true;
			}
		}
		return false;
	}

}