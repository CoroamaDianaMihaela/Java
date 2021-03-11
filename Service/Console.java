package Service;
import java.util.Scanner;

import Domain.Afisari;
import Domain.Cheltuiala;

import java.io.*;
import Exceptions.*;

public class Console {
	Service service;
	
	public Console(Service service)							// constructor explicit
	{
		this.service=service;
	}
	
	public void run()										//functia principala de rulare
	{			
		int op=Menu();
		while(op!=0)
		{
			switch(op)
			{
			case 1:
				citireDinFisier();							//citim din fisier
				break;
			case 2:
				create();									//cream o Cheltuiala de la tastatura					
				break;
			case 3:
				Afisari.afisare_default(service.read());	//afisam Cheltuielile
				break;
			case 4:
				this.update();								//facem update la Cheltuiala
				break;
			case 5:
				this.delete();								//stergem o Cheltuiala
				break;
			case 6:
				this.afisare_per_luna();					//afisam Cheltuielile in functie de luna data
				break;
			case 7:
				this.afisare_per_persoana();				//afisam Cheltuielile in functie de persoana data
				break;
			case 8:
				this.afisare_categorii_per_luna();			//afisam Cheltuielile in functie de categoria si persoana data
				break;
			default:
				return ;
			}
			op=Menu();
		}
	}
	
	public static void categorie()											//afisarea tipurilor de categorie
	{
		
		System.out.println("Categoriile posibile: ");
		System.out.println("----------------------");
		System.out.println("0. alimente");
		System.out.println("1. imbracaminte");
		System.out.println("2. cheltuieli de intretinere");
		System.out.println("3. cultura");
		System.out.println("4. educatie");
		System.out.println("----------------------\n");
		
	}
	public static int Menu()												//meniu
	{
		System.out.println("\n");
		System.out.println(" Optiunile posibile: ");
		System.out.println("===============================");
		System.out.println("1. Introducerea Datelor din Fisier");
		System.out.println("2. Creare cheltuiala");
		System.out.println("3. Afisare toate cheltuieli");
		System.out.println("4. Update cheltuiala");
		System.out.println("5. Delete cheltuiala");
		System.out.println("6. Afisare cheltuieli dupa luna");
		System.out.println("7. Afisare cheltuieli dupa persoana");
		System.out.println("8. Afisare chetuieli dupa categorie");
		System.out.println("0. Oprire program");
		System.out.println("===============================");
		int op=cinInt(" Alegerea dumneavoastra: ");
		return op;
		
	}	
	
	public void citireDinFisier()
	{
		if (this.service.read().size()!=0)
		{
			System.out.println("Deja ati citit din fisier");
			return;
		}
		
		try
		{
			 
			 BufferedReader bf=new BufferedReader(new FileReader("src/ObjectFiles/Cheltuieli.txt"));
			 String data;
			 int categorie;
			 float suma;
			 String persoana;
			 String line=bf.readLine();
				while (line!=null)												//citim pana cand fisierul nostru este gol
				{
					String[] informatii=line.split(",");						//impartim informatia folosind split unde primul element e numele iar al doilea numarul de bucati vandute
					data=informatii[0];
					categorie=Integer.valueOf(informatii[1]);
					suma=Float.valueOf(informatii[2]); 
					persoana=informatii[3];
					
					
					try
					{
						this.service.create(data, categorie, suma, persoana);
					}
					catch(InputValueException ex)
					{
						System.out.println(ex.getMessage());
					}
					line=bf.readLine();
				}
				bf.close();
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return;
		}
	}
	
	public void create()
	{
			
		System.out.println("Introduceti datele: ");													
		categorie();																				//informam utilizatorul de tipurile de categorii posibile
		System.out.println("Structura este: data(zi/luna),categorie,suma cheltuita,persoana");		//anuntam utilizatorul de structura care trb respectata
		
		
		@SuppressWarnings("resource")
		Scanner scn=new Scanner(System.in);
		String line=scn.nextLine();
		String data;
		int categorie;
		float suma;
		String persoana;
		while(line!=null)
		{
			try {
			if(line.compareTo("")==0)
				return;
			String[] informatii=line.split(",");		  				//impartim informatia folosind split unde primul element e numele iar al doilea numarul de bucati vandute
			data=informatii[0];
			suma=Float.valueOf(informatii[2]); 
			persoana=informatii[3];
			categorie=Integer.valueOf(informatii[1]);
			
			try															//incercam sa cream o Cheltuiala cu atributele scrise
			{
				this.service.create(data, categorie, suma, persoana);
			}
			catch(InputValueException ex)
			{
				System.out.println(ex.getMessage());
				System.out.println("Introduceti din nou datele: ");
			}
			
			line=scn.nextLine();										//daca am introdus corect datele putem sa introducem datele pentru urmatoarea Cheltuiala
		}
		catch(Exception ex)												//daca nu sunt introduse datele conform structurii anuntam user-ul ca nu a respectat structura
		{
			System.out.println("Nu ati introdus datele conform structurii");	
			line=cinString("Daca doriti sa nu mai incercati apasati enter");
			if(line.compareTo("")==0)
				return ;
			line=scn.nextLine();
		}
			
		}
	
	
	}

	
	
	public void update()
	{
		if (this.service.read().size()==0)
		{
			System.out.println("Nu exista nicio cheltuiala din repository");
			return;
		}
		
		int id=cinInt("Ce id are cheltuiala pe care doriti sa o modificati? : ");				//cerem id-ul necesar pentru gasirea Cheltuielii care trebuie modificata
		try	
		{
			
			System.out.println("Introduceti datele noii cheltuieli: ");							//daca am introdus corect datele putem sa introducem datele pentru urmatoarea Cheltuiala
			categorie();
			System.out.println("Structura este: data(zi/luna),categorie,suma cheltuita,persoana");//anuntam utilizatorul de structura care trb respectata
			
			
			@SuppressWarnings("resource")
			Scanner scn=new Scanner(System.in);
			String line=scn.nextLine();
			String data;
			int categorie;
			float suma;
			String persoana;
			String[] informatii=line.split(",");		  									//impartim informatia folosind split unde primul element e numele iar al doilea numarul de bucati vandute
			data=informatii[0];
			suma=Float.valueOf(informatii[2]); 
			persoana=informatii[3];
			categorie=Integer.valueOf(informatii[1]);
			
			this.service.update(id, data, categorie, suma, persoana);						//incercam sa modificam Cheltuiala cu id-ul dat
			
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Veti reveni la meniul principal");
		}
	}
	
	
	
	public void delete()
	{
		
		if (this.service.read().size()==0)
		{
			System.out.println("Nu exista nicio cheltuiala din repository");
			return;
		}
		int id=cinInt("Ce id are cheltuiala pe care doriti sa o stergeti? : ");			//cerem id-ul Cheltuielii care urmeaza sa fie stearsa
		
		try
		{
			this.service.delete(id);													//incercam sa stergem Cheltuiala cu id-ul dat
		}
		catch(Exception ex)																//daca nu sunt introduse datele conform structurii anuntam user-ul ca nu a respectat structura
		{
			System.out.println(ex.getMessage());
			System.out.println("Veti reveni la meniul principal");
		}
	}
	
	
	public void afisare_dault()
	{
		if (this.service.read().size()==0)												//ne asiguram ca repository sa nu fie gol
		{
			System.out.println("Nu exista nicio cheltuiala din repository");		
			return;
		}
		Afisari.afisare_default(this.service.read());
	}
	
	
	public void afisare_per_luna()														//afisam Cheltuielile in functie de luna data
	{
		if (this.service.read().size()==0)
		{
			System.out.println("Nu exista nicio cheltuiala din repository");
			return;
		}
		int luna=cinInt("Scrieti luna: ");												// cerem luna dupa care sa afisam cheltuielile
		try {
		Afisari.afisare_per_luna(this.service.read(), luna);							// daca luna nu este valida se arunca exceptia InputValueException
		}
		catch( InputValueException ex)
		{
			System.out.println(ex.getMessage());
			System.out.println("Veti reveni la meniul principal");
		}
	}
	
	public void afisare_categorii_per_luna()											// afisam Cheltuielile in functie de categoria si luna data
	{
		if (this.service.read().size()==0)
		{
			System.out.println("Nu exista nicio cheltuiala din repository");
			return;
		}
		System.out.println("Introduceti luna si categoria");
		int luna=cinInt("Scrieti luna: ");													// cerem luna si categoria in functie de care sa afisam Cheltuielile
		categorie();
		int categ=cinInt("Alegerea dumneavoastra: ");
		try
		{
			Afisari.afisare_categorii_per_luna(this.service.read(), luna, categ);			// daca luna sau categoria nu sunt valide se arunca exceptia InputValueException
		} catch (InputValueException e) {
			System.out.println(e.getMessage());
			System.out.println("Veti reveni la meniul principal");
		}
	}
	
	
	public void afisare_per_persoana()
	{
		if (this.service.read().size()==0)
		{
			System.out.println("Nu exista nicio cheltuiala din repository");
			return;
		}
		String persoana=cinString("Scrieti persoana: ");									// cerem persoana dupa care sa afisam Cheltuielile
		Afisari.afisare_per_persoana(this.service.read(), persoana);
	}
	
	
	
	public static float cinFloat(String str)								// citire variabile Float
	{
		try
		{
			System.out.println(str);
			@SuppressWarnings("resource")
			Scanner scn=new Scanner(System.in);
			float fl=scn.nextFloat();
			return fl;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return cinFloat(str);
		}
	}
	
	public static String cinString(String str)								// citire variabila String
	{
		try 
		{
			  System.out.println(str);
			  @SuppressWarnings("resource")
			Scanner scn=new Scanner(System.in);
			  String ss=scn.nextLine();
			  return ss;
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return cinString(str);
		}
	}
	
	@SuppressWarnings("resource")
	public static int cinInt(String str)									// citire variabile Int
	{
		try
		{
			System.out.println(str);
			Scanner scanner=new Scanner(System.in);
			int nr=scanner.nextInt();
			return nr; 
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage());
			return cinInt(str);
		}
		
				
		
 }
	
	
	public Object[][] getTableDefault()										//returneaza o matrice cu toate obiectele
	{
			
			Object[][] o= new Object[this.service.read().size()][6];		//initializam o matrice cu maximul de elemente din repository si un numar de coloane egal cu atributele
			int i=0;
			for(Cheltuiala ob: this.service.read()) {						//adaugam in matrice pe fiecare rand toate atributele fiecare cheltuieli
				o[i][0]= ob.getId();
				o[i][1]= ob.getData();
				o[i][2]= ob.getCategorie();
				o[i][3]= ob.getPersoana();
				o[i][4]= String.valueOf(ob.getSuma());
			
				i++;														//trecem la urmatorul rand
			}
			
			return o;
	}
		
	public Object[][] getTablePerLuna(int luna)
	{
		Object[][] o= new Object[this.service.read().size()][6];			//initializam o matrice cu maximul de elemente din repository si un numar de coloane egal cu atributele
		int i=0;															//initializam variabila contor
		for(Cheltuiala ob: this.service.read()) {							//iteram prin lista de cheltuieli si le punem in tabel numai pe cele care sunt in aceeasi luna ca parametrul functiei
			if (ob.getLuna()==luna)
			{	o[i][0]= ob.getId();
				o[i][1]= ob.getData();
				o[i][2]= ob.getCategorie();
				o[i][3]= ob.getPersoana();
				o[i][4]= String.valueOf(ob.getSuma());
			i++;															//incrementam contorul
			}		
		}
			
			return o;
	}
	
	public Object[][] getTablePersoana(String persoana)
	{
			persoana=persoana.toLowerCase();
			Object[][] o= new Object[this.service.read().size()][6];		//initializam o matrice cu maximul de elemente din repository si un numar de coloane egal cu atributele
			int i=0;														//initializam variabila contor
			for(Cheltuiala ob: this.service.read()) {
				{
					String persoana_2=ob.getPersoana();
					persoana_2=persoana_2.toLowerCase();
				if (persoana_2.compareTo(persoana)==0)				//iteram prin lista de cheltuieli si le punem in tabel numai pe cele care au aceeasi persoana ca parametrul functiei
				{o[i][0]= ob.getId();
				o[i][1]= ob.getData();
				o[i][2]= ob.getCategorie();
				o[i][3]= ob.getPersoana();
				o[i][4]= String.valueOf(ob.getSuma());
			
				i++;														//incrementam contorul
				}
				}
			}
			
			return o;
	}
	
	public Object[][] getTableCategorieSiLuna(int luna , String categorie_c)
	{
			
		Object[][] o= new Object[this.service.read().size()][6];						//initializam o matrice cu maximul de elemente din repository si un numar de coloane egal cu atributele
		int i=0;																		//initializam variabila contor
		for(Cheltuiala ob: this.service.read()) {
			if(ob.getLuna()==luna && ob.getCategorie().compareTo(categorie_c)==0)		//iteram prin lista de cheltuieli si le punem in tabel numai pe cele care au aceeasi persoana ca parametrul functiei
			{o[i][0]= ob.getId();
			o[i][1]= ob.getData();
			o[i][2]= ob.getCategorie();
			o[i][3]= ob.getPersoana();
			o[i][4]= String.valueOf(ob.getSuma());
		
			i++;																		// incrementam variabila contor
			}	
		}
			
			return o;
	}

	
}
