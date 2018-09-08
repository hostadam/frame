# Frame
A Spigot/Bukkit API library to create and update scoreboards.

Many of the scoreboard libraries I've used are pretty trash and perform a heap of unnecessary operations. This maintains a similar structure to most libraries out there, but the internal functionality is more efficient and only does what it needs to do.

### Features
* Non-flickering.
* Supports up to 32 characters per line.
* Extremely light weight.
* Developer friendly. Setup your board in a few lines.

### Example
```
@Override
public void onEnable() {
	new Frame(new ExampleFrameAdapter());
}
```
```
public class ExampleFrameAdapter implements FrameAdapter {

	@Override
	public String getTitle(Player player) {
		return ChatColor.GOLD.toString() + "Frame Board Example";
	}

	@Override
	public List<String> getLines(Player player) {
		final int rand = ThreadLocalRandom.current().nextInt(500);
		final List<String> toReturn = new ArrayList<>();

		toReturn.add("&eThis is an example board.");
		toReturn.add("&dAs you can see, it supports");
		toReturn.add("&dup to 32 characters per line.");
		toReturn.add("&aDon't forget... Colors count");
		toReturn.add("&btowards the character count.");
		toReturn.add("Random number: " + rand);

		return toReturn;
	}

}

```
![](example.gif)
