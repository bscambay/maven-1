package org.ssa.ironyard;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class BTSudokuSolverTest {

    String easyGame = "075090006023080040800003001500702000040806020000901003900400007060070580700010390";
    String easyGameSolution = "175294836623187945894563271519732468347856129286941753938425617461379582752618394";
    String easyGame2 = "024000135019024600000106000080005009050769040900300050000403000001850290538000410";
    String mediumGame = "801000000050304070740000605030090007007532900200060050506000082010207030000000704";
    String hardGame = "000000900039080005100034800000843601000000000206751000002490008600020540008000000";
    
    String evilGame = "000900530500070008000008060300800000204000103000005009070300000900010005018006000";

    @Test
    public void test() {

	assertTrue(easyGame.length() == 81);
	assertTrue(easyGameSolution.length() == 81);
	assertTrue(BTSudokuSolver.guessValid(easyGame, 0, '1'));
	assertTrue(BTSudokuSolver.guessValid(easyGame, 9, '6'));
	assertTrue(BTSudokuSolver.guessValid(easyGame, 80, '4'));
	// System.out.println(BTSudokuSolver.solve(easyGame));
	// System.out.println(BTSudokuSolver.solve(mediumGame));
	// System.out.println(BTSudokuSolver.solve(hardGame));
	System.out.println(BTSudokuSolver.toString(BTSudokuSolver.solve(evilGame)));
    }

}
