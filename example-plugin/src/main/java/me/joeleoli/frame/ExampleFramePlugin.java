package me.joeleoli.frame;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Testing possible issues with library
 */
public class ExampleFramePlugin extends JavaPlugin {

	@Override
	public void onEnable() {
		new Frame(this, new FrameAdapter() {
			@Override
			public String getTitle(Player player) {
				return ChatColor.GOLD.toString() + ChatColor.BOLD.toString() + "Savage" + ChatColor.WHITE.toString() + ChatColor.BOLD.toString() + "Games";
			}

			@Override
			public List<String> getLines(Player player) {
				final List<String> toReturn = new ArrayList<>();

				toReturn.add(ChatColor.GRAY.toString() + ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "---------------------------");
				toReturn.add("Players: " + ChatColor.GOLD.toString() + "1");
				toReturn.add("Host: " + ChatColor.GOLD.toString() + "joeleoli");
				toReturn.add("Game Type: " + ChatColor.GOLD.toString() + "Cut NoClean");
				toReturn.add(ChatColor.GRAY.toString() + ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "---------------------------");
				toReturn.add(ChatColor.GRAY.toString() + ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "---------------------------");
				toReturn.add(ChatColor.GRAY.toString() + ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH + "---------------------------");

				return toReturn;
			}
		});
	}

}
