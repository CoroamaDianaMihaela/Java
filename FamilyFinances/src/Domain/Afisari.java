package Domain;
import java.util.ArrayList;
//- tabel cu cheltuielile totale pe luna
//- tabel cu cheltuielile totale pe persoana data;
//- tabel cu cheltuielile lunare pe categorie si pe luna;(am nevoie de ambele)

import Exceptions.InputValueException;


//- data(zi,luna),
//- categoria,
//- suma cheltuita;
//- persoana, membra a familiei .
public class Afisari {

	public static void afisare_default(ArrayList<Cheltuiala> cheltuieli)
	{	
		String line="========================================================";
		System.out.println(line);
		System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n","ID","Data","Categorie","Persoana","Suma");
		System.out.println(line);
		
		for(Cheltuiala c: cheltuieli)					// iteram prin lista de cheltuieli si afisam fiecare cheltuiala
			System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n",String.valueOf(c.getId()),c.getData(),c.getCategorie(),c.getPersoana(),String.valueOf(c.getSuma()));
		System.out.println(line);
	}
	
	
	public static void afisare_categorii_per_luna(ArrayList<Cheltuiala> cheltuieli,int luna,int categorie_c) throws InputValueException
	{	// tabel cu cheltuieli lunare
		
		String[] dict={"alimente","imbracaminte","intretinere","cultura","educatie"};				// lista cu tipurile de categorii
		
		if(categorie_c<0 ||categorie_c>=5)						// verificam daca categoria este valida
			throw new InputValueException("Categoria trebuie sa fie una din cele 5 optiuni");
		
		String categorie=dict[categorie_c];
			
		
		if(luna<=0 || luna>=13)									// veridicam daca luna este valida
		{
			throw new InputValueException("Luna datei trebuie sa fie intre 1 si 12");
		}
		
		
		String line="========================================================";
		System.out.println(line);
		System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n","ID","Data","Categorie","Persoana","Suma");
		System.out.println(line);
		
		int val=0;				// initializam o variabila conditionala
		
		for(Cheltuiala c: cheltuieli)			// iteram prin lista de cheltuieli si afisam fiecare cheltuiala care are acelasi tip de categorie si aceeasi luna ca parametrii functiei
		{
			if(c.getCategorie().compareTo(categorie)==0 &&  c.getLuna()==luna)				
			{System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n",String.valueOf(c.getId()),c.getData(),c.getCategorie(),c.getPersoana(),String.valueOf(c.getSuma()));
			val=1;
			}
		}
			
			System.out.println(line);
			
			if (val==0)			// folosim variabila conditionala ca sa printam faptul ca nu s-a gasit nicio cheltuiala
				System.out.println("Nu s-a gasit nicio cheltuiala");
	}
	
	
	public static void afisare_per_luna(ArrayList<Cheltuiala> cheltuieli,int luna) throws InputValueException
	{	// tabel cu cheltuieli lunare
		
		if(luna<=0 || luna>=13)						// verificam daca luna este valida
		{
			throw new InputValueException("Luna datei trebuie sa fie intre 1 si 12");
		}
		
		String line="========================================================";
		System.out.println(line);
		System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n","ID","Data","Categorie","Persoana","Suma");
		System.out.println(line);
		
		int val=0;				// initializam o variabila conditionala
		
		for(Cheltuiala c: cheltuieli)
		{
			if(c.getLuna()==luna)				// iteram prin lista de cheltuieli si afisam fiecare cheltuiala care are aceeasi luna ca parametrul functiei
			{
				System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n",String.valueOf(c.getId()),c.getData(),c.getCategorie(),c.getPersoana(),String.valueOf(c.getSuma()));
				val=1;
			}
		}
			System.out.println(line);
				
			if (val==0)						// folosim variabila conditionala ca sa printam faptul ca nu s-a gasit nicio cheltuiala
				System.out.println("Nu s-a gasit nicio cheltuiala");
	}
	
	
	
	public static void afisare_per_persoana(ArrayList<Cheltuiala> cheltuieli,String persoana)
	{	// tabel cu cheltuieli lunare
		String line="========================================================";
		System.out.println(line);
		System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n","ID","Data","Categorie","Persoana","Suma");
		System.out.println(line);
		
		int val=0;				// initializam o variabila conditionala
		
		persoana=persoana.toLowerCase();
		for(Cheltuiala c: cheltuieli)						// iteram prin lista de cheltuieli si afisam fiecare cheltuiala care are aceesi persoana ca parametrul persoana
		{
			if(c.getPersoana().compareTo(persoana)==0)
			{
				System.out.format("|%-5s|%-10s|%-15s|%-10s|%10s|\n",String.valueOf(c.getId()),c.getData(),c.getCategorie(),c.getPersoana(),String.valueOf(c.getSuma()));
				val=1;
			}
		}
			System.out.println(line);
			
			if (val==0)						// folosim variabila conditionala ca sa printam faptul ca nu s-a gasit nicio cheltuiala
				System.out.println("Nu s-a gasit nicio cheltuiala");
	}
}
