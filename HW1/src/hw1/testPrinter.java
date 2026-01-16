package hw1;

public class testPrinter {
	public static void main(String args[]) {

	    
	      Printer n = new Printer(100); 
	      n.addPaper(1); 
	      n.startPrintJob(5); 
	      n.printPage(); 
	      System.out.println(n.getNextPage()); 
	      System.out.println("Expected 1"); 
	      System.out.println(n.getTotalPages()); 
	           System.out.println("Expected 1");
	           
	   		Printer p = new Printer(100); 
			p.addPaper(1);
			System.out.println(p.getSheetsAvailable());
			System.out.println("Expected 1");
			p.addPaper(5);
			System.out.println(p.getSheetsAvailable());
			System.out.println("Expected 6");
			p.addPaper(5);
			System.out.println(p.getSheetsAvailable());
			System.out.println("Expected 11");
		//	p.printPage();
		//	System.out.println(p.getTotalPages());
			
		      p.startPrintJob(2); 
		 System.out.println(p.getNextPage()); 
		      System.out.println("Expected 0");
		      
		      Printer j = new Printer(10);
		      j.addPaper(8);
		      System.out.println(j.getSheetsAvailable());
		      j.removePaper(1);
		      j.removePaper(1);
		      j.removePaper(1);
		      j.removePaper(1);
		      System.out.println(j.getSheetsAvailable());
		      System.out.println("Expected: 4");
		      
		      Printer u = new Printer(100);
		      u.addPaper(99);
		      u.startPrintJob(5);
		      u.printPage();
		      u.printPage();
		      u.printPage();
		      u.printPage();
		      u.printPage();
		      System.out.println(u.getNextPage());
		      System.out.println("Expected: 0");
		     
		      Printer o = new Printer(100);
		      o.addPaper(99);
		      o.startPrintJob(5);
		      o.printPage();
		      o.printPage();
		      o.printPage();
		      o.printPage();
		      o.printPage();
		      System.out.println(o.getSheetsAvailable());
		      System.out.println("Expected: 94");
		      
		      n.addPaper(200); 
		      System.out.println(n.getSheetsAvailable()); 
		      System.out.println("Expected 100"); 
		      n.printPage(); 
		      System.out.println(n.getTotalPages()); 
		      System.out.println("Expected 2"); 
		      System.out.println(n.getNextPage()); 
		           System.out.println("Expected 2"); 
		      
		      
		      
	}
}
