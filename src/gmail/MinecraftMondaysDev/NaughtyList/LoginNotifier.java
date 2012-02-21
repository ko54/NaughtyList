package gmail.MinecraftMondaysDev.NaughtyList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.ChatColor;

public class LoginNotifier implements Listener {

	@SuppressWarnings("unused")
	private NaughtyList plugin;
	private boolean found;

	public LoginNotifier(NaughtyList plugin) {
		this.plugin = plugin;
	}

	@EventHandler
	public void onPlayerLogin(PlayerLoginEvent event) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("plugins/NaughtyList/watchlist.yml"));

		ArrayList<String> names = new ArrayList<String>();
		String temp = null;
		while ((temp = br.readLine()) != null) {
			names.add(temp);
		}

		for (int i = 0; i < names.size(); i++) {
			if (event.getPlayer().getName().equalsIgnoreCase(names.get(i))) {
				found = true;
				break;
			} else
				found = false;
		}
		if (found == true) {
			//This is where the output stuff will go
			
			String msg = event.getPlayer().getName() + " is on the watch list and has logged in!!";
			//System.out.println(event.getPlayer().getName() + " is on the watch list and has logged in!!!");
			Bukkit.broadcast(ChatColor.DARK_RED + msg, "nl.alert");
		}
	}

}
