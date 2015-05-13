package fr.tse.fi2.hpp.labs.queries.impl.lab4;

import java.security.MessageDigest;

import fr.tse.fi2.hpp.labs.beans.DebsRecord;
import fr.tse.fi2.hpp.labs.beans.measure.QueryProcessorMeasure;
import fr.tse.fi2.hpp.labs.queries.AbstractQueryProcessor;

public class Bloom extends AbstractQueryProcessor {

	private final int n;
	private final double p;
	private static int hashSize;
	
	public Bloom(QueryProcessorMeasure measure, int n, double p) { // n est le nombre de doçnnées à traiter et p est la précisin que l'on veut
		super(measure);
		this.n=n;
		this.p=p;
		// TODO Auto-generated constructor stub
		int m = (int) Math.ceil((n *  Math.log(p)) / Math.log(1.0 / (Math.pow(2.0, Math.log(2.0))))); // On calcule le nombre de bits dans le filtre
		int k = (int) Math.round(Math.log(2.0)*m/n); // On calcule le nombre de fonction de hachagfe à calculer
		hashSize=(int) Math.ceil((Math.log10(m)/Math.log10(m)%m));
	}

	

	@Override
	protected void process(DebsRecord record) {
		// TODO Auto-generated method stub
		

	}
	
	

}
