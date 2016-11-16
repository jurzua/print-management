package cl.printmanagement;

import java.awt.print.PrinterJob;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.Copies;
import javax.print.attribute.standard.MediaSize;
import javax.print.attribute.standard.Sides;
import javax.print.event.PrintServiceAttributeListener;

public class Test1 {

	public static void main (String [] args)
    {
        PrintService[] printServices = PrintServiceLookup.lookupPrintServices(null, null);
        System.out.println("Number of print services: " + printServices.length);

        for (PrintService printer : printServices){
            System.out.println("Printer: " + printer.getName());
            //DocPrintJob docPrintJob =  printer.createPrintJob();
            //docPrintJob.addPrintJobAttributeListener(listener, attributes);
            
            PrintServiceAttributeListener listener = new PrintListener(); 
            
            printer.addPrintServiceAttributeListener(listener);
        }
        
        
    }

}
