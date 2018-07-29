package cul_organization_ontology;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec; 
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.reasoner.Reasoner;
import org.openjena.atlas.io.IndentedWriter;
import com.hp.hpl.jena.util.FileManager;
import java.util.Scanner;
import java.io.*;

public class Cul_organization_ontology {
    public static void main(String[] args) {
        String base ="http://www.owl-ontologies.com/5399_ask4.owl#";
        Scanner inputReader = new Scanner(System.in);
        OntModel model = ModelFactory.createOntologyModel( OntModelSpec.OWL_DL_MEM_RULE_INF);
        InputStream in = FileManager.get().open("5399_project.owl");
        model.read(in, "");
        int exit=0;
        //input variables
        String input = null;
        String chA = new String("A");
        String chB = new String("B");
        String chC = new String("C");
        String chD = new String("D");
        String chE = new String("E");
        
        while(exit!=1){
            System.out.println("");
            System.out.println("CHOICE MENU");
            System.out.println("A.Enter the name of the Class to see the individuals of it.");
            System.out.println("B.Data insertion.");
            System.out.println("C.Data search based on certain parameters.");
            System.out.println("D.Individual's triples display.");
            System.out.println("E.Exit.");
            System.out.println("Input:");
            //read from input
            input = inputReader.nextLine();
            String choice = null;
            if(input.equals(chA)) {
                System.out.println("\n  Choose one of the following classes of the ontology:\n");
                System.out.println("1.Αrea");
                System.out.println("2.Cultural_organizations");
                System.out.println("3.Exibition_objects");
                System.out.println("Input:");
                //read from input
                choice = inputReader.nextLine();
                if(choice.equals("1"))
                {
                    System.out.println("\n Choose one of the following subclasses of the class Area");
                    System.out.println("City");
                    System.out.println("Country");
                    System.out.println("Region");
                    System.out.println("Or choose 'Area' for the individuals of the class Area");
                    System.out.println("Input:");
                    String input1;
                    input1 = inputReader.nextLine();
                    input1 = input1.replaceAll("(\\r|\\n)", "");

                    String queryString;
                    queryString="PREFIX base:<http://www.owl-ontologies.com/5399_ask4.owl#> "
                            + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> SELECT "
                            + "?ind ?name  ?x WHERE{?_ind  rdf:type base:"+input1
                            +". ?_ind base:area_name ?_name. "
                            + "bind( strafter(str(?_ind),str(base:)) as ?ind  ). "
                            + "bind( str(?_name) as ?name )}";

                    Query query1 = QueryFactory.create(queryString) ;
                    QueryExecution new_qexec = QueryExecutionFactory.create(query1, model) ;
                    ResultSet rs1 = new_qexec.execSelect() ;

                    System.out.println("\n| Area | Name |");           

                    for ( ; rs1.hasNext() ; )       
                    {
                        QuerySolution rb1 = rs1.nextSolution() ;
                        RDFNode x = rb1.get("ind") ;
                        RDFNode y = rb1.get("name") ;
                        if ( x.isLiteral() )
                        {
                            Literal Str1 = (Literal)x ;
                            System.out.print(Str1) ;               
                        }
                        else
                            System.out.print(x.toString() +" ") ;

                        if ( y.isLiteral() )
                        {
                            Literal Str2 = (Literal)y ;
                            System.out.println("\t "+Str2) ;               
                        }
                        else
                            System.out.println(y.toString() +" \t ") ;
                        }
                    }
                    else if(choice.equals("2"))
                    {
                        System.out.println("\nChoose one of the following subclasses of the class Cultural_organizations");
                        System.out.println("Exhibitions");
                        System.out.println("Picture_gallery");
                        System.out.println("National_Picture_gallery");
                        System.out.println("National_Picture_gallery_of_Athens");
                        System.out.println("Antic_exhibition");
                        System.out.println("Art_exhibition");
                        System.out.println("Big_exhibition");
                        System.out.println("National_exhibition");
                        System.out.println("Athens_National_exhibition");
                        System.out.println("Mixed_exhibition");
                        System.out.println("Planetarium_exhibition");
                        System.out.println("Small_museum\n");
                        System.out.println("Or choose 'Cultural_organizations' for the individuals of the class Cultural_organizations");
                        System.out.println("Input:");
                        String input2;
                        input2 = inputReader.next();

                        input2 = input2.replaceAll("(\\r|\\n)", "");

                        String queryString;
                        queryString="PREFIX base:<http://www.owl-ontologies.com/5399_ask4.owl#>"
                                + " PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                                + "SELECT ?ind ?name ?loc ?exh ?vis WHERE{?_ind  rdf:type base:"+input2
                                +". ?_ind base:org_name ?_name.?_ind base:is_located_in ?_loc. ?_ind base:no_exhibits ?_exh. ?_ind base:no_visitors ?_vis. bind( strafter(str(?_ind),str(base:)) as ?ind  ). bind( str(?_name) as ?name ). bind( str(?_vis) as ?vis ). bind( str(?_exh) as ?exh ).  bind( strafter(str(?_loc),str(base:)) as ?loc )}";

                        Query query1 = QueryFactory.create(queryString) ;
                        QueryExecution new_qexec = QueryExecutionFactory.create(query1, model) ;
                        ResultSet rs1 = new_qexec.execSelect() ;
                        System.out.println("| Cultural_organizations |   Name   |  Location  |  Exhibits  |  Visitors |");            
                        for ( ; rs1.hasNext() ; )       
                        {
                            QuerySolution rb1 = rs1.nextSolution() ;
                            RDFNode x = rb1.get("ind") ;
                            RDFNode y = rb1.get("name") ;
                            RDFNode z = rb1.get("loc") ;
                            RDFNode x1 = rb1.get("exh") ;
                            RDFNode y1 = rb1.get("vis") ;
                            if ( x.isLiteral() )
                            {
                                Literal Str1 = (Literal)x ;
                                System.out.print(Str1) ;               
                            }
                            else
                                System.out.print(x.toString() +" ") ;

                            if ( y.isLiteral() )
                            {
                                Literal Str2 = (Literal)y ;
                                System.out.print("\t "+Str2) ;               
                            }
                            else
                                System.out.print(y.toString() +" \t ") ;

                             if ( z.isLiteral() )
                            {
                                Literal Str3 = (Literal)z ;
                                System.out.print("\t "+Str3) ;               
                            }
                            else
                                System.out.print(z.toString() +" \t ") ;

                            if ( x1.isLiteral() )
                            {
                                Literal Str1 = (Literal)x1 ;
                                System.out.print("\t "+Str1) ;               
                            }
                            else
                                System.out.print(x1.toString() +" \t ") ;

                            if ( y1.isLiteral() )
                            {
                                Literal Str2 = (Literal)y1 ;
                                System.out.println("\t "+Str2) ;               
                            }
                            else
                                System.out.println(y1.toString() +" \t ") ;
                        }
                    }
                    else if(choice.equals("3"))
                    {
                        System.out.println("\nChoose one of the following subclasses of the class Exibition_objects");
                        System.out.println("Exhibit");
                        System.out.println("Antic_cars");
                        System.out.println("planet_documetary");
                        System.out.println("Various_exhibit");
                        System.out.println("Art_exhibit");
                        System.out.println("Paintings");
                        System.out.println("Or choose 'Exibition_objects' for the individuals of the class Exibition_objects");
                        System.out.println("Input:");
                        String input3;
                        input3 = inputReader.nextLine();

                        input3 = input3.replaceAll("(\\r|\\n)", "");

                        String queryString;
                        queryString="PREFIX base:<http://www.owl-ontologies.com/5399_ask4.owl#> "
                                + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                                + "SELECT ?ind ?name ?bel WHERE{?_ind  rdf:type base:"+input3
                                +". ?_ind base:exh_title ?_name.?_ind base:belongs_to ?_bel.  bind( strafter(str(?_ind),str(base:)) as ?ind  ). bind( str(?_name) as ?name ). bind( strafter(str(?_bel),str(base:)) as ?bel  )}";

                        Query query1 = QueryFactory.create(queryString) ;
                        QueryExecution new_qexec = QueryExecutionFactory.create(query1, model) ;
                        ResultSet rs1 = new_qexec.execSelect() ;

                        System.out.println("\n| Individual | Title | Belongs to | ");     

                        for ( ; rs1.hasNext() ; )       
                        {
                            QuerySolution rb1 = rs1.nextSolution() ;
                            RDFNode x = rb1.get("ind") ;
                            RDFNode y = rb1.get("name") ;
                            RDFNode z = rb1.get("bel") ;
                            if ( x.isLiteral() )
                            {
                                Literal Str1 = (Literal)x ;
                                System.out.print(Str1) ;               
                            }
                            else
                                System.out.print(x.toString() +" ") ;

                            if ( y.isLiteral() )
                            {
                                Literal Str2 = (Literal)y ;
                                System.out.print("\t\t "+Str2) ;               
                            }
                            else
                                System.out.print(y.toString() +" \t ") ;

                             if ( z.isLiteral() )
                            {
                                Literal Str3 = (Literal)z ;
                                System.out.println("\t\t "+Str3) ;               
                            }
                            else
                                System.out.println(z.toString() +" \t ") ;
                        }
                    }
            }//if-A
            if(input.equals(chB)) {
                System.out.println("Choose what class-type individual you want to insert into the ontology:");
		System.out.println("1. New Area Individual");
                System.out.println("2. New Cultural_organizations Individual");
                System.out.println("3. New Exibition_objects Individual");
                System.out.println("Input:");
		choice = inputReader.nextLine();
                    
                if(choice.equals("1"))
		{
                    System.out.print("Give the resource name of the individual:  ");
                    String name = inputReader.nextLine();

                    System.out.println("Choose in which class it belongs to:");
                    System.out.println("1-City");
                    System.out.println("2-Country");
                    System.out.println("3-Region");
                    System.out.println("4-Area");
                    System.out.println("Input:");
                    String choice1 = inputReader.nextLine();
                    Resource org = model.createResource(base+name);  
                    if(choice1.equals("1"))
                        org.addProperty(RDF.type, base+"City");
                    else  if(choice1.equals("2"))
                        org.addProperty(RDF.type, base+"Country");
                    else  if(choice1.equals("3"))
                        org.addProperty(RDF.type, base+"Region");
                    else  if(choice1.equals("4"))
                        org.addProperty(RDF.type, base+"Area");
                    else
                    {
                         System.out.println("Wrong input.");
                         return;
                    }
                    System.out.print("Give the name of the individual:");
                    System.out.println("Input:");
                    name = inputReader.nextLine();
                    Property hasNameProperty = model.createProperty(base, "area_name");
                    org.addProperty(hasNameProperty, name);
                    System.out.print("If this individual belongs to some other Area type '1':");
                    choice1 = inputReader.nextLine();
                    if(choice1.equals("1"))
                    {
                        System.out.print("Give the resource name of the Area it belongs to:");
                        name = inputReader.nextLine();
                        hasNameProperty = model.createProperty(base, "is_region_of");
                        org.addProperty(hasNameProperty, base+name);
                    }

                    System.out.print("If this individual is road connected to some other Area type '1', otherwise type '0':");
                    choice1 = inputReader.nextLine();
                    while(choice1.equals("1"))
                    {
                        System.out.print("Give the name of the Area to which is road connected to:");
                        name = inputReader.nextLine();
                        hasNameProperty = model.createProperty(base, "road_connected");
                        org.addProperty(hasNameProperty, base+name);
                        System.out.print("If this individual is road connected to some other Area type '1', otherwise type '0':");
                        choice1 = inputReader.nextLine();
                    }
                    System.out.println("The new individual is succesfully added.");
		}               
		else if(choice.equals("2"))
                {
                    System.out.print("Give the resource name of the individual:");
                    String name = inputReader.nextLine();
                    System.out.println("Choose in which class it belongs to:");
                    System.out.println("1-Cultural Organization");
                    System.out.println("2-Exhibition");
                    System.out.println("3-Antic exhibition");
                    System.out.println("4-Art exhibition");
                    System.out.println("5-Big exhibition");
                    System.out.println("6-Mixed exhibition");
                    System.out.println("7-National exhibition");
                    System.out.println("8-Athens National exhibition");
                    System.out.println("9-Planetarium exhibition");
                    System.out.println("10-Small exhibition");
                    System.out.println("11-Various exhibition");
                    System.out.println("12-Picture gallery");
                    System.out.println("13-National Picture gallery");
                    System.out.println("14-National Picture gallery of Athens");
                    System.out.println("Input:");
                    String choice1 = inputReader.nextLine();

                    Resource org = model.createResource(base+name);  
                    if(choice1.equals("1"))
                        org.addProperty(RDF.type, base+"Cultural_organizations");
                    else  if(choice1.equals("2"))
                        org.addProperty(RDF.type, base+"Exhibitions");
                     else  if(choice1.equals("3"))
                        org.addProperty(RDF.type, base+"Antic_exhibition");
                     else  if(choice1.equals("4"))
                        org.addProperty(RDF.type, base+"Art_exhibition");
                     else  if(choice1.equals("5"))
                        org.addProperty(RDF.type, base+"Big_exhibition");
                     else  if(choice1.equals("6"))
                        org.addProperty(RDF.type, base+"Mixed_exhibition");
                     else  if(choice1.equals("7"))
                        org.addProperty(RDF.type, base+"National_exhibition");
                     else  if(choice1.equals("8"))
                        org.addProperty(RDF.type, base+"Athens_National_exhibition");
                     else  if(choice1.equals("9"))
                        org.addProperty(RDF.type, base+"Planetarium_exhibition");
                    else  if(choice1.equals("10"))
                        org.addProperty(RDF.type, base+"Small_exhibition");
                     else  if(choice1.equals("11"))
                        org.addProperty(RDF.type, base+"Various_exhibition");
                     else  if(choice1.equals("12"))
                        org.addProperty(RDF.type, base+"Picture_gallery");
                     else  if(choice1.equals("13"))
                        org.addProperty(RDF.type, base+"National_Picture_gallery");
                     else  if(choice1.equals("14"))
                        org.addProperty(RDF.type, base+"National_Picture_gallery_of_Athens");
                     else
                    {
                         System.out.println("Wrong input.");
                         return;
                    }
                    System.out.print("Give the name of the individual:");
                    name = inputReader.nextLine();
                    Property hasNameProperty = model.createProperty(base, "org_name");
                    org.addProperty(hasNameProperty, name);

                    System.out.print("Give the address of the individual:");
                    name = inputReader.nextLine();
                    hasNameProperty = model.createProperty(base, "address");
                    org.addProperty(hasNameProperty, name);

                    System.out.print("Give the location of the individual (the resource name of the located area):");
                    name = inputReader.nextLine();
                    hasNameProperty = model.createProperty(base, "is_located_in");
                    org.addProperty(hasNameProperty, base+name);

                    System.out.print("Give the e-mail of the individual:");
                    name = inputReader.nextLine();
                    hasNameProperty = model.createProperty(base, "email");
                    org.addProperty(hasNameProperty, name);

                     System.out.print("Give the telephone of the individual:");
                    name = inputReader.nextLine();
                    hasNameProperty = model.createProperty(base, "telephone");
                    org.addProperty(hasNameProperty, name);

                    System.out.print("Give the number of the exhibits of the individual:");
                    name = inputReader.nextLine();
                    hasNameProperty = model.createProperty(base, "no_exhibits");
                    org.addProperty(hasNameProperty, name);

                    System.out.print("Give the number of the visitors of the individual:");
                    name = inputReader.nextLine();
                    hasNameProperty = model.createProperty(base, "no_visitors");
                    org.addProperty(hasNameProperty, name);

                    System.out.print("If this organization is a national organization type '1', otherwise type '0':");
                    choice1 = inputReader.nextLine();
                    if(choice1.equals("1"))
                    {
                         hasNameProperty = model.createProperty(base, "is_national");
                         org.addProperty(hasNameProperty, "true");
                    }
                    
                    System.out.print("If this organization collaborates with another organization type '1', otherwise type '0':");
                    choice1 = inputReader.nextLine();
                    if(choice1.equals("1"))
                    {
                        System.out.print("Give the resource name of the organization which is collaborated with:");
                        name = inputReader.nextLine();
                        hasNameProperty = model.createProperty(base, "collaborate_with");
                        org.addProperty(hasNameProperty, base+name);
                    }

                    System.out.print("If this organization belongs to another organization type '1', otherwise type '0':");
                    choice1 = inputReader.nextLine();
                    if(choice1.equals("1"))
                    {
                        System.out.print("Give the resource name of the organization in which belongs to:");
                        name = inputReader.nextLine();
                        hasNameProperty = model.createProperty(base, "sub_org_of");
                        org.addProperty(hasNameProperty, base+name);
                    }
                    System.out.println("The new individual is succesfully added.");
                }
                else if(choice.equals("3"))
		{
                    System.out.print("Give the resource name of the individual:");
                    String name = inputReader.nextLine();
                    System.out.println("Choose in which class it belongs to:");
                    System.out.println("1-Exhibition_objects");
                    System.out.println("2-Exhibit");
                    System.out.println("3-Paintings");
                    System.out.print("Input:");
                    String choice1 = inputReader.nextLine();
                    Resource org = model.createResource(base+name);  
                    if(choice1.equals("1"))
                        org.addProperty(RDF.type, base+"Exhibition_objects");
                    else  if(choice1.equals("2"))
                        org.addProperty(RDF.type, base+"Exhibit");
                    else  if(choice1.equals("3"))
                        org.addProperty(RDF.type, base+"Paintings");
                    else
                    {
                         System.out.println("Wrong input.");
                         return;
                    }
                    System.out.print("Give the resource name of the organization it belongs to:");
                    name = inputReader.nextLine();
                    Property hasNameProperty = model.createProperty(base, "belongs_to");
                    org.addProperty(hasNameProperty, name);

                    System.out.print("If this individual is associated with another exhibit object type '1', otherwise '0':");
                    choice = inputReader.nextLine();
                    if(choice1.equals("1"))
                    {
                        System.out.print("Give the resource name of the individual which is associated with:");
                        name = inputReader.nextLine();
                        hasNameProperty = model.createProperty(base, "is_associated_with");
                        org.addProperty(hasNameProperty, base+name);
                    }
                    System.out.println("The new individual is succesfully added.");
                    
                }
                else
                    System.out.println("Wrong input");
                //try-catch exception
                try{
                //saving the file
                OutputStream output = new FileOutputStream("5399_project.owl");
                model.write(output);
                }
                catch(IOException e){
                System.err.println("Error: " + e);
                }
            }
            if(input.equals(chC)) {
                System.out.println("\nThe search parameters that are available in this application are the followings:\n");
                System.out.println("1. Search for road connection from an area to another");
                System.out.println("2. Search for associated exhibition objects");
                System.out.println("3. Search for Cultural organizations depending on the number of the visitors");
                System.out.println("4. Search for Cultural organizations depending on the number of the exhibits");
                System.out.print("\nInput: ");
    
		String choice1 = inputReader.nextLine();
                    
                System.out.print("\n");
                    
                if(choice1.equals("1"))
                {
                    System.out.print("Give the name of the area: ");
                    String input1= inputReader.nextLine();	
                    String query = "PREFIX base:<http://www.owl-ontologies.com/5399_ask4.owl#> "
                            + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                            + "SELECT ?name2 ?name1\n" +
                              "WHERE { ?ind rdf:type base:City.\n" +
                            "?ind base:area_name ?name1.\n" +
                            "?ind base:road_connected base:"+input1+".   "
                            +" base:"+input1+" base:area_name ?name2.\n" +
                            "}";
                     
                    Query query1 = QueryFactory.create(query) ;
                    QueryExecution new_qexec = QueryExecutionFactory.create(query1, model) ;
                    ResultSet rs1 = new_qexec.execSelect() ;

                    System.out.println("\n|  Area1  | Area2 |\n");
                    for ( ; rs1.hasNext() ; )       
                    {
                        QuerySolution rb1 = rs1.nextSolution() ;
                        RDFNode y = rb1.get("name2") ;
                        RDFNode x = rb1.get("name1") ;
                        if ( x.isLiteral() )
                        {
                            Literal Str1 = (Literal)x ;
                            System.out.print(Str1+" \t ") ;               
                        }
                        else
                            System.out.print(x.toString() +" \t ") ;

                        if ( y.isLiteral() )
                        {
                            Literal Str1 = (Literal)y ;
                            System.out.println(Str1+" \t ") ;               
                        }
                        else
                            System.out.println(y.toString() +" \t ") ;
                    }
                }
		else if(choice1.equals("2"))
		{
                    System.out.print("Give the resource name of the individual: ");
                    String input1= inputReader.nextLine();	
                    String query="PREFIX base:<http://www.owl-ontologies.com/5399_ask4.owl#> "
                            + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                            + "SELECT ?name1 ?name2 WHERE{?ind rdf:type base:Paintings. ?ind base:exh_title ?name1. ?ind base:is_associated_with base:"+input1+". base:"+input1+" base:exh_title ?name2. }";

                    Query query1 = QueryFactory.create(query) ;
                    QueryExecution new_qexec = QueryExecutionFactory.create(query1, model) ;
                    ResultSet rs1 = new_qexec.execSelect() ;
                    System.out.println("\n | Exhibition Object1 | Exhibition Object2 |\n");
                    for ( ; rs1.hasNext() ; )       
                    {
                        QuerySolution rb1 = rs1.nextSolution() ;
                        RDFNode x = rb1.get("name1") ;
                        RDFNode y = rb1.get("name2") ;

                        if ( x.isLiteral() )
                        {
                            Literal Str1 = (Literal)x ;
                            System.out.println(Str1+" \t ") ;               
                        }
                        else
                            System.out.println(x.toString() +" \t ") ;
                        if ( y.isLiteral() )
                        {
                            Literal Str1 = (Literal)y ;
                            System.out.println(Str1+" \t ") ;               
                        }
                        else
                            System.out.println(y.toString() +" \t ") ;
                    }
                }
		else if(choice1.equals("3"))
		{
                    System.out.print("Give the number of the visitors: ");
                    String input2= inputReader.nextLine();	

                    System.out.print("Greater than(>) or Less than(<): ");
                    String input1= inputReader.nextLine();	
                    String query="PREFIX base:<http://www.owl-ontologies.com/5399_ask4.owl#> "
                            + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                            + "SELECT ?name ?visitors WHERE{?x base:no_visitors ?y. FILTER(?y"+input1+input2+") bind( strafter(str(?x),str(base:)) as ?name)  bind( str(?y) as ?visitors )}";

                    Query query1 = QueryFactory.create(query) ;
                    QueryExecution new_qexec = QueryExecutionFactory.create(query1, model) ;
                    ResultSet rs1 = new_qexec.execSelect() ;
                    System.out.println("\n Cultural organization  |  Number of visitors \n");
                    for ( ; rs1.hasNext() ; )       
                    {
                          QuerySolution rb1 = rs1.nextSolution() ;
                          RDFNode x = rb1.get("name") ;
                          RDFNode y = rb1.get("visitors") ;

                          if ( x.isLiteral() )
                          {
                              Literal Str1 = (Literal)x ;
                              System.out.print(Str1+" \t ") ;               
                          }
                          else
                              System.out.print(x.toString() +" \t ") ;

                          if ( y.isLiteral() )
                          {
                              Literal Str1 = (Literal)y ;
                              System.out.println(Str1+" \t ") ;               
                          }
                          else
                              System.out.println(y.toString() +" \t ") ;
                    }
                }
                else if(choice1.equals("4"))
		{
                    System.out.print("Give the number of the exhibits: ");
                    String input2= inputReader.nextLine();	
                    System.out.print("Greater than(>) or Less than(<): ");
                    String input1= inputReader.nextLine();	
                    String query="PREFIX base:<http://www.owl-ontologies.com/5399_ask4.owl#> "
                            + "PREFIX rdf:<http://www.w3.org/1999/02/22-rdf-syntax-ns#> "
                            + "SELECT ?name ?exhibits WHERE{?x base:no_exhibits ?y. "
                            + "FILTER(?y"+input1+input2+") bind( strafter(str(?x),str(base:)) as ?name)  bind( str(?y) as ?exhibits )}";

                    Query query1 = QueryFactory.create(query) ;
                    QueryExecution new_qexec = QueryExecutionFactory.create(query1, model) ;
                    ResultSet rs1 = new_qexec.execSelect() ;
                    System.out.println("\n Cultural organization  |  Number of exhibits \n");
                    for ( ; rs1.hasNext() ; )       
                    {
                        QuerySolution rb1 = rs1.nextSolution() ;
                        RDFNode x = rb1.get("name") ;
                        RDFNode y = rb1.get("exhibits") ;

                        if ( x.isLiteral() )
                        {
                            Literal Str1 = (Literal)x ;
                            System.out.print(Str1+" \t ") ;               
                        }
                        else
                            System.out.print(x.toString() +" \t ") ;

                        if ( y.isLiteral() )
                        {
                            Literal Str1 = (Literal)y ;
                            System.out.println(Str1+" \t ") ;               
                        }
                        else
                            System.out.println(y.toString() +" \t ") ;
                    }
                }
		    else
                        System.out.println("Wrong input.");
            }
            if(input.equals(chD)) {
                System.out.print("Type the resource name of an individual:");
                String URI = inputReader.nextLine();
                Resource r = model.getResource(base+URI);
                StmtIterator iter = r.listProperties();
                System.out.print("Showing tripletes...");
                System.out.println("\n| Property | Value |");
                while (iter.hasNext()) 
                {
                    Statement stmt      = iter.nextStatement();         
                    Resource  subject   = stmt.getSubject();   
                    Property  predicate = stmt.getPredicate(); 
                    RDFNode   object    = stmt.getObject();    
                    if(object.toString().indexOf(base) != -1 && predicate.toString().indexOf(base) != -1)
                    {
                        System.out.print("\t " + predicate.toString().substring(predicate.toString().lastIndexOf("#") + 1) + "\t ");
                        if (object instanceof Resource) 
                        {
                            System.out.print(object.toString().substring(object.toString().lastIndexOf("#") + 1));
                        }
                        else
                        {
                            System.out.print(" \"" + object.toString().substring(object.toString().lastIndexOf("#") + 1) + "\"");
                        }
                        System.out.println("");
                    }
                }
            }
            if(input.equals(chE)) {
                System.out.println("Exiting application...");
                exit = 1;
            }
        }//while
    }//main
}//class