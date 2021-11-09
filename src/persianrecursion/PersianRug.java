package persianrecursion;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class PersianRug {
	

	/**
	 * 
	 * @param palette an array of Colors to choose from
	 * @param llx     lower left x coordinate of this rug square
	 * @param lly     lower left y coordinate of this rug square
	 * @param size    width (and therefore also height) of this rug square
	 * @param north   color index of the north side of this rug square
	 * @param east    color index of the east side of this rug square
	 * @param south   color index of the south side of this rug square
	 * @param west    color index of the west side of this rug square
	 */
	private static void persianRug(
			Color[] palette,
			double llx, double lly,
			double size,
			int north, int east, int south, int west) {
		//
		// FIXME Your code goes here
		//

		
	}

	public static void main(String args[]) {

		// Changing IS_SPEED_UP_DESIRED from false to true will run the graphics code
		// in double-buffering mode, so that your image will appear faster,
		// instead of being drawn one line at a time.
		boolean IS_SPEED_UP_DESIRED = false;
		
		if (IS_SPEED_UP_DESIRED) {
			StdDraw.enableDoubleBuffering();
		}

		// https://jacksonlab.agronomy.wisc.edu/2016/05/23/15-level-colorblind-friendly-palette/
		// http://mkweb.bcgsc.ca/biovis2012/krzywinski-visualizing-biological-data.pdf
		// http://mkweb.bcgsc.ca/biovis2012/color-blindness-palette.png
		//
		// A palette of colors
		//
		Color[] palette = { new Color(0x000000), new Color(0x004949), new Color(0x009292), new Color(0xff6db6),
				new Color(0xffb16db), new Color(0x490092), new Color(0x006ddb), new Color(0xb66dff),
				new Color(0x6db6ff), new Color(0xb6dbff), new Color(0x920000), new Color(0x924900), new Color(0xdb6d00),
				new Color(0x24ff24), new Color(0xffff6d) };
		//
		// Draw the outermost square as a special case
		// Use color 0 for that
		//
		StdDraw.setPenColor(palette[0]);
		StdDraw.line(0, 0, 1, 0);
		StdDraw.line(1, 0, 1, 1);
		StdDraw.line(1, 1, 0, 1);
		StdDraw.line(0, 1, 0, 0);

		//
		// Kick off the recursion
		// Lower left is point (0,0)
		// Size of the square is 1
		// The color index of each surrounding side is 0
		//
		persianRug(palette, 0, 0, 1, 0, 0, 0, 0);

		StdDraw.show();
	}

}
