package hw1;

public class Printer {
	private int aSheets;
	private int nextPage;
	private int pagesPrinted;
	private int addedPaper;
	
	private int trayCapacity;
/*	
 * Constructs a new printer with the given maximum tray capacity.
 * @param uses tray capacity of the number of paper sheets it can hold.
 * Tray is initially empty and printer has printed nothing.
 */
	public Printer(int trayCapacity) {
		aSheets = 0;
		nextPage = 0;
		pagesPrinted = 0;
		addedPaper = 0;
		this.trayCapacity = trayCapacity;
		
	}
	/*
	 * Starts a new print job.
	 * Makes copies of a document that is a specified page length.
	 * @param Updates the next page to print as page 0.
	 */
	public void startPrintJob(int documentPages) {
	
		//documentPages = pagesPrinted;
		nextPage = Math.min(documentPages, 0);
		
		
	
		
		
		
		
	
		
	}
	/*
	 * @return the number of sheets available for printing.
	 */
	public int getSheetsAvailable() {
		
		return aSheets;
	}
	/*
	 * @return the next page number of the document that will be printed.
	 */
	public int getNextPage() {
		

		return nextPage;
		
	}
	/*
	 * @return the count of all the pages printed by the printer.
	 */
	public int getTotalPages() {
	
		return pagesPrinted;
	}
	/*
	 * Simulation of the the printer printing a page.
	 * Increments total page count of printer.
	 * Advances the next page to print number of pages.
	 * Number of pages available to the printer and in the tray are updated.
	 */
	public void printPage() {
		nextPage = nextPage + Math.min(1, aSheets);
		int method  = Math.min(1, aSheets);
		aSheets -= method; 
		nextPage = nextPage % 5;
		pagesPrinted += method; 
		
		
		 
	}
	/*
	 * removes paper from the printer.
	 * makes the sheets available to printer 0.
	 */
	public void removeTray() {
		
		aSheets = addedPaper;
		aSheets = 0;
		
	}
	/*
	 * replaces the tray in printer.
	 * makes sheets available to the printer the same as the number of sheets in the tray.
	 */
	public void replaceTray() {
		 aSheets = addedPaper;
		
	}
	/*
	 * Simulates removing the tray
	 * Adds given number of sheets
	 */
	public void addPaper(int sheets) {
		
		
		addedPaper = Math.min(addedPaper + sheets, trayCapacity);
		
		replaceTray();
		
		
		
	}
	/*
	 * Simulates removing the tray, given number of sheets.
	 */
	public void removePaper(int sheets) {
		
		
		addedPaper = Math.max(addedPaper - sheets, 0);
		
		replaceTray();
		
	}
}
