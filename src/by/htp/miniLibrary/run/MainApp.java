package by.htp.miniLibrary.run;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;

public class MainApp {

	public static void main(String[] args) {

		InputStream is = null;

		try {
			File f = new File("bookList.txt");

			if (!f.exists()) {
				f.createNewFile();
				System.out.println("New file created");

			} else System.out.println("Existing file found.");

			try (OutputStream os = new FileOutputStream(f)) {

				is = new FileInputStream(f);
				int available = is.available();

				byte[] data = new byte[available];

				is.read(data);
				System.out.println(new String(data));

				os.write(("book1\r\n" + "book2\r\n" + "book3\r\n" + "book4\r\n" + "book5\r\n" + "book6\r\n"
						+ "book7\r\n" + "book8\r\n" + "book9\r\n" + "book10").getBytes());

				System.out
						.println("List of books loaded..." + "\n" + "To find exact book proceed to MainAppBookFinder.java");

			} catch (FileNotFoundException e) {
				e.printStackTrace();

			} finally {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		catch (IOException e) {
			e.printStackTrace();

		}

	}

}
