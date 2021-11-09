package calculator.tests;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
class ArithmeticExpressionParsingUtils {
	static List<String> toTokens(String s) {
		return toJoinedMinusSignAfterEqualsSignTokens(toPerhapsOverSplitMinusSignTokens(removeWhitespace(s)));
	}

	private static String removeWhitespace(String s) {
		return s.replaceAll("\\s", "");
	}

	private static List<String> toPerhapsOverSplitMinusSignTokens(String s) {
		// https://stackoverflow.com/a/2206432
		String WITH_DELIMITER = "((?<=%1$s)|(?=%1$s))";
		String regex = String.format(WITH_DELIMITER, "[\\+\\-\\*\\/\\=]");
		return Arrays.asList(s.split(regex));
	}

	private static List<String> toJoinedMinusSignAfterEqualsSignTokens(List<String> tokens) {
		List<String> result = new LinkedList<>();
		boolean isAfterEqualsSign = false;
		boolean isPrependingMinusSignNext = false;
		for (String token : tokens) {
			if (isAfterEqualsSign) {
				if (Objects.equals(token, "-")) {
					isPrependingMinusSignNext = true;
					continue;
				}
			}
			if (isPrependingMinusSignNext) {
				result.add("-" + token);
				isPrependingMinusSignNext = false;
			} else {
				result.add(token);
			}
			if (Objects.equals(token, "=")) {
				isAfterEqualsSign = true;
			}
		}
		if (isPrependingMinusSignNext) {
			result.add("-");
		}
		return result;
	}
}
