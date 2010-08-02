

import java.awt.Color;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;
import com.lowagie.text.pdf.fonts.*;


public class resumewebd {
	
	/*******    Common data for each timetable object ***********************/
	
	int numRooms;										// Total number of rooms
	int  numSlots;										// Total number of slots
	int eventToCourse[];
	com.lowagie.text.Image iitrLogo;
	
	public static void main(String args[]){
	try{
		resumewebd r = new resumewebd();
		r.publishDocument();
		}
		catch(Exception e){
		System.out.println(e);
		}
	}
	
	public void publishDocument() throws Exception {
		
		String days[] = {"", "Monday", "Tueday","Wednesday","Thursday","Friday" };
		String[] months = {"Jan","Feb","March","April","May","June","July","Aug","Sep","Oct","Nov","Dec"};
		String slots[] = {"", "9-10 AM","10-11 AM","11-12 Noon","12-1 PM", "1-2 PM", 
				"2-3 PM","3-4 PM","4-5 PM","5-6 PM","","","",""};
		int noOfCols=10;
		int noOfRows=6;
		int breakTime = 25;
			Document document = new Document();
			try {
				PdfWriter.getInstance(document, new FileOutputStream("C:/Users/Aniket/Desktop/Resume.pdf"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("here");
			
			document.open();
			try{
				iitrLogo = com.lowagie.text.Image.getInstance("IITR Logo.jpg");
				iitrLogo.setAbsolutePosition(75, 760);
				iitrLogo.scaleAbsolute(50,50);
				document.add(iitrLogo);
			}
			catch(Exception ee){
				ee.printStackTrace();
			}
			Font f;
			Paragraph p;
			GregorianCalendar g = new GregorianCalendar();
			f = new Font(Font.UNDEFINED,10,Font.ITALIC);
			p = new Paragraph("Dated: "+months[g.get(Calendar.MONTH)]+"."+g.get(Calendar.DAY_OF_MONTH)+", "+g.get(Calendar.YEAR),f);
			p.setAlignment(Element.ALIGN_RIGHT);
			document.add(p);
			
			f = new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE,Font.BOLD);
			p= new Paragraph("Indian Institute of Technology, Roorkee",f);
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			p = new Paragraph("Department of Computer Science",f);
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			f = new Font(Font.TIMES_ROMAN,Font.DEFAULTSIZE,Font.NORMAL);
			p = new Paragraph("Spring Semester 2010-2011",f);
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			f = new Font(Font.UNDEFINED,10,Font.NORMAL);
			p = new Paragraph("                    Batch: B2",f);
			p.setAlignment(Element.ALIGN_LEFT);
			document.add(p);
			
			float[] colWidths = {1.25f,2f,2f,2f,2f,2f};
			PdfPTable table = new PdfPTable(colWidths);
			PdfPCell cell = new PdfPCell();
			
			table.setWidthPercentage(80);
			table.setSpacingBefore(25f);
			table.setSpacingAfter(10f);
			table.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setUseBorderPadding(true);
			
			f = new Font(Font.UNDEFINED,10,Font.BOLD | Font.UNDERLINE);
			p = new Paragraph("Course: Java Development for Enterprise",f);
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			
			f = new Font(Font.UNDEFINED,9,Font.BOLD);
			p=new Paragraph("Time\\Day",f);
			cell = new PdfPCell(p);
			cell.setFixedHeight(20f);
			cell = getSpecialCell(cell);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);
			
			f = new Font(Font.UNDEFINED,9,Font.BOLD);
			for(int k = 1 ; k <= 5; k++) {
				Paragraph dayText = new Paragraph(days[k],f);
				cell = new PdfPCell(dayText);
				cell.setFixedHeight(20f);
				cell = getSpecialCell(cell);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);
			}
			
			table.getDefaultCell().setHorizontalAlignment(Element.ALIGN_CENTER);
			table.getDefaultCell().setVerticalAlignment(Element.ALIGN_BOTTOM);
			table.getDefaultCell().setFixedHeight(40f);
			table.getDefaultCell().setPadding(2);
			table.getDefaultCell().setPaddingBottom(2);
			table.getDefaultCell().setUseAscender(true);
			table.getDefaultCell().setUseDescender(true);
			
			for(int x=0;x<noOfCols*(noOfRows-1);x++){
				if(x%6==0){
					f = new Font(Font.TIMES_ROMAN,8,Font.NORMAL);
					p=new Paragraph(slots[(x/6)+1],f);
					table.addCell(getSpecialCell(new PdfPCell(p)));
				}
				else if(x==breakTime){
					f = new Font(Font.TIMES_ROMAN,12,Font.BOLD);
					p = new Paragraph("Break",f);
					cell = new PdfPCell(p);
					cell.setColspan(5);
					cell = getSpecialCell(cell);
					//cell.setBorderWidth(1f);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					x+=4;
				}
				else{
					f = new Font(Font.UNDEFINED,10,Font.NORMAL);
					p = new Paragraph("L6 EC-201\nBMW",f);
					table.addCell(getNormalCell(new PdfPCell(p)));
				}
			}
			
			document.add(table);
			document.close();
		}
	private PdfPCell getSpecialCell(PdfPCell cell){
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		cell.setPadding(2);
		cell.setGrayFill(0.8f);
		cell.setBorderWidth(1.1f);
		cell.setUseAscender(true);
		cell.setUseDescender(true);
		cell.setUseBorderPadding(true);
		return cell;
	}
	private PdfPCell getNormalCell(PdfPCell cell){
		cell.setHorizontalAlignment(Element.ALIGN_RIGHT);
		cell.setVerticalAlignment(Element.ALIGN_BOTTOM);
		cell.setPadding(2);
		cell.setBorderWidth(1f);
		cell.setFixedHeight(40f);
		cell.setUseAscender(true);
		cell.setUseDescender(true);
		cell.setUseBorderPadding(true);
		return cell;
	}
}

