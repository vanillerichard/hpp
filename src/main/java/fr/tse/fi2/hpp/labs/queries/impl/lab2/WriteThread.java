package fr.tse.fi2.hpp.labs.queries.impl.lab2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.tse.fi2.hpp.labs.beans.DebsRecord;


import fr.tse.fi2.hpp.labs.beans.measure.QueryProcessorMeasure;
import fr.tse.fi2.hpp.labs.queries.AbstractQueryProcessor;

public class WriteThread implements Runnable {
	final static Logger Logger = LoggerFactory.getLogger(WriteThread.class);
			
	private BufferedWriter outputWriter;
	
	private int id;
	
	public final BlockingQueue<String> resultqueue;

	public WriteThread(int id) {
		super();
		this.id=id;
		try {
			outputWriter = new BufferedWriter(new FileWriter(new File("result/query"+id+".txt")));
		} catch (IOException e) {
			Logger.error("Cannot open output file for" + id, e);
			
		}
	}

	@Override
	protected void writeLine(String line) {
		try {
			outputWriter.write(line);
			outputWriter.newLine();
		} catch (IOException e) {
			Logger.error("Could not Write new line for query processor" + id + ", line content " + line, e);
		}
		
	}

	@Override
	public void run() {
		// Récupérer la queue
		// Ecrire
		
	}
	
	private void finish () {
		try {
			outputWriter.flush();
			outputWriter.close();
		} catch (IOException e ) {
			Logger.error("Cannot properly close the file for query" + id, e);
		}
	}

}
