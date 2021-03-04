//package UI;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.*;
//
//import repository.Repository;
//import Service.Service;
//import Service.Console;
//	
//public class GUI {
//	
//	 Repository repo=new Repository();											// cream un obiect Repository
//	 Service service=new Service(repo);											// cream un obiect Service care are obiectul Repository ca atribut
//	 Console console=new Console(service);										// cream un obiect Console care are obiectul Service ca atribut
//	 
//	public GUI()
//	{	
//		ImageIcon image1 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim.png"); 	// setam mai multe obiecte ImageIcon pentru a le pune butoanelor
//		ImageIcon image2= new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim2r.png");
//		ImageIcon image3 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim3r.png");
//		ImageIcon image4 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim4r.png");
//		ImageIcon image5 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim5r.png");
//		ImageIcon image6 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim6r.png");
//		ImageIcon image7 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim7r.png");
//		ImageIcon image8 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim8r.png");
//		
//		JLabel label_1= new JLabel(" Gestionare Buget Familial");											//cream un label (eticheta)
//		label_1.setFont(new Font("Colonna TM", Font.BOLD, 20));												//setam fontul  etichetei
//		ImageIcon icon_2 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//money4.png"); 			//setam o imagine pe care sa o folosim pentru label
//		label_1.setIcon(icon_2);
//		label_1.setIconTextGap(-50);																		//setam distanta minima intre iconita si titlu
//		label_1.setMaximumSize(new Dimension(Integer.MAX_VALUE, label_1.getMinimumSize().height));			//maximizam distanta dintre icons si titlu
//		
//		JButton button_1=new JButton("Introducerea Datelor din Fisier",image1);								//cream mai multe butoane
//		JButton button_2=new JButton("Creare cheltuieli");
//		JButton button_3=new JButton("Afisare cheltuieli");
//		JButton button_4=new JButton("Update cheltuiala");
//		JButton button_5=new JButton("Delete cheltuiala");
//		JButton button_6=new JButton("Afisare cheltuieli dupa luna");
//		JButton button_7=new JButton("Afisare cheltuieli dupa persoana");
//		JButton button_8=new JButton("Afisare chetuieli dupa categorie si luna ");
//
//		JFrame frame=new JFrame();																			//cream panel-ul si frame-ul 
//		JPanel panel=new JPanel();
//
//
//		
//		frame.setSize(600,600);																				//setam dimensiunea ferestrei
//		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 10));										//setam bordura frame-ului
//		panel.setLayout(new BoxLayout(panel,BoxLayout.PAGE_AXIS));											//setam modul de orientare a cutiilor
//		panel.setBackground(Color.white);
//		
//		frame.add(panel,BorderLayout.CENTER);																//adaugam panel in centru
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);												//setam momentul cand fereasta se inchide
//		frame.setTitle("Gestionare Cheltuieli");															//seteaza titlul ferestrei
//		
//		
//	
//		frame.setIconImage(icon_2.getImage());																//setam iconita ferestrei
//		
//		
//		
//		Box box= Box.createVerticalBox();																	//cream un box (cutie) pentru butoane si etichete
//		
//		
//		box.add(label_1,Box.LEFT_ALIGNMENT);		//adaugam eticheta in cutie
//		
//		box.add(button_1);							//adaugam buton
//		button_1.setIcon(image5);					//setam imaginea butonului
//		button_1.setFont(new Font("Colonna TM", Font.PLAIN, 18));	//setam fontul butonului
//		button_1.setOpaque(false);					//setam opacitatea butonului
//	    button_1.setContentAreaFilled(false);		//setam sa nu fie umplut fundalul butonului
//	    button_1.setBorderPainted(false);			//setam bordura butonului
//	    button_1.setFocusPainted(false);			//metoda pentru a seta ca butonul sa fie pictat ( de folos pentru a face butonul transparent)
//		button_1.addActionListener(new ActionListener()	//metoda pentru a adauga o actiune pentru buton
//		{
//			public void actionPerformed(ActionEvent e){  
//			console.citireDinFisier(); 				//setam actiunea butonului sa fie functia de citire din fisier
//	        }  
//			
//		});						
//		box.add(Box.createVerticalStrut(5));		//operatiune estetica care adauga un spatiu intre butoane
//		
//																		//repetam aceeasi pasi pentru celelalte 7 butoane
//		
//		box.add(button_2);							
//		button_2.setIcon(image2);										//setam imaginea pentru buton
//		button_2.setFont(new Font("Colonna TM", Font.PLAIN, 18));		//setam font-ul butonului
//		button_2.setOpaque(false);
//	    button_2.setContentAreaFilled(false);							//setam ca butonul sa fie transparent
//	    button_2.setBorderPainted(false);
//	    button_2.setFocusPainted(false);
//		button_2.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e){  
//			console.create(); 
//	        }  
//			
//		});
//		box.add(Box.createVerticalStrut(5));
//		
//		box.add(button_3);												//adaugam butonul
//		button_3.setIcon(image3);										//adaugam imagine butonului
//		button_3.setFont(new Font("Colonna TM", Font.PLAIN, 18));
//		button_3.setOpaque(false);
//	    button_3.setContentAreaFilled(false);							//modificam butonul pentru a fi transparent
//	    button_3.setBorderPainted(false);
//	    button_3.setFocusPainted(false);
//		button_3.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e){  
////			console.afisare_dault();									//modificam actiunea butonul in a apela functia afisaredefault()
//			afisaredefault();
//	        }  
//			
//		});
//		
//		
//		box.add(Box.createVerticalStrut(5));						//operatiune estetica de a dauga spatiu intre butoane
//		box.add(button_4);											//adaugam butonul in cutie
//		button_4.setIcon(image4);
//		button_4.setOpaque(false);									//modificam butonul in a fi transparent si a avea o imagine
//	    button_4.setContentAreaFilled(false);
//	    button_4.setBorderPainted(false);
//	    button_4.setFocusPainted(false);
//		button_4.setFont(new Font("Colonna TM", Font.PLAIN, 18));
//		button_4.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e){  			//modificam actiunea butonului in a apela console.update
//			console.update();
//	        }  
//			
//		});
//		
//		
//		box.add(Box.createVerticalStrut(5));
//		box.add(button_5);											//adaugam butonul in cutie
//		button_5.setIcon(image5);
//		button_5.setOpaque(false);									//modificam butonul in a fi transparent si a avea o imagine pe el
//	    button_5.setContentAreaFilled(false);
//	    button_5.setBorderPainted(false);
//	    button_5.setFocusPainted(false);
//		button_5.setFont(new Font("Colonna TM", Font.PLAIN, 18));	//setam fonul butonului
//		button_5.addActionListener(new ActionListener()				//modificam actiunea butonul in a apela functia console.delete();
//		{
//			public void actionPerformed(ActionEvent e){  
//			console.delete();
//	        }  
//			
//		});
//		
//		box.add(Box.createVerticalStrut(5));						//operatiune estetica pentru a pune spatiu intre butoane
//		box.add(button_6);										
//		button_6.setIcon(image6);
//		button_6.setOpaque(false);
//	    button_6.setContentAreaFilled(false);
//	    button_6.setBorderPainted(false);
//	    button_6.setFocusPainted(false);
//		button_6.setFont(new Font("Colonna TM", Font.PLAIN, 18));
//		
//		button_6.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e){  
//			text_button_1();
//	        }  
//			
//		});
//		
//		box.add(Box.createVerticalStrut(5));
//		box.add(button_7);
//		button_7.setIcon(image7);
//		button_7.setOpaque(false);
//	    button_7.setContentAreaFilled(false);
//	    button_7.setBorderPainted(false);
//	    button_7.setFocusPainted(false);
//		button_7.setFont(new Font("Colonna TM", Font.PLAIN, 18));
//		button_7.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e){  
////			afisareperpersoana();
//				text_button_2();
//	        }  
//			
//		});
//		
//		box.add(Box.createVerticalStrut(5));
//		box.add(button_8);
//		button_8.setIcon(image8);
//		button_8.setOpaque(false);
//	    button_8.setContentAreaFilled(false);
//	    button_8.setBorderPainted(false);
//	    button_8.setFocusPainted(false);
//		button_8.setFont(new Font("Colonna TM", Font.PLAIN, 18));
//		button_8.addActionListener(new ActionListener()
//		{
//			public void actionPerformed(ActionEvent e){  
////			afisaredepercategoriesiluna();
//				text_button_3();
//	        }  
//			
//		});
//		box.add(Box.createVerticalStrut(5));
//		
//		
//		panel.add(box);
//		frame.add(panel);
//		
//		
//		
//		frame.pack();
//		frame.setVisible(true);
//		}
//	
//public void afisaredefault()
//{
//	JFrame frame=new JFrame();
//	String[] columnNames= {"ID","Data","Categorie","Persoana","Suma"};			//cream o lista cu stringuri pentru numele coloanelor
//	Object[][] o= new Object[this.service.read().size()][6];					//matrice de obiecte pentru a o introduce ca parametru la crearea tabelului
//	try
//	{
//		o=console.getTableDefault();											//luam matricea cu cheltuielile care respecta o anumita conditie
//	}
//	catch(Exception ex)
//	{
//		System.out.println("Veti reveni la meniul principal");
//	}
//	
//	JTable table= new JTable(o,columnNames);									//cream tabelul
//	frame.add(new JScrollPane(table));											//metoda pentru a seta ca sa se poata misca prin tabel cu scroll
//	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);						//metoda pentru a seta ca modul de inchidere este prin a apasa X pe fereastra
//	frame.setSize(800,200);														//setam marimea
//	frame.setLocationByPlatform(true);		
//	frame.setVisible(true);														//setam vizibilitatea
//}
//	
//public void afisareperluna(int luna)
//{
//	JFrame frame=new JFrame();					
//	String[] columnNames= {"ID","Data","Categorie","Persoana","Suma"};			//cream o lista cu stringuri pentru numele coloanelor	
//	Object[][] o= new Object[this.service.read().size()][6];					//matrice de obiecte pentru a o introduce ca parametru la crearea tabelului
//	
//	if (luna <=0 || luna >=13)													//verificam valabilitate parametrilor
//		System.out.println("Luna trb sa fie intre 1 si 12");
//	try
//	{
//		o=console.getTablePerLuna(luna);										//luam o matrice de cheltuieli care respecta conditia stabilita (sa aiba aceeasi luna ca cea data)
//	}
//	catch(Exception ex)
//	{
//		System.out.println("Veti reveni la meniul principal");
//	}
//	
//	JTable table= new JTable(o,columnNames);									//repetam procesul de mai sus cu crearea unui frame care sa contina tabela
//	frame.add(new JScrollPane(table));
//	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//	frame.setSize(600,100);
//	frame.setLocationByPlatform(true);
//	frame.setVisible(true);
//}
//	
//
//
//public void afisareperpersoana(String persoana)
//{
//	JFrame frame=new JFrame();			
//	String[] columnNames= {"ID","Data","Categorie","Persoana","Suma"};			//cream o lista cu stringuri pentru numele coloanelor	
//	Object[][] o= new Object[this.service.read().size()][6];		
//	
//	try
//	{	
//		o=console.getTablePersoana(persoana);									//luam matricea cu cheltuielile cu aceeasi parsoana ca parametrul persoana
//	}			
//	catch(Exception ex)
//	{
//		System.out.println("Veti reveni la meniul principal");
//	}
//	
//	JTable table= new JTable(o,columnNames);									//urmam aceeasi pasi ca mai sus ca sa formam un frame care sa contina tabelul
//	frame.add(new JScrollPane(table));
//	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//	frame.setSize(800,100);
//	frame.setLocationByPlatform(true);
//	frame.setVisible(true);
//}
//
//public void afisaredepercategoriesiluna(int luna ,int categ)
//{
//	
//	if (luna <=0 || luna >=13)													//verificam valabilitatea parametrilor
//		{
//		System.out.println("Luna trebuie sa fie intre 1 si 12");
//		}
//		
//	
//	Console.categorie();
//	if (categ<=0 || categ>=5)
//	{
//		System.out.println("Categorie trebuie sa fie intre 0 si 4");
//	}
//	String[] dict={"alimente","imbracaminte","intretinere","cultura","educatie"};
//	String categorie_c=dict[categ];
//	
//	
//	JFrame frame=new JFrame();
//	String[] columnNames= {"ID","Data","Categorie","Persoana","Suma"};			//initializam o lista cu numele coloanelor
//	Object[][] o= new Object[this.service.read().size()][6];
//	try
//	{	
//		o=console.getTableCategorieSiLuna(luna,categorie_c);					//returnam o matrice cu toate cheltuielile care au aceeasi luna si categorie ca parametrii functiei
//	}
//	catch(Exception ex)
//	{
//		System.out.println("Veti reveni la meniul principal");
//	}
//	
//	JTable table= new JTable(o,columnNames);									//repetam pasii de mai sus pentru a forma un frame care sa contina tabelul
//	frame.add(new JScrollPane(table));
//	frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//	frame.setSize(800,100);
//	frame.setLocationByPlatform(true);
//	frame.setVisible(true);
//	
//}
//	
//public void text_button_1()
//{
//	ImageIcon image1 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim2r.png");
//	JFrame frame2 = new JFrame("GUI");																		//pentru a aparea un nou frame ca utilizatorul sa introduca valoarea, creem un nou frame
//	Box box4= Box.createVerticalBox();																		//se creaza "boxes"(cutii) pentru a introduce obiectele ca sa apara ordonat in frame
//	Box box5= Box.createHorizontalBox();
//	
//	
//	JLabel label2= new JLabel("Introduceti luna: ");														//se creaza un label (eticheta)
//	label2.setAlignmentX(Component.LEFT_ALIGNMENT);															//folosim metoda .setAlignment pentru a alinia label-ul la stanga
//	
//	JTextArea editTextArea = new JTextArea("");																//creem un component in care se poate scrie in fereastra 
//	editTextArea.setAlignmentX(Component.CENTER_ALIGNMENT);													//il asezam spre stanga
//	editTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, editTextArea.getMinimumSize().height));	//folosim .setMaximumSize pentru valoare estetica, sa se aseze bine langa eticheta
//	
//	JButton button10 = new JButton("Enter");
//	button10.setAlignmentX(Component.CENTER_ALIGNMENT);														//aliniem noul buton in centru
//	button10.setIcon(image1);
//    button10.setOpaque(false);
//    button10.setContentAreaFilled(false);
//    button10.setBorderPainted(false);
//    button10.setFocusPainted(false);
//    
//	button10.addActionListener(new ActionListener() {														
//			@Override		
//    	    public void actionPerformed(ActionEvent e) {
//				afisareperluna(Integer.parseInt(editTextArea.getText()));
//																											//facem override la metoda butonului ca la apasarea butonului sa se apeleze metoda afisare
//																										
//    	    }
//    	});
//   
//   
//																											//codul care urmeaza reprezinta introducerea componentelor create in cutii si cutii rigide intre componente pentru a face spatiu intre ele in fereastra(din nou estetic)
//	
//   box5.add(Box.createRigidArea(new Dimension(5, 10)));														//se introduce o cutie "rigida" din valoare estetica, pentru a face spatiu intre inceputul cutiei si eticheta introdusa 
//   box5.add(label2);
//   box5.add(editTextArea);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//   box4.add(box5);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//   box4.add(button10);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));																				
//   																											//adaugam cutia in frame
//   frame2.add(box4);
//   frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);													//deodata ce se inchide frame-ul, optam sa nu se inchida tot programul prin a apela JFRAME.HIDE_ON_CLOSE nu JFRAME.EXIT_ON_CLOSE
//   frame2.setSize(180,190);																					//setam marimea frame-ului
//   frame2.setLocationByPlatform(true);																		
//   frame2.setVisible(true);																					//facem vizibil frame-ul
//}
//
//
//public void text_button_2()
//{
//	ImageIcon image1 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim2r.png");
//	JFrame frame2 = new JFrame("GUI");																		//pentru a aparea un nou frame ca utilizatorul sa introduca valoarea, creem un nou frame
//	Box box4= Box.createVerticalBox();																		//se creaza "boxes"(cutii) pentru a introduce obiectele ca sa apara ordonat in frame
//	Box box5= Box.createHorizontalBox();
//	
//	
//	JLabel label2= new JLabel("Introduceti o persoana: ");													//se creaza o eticheta
//	label2.setAlignmentX(Component.LEFT_ALIGNMENT);															//folosim metoda .setAlignment pentru a alinia label-ul la stanga
//	
//	JTextArea editTextArea = new JTextArea("");																//creem un component in care se poate scrie in fereastra 
//	editTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);													//il asezam spre stanga
//	editTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, editTextArea.getMinimumSize().height));	//folosim .setMaximumSize pentru valoare estetica, sa se aseze bine langa eticheta
//	
//	JButton button10 = new JButton("Enter");
//	button10.setAlignmentX(Component.CENTER_ALIGNMENT);														//aliniem noul buton in centru
//	button10.setIcon(image1);
//    button10.setOpaque(false);
//    button10.setContentAreaFilled(false);
//    button10.setBorderPainted(false);
//    button10.setFocusPainted(false);
//    
//	button10.addActionListener(new ActionListener() {														
//			@Override		
//    	    public void actionPerformed(ActionEvent e) {
//				afisareperpersoana(editTextArea.getText());
//																											//facem override la metoda butonului ca la apasarea butonului sa se apeleze metoda afisare
//																											
//    	    }
//    	});
//																											//codul care urmeaza reprezinta introducerea componentelor create in cutii si cutii rigide intre componente pentru a face spatiu intre ele in fereastra(din nou estetic)
//	
//   box5.add(Box.createRigidArea(new Dimension(5, 10)));														//se introduce o cutie "rigida" din valoare estetica, pentru a face spatiu intre inceputul cutiei si eticheta introdusa 
//   box5.add(label2);
//   box5.add(editTextArea);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//   box4.add(box5);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//   box4.add(button10);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//																			
//   																											//adaugam cutia in frame
//   frame2.add(box4);
//   frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);													//deodata ce se inchide frame-ul, optam sa nu se inchida tot programul prin a apela JFRAME.HIDE_ON_CLOSE nu JFRAME.EXIT_ON_CLOSE
//   frame2.setSize(180,190);																					//setam marimea frame-ului
//   frame2.setLocationByPlatform(true);																		
//   frame2.setVisible(true);																					//facem vizibil frame-ul
//}
//
//public void text_button_3()
//{
//	Console.categorie();
//	ImageIcon image1 = new ImageIcon("C://Users//GEMENELE//Pictures//img_lab12//dim2r.png");
//	JFrame frame2 = new JFrame("GUI");																		//pentru a aparea un nou frame ca utilizatorul sa introduca valoarea, creem un nou frame
//	Box box4= Box.createVerticalBox();																		//se creaza "boxes"(cutii) pentru a introduce obiectele ca sa apara ordonat in frame
//	Box box5= Box.createHorizontalBox();
//	
//	
//	JLabel label2= new JLabel("Introduceti o valoare: ");													//se creaza o eticheta
//	label2.setAlignmentX(Component.LEFT_ALIGNMENT);															//folosim metoda .setAlignment pentru a alinia label-ul la stanga
//	
//	JTextArea editTextArea = new JTextArea("");																//creem un component in care se poate scrie in fereastra 
//	editTextArea.setAlignmentX(Component.LEFT_ALIGNMENT);													//il asezam spre stanga
//	editTextArea.setMaximumSize(new Dimension(Integer.MAX_VALUE, editTextArea.getMinimumSize().height));	//folosim .setMaximumSize pentru valoare estetica, sa se aseze bine langa eticheta
//	
//	JButton button10 = new JButton("Enter");
//	button10.setAlignmentX(Component.CENTER_ALIGNMENT);														//aliniem noul buton in centru
//	button10.setIcon(image1);
//    button10.setOpaque(false);
//    button10.setContentAreaFilled(false);
//    button10.setBorderPainted(false);
//    button10.setFocusPainted(false);
//
//    
//    
//	button10.addActionListener(new ActionListener() {														
//			@Override		
//    	    public void actionPerformed(ActionEvent e) {
//				String[] informatii=editTextArea.getText().split(",");
//				afisaredepercategoriesiluna(Integer.valueOf(informatii[0]),Integer.valueOf(informatii[1]));
//														//facem override la metoda butonului ca la apasarea butonului sa se apeleze metoda c.console(5,v)
//																											//unde v este valoare introdusa in zona de text din fereastra
//    	    }
//    	});
//   
//   
//																											//codul care urmeaza reprezinta introducerea componentelor create in cutii si cutii rigide intre componente pentru a face spatiu intre ele in fereastra(din nou estetic)
//	
//   box5.add(Box.createRigidArea(new Dimension(5, 10)));														//se introduce o cutie "rigida" din valoare estetica, pentru a face spatiu intre inceputul cutiei si eticheta introdusa 
//   box5.add(label2);
//   box5.add(editTextArea);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//   box4.add(box5);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//   box4.add(button10);
//   box4.add(Box.createRigidArea(new Dimension(5, 10)));
//																			
//   																											//adaugam cutia in frame
//   frame2.add(box4);
//   frame2.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);													//deodata ce se inchide frame-ul, optam sa nu se inchida tot programul prin a apela JFRAME.HIDE_ON_CLOSE nu JFRAME.EXIT_ON_CLOSE
//   frame2.setSize(180,190);																					//setam marimea frame-ului
//   frame2.setLocationByPlatform(true);																		
//   frame2.setVisible(true);																					//facem vizibil frame-ul
//   
//}
//
//public static void main(String[] args)
//{
//	
//	new GUI();
//}
//}
