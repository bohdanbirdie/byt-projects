public class CsvWriter {
	public CsvWriter() {
	}

	/*
	 * I don't think that there is a sense of diving those methods into separate classes or something
	 * they all are from one domain and does work on the same thing
	 * I only made all the methods static 
	 */
	public static void write(String[][] lines) {
		for (int i = 0; i < lines.length; i++) {
			writeLine(lines[i]);
		}
	}

	private static void writeLine(String[] fields) {
		if (fields.length == 0) {
			System.out.println();
		} else {
			writeField(fields[0]);

			for (int i = 1; i < fields.length; i++) {
				System.out.print(",");
				writeField(fields[i]);
			}
			System.out.println();
		}
	}

	private static void writeField(String field) {
		if (field.indexOf(',') != -1 || field.indexOf('\"') != -1)
			writeQuoted(field);
		else
			System.out.print(field);
	}

	private static void writeQuoted(String field) {
		System.out.print('\"');
		for (int i = 0; i < field.length(); i++) {
			char c = field.charAt(i);
			if (c == '\"')
				System.out.print("\"\"");
			else
				System.out.print(c);
		}
		System.out.print('\"');
	}
}