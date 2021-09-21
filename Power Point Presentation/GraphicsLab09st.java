import java.awt.*;

public class GraphicsLab09st extends java.applet.Applet
{
	int numClicks;
	Image pic1, pic2, pic3, pic4, pic5, pic6, pic7, pic8, pic9, pic10, pic11, pic12;

	public void init()
	{
		numClicks = 0;
		pic1 = getImage(getDocumentBase(),"Krithika.jpg");
		pic2 = getImage(getDocumentBase(),"andrews.jpg");
		pic3 = getImage(getDocumentBase(),"rice.jpg");
		pic4 = getImage(getDocumentBase(),"schedule.jpg");
		pic5 = getImage(getDocumentBase(),"schedule2.jpg");
		pic6 = getImage(getDocumentBase(),"parents.jpeg");
		pic7 = getImage(getDocumentBase(),"brother.jpg");
		pic8 = getImage(getDocumentBase(),"alaska.jpg");
		pic9 = getImage(getDocumentBase(),"young.jpg");
		pic10 = getImage(getDocumentBase(),"younger.jpg");
		pic11 = getImage(getDocumentBase(),"cake.jpg");
		pic12 = getImage(getDocumentBase(),"end.gif");	
	}

	public void paint(Graphics g)
	{
		switch (numClicks)
		{
			case 0:	page1(g); break;
			case 1: page2(g); break;
			case 2: page3(g); break;
			case 3: page4(g); break;
			case 4: page5(g); break;
			case 5: page6(g); break;
			case 6: page7(g); break;
			case 7: page8(g); break;
			case 8: page9(g); break;
			case 9: page10(g); break;
			case 10: page11(g); break;
			case 11: page12(g); break;
			default: numClicks =0; page1(g);
		}
	}

	public boolean mouseDown(Event e, int x, int y)
	{
		numClicks++;
		repaint();
		return true;
	}

	public void page1(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Krithika Kannan",115,100);
		Expo.drawString(g,"-------------------------",115,140);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic1,230,220,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,30);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Alaska",420,620);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page2(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Education",245,100);
		Expo.drawString(g,"----------------",235,140);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic2,230,220,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,30);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Andrews Elementary",350,550);
		Expo.drawString(g,"School",438,620);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page3(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Education",245,100);
		Expo.drawString(g,"----------------",235,140);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic3,202,260,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,30);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Rice Middle School",350,590);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page4(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Schedule",255,100);
		Expo.drawString(g,"---------------",245,140);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic4,202,250,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Classes: ",580,280);
		Expo.drawString(g,"-Physics HL",580,310);
		Expo.drawString(g,"-Econ SL",580,340);
		Expo.drawString(g,"-CompSci HL",580,370);
		Expo.drawString(g,"-APUSH",580,400);
		Expo.drawString(g,"-English HL",580,430);
		Expo.drawString(g,"-French SL",580,460);
		Expo.drawString(g,"-Precal",580,490);
		Expo.drawString(g,"2017 - 2018 Classes",350,590);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page5(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Schedule",255,100);
		Expo.drawString(g,"---------------",245,145);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic5,230,220,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Classes: ",580,280);
		Expo.drawString(g,"-Physics HL",580,310);
		Expo.drawString(g,"-CompSci HL",580,340);
		Expo.drawString(g,"-English HL",580,370);
		Expo.drawString(g,"-Calculus SL",580,400);
		Expo.drawString(g,"-TOK :(",580,430);
		Expo.drawString(g,"2018 - 2019 Classes",350,590);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page6(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Family",305,100);
		Expo.drawString(g,"----------",305,145);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic6,260,220,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Parents",450,590);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page7(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Family",305,100);
		Expo.drawString(g,"----------",305,145);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic7,310,270,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Brother",450,590);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page8(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Future",305,100);
		Expo.drawString(g,"----------",305,145);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic8,240,230,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"Summer Vacation",400,610);
		Expo.drawString(g,"Alaska",450,630);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page9(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Younger Me",230,100);
		Expo.drawString(g,"------------------",222,145);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic10,270,250,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"1 Years Old",450,600);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page10(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Younger Me",230,100);
		Expo.drawString(g,"------------------",222,145);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic9,310,290,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.black);
		Expo.drawString(g,"4 Years Old",450,600);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page11(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Title
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,100);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"Birthday",290,100);
		Expo.drawString(g,"-------------",290,145);
		
		//Image
		Expo.fillRectangle(g,180,210,800,850);
		g.drawImage(pic11,230,240,this);
		Expo.setFont(g,"Franklin Gothic Book",Font.BOLD,25);
		Expo.setColor(g,Expo.white);
		Expo.drawString(g,"5 Years Old",450,600);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,100,210,20,5);
		Expo.fillStar(g,100,250,20,5);
		Expo.fillStar(g,100,290,20,5);
		Expo.fillStar(g,100,330,20,5);
		Expo.fillStar(g,100,370,20,5);
		Expo.fillStar(g,100,410,20,5);
		Expo.fillStar(g,100,450,20,5);
		Expo.fillStar(g,100,490,20,5);
		Expo.fillStar(g,100,530,20,5);
		Expo.fillStar(g,100,570,20,5);
		Expo.fillStar(g,100,610,20,5);
		Expo.fillStar(g,100,650,20,5);
		
		//Middle
		Expo.fillStar(g,100,170,20,5);
		Expo.fillStar(g,140,170,20,5);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,220,170,20,5);
		Expo.fillStar(g,260,170,20,5);
		Expo.fillStar(g,300,170,20,5);
		Expo.fillStar(g,340,170,20,5);
		Expo.fillStar(g,380,170,20,5);
		Expo.fillStar(g,420,170,20,5);
		Expo.fillStar(g,460,170,20,5);
		Expo.fillStar(g,500,170,20,5);
		Expo.fillStar(g,540,170,20,5);
		Expo.fillStar(g,580,170,20,5);
		Expo.fillStar(g,620,170,20,5);
		Expo.fillStar(g,660,170,20,5);
		Expo.fillStar(g,700,170,20,5);
		Expo.fillStar(g,740,170,20,5);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,820,170,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,860,170,20,5);
		Expo.fillStar(g,860,210,20,5);
		Expo.fillStar(g,860,250,20,5);
		Expo.fillStar(g,860,290,20,5);
		Expo.fillStar(g,860,330,20,5);
		Expo.fillStar(g,860,370,20,5);
		Expo.fillStar(g,860,410,20,5);
		Expo.fillStar(g,860,450,20,5);
		Expo.fillStar(g,860,490,20,5);
		Expo.fillStar(g,860,530,20,5);
		Expo.fillStar(g,860,570,20,5);
		Expo.fillStar(g,860,610,20,5);
		Expo.fillStar(g,860,650,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
	}
	
	public void page12(Graphics g)
	{
		//Background
		Expo.setBackground(g,Expo.black);
		
		//Image
		g.drawImage(pic12,230,140,this);
		
		//Left
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,180,170,20,5);
		Expo.fillStar(g,180,210,20,5);
		Expo.fillStar(g,180,250,20,5);
		Expo.fillStar(g,180,290,20,5);
		Expo.fillStar(g,180,330,20,5);
		Expo.fillStar(g,180,370,20,5);
		Expo.fillStar(g,180,410,20,5);
		Expo.fillStar(g,180,450,20,5);
		Expo.fillStar(g,180,490,20,5);
		Expo.fillStar(g,180,530,20,5);
		
		//Middle
		Expo.fillStar(g,180,150,20,5);
		Expo.fillStar(g,220,150,20,5);
		Expo.fillStar(g,260,150,20,5);
		Expo.fillStar(g,300,150,20,5);
		Expo.fillStar(g,340,150,20,5);
		Expo.fillStar(g,380,150,20,5);
		Expo.fillStar(g,420,150,20,5);
		Expo.fillStar(g,460,150,20,5);
		Expo.fillStar(g,500,150,20,5);
		Expo.fillStar(g,540,150,20,5);
		Expo.fillStar(g,580,150,20,5);
		Expo.fillStar(g,620,150,20,5);
		Expo.fillStar(g,660,150,20,5);
		Expo.fillStar(g,700,150,20,5);
		Expo.fillStar(g,740,150,20,5);
		Expo.fillStar(g,780,150,20,5);
		
		//Right
		Expo.setColor(g,Expo.yellow);
		Expo.fillStar(g,780,170,20,5);
		Expo.fillStar(g,780,210,20,5);
		Expo.fillStar(g,780,250,20,5);
		Expo.fillStar(g,780,290,20,5);
		Expo.fillStar(g,780,330,20,5);
		Expo.fillStar(g,780,370,20,5);
		Expo.fillStar(g,780,410,20,5);
		Expo.fillStar(g,780,450,20,5);
		Expo.fillStar(g,780,490,20,5);
		Expo.fillStar(g,780,530,20,5);
		
		//Down
		Expo.fillStar(g,180,530,20,5);
		Expo.fillStar(g,220,530,20,5);
		Expo.fillStar(g,260,530,20,5);
		Expo.fillStar(g,300,530,20,5);
		Expo.fillStar(g,340,530,20,5);
		Expo.fillStar(g,380,530,20,5);
		Expo.fillStar(g,420,530,20,5);
		Expo.fillStar(g,460,530,20,5);
		Expo.fillStar(g,500,530,20,5);
		Expo.fillStar(g,540,530,20,5);
		Expo.fillStar(g,580,530,20,5);
		Expo.fillStar(g,620,530,20,5);
		Expo.fillStar(g,660,530,20,5);
		Expo.fillStar(g,700,530,20,5);
		Expo.fillStar(g,740,530,20,5);
		Expo.fillStar(g,780,530,20,5);
		
		//Top
		Expo.setColor(g,Expo.red);
		Expo.drawBurst(g,60,60,50,16);
		Expo.drawBurst(g,950,60,50,16);
		Expo.drawBurst(g,60,600,50,16);
		Expo.drawBurst(g,950,600,50,16);
	}
}

