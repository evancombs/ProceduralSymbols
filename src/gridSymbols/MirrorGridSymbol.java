package gridSymbols;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class MirrorGridSymbol extends GridSymbol
{

	public MirrorGridSymbol(int n) {
		super(n);
	}
	
	public void paint(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
		int vertexAXPos;
		int vertexAYPos;
		int vertexBXPos;
		int vertexBYPos;
		
		for (int i = 0; i < dimension; i++)
		{
			for(int j = 0; j < dimension; j++)
			{
				//g.drawOval((i * 100) + paddingInPix, (j * 100) + paddingInPix, 10, 10);
			}
		}
		// The same basic idea here applies, BUT now we wish to mirror the links to make a symmetric glyph
		for (Link link : links)
		{
			int quadPadding = dimension * scale;
			// Quad structure:
			// 1 2
			// 3 4
			// Quad 1
			//System.out.println("Now drawing link from vertices: " + link.vertexA + " to " +  link.vertexB);
			vertexAXPos = (link.vertexA % dimension) * scale + paddingInPix;
			vertexAYPos = (link.vertexA / dimension) * scale + paddingInPix;
			vertexBXPos = (link.vertexB % dimension) * scale + paddingInPix;
			vertexBYPos = (link.vertexB / dimension) * scale + paddingInPix;
			//System.out.printf("Drawing links from point (%d, %d) to (%d, %d)\n", vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			g2.drawLine(vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			
			// Quad 3
		
			vertexAXPos = (link.vertexA % dimension) * scale + paddingInPix;
			vertexAYPos = quadPadding - (link.vertexA / dimension) * scale + paddingInPix;
			vertexBXPos = (link.vertexB % dimension) * scale + paddingInPix;
			vertexBYPos = quadPadding - (link.vertexB / dimension) * scale + paddingInPix;
			//System.out.printf("Drawing links from point (%d, %d) to (%d, %d)\n", vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			g2.drawLine(vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			
			// Quad 2
			vertexAXPos = quadPadding - (link.vertexA % dimension) * scale + paddingInPix;
			vertexAYPos = (link.vertexA / dimension) * scale + paddingInPix;
			vertexBXPos = quadPadding - (link.vertexB % dimension) * scale + paddingInPix;
			vertexBYPos = (link.vertexB / dimension) * scale + paddingInPix;
			//System.out.printf("Drawing links from point (%d, %d) to (%d, %d)\n", vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			g2.drawLine(vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			
			// Quad 4
			vertexAXPos = quadPadding - (link.vertexA % dimension) * scale + paddingInPix;
			vertexAYPos = quadPadding - (link.vertexA / dimension) * scale + paddingInPix;
			vertexBXPos = quadPadding - (link.vertexB % dimension) * scale + paddingInPix;
			vertexBYPos = quadPadding - (link.vertexB / dimension) * scale + paddingInPix;
			//System.out.printf("Drawing links from point (%d, %d) to (%d, %d)\n", vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			g2.drawLine(vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			
		}
	}

}
