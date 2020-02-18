package gridSymbols;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.*;

public class ArcSymbol extends GridSymbol
{

	public ArcSymbol(int n) 
	{
		super(n);
		

	}
	public void paint(Graphics g)
	{
		Random rand = new Random();
		Graphics2D g2 = (Graphics2D) g;
		g2.setStroke(new BasicStroke(10, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));

		for (Link link : links)
		{
			//int x0 = rand.nextInt(dimension) * scale + paddingInPix;
			//int y0 = rand.nextInt(dimension) * scale + paddingInPix;
			System.out.println("Now drawing link from vertices: " + link.vertexA + " to " +  link.vertexB);
			int vertexAXPos = (link.vertexA % dimension) * scale + paddingInPix;
			int vertexAYPos = (link.vertexA / dimension) * scale + paddingInPix;
			int vertexBXPos = (link.vertexB % dimension) * scale + paddingInPix;
			int vertexBYPos = (link.vertexB / dimension) * scale + paddingInPix;
			g2.drawOval(paddingInPix/2 ,paddingInPix/2 , 500, 500);
			if (Math.random() < 0.5)
			{
				g2.drawLine(vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
			}
			else
			{
				int x0 = (vertexAXPos + vertexBXPos) / 2;
				int y0 = (vertexAYPos + vertexBYPos) / 2;
				System.out.printf("Drawing links from point (%d, %d) to (%d, %d)\n", vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
				//g2.drawLine(vertexAXPos, vertexAYPos, vertexBXPos, vertexBYPos);
				// g2.drawArc(x, y, width, height, startAngle, arcAngle);
				int r = (int)Math.sqrt((vertexAXPos-x0)*(vertexAXPos-x0) + (vertexAYPos-y0)*(vertexAYPos-y0));
				int x = x0-r;
				int y = y0-r;
				int width = 2*r;
				int height = 2*r;
				int startAngle = (int) (180/Math.PI * Math.atan2(vertexAYPos-y0, vertexAXPos-x0));
				int endAngle = (int) (180/Math.PI * Math.atan2(vertexBYPos-y0, vertexBXPos-x0));
				
				startAngle *= (Math.random() < 0.7 ? -1 : 1);
				endAngle *= (Math.random() < 0.7 ? -1 : 1);
				g2.drawArc(x, y, width, height, startAngle, endAngle);
			}
		}
	}

}
