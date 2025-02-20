package triangle.syntacticAnalyser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import triangle.ErrorReporter;
import triangle.syntacticAnalyzer.Parser;
import triangle.syntacticAnalyzer.Scanner;
import triangle.syntacticAnalyzer.SourceFile;

public class TestScanner {

	@Test
	public void testHi() {
		compileExpectSuccess("/hi.tri");
	}
	

	@Test
	public void testHiNewComment() {
		compileExpectSuccess("/hi-newcomment.tri");
	}
	

	@Test
	public void testHiNewComment2() {
		compileExpectSuccess("/hi-newcomment2.tri");
	}
	

	@Test
	public void testBarDemo() {
		compileExpectSuccess("/bardemo.tri");
	}
	

	@Test
	public void testRepeatUntil() { compileExpectSuccess("/repeatuntil.tri"); }

	@Test
	public void testIncrement() { compileExpectSuccess("/increment.tri"); }

<<<<<<< HEAD
	//Task 3.b implement unit test for doubling (a**)
	@Test
	public void testDoubling() {compileExpectSuccess("/double.tri");}

	//Task 4.b implement unit test for {...}
	@Test
	public void testCurly(){compileExpectSuccess("/while-curly.tri");}

	/*Task 6.b implement unit test for new loop:
	    loop C1
	    while E
	    do C2 */
	@Test
	public void testTestWhileLoop(){compileExpectSuccess("/loopwhile.tri");}
=======
>>>>>>> a15935a019d310364b660e764b41eec26759f780


	private void compileExpectSuccess(String filename) {
		// build.gradle has a line sourceSets.test.resources.srcDir file("$rootDir/programs")
		// which adds the programs directory to the list of places Java can easily find files
		// getResource() below searches for a file, which is in /programs 
		//SourceFile source = SourceFile.ofPath(this.getClass().getResource(filename).getFile().toString());
		SourceFile source = SourceFile.fromResource(filename);
		
		Scanner scanner = new Scanner(source);
		ErrorReporter reporter = new ErrorReporter(true);
		Parser parser = new Parser(scanner, reporter);
		
		parser.parseProgram();
		
		// we should get to here with no exceptions
		
		assertEquals("Problem compiling " + filename, 0, reporter.getNumErrors());
	}
	
	private void compileExpectFailure(String filename) {
		//SourceFile source = SourceFile.ofPath(this.getClass().getResource(filename).getFile().toString());
		SourceFile source = SourceFile.fromResource(filename);
		Scanner scanner = new Scanner(source);
		ErrorReporter reporter = new ErrorReporter(true);
		Parser parser = new Parser(scanner, reporter);

		// we expect an exception here as the program has invalid syntax
		assertThrows(RuntimeException.class, new ThrowingRunnable() {
			public void run(){
				parser.parseProgram();
			}
		});
		
		// currently this program will fail
		assertNotEquals("Problem compiling " + filename, 0, reporter.getNumErrors());
	}

}
