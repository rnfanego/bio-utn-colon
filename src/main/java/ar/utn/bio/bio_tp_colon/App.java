package ar.utn.bio.bio_tp_colon;

import java.io.File;
import java.util.LinkedHashMap;

import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.io.FastaWriterHelper;
import org.biojava3.core.sequence.io.GenbankReaderHelper;

public class App{
    public static void main( String[] args ) throws Exception{
    	File dnaFile = new File("src/main/resources/sequence.gb");		
     
    	LinkedHashMap<String, DNASequence> dnaSequences = GenbankReaderHelper.readGenbankDNASequence( dnaFile );
    	for (DNASequence sequence : dnaSequences.values()) {
    	    	System.out.println( sequence.getSequenceAsString() );
    	}
    	
    	FastaWriterHelper.writeNucleotideSequence(new File("src/main/resources/fasta-colon.fna"),dnaSequences.values());
    }
}
