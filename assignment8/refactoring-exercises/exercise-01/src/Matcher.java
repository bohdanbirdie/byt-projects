public class Matcher {
	public Matcher() {
	}

	public boolean match(int[] expected, int[] actual, int clipLimit, int delta) {

		// Check for length differencess
		if (actual.length != expected.length)
			return false;
				
		// Clip "too-large" values
		removeValuesOutOfLimit(actual, clipLimit);

		// Check that each entry within expected +/- delta
		return checkEntries(expected, actual, delta);
	}

	/**
	 * @param expected
	 * @param actual
	 * @param delta
	 * @return
	 */
	private boolean checkEntries(int[] expected, int[] actual, int delta) {
		for (int i = 0; i < actual.length; i++)
			if (Math.abs(expected[i] - actual[i]) > delta)
				return false;

		return true;
	}

	/**
	 * @param actual
	 * @param clipLimit
	 */
	private void removeValuesOutOfLimit(int[] actual, int clipLimit) {
		for (int i = 0; i < actual.length; i++)
			if (actual[i] > clipLimit)
				actual[i] = clipLimit;
	}
}