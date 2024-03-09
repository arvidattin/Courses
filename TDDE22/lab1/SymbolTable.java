package lab1;

/**
 * This class represents a symbol table, or hash table, with a very simple hash
 * function. Observe that you are not supposed to change hash function. Ensure
 * that you use linear probing as your method of collision handling.
 *
 * @author Magnus Nielsen, Tommy FÃÂ¤rnqvist ...
 */
public class SymbolTable {
	private static final int INIT_CAPACITY = 7;

	/* Number of key-value pairs in the symbol table */
	private int size;
	/* Size of linear probing table */
	private int maxSize;
	/* The keys */
	private String[] keys;
	/* The values */
	private Character[] vals;

	private int indexKey;

	private boolean isFull = false;

	/**
	 * Create an empty hash table - use 7 as default size
	 */
	public SymbolTable() {
		this(INIT_CAPACITY);
	}

	/**
	 * Create linear probing hash table of given capacity
	 */
	public SymbolTable(int capacity) {
		size = 0;
		maxSize = capacity;
		keys = new String[maxSize];
		vals = new Character[maxSize];
	}

	/**
	 * Return the number of key-value pairs in the symbol table
	 */
	public int size() {
		return size;
	}

	/**
	 * Is the symbol table empty?
	 */
	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * Does a key-value pair with the given key exist in the symbol table?
	 */
	public boolean contains(String key) {
		return get(key) != null;
	}

	/**
	 * Hash function for keys - returns value between 0 and maxSize-1
	 */
	public int hash(String key) {
		int i;
		int v = 0;

		for (i = 0; i < key.length(); i++) {
			v += key.charAt(i);
		}
		return v % maxSize;
	}

	/**
	 * Insert the key-value pair into the symbol table.
	 */
	public void put(String key, Character val) {

		if (key == null) {
			return;
		}
		if (val == null) {
			delete(key);
			return;
		}

		if (size == maxSize) {
			isFull = true;
		}
		indexKey = hash(key);
		int counter = 0;
		if (!isFull || keys[indexKey] != key) {
			/* Check if empty position and if deleted position */
			while (keys[indexKey] != null && counter < maxSize) {
				if (keys[indexKey].equals(key)) {
					keys[indexKey] = key;
					vals[indexKey] = val; // update new val
					return;
				}
				indexKey++;
				counter++;
				/* Overbound? */
				if (indexKey == maxSize) {
					indexKey = indexKey % maxSize;
				}
			}
			/* if empty postition exists and array not full */
			if ((keys[indexKey] != key && !isFull) || keys[indexKey] == null) { // || isEMpty
				keys[indexKey] = key;
				vals[indexKey] = val;
				size += 1;
			}
		}
		return;
	}

	/**
	 * Return the value associated with the given key, null if no such value.
	 */
	public Character get(String key) {
		if (key != null) {
			indexKey = hash(key);
			for (int i = 0; i < maxSize; i++) {

				if (keys[(indexKey + i) % maxSize] != null && keys[(indexKey + i) % maxSize].equals(key)) {
					return vals[(indexKey + i) % maxSize];
				}
			}
		}
		return null;
	}

	private int getPos(String key) {

		if (key != null) {

			for (int i = 0; i < maxSize; i++) {

				if (keys[(indexKey + i) % maxSize] != null && keys[(indexKey + i) % maxSize].equals(key)) {

					return (indexKey + i) % maxSize; // returnernar index dÃ¤r nyckeln finns
				}
			}
		}
		return -1;
	}

	/**
	 * Delete the key (and associated value) from the symbol table.
	 */

	public void delete(String key) { // tidskomplexitet ~ g(n) + f(n)(h(n)) ~ O(n^2)
		if (key == null) {
			return;
		}
		int indexKey = hash(key);
		if (keys[indexKey] == null) {
			return;
		}

		String tmpS;
		char tmpC;
		int keyPos = getPos(key); // index i arrayen dÃ¤r nyckeln finns ,g(n) = O(n)

		if (keyPos == -1) {
			return;
		}
		vals[keyPos] = null; // raderar nyckel/val
		keys[keyPos] = null;
		size--;

		// itererar genom arrayen med start i index efter raderat vÃ¤rde. fram till vi
		// stÃ¶ter pÃ¥ null igen. SÃ¥ ett varv
		for (int i = (keyPos + 1) % maxSize; i != keyPos; i = (i + 1) % maxSize) { // f(n)(h(n)) = O(n^2)

			if (keys[i] == null && vals[i] == null) {
				return;
			}
			tmpS = keys[i]; // sparar undan vÃ¤rden
			tmpC = vals[i];

			keys[i] = null; // raderar
			vals[i] = null;
			size--;
			put(tmpS, tmpC); // lÃ¤gger tbx
		}
	}

	/**
	 * Print the contents of the symbol table.
	 */
	public void dump() {
		String str = "";

		for (int i = 0; i < maxSize; i++) {
			str = str + i + ". " + vals[i];
			if (keys[i] != null) {
				str = str + " " + keys[i] + " (";
				str = str + hash(keys[i]) + ")";
			} else {
				str = str + " -";
			}
			System.out.println(str);
			str = "";
		}
	}
}
