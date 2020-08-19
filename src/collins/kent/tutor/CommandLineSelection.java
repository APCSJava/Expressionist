package collins.kent.tutor;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CommandLineSelection {

	public static void main(String[] args) {
		// add a branch for each package in the running directory
		File[] folders = null;
		folders = new File("./src/collins/kent/tutor/")
				.listFiles(File::isDirectory);
		List<String> modules = Arrays.stream(folders)
				.map(f -> f.getName()).sorted()
				.collect(Collectors.toList());
		if (args.length == 0 || !modules.contains(args[0])) {
			System.out
					.println("The following modules are available:");
			for (File f : folders) {
				System.out.println("  " + f.getName());
			}
			System.out.println(
					"Expected usage: java CommandLineSelection moduleName");
		}
	}

}
