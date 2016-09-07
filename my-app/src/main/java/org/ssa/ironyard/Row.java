package org.ssa.ironyard;

public class Row {
    char[] cells = new char[9];
    
    public boolean contains(char target){
	for(char c: cells)
	    if(target == c)
		return true;
	return false;
    }
    
    public void set(int index, char c){
	cells[index] = c;
    }
    
    public char get(int index){
	return cells[index];
    }

    @Override
    public String toString() {
	StringBuilder sb = new StringBuilder("");
	for (int i = 0; i < cells.length; i++)
	    sb.append(cells[i]);
	return sb.toString();
    }
}
