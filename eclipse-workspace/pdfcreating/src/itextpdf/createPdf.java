package itextpdf;

import com.itextpdf.text.*;

import com.itextpdf.text.pdf.*;
import java.io.FileOutputStream;
import java.nio.file.Paths;
import java.nio.file.Path;

public class createPdf {
    private static final String File_path = "C:\\Users\\admin\\OneDrive\\Desktop\\";
    private static final String File_name = "yesvanth.pdf";
    private static final String Img_name = "yesh.jpg";

    public static void main(String[] args) {
       //1.Document to create Pdf document
    	Document doc = new Document();
    	try {
    	
    	PdfWriter towrite = PdfWriter.getInstance(doc, new FileOutputStream(new String(File_path + File_name)));
    	
    	//to open document
    	doc.open();
    	
    	//2.create a chunk
    	Font font = FontFactory.getFont(FontFactory.COURIER_BOLD,14,BaseColor.BLUE);
    	Chunk chunk = new Chunk("yesvanth R ".toUpperCase(),font);
    	//add text to pdf
    	doc.add(chunk);
    	
    	//paragraph
    	String multiline = "hey I'm yesvanth from vellore i used to create web "
    			+ "application using html,css,javascript and in backend i used java,mysql for database";
    	//to add paragaraph create object
    	Paragraph paragraph = new Paragraph(multiline);
    	doc.add(paragraph);
    	
    	//to add path for image
    	Path imgpath = Paths.get(File_path + Img_name);
    	//to create object for image
    	Image image = Image.getInstance(imgpath.toAbsolutePath().toString());
    	image.scaleAbsolute(550f,400f);//to set height and width
    	doc.add(image);
    	
    	//we can set attributes like author,data,title etc..
    	
    	doc.addAuthor("Yesvanth R");
    	doc.addTitle("My Java Pdf");
    	doc.addCreationDate();
    	doc.addProducer();
//    	doc.setPageSize(PageSize.LETTER);
//    	doc.addSubject("YEsvanth pdf");
//    	doc.addKeywords("yesvanth, first, pdf, using itext jar file");
    	
    	
    	//insert table in pdf
    	//we want to create array
    	float[] columns = {150F,150F,250F,150F}; //three columns
    	PdfPTable table = new PdfPTable(columns);
    	
    	//we want to create cells 
    	//1st cell
    	PdfPCell cell1 = new PdfPCell();//first cell
    	cell1.setPhrase(new Phrase("First Name",font));//cell name
    	table.addCell(cell1);//we want to add to table
    	//2nd cell
    	PdfPCell cell2 = new PdfPCell();
    	cell2.setPhrase(new Phrase("Last Name",font));
    	table.addCell(cell2);
    	//3rd cell
    	PdfPCell cell3 = new PdfPCell();
    	cell3.setPhrase(new Phrase("Email",font));
    	table.addCell(cell3);
    	//4th cell
    	PdfPCell cell4 = new PdfPCell();
    	cell4.setPhrase(new Phrase("Phone no",font));
    	table.addCell(cell4);
    	//5th cell
    	PdfPCell cell5 = new PdfPCell();
    	cell5.setPhrase(new Phrase("Yesvanth"));
    	table.addCell(cell5);
    	//6th cell
    	PdfPCell cell6 = new PdfPCell();
    	cell6.setPhrase(new Phrase("R"));
    	table.addCell(cell6);
    	//7th cell
    	PdfPCell cell7 = new PdfPCell();
    	cell7.setPhrase(new Phrase("yesvanth1805@gmail.com"));
    	table.addCell(cell7);
    	//8th cell
    	PdfPCell cell8 = new PdfPCell();
    	cell8.setPhrase(new Phrase("7708807977"));
    	table.addCell(cell8);
    	//9th cell
    	PdfPCell cell9 = new PdfPCell();
    	cell9.setPhrase(new Phrase("Yokeshwaran"));
    	table.addCell(cell9);
    	//6th cell
    	PdfPCell cell10 = new PdfPCell();
    	cell10.setPhrase(new Phrase("R"));
    	table.addCell(cell10);
    	//7th cell
    	PdfPCell cell11 = new PdfPCell();
    	cell11.setPhrase(new Phrase("yokeshwaran2005@gmail.com"));
    	table.addCell(cell11);
    	//8th cell
    	PdfPCell cell12 = new PdfPCell();
    	cell12.setPhrase(new Phrase("9080743194"));
    	table.addCell(cell12);
    	
    	doc.add(table);
    	//close the document
    	doc.close();
    	
    	//to secure our document
    	PdfReader reader = new PdfReader(File_path + File_name);
    	PdfStamper stamper = new PdfStamper(reader,new FileOutputStream(new String(File_path + "Secure.pdf")));
    	String Owner_password = "owner";
    	String user_password = "user";
    	
    	stamper.setEncryption(Owner_password.getBytes(), user_password.getBytes(), PdfWriter.ALLOW_PRINTING,PdfWriter.ENCRYPTION_AES_256);
    	
    	stamper.close();
    	System.out.println("pdf created successfully");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Errir occured");
    		e.printStackTrace();
    	}
    	}
}
