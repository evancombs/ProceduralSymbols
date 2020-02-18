package gridSymbols;

import java.util.Random;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Graphics2D;



// The basic idea here is to for an n x n array of points, choose several to connect,
// forming some lines that make up a symbol. We do this by using one array to represent
// all of the points, and one to represent which points are "linked up".
public class GridSymbol extends Canvas
{
	Link[] links;
	int dimension;
	int paddingInPix = 200;
	int scale = 100;
	
	public GridSymbol(int n)
	{
		dimension = n;
		//links = new Link[n * n];
		generateSymbol();
	}
	
	// We generate all of our links here. 
	private void generateSymbol()
	{
		Random rand = new Random();
		
		// We want to choose a number of links scaling with the number of
		int numLinks = dimension * dimension;
		int numPotentialDots = 0;
		int vertexA, vertexB, dot;
		links = new Link[numLinks + numPotentialDots];
		
		for (int i = 0; i < numLinks; i++)
		{
			vertexA = rand.nextInt(dimension * dimension);
			vertexB = rand.nextInt(dimension * dimension);
			// System.out.println("Generated new point: (" + vertexA + " , " +  vertexB + ")");
			links[i] = new Link(vertexA, vertexB);
			System.out.println("Generating link: " + i);
		}
		for (int i = numLinks; i < numPotentialDots + numLinks; i++)
		{
			dot = rand.nextInt(dimension * dimension);
			links[i] = new Link(dot, dot);
			System.out.println("Generating dot: " + i);
		}
		
	}
	
	// This function is invoked when we try to draw the frame it has been added to, *I think*
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		for (int i = 0; i < dimension; i++)
		{
			for(int j = 0; j < dimension; j++)
			{
				//g.drawOval((i * 100) + paddingInPix, (j * 100) + paddingInPix, 10, 10);
			}
		}
		for (Link link : links)
		{
			
			System.out.println("Now drawing link from vertices: " + link.vertexA + " to " +  link.vertexB);
			int vertexAXPos = (link.vertexA % dimension) * scale + paddingInPix;
			int vertexAYPos = (link.vertexA / dimension) * scale + paddingInPix;
			int vertexBXPos = (link.vertexB % dimension) * scale + paddingInPix;
			int vertexBYPos = (link.vertexB / dimension) * scale + paddingInPix;
			System.out.printf("Drawing links from point (%d, %d) to (%d, %d)\n", vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			g2.drawLine(vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
		}
	}
}
