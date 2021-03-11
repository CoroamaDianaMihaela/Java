package Service;
import java.util.ArrayList;
import repository.Repository;
import Exceptions.*;
import Domain.Cheltuiala;
public class Service {

	Repository repo;							
	
	public Service(Repository repo)			//constructor explicit
	{
		this.repo=repo;
	}
	
	
	
	public void create(String data,int categorie,float suma,String persoana) throws InputValueException
	{
		String[] dict={"alimente","imbracaminte","intretinere","cultura","educatie"};					// initializam o lista tipurile de categorii			
		
		if(categorie<0 ||categorie>=5)																	// verificam daca categorie este valid, daca nu este intre 0 si 5 atunci iese din lungimea listei deci este invalid 
			throw new InputValueException("Categoria trebuie sa fie una din cele 5 optiuni");
		String categorie_c=dict[categorie];																// initializam noua variabila cu reprezentantul categoriei din lista de categorii
		
		
		if (suma<=0)																					// suma nu poate fi mai mica decat 0 , daca e aruncam exceptia custom InputValueException
			throw new InputValueException("Suma trebuie sa fie mai mare decat 0");
		
		
		String[] informatii_data=data.split("/");														// impartim parametrul data intr-o lista care continue ziua si luna
		
		if(Integer.valueOf(informatii_data[0])<=0 || Integer.valueOf(informatii_data[0])>=32)			// verificam daca ziua e intre 1 si 31
		{
			throw new InputValueException("Ziua datei trebuie sa fie intre 1 si 31");
		}
		if(Integer.valueOf(informatii_data[1])<=0 || Integer.valueOf(informatii_data[1])>=13)			// verificam daca luna e intre 1 si 12
		{
			throw new InputValueException("Luna datei trebuie sa fie intre 1 si 12");
		}
		
		
		Cheltuiala c=new Cheltuiala(data,categorie_c,suma,persoana);						// formam noua Cheltuiala si o adaugam in Repository
		repo.create(c);
	}
	
	
	
	public void update(int id,String data,int categorie_c,float suma,String persoana) throws InputValueException,NotFoundException
	{
		String[] dict={"alimente","imbracaminte","intretinere","cultura","educatie"};					// initializam o lista cu tipurile de categorii
		
		if(categorie_c<0 ||categorie_c>=5)																// verificam daca categoria este intre 0 si 5
			throw new InputValueException("Categoria trebuie sa fie una din cele 5 optiuni");
		String categorie=dict[categorie_c];
		
		if (suma<=0)																					// verificam daca suma este mai mica sau egala cu 0
			throw new InputValueException("Suma noua trebuie sa fie mai mare decat 0");				
		
		String[] informatii_data=data.split("/");														// verificam daca ziua e intre 1 si 31 
		
		if(Integer.valueOf(informatii_data[0])<=0 || Integer.valueOf(informatii_data[0])>=32)
		{
			throw new InputValueException("Ziua datei noi trebuie sa fie intre 1 si 31");
		}
		if(Integer.valueOf(informatii_data[1])<=0 || Integer.valueOf(informatii_data[1])>=13)			// verificam daca luna e intre 1 si 12
		{
			throw new InputValueException("Luna datei noi  trebuie sa fie intre 1 si 12");
		}
		Cheltuiala c1=new Cheltuiala();
		
		try
		{
		  c1=this.readByID(id);												// verificam daca exista o cheltuiala cu acest id
		}
		catch(Exception ex)
		{
			throw new NotFoundException("Nu s-a gasit nicio Cheltuiala cu acest ID");		// daca nu e gasita atunci aruncam eroarea custom NotFoundException
		}
		  Cheltuiala c2=new Cheltuiala(data,categorie,suma,persoana);
		  repo.update(c1, c2);	
	}
	
	
	
	public void delete(int id) throws IdNotFound, NotFoundException
	{
		this.readByID(id);			// daca nu se gaseste o cheltuiala cu acest ID atunci aruncam NotFoundException
		repo.delete(id);			// stergem Cheltuiala cu id-ul dat
	}
	
	
	public ArrayList<Cheltuiala> read()					// returnam lista de Cheltuieli
	{
		return repo.read();								
	}
	
	
	
	public Cheltuiala readByID(int id) throws NotFoundException
	{
		Cheltuiala c=new Cheltuiala();						// initializam o Cheltuiala nula cu id-ul 0
		c.setID(0);	
		Cheltuiala c2=repo.readByID(id);					// verificam daca readById ne returneaza o Cheltuiala nenula , daca nu atunci aruncam o eroare
		if (c.getId()==c2.getId())
			throw new NotFoundException("\n Nu s-a gasit o cheltuiala cu acest id");
		return c2;											// returnam Cheltuiala gasita
	}
	
}
