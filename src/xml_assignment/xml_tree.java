package xml_assignment;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.lang.model.element.Element;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.io.IOException;

public class xml_tree {
	public static final String xmlFilePath = "C:/Users/Aziz/Desktop/xml_assignment6/xmlile.xml";
	public static void main(String[] args) throws SQLException, ParserConfigurationException, TransformerConfigurationException, SAXException, IOException {
		
		
		Connection connect = null;
		String url = "jdbc:sqlite:C:/Users/Aziz/Desktop/xml_assignment6/src/db.sqlite"; 
		
		connect = DriverManager.getConnection(url);
		
		java.sql.Statement statement = null;
		
		statement = connect.createStatement(); 
		
		ResultSet resultSet = statement.executeQuery("SELECT * from Customer");

		
		
        
      int rootval=0;
        

        	
        	try {
        		
    			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();

    			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();

    			Document document = documentBuilder.newDocument();
    			
    			// root element
    			//org.w3c.dom.Element root = document.createElement("company");
    			//document.appendChild(root);

    			// employee element
    			org.w3c.dom.Element Customers = document.createElement("Customers");
    			document.appendChild(Customers);
    						
    			while(resultSet.next())
    	        {
    	        
    			
  // reading from sqlite   			
 //  		   System.out.println("Customer Id = " + resultSet.getString("CustomerId"));
 //   		   System.out.println("First Name  = " + resultSet.getString("FirstName"));
//    		   System.out.println("Last Name = " + resultSet.getString("LastName"));
//    		   System.out.println("Company = " + resultSet.getString("Company"));
//    		   System.out.println("Address = " + resultSet.getString("Address"));
// 	           System.out.println("City = " + resultSet.getString("City"));
// 	           System.out.println("State = " + resultSet.getString("State"));
// 	           System.out.println("Country = " + resultSet.getString("Country"));
// 	           System.out.println("Postal Code = " + resultSet.getInt("PostalCode"));
// 	           System.out.println("Phone = " + resultSet.getString("Phone"));
// 	           System.out.println("Fax = " + resultSet.getString("Fax"));
// 	           System.out.println("Email = " + resultSet.getString("Email"));
// 	           
 	            // iterate & read the result set
   		    
  		     
 	            // employee element
 	            org.w3c.dom.Element Customer = document.createElement("Customer");
 	           Customers .appendChild(Customer);
 	            // set an attribute to staff element
    			Attr attr = document.createAttribute("CustomerId");
    			if(resultSet.getString("CustomerId")==" ") attr.setValue("null");
    			else attr.setValue(resultSet.getString("CustomerId"));
    			Customer.setAttributeNode(attr);

    			//you can also use staff.setAttribute("id", "1") for this
    			
    			
    			// firstname element
    			org.w3c.dom.Element firstName = document.createElement("FirstName");
    			if(resultSet.getString("FirstName")==null) firstName.appendChild(document.createTextNode("null"));
    			else firstName.appendChild(document.createTextNode(resultSet.getString("FirstName")));
    			Customer.appendChild(firstName);

    			
    			// lastname element
    			org.w3c.dom.Element lastname = document.createElement("LastName");
    			if(resultSet.getString("LastName")==null) lastname.appendChild(document.createTextNode("null"));
    			else lastname.appendChild(document.createTextNode(resultSet.getString("LastName")));
    			Customer.appendChild(lastname);
    			
    			// Company element
    			org.w3c.dom.Element company = document.createElement("Company");
    			if(resultSet.getString("Company")==null) company.appendChild(document.createTextNode("null"));
    			else company.appendChild(document.createTextNode(resultSet.getString("Company")));
    			Customer.appendChild(company);

   			
    			// address elements
    			org.w3c.dom.Element department = document.createElement("Address");
    			if(resultSet.getString("Address")==null) department.appendChild(document.createTextNode("null"));
    			else department.appendChild(document.createTextNode(resultSet.getString("Address")));
    			Customer.appendChild(department);
    			
    			org.w3c.dom.Element city = document.createElement("City");
    			if(resultSet.getString("City")==null) city.appendChild(document.createTextNode("null"));
    			else city.appendChild(document.createTextNode(resultSet.getString("City")));
    			Customer.appendChild(city);
    			
    			org.w3c.dom.Element state = document.createElement("State");
    			if(resultSet.getString("State")==null) state.appendChild(document.createTextNode("null"));
    			else state.appendChild(document.createTextNode(resultSet.getString("State")));
    			Customer.appendChild(state);
    			
    			
    			org.w3c.dom.Element country = document.createElement("Country");
    			if(resultSet.getString("Country")==null) country.appendChild(document.createTextNode("null"));
    			else country.appendChild(document.createTextNode(resultSet.getString("Country")));
    			Customer.appendChild(country);
    			
    			org.w3c.dom.Element postalcode = document.createElement("PostalCode");
    			if(resultSet.getString("PostalCode")==null) postalcode.appendChild(document.createTextNode("null"));
    			else postalcode.appendChild(document.createTextNode(Integer.toString(resultSet.getInt("PostalCode"))));
    			Customer.appendChild(postalcode);
    			
    			
    			org.w3c.dom.Element phone = document.createElement("Phone");
    			if(resultSet.getString("Phone")==null) phone.appendChild(document.createTextNode("null"));
    			else phone.appendChild(document.createTextNode(resultSet.getString("Phone")));
    			Customer.appendChild(phone);
    			
    			org.w3c.dom.Element fax = document.createElement("Fax");
    			if(resultSet.getString("Fax")==null) fax.appendChild(document.createTextNode("null"));
    			else fax.appendChild(document.createTextNode(resultSet.getString("Fax")));
    			Customer.appendChild(fax);
    			
    			org.w3c.dom.Element email = document.createElement("Email");
    			if(resultSet.getString("Email")==null) email.appendChild(document.createTextNode("null"));
    			else email.appendChild(document.createTextNode(resultSet.getString("Email")));
    			Customer.appendChild(email);
    	        
    			 
    			
    	        }
    			// create the xml file
    			//transform the DOM Object to an XML File
    			TransformerFactory transformerFactory = TransformerFactory.newInstance();
    			Transformer transformer = transformerFactory.newTransformer();
    			DOMSource domSource = new DOMSource(document);
    			StreamResult streamResult = new StreamResult(new File(xmlFilePath));

    			// If you use
    			// StreamResult result = new StreamResult(System.out);
    			// the output will be pushed to the standard output ...
    			// You can use that for debugging 

    			transformer.transform(domSource, streamResult);

    			System.out.println("Done creating XML File");
    	        
    		} catch (ParserConfigurationException pce) {
    			pce.printStackTrace();
    		} catch (TransformerException tfe) {
    			tfe.printStackTrace();
    		}
        	
	           
	   /* 
	    * 
	    *        reading from xml file 
	    *        
        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        	DocumentBuilder builder = factory.newDocumentBuilder();
        	Document doc = builder.parse(xmlFilePath); 
        	
        	org.w3c.dom.Element root = doc.getDocumentElement();   
        	NodeList nList = root.getElementsByTagName("FirstName");
        	//Node temp = first.getNextSibling();
        	// System.out.println("Customer Id = " + resultSet.getString("CustomerId"));
//  		   System.out.println("First Name  = " + resultSet.getString("FirstName"));
//  		   System.out.println("Last Name = " + resultSet.getString("LastName"));
//  		   System.out.println("Company = " + resultSet.getString("Company"));
//  		   System.out.println("Address = " + resultSet.getString("Address"));
//	           System.out.println("City = " + resultSet.getString("City"));
//	           System.out.println("State = " + resultSet.getString("State"));
//	           System.out.println("Country = " + resultSet.getString("Country"));
//	           System.out.println("Postal Code = " + resultSet.getInt("PostalCode"));
//	           System.out.println("Phone = " + resultSet.getString("Phone"));
//	           System.out.println("Fax = " + resultSet.getString("Fax"));
//	           System.out.println("Email = " + resultSet.getString("Email"));
        	for (int temp = 0; temp < nList.getLength(); temp++)
        	{
        		//NodeList nList = root.getElementsByTagName("FirstName");
        	//String id=((Node) nList).getTextContent();
        		
        		//Object str = ((DocumentBuilderFactory) nList).getAttribute("CustomerId");
        				
        	String str = (String) nList.item(temp).getTextContent();
        	
        	Node sb = nList.item(temp).getNextSibling();
        	str = sb.getTextContent();   
        	System.out.println("First Name  : "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print("  Last Name  : "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print("  Company  :  "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print("  Address :  "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print("  City : "+str);
        	
        	
        	sb=sb.getNextSibling();
        	System.out.print("  State :  "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print("  Country :  "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print("  Postal Code : "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print("  Phone : "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print(" Fax : "+str);
        	
        	sb=sb.getNextSibling();
        	System.out.print(" Email : "+str);
        	//print all data through loop
        	
//        	while(sb.getNextSibling()!=null) {
//        	str = sb.getTextContent();   
//        	System.out.println(str);
//        	sb=sb.getNextSibling();
//        	}
//        	
        	
        	}
        	

        */
        	
         
        }

        

	

        
        

	

}












//Class.forName("org.sqlite.JDBC");

/*
  Connection connection = null;
  try
  {
     // create a database connection
     connection = DriverManager.getConnection("jdbc:sqlite:dbj.sqlite");

     java.sql.Statement statement = connection.createStatement();
     statement.setQueryTimeout(30);  // set timeout to 30 sec.


     //statement.executeUpdate("DROP TABLE IF EXISTS person");
     //statement.executeUpdate("CREATE TABLE person (id INTEGER, name STRING)");

   //  int ids [] = {1,2,3,4,5};
    // String names [] = {"Peter","Pallar","William","Paul","James Bond"};

  //   for(int i=0;i<ids.length;i++){
    //      statement.executeUpdate("INSERT INTO person values(' "+ids[i]+"', '"+names[i]+"')");   
    // }

     //statement.executeUpdate("UPDATE person SET name='Peter' WHERE id='1'");
     //statement.executeUpdate("DELETE FROM person WHERE id='1'");

       ResultSet resultSet = statement.executeQuery("SELECT * from 	Customer");
       while(resultSet.next())
       {
          // iterate & read the result set
          System.out.println("id = " + resultSet.getString("CustomerId"));
          System.out.println("name = " + resultSet.getInt("FirstName"));
       }
      }

 catch(SQLException e){  System.err.println(e.getMessage()); }       
  finally {         
        try {
              if(connection != null)
                 connection.close();
              }
        catch(SQLException e) {  // Use SQLException class instead.          
           System.err.println(e); 
         }
  }

*/
