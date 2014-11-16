package ar.utn.bio.bio_tp_colon;

import java.io.File;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.biojava3.core.sequence.DNASequence;
import org.biojava3.core.sequence.ProteinSequence;
import org.biojava3.core.sequence.io.FastaWriterHelper;
import org.biojava3.core.sequence.io.GenbankReaderHelper;
import org.biojava3.core.sequence.transcription.Frame;

public class App{
    public static void main( String[] args ) throws Exception{
    	File dnaFile = new File("src/main/resources/sequence.gb");		
     
    	LinkedHashMap<String, DNASequence> dnaSequences = GenbankReaderHelper.readGenbankDNASequence( dnaFile );
    	List<ProteinSequence> proteinSequences = new ArrayList<ProteinSequence>();
    	for (DNASequence sequence : dnaSequences.values()) {
    			for(Frame frame : Frame.values()){    				
    				ProteinSequence proteinSequence = sequence.getRNASequence(frame).getProteinSequence();
    				proteinSequences.add(proteinSequence);
    			}
    	    	System.out.println( sequence.getSequenceAsString() );
    	}
    	FastaWriterHelper.writeProteinSequence(new File("src/main/resources/fasta-protein.fna"), proteinSequences);
    	
    	FastaWriterHelper.writeNucleotideSequence(new File("src/main/resources/fasta-dna.fna"),dnaSequences.values());
    }
}
