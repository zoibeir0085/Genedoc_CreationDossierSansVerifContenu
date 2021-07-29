package Pages;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PDFPage {
    WebDriver driver;
    public PDFPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    //String downloadPath="/home/ala/Téléchargements";
    String downloadPath="C:\\Users\\abensalah\\Downloads";

    public void afficherPDF(){
        try
        {
            //Créer une instance PdfReader.
            DownloadsPage page= new DownloadsPage(driver);
            System.out.println(downloadPath+"/"+page.pdfFileName());
            //PdfReader pdf = new PdfReader(downloadPath+"/"+page.pdfFileName());
            PdfReader pdf = new PdfReader(downloadPath+"\\"+page.pdfFileName());

            //Récupérer le nombre de pages en pdf.
            int nbrPages = pdf.getNumberOfPages();

            //Itérer le pdf à travers les pages.
            for(int i=1; i <= nbrPages; i++)
            {
                //Extraire le contenu de la page à l'aide de PdfTextExtractor.
                String content = PdfTextExtractor.getTextFromPage(pdf, i);

                //Afficher le contenu de la page sur la console.
                System.out.println("Contenu du page : " + content);
            }

            //Fermez le PdfReader.
            pdf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public boolean verifyPDFContenu(String contenu){
        //String fullContent="";
        boolean b= false ;
        try
        {
            //Créer une instance PdfReader.
            DownloadsPage page= new DownloadsPage(driver);
            PdfReader pdf = new PdfReader(downloadPath+"\\"+page.pdfFileName());
            //PdfReader pdf = new PdfReader(downloadPath+"/"+page.pdfFileName());

            //Récupérer le nombre de pages en pdf.
            int nbrPages = pdf.getNumberOfPages();

            int i=1;
            //Itérer le pdf à travers les pages.
            while(i <= nbrPages && b==false)
            {
                //Extraire le contenu de la page à l'aide de PdfTextExtractor.
                String content = PdfTextExtractor.getTextFromPage(pdf, i);
                b= content.contains(contenu);
                //fullContent+=content+"\n";
                i++;
            }

            pdf.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //System.out.println("FULL CONTENT =" + fullContent);

        System.out.println("Contenu =" +contenu);
        System.out.println("résultat="+(b));
        return (b);
    }


}