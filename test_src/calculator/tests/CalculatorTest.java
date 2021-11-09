package calculator.tests;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import calculator.Calculator;
import support.cse131.LenientTextUtils;
import support.cse131.OutputUtils;

/**
 * @author Dennis Cosgrove (http://www.cse.wustl.edu/~cosgroved/)
 */
@RunWith(Parameterized.class)
public class CalculatorTest {
	private final String text;
	private final String expected;

	public CalculatorTest(String text, int expected) {
		this.text = text;
		this.expected = String.format("%s = %d", text, expected);
	}

	@Test
	public void test() throws IOException {
		String actualOutput = OutputUtils.capture(() -> Calculator.main(new String[] { text }));
		List<String> cleanedLines = LenientTextUtils.toTrimmedNonemptyLines(actualOutput);

		String lineCountMessage = CalculatorTestMessages.toLineCountMessage(expected, actualOutput, cleanedLines);
		assertEquals(lineCountMessage, 1, cleanedLines.size());

		String cleanedLine = cleanedLines.get(0);
		List<String> actualTokens = ArithmeticExpressionParsingUtils.toTokens(cleanedLine);
		String tokenCountMessage = CalculatorTestMessages.toTokenCountMessage(expected, actualOutput, cleanedLine,
				actualTokens);
		assertEquals(tokenCountMessage, 5, actualTokens.size());

		assertEquals(expected, cleanedLine);
	}

	@Parameterized.Parameters(name = "{0} = {1}")
	public static Collection<Object[]> getConstructorArguments() {
		List<Object[]> args = new LinkedList<>();
		
		// specific cases
		args.add(new Object[] {"1 + 1", 2});
		args.add(new Object[] {"2 + 3", 5});
		args.add(new Object[] {"3 + 5", 8});
		args.add(new Object[] {"7 + 42", 49});
		args.add(new Object[] {"20 + 9", 29});
		args.add(new Object[] {"131 + 231", 362});
		args.add(new Object[] {"425 + 131", 556});
		args.add(new Object[] {"1111 + 12345", 13456});
		args.add(new Object[] {"1 - 1", 0});
		args.add(new Object[] {"2 - 3", -1});
		args.add(new Object[] {"3 - 5", -2});
		args.add(new Object[] {"7 - 42", -35});
		args.add(new Object[] {"20 - 9", 11});
		args.add(new Object[] {"131 - 231", -100});
		args.add(new Object[] {"425 - 131", 294});
		args.add(new Object[] {"1111 - 12345", -11234});
		args.add(new Object[] {"1 * 1", 1});
		args.add(new Object[] {"2 * 3", 6});
		args.add(new Object[] {"3 * 5", 15});
		args.add(new Object[] {"7 * 42", 294});
		args.add(new Object[] {"20 * 9", 180});
		args.add(new Object[] {"131 * 231", 30261});
		args.add(new Object[] {"425 * 131", 55675});
		args.add(new Object[] {"1111 * 12345", 13715295});
		args.add(new Object[] {"1 / 1", 1});
		args.add(new Object[] {"2 / 3", 0});
		args.add(new Object[] {"3 / 5", 0});
		args.add(new Object[] {"7 / 42", 0});
		args.add(new Object[] {"20 / 9", 2});
		args.add(new Object[] {"131 / 231", 0});
		args.add(new Object[] {"425 / 131", 3});
		args.add(new Object[] {"1111 / 12345", 0});

		// random cases
		args.add(new Object[] {"1149 + 8437", 9586});
		args.add(new Object[] {"6560 + 8729", 15289});
		args.add(new Object[] {"6000 + 1063", 7063});
		args.add(new Object[] {"9281 + 8948", 18229});
		args.add(new Object[] {"4177 + 1211", 5388});
		args.add(new Object[] {"1477 + 2579", 4056});
		args.add(new Object[] {"8104 + 6723", 14827});
		args.add(new Object[] {"3557 + 7649", 11206});
		args.add(new Object[] {"4884 + 8036", 12920});
		args.add(new Object[] {"8523 + 6389", 14912});
		args.add(new Object[] {"3345 + 9310", 12655});
		args.add(new Object[] {"7013 + 3792", 10805});
		args.add(new Object[] {"5125 + 2421", 7546});
		args.add(new Object[] {"5849 + 3907", 9756});
		args.add(new Object[] {"4684 + 6413", 11097});
		args.add(new Object[] {"6918 + 6766", 13684});
		args.add(new Object[] {"30 - 9316", -9286});
		args.add(new Object[] {"162 - 5923", -5761});
		args.add(new Object[] {"8234 - 9786", -1552});
		args.add(new Object[] {"2373 - 6841", -4468});
		args.add(new Object[] {"466 - 7628", -7162});
		args.add(new Object[] {"9585 - 7149", 2436});
		args.add(new Object[] {"850 - 5405", -4555});
		args.add(new Object[] {"3181 - 3826", -645});
		args.add(new Object[] {"9518 - 1829", 7689});
		args.add(new Object[] {"2397 - 9433", -7036});
		args.add(new Object[] {"9719 - 1956", 7763});
		args.add(new Object[] {"7535 - 8668", -1133});
		args.add(new Object[] {"3689 - 9663", -5974});
		args.add(new Object[] {"6420 - 3044", 3376});
		args.add(new Object[] {"1572 - 8523", -6951});
		args.add(new Object[] {"648 - 826", -178});
		args.add(new Object[] {"9637 * 3336", 32149032});
		args.add(new Object[] {"240 * 1498", 359520});
		args.add(new Object[] {"5249 * 7284", 38233716});
		args.add(new Object[] {"5008 * 5588", 27984704});
		args.add(new Object[] {"9805 * 1809", 17737245});
		args.add(new Object[] {"6119 * 8157", 49912683});
		args.add(new Object[] {"1117 * 8848", 9883216});
		args.add(new Object[] {"6663 * 242", 1612446});
		args.add(new Object[] {"5031 * 3964", 19942884});
		args.add(new Object[] {"2260 * 8108", 18324080});
		args.add(new Object[] {"7347 * 2644", 19425468});
		args.add(new Object[] {"889 * 8495", 7552055});
		args.add(new Object[] {"6738 * 9008", 60695904});
		args.add(new Object[] {"7889 * 8332", 65731148});
		args.add(new Object[] {"7255 * 9621", 69800355});
		args.add(new Object[] {"2025 * 3863", 7822575});
		args.add(new Object[] {"7814 / 9827", 0});
		args.add(new Object[] {"4879 / 1155", 4});
		args.add(new Object[] {"5032 / 8763", 0});
		args.add(new Object[] {"8742 / 9000", 0});
		args.add(new Object[] {"7160 / 830", 8});
		args.add(new Object[] {"1306 / 7847", 0});
		args.add(new Object[] {"8029 / 4353", 1});
		args.add(new Object[] {"5706 / 8020", 0});
		args.add(new Object[] {"4052 / 1037", 3});
		args.add(new Object[] {"1607 / 8114", 0});
		args.add(new Object[] {"6586 / 5698", 1});
		args.add(new Object[] {"4423 / 1245", 3});
		args.add(new Object[] {"4819 / 92", 52});
		args.add(new Object[] {"6454 / 3409", 1});
		args.add(new Object[] {"8602 / 3966", 2});
		args.add(new Object[] {"970 / 7448", 0});

		return args;
	}
}
