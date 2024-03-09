package labb5;

public class Word {

	private String text;

	public Word(String text) {

		this.text = text;

	}

	public boolean equals(Object obj) {

		if (obj.toString().equals(text))

			return true;

		else {
			return false;

		}
	}

	public int hashCode() {

		return text.hashCode();

	}

	public String toString() {

		return text;

	}
}
