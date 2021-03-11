package Domain;
public class Cheltuiala {

private	int id;
private String data;
private String categorie;
private float suma_cheltuita;
private String persoana;

public Cheltuiala()										//constructor implicit
{ 	
	this.data="";
	this.categorie="";
	this.suma_cheltuita=(float) 0.0;
	this.persoana="";
	
}
public Cheltuiala(String data,String categorie,float suma,String persoana)	//constructor explicit
{
	this.data=data;
	this.categorie=categorie; 
	this.suma_cheltuita=suma;
	this.persoana=persoana;
}


public String getData()														//getteri
{
	return this.data;
}
public String getCategorie()
{
	return this.categorie;
}
public float getSuma()
{
	return this.suma_cheltuita;
}
public String getPersoana()
{
	return this.persoana;
}
public int getId()
{
	return this.id;
}


public int getLuna()									//un get custom pentru luna deoarece avem nevoie de el la afisare
{			
	String []informatii=this.data.split("/");			//impartim data in zi si luna
	int luna=Integer.valueOf(informatii[1]);			
	return luna;
}





public void setData(String data)										//setteri 
{
	this.data=data;
}
public void setCategorie(String Categorie)
{
	this.categorie=Categorie;
}
public void setSuma(float suma)
{
	this.suma_cheltuita=suma;
}
public void setPersoana(String persoana)
{
	this.persoana=persoana;  
}
public void setID(int id)
{
	this.id=id;  
}

}
