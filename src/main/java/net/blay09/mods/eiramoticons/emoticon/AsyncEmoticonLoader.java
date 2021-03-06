package net.blay09.mods.eiramoticons.emoticon;

import net.blay09.mods.eiramoticons.api.IEmoticon;

import java.util.LinkedList;

public class AsyncEmoticonLoader implements Runnable {

	public static final AsyncEmoticonLoader instance = new AsyncEmoticonLoader();

	private boolean running;
	private final LinkedList<IEmoticon> loadQueue = new LinkedList<>();

	public AsyncEmoticonLoader() {
		running = true;
		Thread thread = new Thread(this, "EiraMoticonLoader");
		thread.start();
	}

	public void loadAsync(IEmoticon emoticon) {
		synchronized(loadQueue) {
			loadQueue.push(emoticon);
		}
	}

	@Override
	public void run() {
		while(running) {
			try {
				synchronized (loadQueue) {
					while (!loadQueue.isEmpty()) {
						IEmoticon emoticon = loadQueue.pop();
						try {
							emoticon.getLoader().loadEmoticonImage(emoticon);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				Thread.sleep(100);
			} catch (InterruptedException ignored) {}
		}
	}
}
