package Vgarden.demo.model;

import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.Embeddable;
import java.util.Objects;

@Embeddable
public class Emplacement {

	@JsonView(Views.Common.class)
	private double positionX;

	@JsonView(Views.Common.class)
	private double positionY;

	public Emplacement() {

	}

	public Emplacement(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	@Override
	public int hashCode() {
		return Objects.hash(positionX, positionY);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emplacement other = (Emplacement) obj;
		return Double.doubleToLongBits(positionX) == Double.doubleToLongBits(other.positionX)
				&& Double.doubleToLongBits(positionY) == Double.doubleToLongBits(other.positionY);
	}

}
