package repository;
import java.util.ArrayList;
import Domain.Cheltuiala;

public class Repository {
ArrayList<Cheltuiala> cheltuieli;		// lista de cheltuieli
static int id;							// avem un atribut static id deoarece va fi un id surogat care va fi  atribuit fieicarei cheltuieli adaugate


public Repository()												// constructor implicit
{
	this.cheltuieli = new ArrayList<Cheltuiala>();				// initializam lista de obiecte de tip Cheltuiala
	id=1;										
}

public Repository(ArrayList<Cheltuiala> cheltuieli)				// constructor explicit
{
	this.cheltuieli=cheltuieli;
}

public void create(Cheltuiala c)								// adaugam o noua cheltuiala in lista de cheltuieli
{
	this.cheltuieli.add(c);
	c.setID(id++);												// setam id-ul cheltuielii adaugate folosindu-ne de campul static id iar dupa incrementam id-ul

}

public ArrayList<Cheltuiala> read()								// returnam lista de Cheltuieli
{
	return this.cheltuieli;
}


public void update(Cheltuiala c1,Cheltuiala c2)					// facem update unei Cheltuieli
{
	
	for(int i=0;i<this.cheltuieli.size();i++)
	{
		if(this.cheltuieli.get(i)==c1)							// trecem prin toate cheltuielile pana gasim una cu id-ul cautat
			{
			c2.setID(c1.getId());								// setam id-ul noii cheltuieli egal cu id-ul cheluielii vechi ca sa se pastreze ordinea
			this.cheltuieli.set(i,c2);							// setam la pozitia i , unde am gasit cheltuiala , noua cheltuiala data ca parametru
			}
	}
}

public void delete(int id)										// stergem Cheltuiala din Repository folosindu-ne de id-ul Cheltuielii
{	
	for(int i=0;i<this.cheltuieli.size();i++)
	{
		if(this.cheltuieli.get(i).getId()==id)					// iteram prin lista de cheltuieli pana cand gasim cheltuiala cu id-ul 
			this.cheltuieli.remove(i);							// dupa ce o gasim o stergem
	}
}


public Cheltuiala readByID(int id)								// returnam Cheltuiala cu id-ul dat ca parametrii
{	
	for(int i=0;i<this.cheltuieli.size();i++)					// iteram prin Cheltuieli pana gasim ce-a cu id-ul nostru
	{
		if(this.cheltuieli.get(i).getId()==id)
			return this.cheltuieli.get(i);
		
	}
	Cheltuiala c=new Cheltuiala();								// daca nu o gasim returnam o Cheltuiala nula cu id-ul 0
	c.setID(0);	
	return c;
}


}
