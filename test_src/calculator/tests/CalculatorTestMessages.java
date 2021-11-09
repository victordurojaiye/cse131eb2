package calculator.tests;

import java.util.Collection;
import java.util.List;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class CalculatorTestMessages {
	static String toLineCountMessage(String expected, String actualOutput, Collection<String> cleanedLines) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("\nExpected a single line. %d (cleaned) lines were printed.\n\n", cleanedLines.size()));
		sb.append("=== expected line ===\n");
		sb.append(expected);
		sb.append("\n\n");
		sb.append("=== actual (cleaned) lines ===\n");
		for (String cleanedLine : cleanedLines) {
			sb.append(cleanedLine).append("\n");
		}
		sb.append("\n");
		sb.append("=== uncleaned raw output ===\n");
		sb.append(actualOutput);
		sb.append("\n");
		return sb.toString();
	}

	static String toTokenCountMessage(String expected, String actualOutput, String cleanedLine,
			List<String> actualTokens) {
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("\nExpected 5 tokens. %d tokens were printed.\n", actualTokens.size()));
		sb.append("=== expected line ===\n");
		sb.append(expected);
		sb.append("\n\n");
		sb.append("=== actual (cleaned) line ===\n");
		sb.append(cleanedLine).append("\n");
		sb.append("\n");
		sb.append("=== actual tokens ===\n");
		sb.append(actualTokens).append("\n");
		sb.append("\n");
		sb.append("=== uncleaned raw output ===\n");
		sb.append(actualOutput);
		sb.append("\n");
		return sb.toString();
	}
}
