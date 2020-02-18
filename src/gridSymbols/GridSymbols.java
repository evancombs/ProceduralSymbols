package gridSymbols;

import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class GridSymbols  
{
	public static void main(String[] args)
	{
		int dimension = 3;
		Canvas symbol = new GridSymbol(dimension);
		symbol.setSize(100 * dimension, 100 * dimension);
		
		Canvas mirrorSymbol = new MirrorGridSymbol(dimension);
		mirrorSymbol.setSize(100 * dimension * 2, 100 * dimension * 2);
		
		Canvas arcSymbol = new ArcSymbol(dimension);
		arcSymbol.setSize(200 * dimension, 200 * dimension);
		drawSymbol(mirrorSymbol);
		

	}
	
	public static void drawSymbol(Canvas symbol)
	{
		JFrame frame = new JFrame("Generated Symbol");
		frame.add(symbol);
		frame.pack();
		frame.setVisible(true);
	}
}
