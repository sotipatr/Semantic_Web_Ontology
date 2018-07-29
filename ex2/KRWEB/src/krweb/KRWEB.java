package krweb;
import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ResultSet;
import org.openjena.atlas.io.IndentedWriter;
import com.hp.hpl.jena.util.FileManager;
import java.util.Scanner;
import java.io.*;


/**
 *
 * @author SOTIRIA
 */
public class KRWEB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();
        System.out.println("I am the force that bids forever evil, yet does forever good"
                + "");
        InputStream in = FileManager.get().open("er3.rdf");
        model.read(in, "");
        model.write(System.out);
        
        int exit=0;
        //input variables
        String input = null;
        Scanner inputReader = new Scanner(System.in);
        String chA = new String("A");
        String chB = new String("B");
        String chC = new String("C");
        String chD = new String("D");
        String chE = new String("E");
        String uni_uri="http://www.mydomain.org/uni-ns/";
        while(exit!=1){
            System.out.println("");
            System.out.println("CHOICE MENU");
            System.out.println("A.Enter the name of the Department to see the members of it.");
            System.out.println("B.Data search based on certain parameters.");
            System.out.println("C.Data insertion.");
            System.out.println("D.Triples display.");
            System.out.println("E.Exit.");
           

            //read from input
            input = inputReader.nextLine();
            
            if(input.equals(chA)){
            
                
                String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                                    "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                                    "PREFIX uni: <http://www.mydomain.org/uni-ns/>\n" +
                                    "\n" +
                                    "SELECT ?name\n" +
                                    "WHERE {	?dep rdf:type uni:Department.\n" +
                                    "		?dep uni:dep_name ?name.\n" +
                                    "		}";
                
                Query query = QueryFactory.create(queryString) ;
                query.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
                ResultSet rs =  qexec.execSelect() ;
                System.out.println("The departments are:");
                for ( ; rs.hasNext() ; ) {
                        QuerySolution rb= rs.nextSolution() ;
                        RDFNode dep = rb.get("name") ;
                        System.out.println(dep.toString() );
                    }//for
                //read from input
                String in_dep = null;
                in_dep = inputReader.nextLine();
                String queryString2 = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                                        "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                                        "PREFIX uni: <http://www.mydomain.org/uni-ns/>\n" +
                                        "\n" +
                                        "SELECT ?name ?age ?phone\n" +
                                        "WHERE {	\n" +
                                        "		?x	uni:member_of ?dep. \n" +
                                        "		?dep uni:dep_name '" + in_dep + "'.\n" +
                                        "		?x	uni:has_name ?name.\n" +
                                        "		?x  uni:has_age  ?age.\n" +
                                        "		?x	uni:has_phone ?phone.\n" +
                                        "			  }";
                                        
                Query query2 = QueryFactory.create(queryString2) ;
                query2.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec2 = QueryExecutionFactory.create(query2, model) ;
                ResultSet rs2 =  qexec2.execSelect() ;
                System.out.println("The personal information of the members of this department are:");
                System.out.println("Name                    Age     Phone");
                for ( ; rs2.hasNext() ; ) {
                        QuerySolution rb2= rs2.nextSolution() ;
                        RDFNode name = rb2.get("name") ;
                        RDFNode age = rb2.get("age") ;
                        RDFNode phone = rb2.get("phone") ;
                        System.out.print(name.toString()+ "     " );
                        System.out.print(age.toString()+ "      ");
                        System.out.println(phone.toString() );
                    }//for-2
                
        }//if-A
        if(input.equals(chB)){
                System.out.println("Give the three paramters:");
                System.out.println("Minimum age:");
                //read from input
                String max_age = null;
                max_age = inputReader.nextLine();
                System.out.println("Maxmum age:");
                //read from input
                String min_age = null;
                min_age = inputReader.nextLine();
                System.out.println("City of the Department:");
                //read from input
                String city = null;
                city = inputReader.nextLine();
                String queryString = "PREFIX rdf: <http://www.w3.org/1999/02/22-rdf-syntax-ns#>\n" +
                                     "PREFIX rdfs: <http://www.w3.org/2000/01/rdf-schema#>\n" +
                                     "PREFIX uni: <http://www.mydomain.org/uni-ns/>\n" +
                                     "\n" +
                                     "SELECT ?name ?age ?phone\n" +
                                     "WHERE {	\n" +
                                     "		?x	uni:member_of ?dep. \n" +
                                     "		?dep uni:dep_city '"+ city +"'.\n" +
                                     "		?x	uni:has_name ?name.\n" +
                                     "		?x  uni:has_age  ?age.\n" +
                                     "		?x	uni:has_phone ?phone.\n" +
                                     "		FILTER (?age<'" + min_age + "' && ?age>'" + max_age + "')\n" +
                                     "			  }";
                Query query = QueryFactory.create(queryString) ;
                query.serialize(new IndentedWriter(System.out,true)) ;
                QueryExecution qexec = QueryExecutionFactory.create(query, model) ;
                ResultSet rs =  qexec.execSelect() ;
                System.out.println("The personal information of the members ,using the parametres you choosed, are:");
                System.out.println("Name                        Age     Phone");
                for ( ; rs.hasNext() ; ) {
                        QuerySolution rb= rs.nextSolution() ;
                        RDFNode name = rb.get("name") ;
                        RDFNode age = rb.get("age") ;
                        RDFNode phone = rb.get("phone") ;
                        System.out.print(name.toString()+ "      ");
                        System.out.print(age.toString()+ "      ");
                        System.out.println(phone.toString() );
                    }//for
                
        }//if-B
        
        if(input.equals(chC)){
            System.out.println("Give the data infomation for the new record:");
            System.out.println("Enter resource type(Department/Professor/Student/Lessoon):");
            //read from input
            String type = null;
            type = inputReader.nextLine();
            if(type.equals(new String("Department"))){
                    System.out.println("Enter a code name for the Department:");
                    //read from input
                    String about_name = null;
                    about_name = inputReader.nextLine();
                    
                    System.out.println("Enter the name of the Department:");
                    //read from input
                    String dep_name = null;
                    dep_name = inputReader.nextLine();
                    
                    System.out.println("Enter the city of the Department:");
                    //read from input
                    String city = null;
                    city = inputReader.nextLine();
                    
                    Resource resource = model.createResource(uni_uri+ about_name);
                    Property p_dep_name =model.createProperty(uni_uri,"dep_name");
                    Property p_dep_city =model.createProperty(uni_uri,"dep_city");
                    
                    resource.addProperty(RDF.type,model.getResource(uni_uri + "Department"));
                    resource.addProperty(p_dep_name, dep_name);
                    resource.addProperty(p_dep_city, city);
                    
            }//if-department
            
            if(type.equals(new String("Professor"))){
                    System.out.println("Enter a code name for the Professor:");
                    //read from input
                    String about_name = null;
                    about_name = inputReader.nextLine();
                    
                    System.out.println("Enter the name of the Professor:");
                    //read from input
                    String name = null;
                    name = inputReader.nextLine();
                    
                    System.out.println("Enter the phone of the Professor:");
                    //read from input
                    String phone = null;
                    phone = inputReader.nextLine();
                    
                    System.out.println("Enter the age of the Professor:");
                    //read from input
                    String age = null;
                    age = inputReader.nextLine();
                    
                    System.out.println("Enter the Department of the Professor:");
                    //read from input
                    String dep = null;
                    dep = inputReader.nextLine();
                    
                    System.out.println("Enter the Lesson that is taught by the Professor:");
                    //read from input
                    String les = null;
                    les = inputReader.nextLine();
                    
                    Resource resource = model.createResource(uni_uri+ about_name);
                    Property p_name =model.createProperty(uni_uri,"has_name");
                    Property p_phone =model.createProperty(uni_uri,"has_phone");
                    Property p_age =model.createProperty(uni_uri,"has_age");
                    Property p_dep =model.createProperty(uni_uri,"member_of");
                    Property p_les =model.createProperty(uni_uri,"teaches");
                    
                    resource.addProperty(RDF.type,model.getResource(uni_uri + "Professor"));
                    resource.addProperty(p_name, name);
                    resource.addProperty(p_phone, phone);
                    resource.addProperty(p_age, age);
                    resource.addProperty(p_dep, model.getResource(uni_uri + dep));
                    resource.addProperty(p_les, model.getResource(uni_uri +les));
                    
            }//if-professor
            
            if(type.equals(new String("Student"))){
                    System.out.println("Enter a code name for the Student:");
                    //read from input
                    String about_name = null;
                    about_name = inputReader.nextLine();
                    
                    System.out.println("Enter the name of the Student:");
                    //read from input
                    String name = null;
                    name = inputReader.nextLine();
                    
                    System.out.println("Enter the phone of the Student:");
                    //read from input
                    String phone = null;
                    phone = inputReader.nextLine();
                    
                    System.out.println("Enter the age of the Student:");
                    //read from input
                    String age = null;
                    age = inputReader.nextLine();
                    
                    System.out.println("Enter the Department of the Student:");
                    //read from input
                    String dep = null;
                    dep = inputReader.nextLine();
                    
                    Resource resource = model.createResource(uni_uri+ about_name);
                    Property p_name =model.createProperty(uni_uri,"has_name");
                    Property p_phone =model.createProperty(uni_uri,"has_phone");
                    Property p_age =model.createProperty(uni_uri,"has_age");
                    Property p_dep =model.createProperty(uni_uri,"member_of");
                    
                    resource.addProperty(RDF.type,model.getResource(uni_uri + "Student"));
                    resource.addProperty(p_name, name);
                    resource.addProperty(p_phone, phone);
                    resource.addProperty(p_age, age);
                    resource.addProperty(p_dep, model.getResource(uni_uri +dep));
                                       
            }//if-student
            
            if(type.equals(new String("Lesson"))){
                    System.out.println("Enter a code name for the Lesson:");
                    //read from input
                    String about_name = null;
                    about_name = inputReader.nextLine();
                    
                    System.out.println("Enter the name of the Lesson:");
                    //read from input
                    String les_name = null;
                    les_name = inputReader.nextLine();
                    
                    System.out.println("Enter the Professor who teaches the Lesson:");
                    //read from input
                    String prof = null;
                    prof = inputReader.nextLine();
                    
                    Resource resource = model.createResource(uni_uri+ about_name);
                    Property p_les_name = model.createProperty(uni_uri,"les_name");
                    Property p_prof = model.createProperty(uni_uri,"taught_by");
                    
                    resource.addProperty(RDF.type,model.getResource(uni_uri + "Lesson"));
                    resource.addProperty(p_les_name, les_name);
                    resource.addProperty(p_prof,model.getResource(uni_uri + prof));                   
            }//if-lesson
            
            //try-catch exception
            try{
                //saving the file
                OutputStream output = new FileOutputStream("er3.rdf");
                model.write(output);
            }
            catch(IOException e){
                System.err.println("Error: " + e);
            }
        }//if-C
        
        if(input.equals(chD)){
            InfModel inf = ModelFactory.createRDFSModel(model); //dhmiourgia mhxanhs sumperasmou
            System.out.println("Enter a code name for the resource you want:");
            //read from input
            String about_name = null;
            about_name = inputReader.nextLine();
            
            Resource rsc = inf.getResource(uni_uri + about_name); //dhmiourgia to url
            StmtIterator iter = rsc.listProperties();
            System.out.println();
            System.out.println("Triples");
            while(iter.hasNext()){
                    System.out.println(iter.nextStatement().toString());
            }
        }//if-D
        
        if(input.equals(chE)){
            exit = 1;
        }//if-E
        // TODO code application logic here
    }//while
    
}//main
}//class
