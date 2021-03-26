package com.etf.editknjiga;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.etf.editknjiga.Knjiga;
import com.etf.editknjiga.Autor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

@SpringBootApplication
public class EditKnjigaApplication {
	@Autowired
	public static MongoDatabase database;

	public static void main(String[] args) {
		MongoClient mongoClient =  MongoClients.create("mongodb+srv://sanja:borkvOCiBpguBQtt@cluster0.7prvw.mongodb.net/biblioteka?retryWrites=true&w=majority");
		MongoDatabase database = mongoClient.getDatabase("biblioteka");
		MongoCollection<Document> connectionKnjiga = database.getCollection("knjiga");
		MongoCollection<Document> connectionAutor = database.getCollection("autor");
		ObjectMapper oMapper = new ObjectMapper();
		
		List<Knjiga> insertKnjiga = new ArrayList<>();
		insertKnjiga.add(new Knjiga(new Long(1),new String("Harry Potter and Sorcerer's stone"), new String("fantasy"), new Long(1)));
		insertKnjiga.add(new Knjiga(new Long(2), new String("Talking to Strangers"), new String("psychology"),new Long(2)));
		insertKnjiga.add(new Knjiga(new Long(3), new String("Brief Answers to the Big Questions"), new String("science"),  new Long(3)));
		insertKnjiga.forEach(i->{
			connectionKnjiga.insertOne(new Document(oMapper.convertValue(i, Map.class)));
		});
		
		List<Autor> insertAutor = new ArrayList<>();
		insertAutor.add(new Autor(new Long(0), new String("J.K"), new String("Rowling"), new String() ));
		insertAutor.add(new Autor(new Long(1), new String("Malcolm"), new String("Gladwell"),new String() ));
		insertAutor.add(new Autor(new Long(2), new String("Stephen"), new String("Hawking"), new String() ));
		insertAutor.forEach(i->{
			connectionAutor.insertOne(new Document(oMapper.convertValue(i, Map.class)));
		});
		
		System.out.println("Knjiga");
		MongoCursor<Document> knjiga=connectionKnjiga.find().iterator();
		while(knjiga.hasNext()) {
			ArrayList<Object> var =new ArrayList<> (knjiga.next().values());
			System.out.println(var.get(0)+" "+var.get(1)+" "+var.get(2)+" "+var.get(3));
		}
		
		System.out.println("Autor");
		MongoCursor<Document> autor=connectionAutor.find().iterator();
		while(autor.hasNext()) {
			ArrayList<Object> var =new ArrayList<> (autor.next().values());
			System.out.println(var.get(0)+" "+var.get(1)+" "+var.get(2)+" "+var.get(3)+" "+var.get(4));
		}
		
		
	}

}



