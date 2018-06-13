package by.htp.miniLibrary.run;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class MainAppBookFinder {

	public static void main(String[] args) {

		try {
			
			File f = new File("bookList.txt");

			if (!f.exists()) {
				System.out.println("create new file");
				f.createNewFile();
			}
			System.out.println("List of books loaded...");

			Reader reader = new FileReader(f);

			BufferedReader br = new BufferedReader(reader);
			
			LineNumberReader count = new LineNumberReader(reader);
			
			while (count.skip(Long.MAX_VALUE) > 0) {
			}

			int result = count.getLineNumber() + 1; 
			
			System.out.println("This list contains " + result + " books");

			Scanner in = new Scanner(System.in);

			System.out.print("Type book number: ");

			int lineId = in.nextInt();

			lineId = lineId - 1;

			String str = Files.readAllLines(Paths.get("bookList.txt")).get(lineId);

			System.out.println(str);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
