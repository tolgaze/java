package com.tolgaze.hashcode2020;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static int libraryNumber;
	public static int bookNumber;
	public static int totalDay;
	public static int remainingDay;
	public static int totalSignup;
	public static int finalScore;
	public static int[] scoreOfBooks;
	public static List<Library> librariesArrayList = new ArrayList<Library>();
	public static List<Library> finallibrariesArrayList = new ArrayList<Library>();
	public static Stream<Library> librariesStream;

	public static void main(String[] args) throws FileNotFoundException, IOException {

		String name = "C:\\DEVEL\\Workspaces\\java\\google-hashcode-2020\\files\\a_example"; 
//		String name = "C:\\DEVEL\\Workspaces\\java\\google-hashcode-2020\\files\\b_read_on"; 
//		String name = "C:\\DEVEL\\Workspaces\\java\\google-hashcode-2020\\files\\c_incunabula"; 
//		String name = "C:\\DEVEL\\Workspaces\\java\\google-hashcode-2020\\files\\d_tough_choices"; 
//		String name = "C:\\DEVEL\\Workspaces\\java\\google-hashcode-2020\\files\\e_so_many_books"; 
//		String name = "C:\\DEVEL\\Workspaces\\java\\google-hashcode-2020\\files\\f_libraries_of_the_world"; 
		BufferedReader fr = new BufferedReader(new FileReader(name + ".txt"));
		totalSignup = 0;
		finalScore = 0;
		
		String line, firstLine,secondLine;
		firstLine = fr.readLine();
		secondLine = fr.readLine();

		String[] vars;
		vars = firstLine.split(" ");
		bookNumber = Integer.valueOf(vars[0]);
		libraryNumber = Integer.valueOf(vars[1]);
		totalDay = Integer.valueOf(vars[2]);
		remainingDay = Integer.valueOf(vars[2]);

		vars = secondLine.split(" ");
		scoreOfBooks = new int[vars.length];
		for(int i=0; i<vars.length; i++){
			scoreOfBooks[i] = Integer.valueOf(vars[i]);
		}

		int libraryIndex=0;
		while ((line = fr.readLine()) != null && !line.equals("") ) {
			String firstLineOfLibrary[] = line.split(" ");
			Library library = new Library();
			library.setBooksList(new ArrayList<Book>());
			library.setId(libraryIndex);
			libraryIndex++;
			library.setNumberOfBooks(Integer.valueOf(firstLineOfLibrary[0]));
			library.setSignupDay(Integer.valueOf(firstLineOfLibrary[1]));
			library.setScanPerDay(Integer.valueOf(firstLineOfLibrary[2]));
			String secondLineOfLibrary[] = fr.readLine().split(" ");
			for (String letter : secondLineOfLibrary) {
				Book book = new Book();
				book.setId(Integer.valueOf(letter));
				book.setScore(scoreOfBooks[book.getId()]);
				library.getBooksList().add(book);
			}
			totalSignup = totalSignup + library.getSignupDay();
			librariesArrayList.add(library);
			library.setBooksList(library.getBooksList().stream().sorted(Comparator.comparing(Book::getScore).reversed()).collect(Collectors.toList()));
		}

		while(remainingDay > 0 && librariesArrayList.size() > 0) {
			findLibrary();
		}

		try (PrintWriter output = new PrintWriter(name + ".out", "UTF-8")) {
			output.println(finallibrariesArrayList.size());
			for(Library library : finallibrariesArrayList){
				output.println(library.getId() + " " + library.getBooksList().size());
				for (Book book: library.getBooksList()){
					output.print(book.getId()+ " ");
					finalScore = finalScore + book.getScore();
				}
				output.println();
			}
		}
		System.out.println("Finished");
	}

	public static void findLibrary(){
		System.out.println("Remaining days:" + remainingDay);

		for(Library library : librariesArrayList){
			library.setScore(library.getBooksList().stream().sorted(Comparator.comparing(Book::getScore).reversed()).mapToDouble(Book::getScore).sum());
			library.setScore((library.getScore() * library.getScanPerDay()) / library.signupDay );
		}

		librariesArrayList = librariesArrayList.stream().sorted(Comparator.comparing(Library::getScore).reversed()).collect(Collectors.toList());
		finallibrariesArrayList.add(librariesArrayList.get(0));
		librariesArrayList.remove(0);

		for(Library library : librariesArrayList) {
			library.setBooksList(library.getBooksList().stream().filter
					(book -> finallibrariesArrayList.get(finallibrariesArrayList.size()-1).getBooksList().stream().noneMatch
							(finalBook -> finalBook.getId() == book.getId())).collect(Collectors.toList()));
		}
		remainingDay = remainingDay - finallibrariesArrayList.get(finallibrariesArrayList.size()-1).getSignupDay();
	}

}
