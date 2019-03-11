package complet.model.agents;

import java.awt.Point;

public class PointPositif implements Cloneable{
	private Point p;
	
	public PointPositif(Point p) {
		this.p=p;
		setX(p.x);
		setY(p.y);
	}
	
	public int getX() {return (int)(p.getX());}
	public int getY() {return (int)(p.getY());}
	public boolean setX(int x) {
		boolean ret=true;
		if(p.x<0){
			p.x=0;
			ret=false;
		}
		else {p.x=x;}
		return ret;
	}
	public boolean setY(int y) {
		boolean ret=true;
		if(p.y<0){
			p.y=0;
			ret=false;
		}
		else {p.y=y;}
		return ret;
	}
	
	@Override
	public String toString() {
		return "("+ getX() + ";" + getY() + ")";
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((p == null) ? 0 : p.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PointPositif other = (PointPositif) obj;
		if (p == null) {
			if (other.p != null)
				return false;
		} else if (!p.equals(other.p))
			return false;
		return true;
	}

	public Object clone() {
		return new PointPositif((Point)p.clone());
		
	}
}
