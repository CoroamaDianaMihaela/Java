package UI;
import repository.Repository;
import Service.Service;
import Service.Console;

public class Main {
	
	public static void main(String[] args)
	{
		Repository repo=new Repository();				// cream un obiect Repository
		Service service=new Service(repo);				// cream un obiect Service care are obiectul Repository ca atribut
		Console console=new Console(service);			// cream un obiect Console care are obiectul Service ca atribut
		console.run();
	}
}
