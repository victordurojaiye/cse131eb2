package linearregression.io;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import linearregression.XY;
import support.cse131.ArgsProcessor;
import support.cse131.Scanners;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
public class AreaPriceFiles {
	public static ArgsProcessor createArgsProcessorForBroward() {
		InputStream is = AreaPriceFiles.class.getResourceAsStream("resources/BrowardAreaPrice.txt");
		Scanner scanner = new Scanner(is);
		return Scanners.createArgsProcessorFromScanner(scanner);
	}

	public static List<XY> createXYsForBroward() {
		ArgsProcessor ap = createArgsProcessorForBroward();
		int n = ap.nextInt();
		List<XY> xys = new ArrayList<>();
		for (int i = 0; i < n; ++i) {
			xys.add(new XY(ap.nextDouble(), ap.nextDouble()));
		}
		return xys;
	}
}
