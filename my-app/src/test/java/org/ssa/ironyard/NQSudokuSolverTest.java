package org.ssa.ironyard;

import static org.junit.Assert.*;

import org.junit.Test;

public class NQSudokuSolverTest {
    
    String easy = "075090006023080040800003001500702000040806020000901003900400007060070580700010390";

    @Test
    public void test() {
	NQSudokuSolver nq = new NQSudokuSolver(easy);
    }

}
