package com.libraryapp;
import java.time.LocalDate; 
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.libraryapp.entities.Book;
import com.libraryapp.entities.User;
import com.libraryapp.services.BookService;
import com.libraryapp.services.NotificationService;
import com.libraryapp.services.UserService;
import com.libraryapp.utils.MidnightApplicationRefresh;

@SpringBootApplication
public class LibraryApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

	@Autowired
	BookService bookService;
	
	@Autowired
	UserService usService;
	
	@Autowired
	NotificationService notifService;
	
	@Autowired
	BCryptPasswordEncoder pwEncoder;
	
	@Autowired
	MidnightApplicationRefresh midAppRef;
	
	@Bean
	CommandLineRunner runner() {
		return args -> {
		
			User user1 = new User("admin", pwEncoder.encode("test"), "baishaliroy321@gmail.com", "Baishali", "Roy", "Huizumerlaan 158", "06-11433823", "Amsterdam");
			user1.setRole("ROLE_ADMIN");
			
			User user2 = new User("employee", pwEncoder.encode("test"), "cyrille.jones@gamail.com", "Cyrille", "Jones", "Hugo de Grootstraat 174", "06-87054875", "Sliedrecht");
			user2.setRole("ROLE_EMPLOYEE");
			
			User user3 = new User("user", pwEncoder.encode("test"), "kevin.leijnse@gmail.com", "Kevin", "Leijnse", "Leidijk 97", "06-18756892", "Groningen");
			user3.setRole("ROLE_USER");	
			User user4 = new User("aniemies", pwEncoder.encode("test"), "annemie.schuurbiers@gmail.com", "Annemie", "Schuurbiers", "Duinerlaan 173", "06-83472443", "Eelde");
			User user5 = new User("seppe", pwEncoder.encode("test"), "seppe.bruinink@gmail.com", "Seppe", "Bruinink", "Gangboord 90", "06-13644621", "Oosterhout");
			User user6 = new User("beukenplein", pwEncoder.encode("test"), "m.snel@gmail.com", "Mikael", "Snel", "Onderkampstraat 30", "06-90982738", "Susteren");
			User user7 = new User("bookwurm", pwEncoder.encode("test"), "bookwurm@gmail.com", "Martina", "Jansen", "Nieuweweg 200", "06-00492182", "Burgum");
			User user8 = new User("daniela45", pwEncoder.encode("test"), "d.peerdeman@gmail.com", "Daniela", "Peerdeman", "Beukenkamp 84", "06-88720394", "Hoogezand");
			User user9 = new User("blackandyellow", pwEncoder.encode("test"), "simons@gmail.com", "Gert", "Simons", "Het Kanaal 170", "06-18392031", "Heerlen");
			User user10 = new User("superman123", pwEncoder.encode("test"), "edo.vandeijck@gmail.com", "Edo", "van Deijck", "Itersonstraat 195", "06-98374821", "Assen");
			
			usService.save(user1);
			usService.save(user2);
			usService.save(user3);
			usService.save(user4);
			usService.save(user5);
			usService.save(user6);
			usService.save(user7);
			usService.save(user8);
			usService.save(user9);
			usService.save(user10);
			
			Book book1 = new Book("Programming Pearls", "Jon Bentley", 1986, 1);
			Book book2 = new Book("Sapiens: A Brief History of Humankind", "Yuval Noah Harari", 2002, 2);
			Book book3 = new Book("Early India – From the Origins to AD 1300 Paperback", "Romila Thapar", 2011, 1);
			Book book4 = new Book("Anna Karenina", "Leo Tolstoy", 2007, 4);
			Book book5 = new Book("The Grapes of Wrath ", "John Steinbeck", 2009, 5);
			Book book6 = new Book("Jane Eyre", "Charlotte Brontë", 1899, 1);
			Book book7 = new Book("Beloved", "Toni Morrison", 2001, 3);
			Book book8 = new Book("Brave New World", "Aldous Huxley", 2005, 1);
			Book book9 = new Book("Invisible Man", "Ralph Ellison", 2009, 2);
			Book book10 = new Book("Middlemarch", "Mary Anne Evans", 1996, 3);
			Book book11 = new Book("To the Lighthouse", "Virginia Woolf", 2001, 1);
			Book book12 = new Book("The Sun Also Rises", "Ernest Hemingway", 2003, 1);
			Book book13 = new Book("In Search of Lost Time", " Marcel Proust", 2007, 1);
			Book book14 = new Book("David Copperfield", "Charles Dickens", 2003, 3);
			Book book15 = new Book("The Handmaid's Tale", "Margaret Atwood", 1989, 2);
			Book book16 = new Book("The Lord of the Rings", "J. R. R. Tolkien", 1968, 1);
			
		
			
			bookService.save(book1);
			bookService.save(book2);
			bookService.save(book3);
			bookService.save(book4);
			bookService.save(book5);
			bookService.save(book6);
			bookService.save(book7);
			bookService.save(book8);
			bookService.save(book9);
			bookService.save(book10);
			bookService.save(book11);
			bookService.save(book12);
			bookService.save(book13);
			bookService.save(book14);
			bookService.save(book15);
			bookService.save(book16);
			
			book10.setTheUser(user3);
			book10.setReturnDate(LocalDate.of(2021, 5, 23));
			
			book1.setTheUser(user3);
			book1.setReturnDate(LocalDate.of(2021, 5, 05));
			
			user3.setBooks(Arrays.asList(book10, book1));
			
			bookService.save(book1);
			bookService.save(book10);
			usService.save(user3);
						
			midAppRef.midnightApplicationRefresher();	
		};
	}
}
