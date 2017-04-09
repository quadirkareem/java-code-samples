import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchEvent.Kind;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.List;

public class TestFileWatcher {

	private static final String FILE_PATH = "D:\\sandbox\\java\\tryouts\\src\\main\\resources\\";
	private static final String FILE_NAME = "hello.txt";

	public static void main(String[] args) throws IOException,
			InterruptedException {
		// Folder we are going to watch
		Path folder = Paths.get(FILE_PATH);
		watchDirectoryPath(folder);
	}

	public static synchronized void watchDirectoryPath(Path path) {
		// Sanity check - Check if path is a folder
		try {
			Boolean isFolder = (Boolean) Files.getAttribute(path,
					"basic:isDirectory", NOFOLLOW_LINKS);
			if (!isFolder) {
				throw new IllegalArgumentException("Path: " + path
						+ " is not a folder");
			}
		} catch (IOException ioe) {
			// Folder does not exists
			ioe.printStackTrace();
		}

		System.out.println("Watching path: " + path);

		// We obtain the file system of the Path
		FileSystem fs = path.getFileSystem();

		// We create the new WatchService using the new try() block
		try (WatchService service = fs.newWatchService()) {

			// We register the path to the service
			// We watch for creation events
			path.register(service, ENTRY_MODIFY);

			// Start the infinite polling loop
			WatchKey key = null;
			int eventCount = 0;
			List<WatchKey> keyList = new ArrayList<WatchKey>();
			File f = new File(FILE_PATH + FILE_NAME);
			while (true) {				
				key = service.take();
//				keyList.add(key);
				
				// Dequeueing events
				Kind<?> kind = null;
				for (WatchEvent<?> watchEvent : key.pollEvents()) {
					// Get the type of the event
					kind = watchEvent.kind();
					
					// handle OVERFLOW event
					if (kind == StandardWatchEventKinds.OVERFLOW) {
						continue;
					}

					/**
					 * 7. Retrieving the File Name Associated with an Event. get
					 * the filename for the event *
					 */
					final WatchEvent<Path> watchEventPath = (WatchEvent<Path>) watchEvent;
					final Path entry = watchEventPath.context();
					
					// print it out
					System.out.println(kind + " -> " + entry + ": " + f.lastModified());

				}
				
				if (!key.reset()) {
					break; // loop
				}
//				System.out.println("Keys: " + Arrays.toString(keyList.toArray(new WatchKey[keyList.size()])) );
			}

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

	}

}
