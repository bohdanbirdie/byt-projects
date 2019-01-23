import java.io.IOException;
import java.io.Writer;

public class Person {
	public String last;

	public String first;

	public String middle;

	public Person(String last, String first, String middle) {
		this.last = last;
		this.first = first;
		this.middle = middle;
	}
	
	private void toWriter(Writer out, Boolean isDefaultFormat) throws IOException {
		out.write(this.toString(isDefaultFormat));
	}
	
	private String defaultFormatting() {
		return this.first + " " + ((this.middle == null) ? "" : this.middle + " ") + this.last;
	}
	
	private String specificFormatting() {
		return this.last + ", " + this.first
				+ ((this.middle == null) ? "" : " " + this.middle);
	}
	
	public String toString(Boolean isDefaultFormat) {
		return isDefaultFormat ? this.defaultFormatting() : this.specificFormatting();
	}
	
	public void toString(Boolean isDefaultFormat, Writer out) throws IOException {
		this.toWriter(out, isDefaultFormat);
	}
}