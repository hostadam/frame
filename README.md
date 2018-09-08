# Frame
A Spigot/Bukkit API library to create and update scoreboards.

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
![](example.gif)

### Note
* It might have a similar structure to other Scoreboard APIs/libraries but the actual teams / updating scores technique is different. This is probably the most simple and performance efficient Scoreboard library.
