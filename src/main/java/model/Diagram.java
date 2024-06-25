package model;

import java.util.List;

import service.Writer;

public class Diagram {

	private List<Point> points;

	public Diagram(List<Point> points) {
		this.points = points;
	}

	public void generateDiagram() throws Exception {
		String toSave = "";
		Integer greaterValue = isGreaterCoordonateValue();
		for (Integer ordonnateIndex = greaterValue; ordonnateIndex >= -greaterValue; ordonnateIndex--) {
			for (Integer abscissaIndex = -greaterValue; abscissaIndex <= greaterValue; abscissaIndex++) {
				if (isPointAtCoordonate(ordonnateIndex, abscissaIndex)) {
					toSave += "*";
				} else if (ordonnateIndex == 0 && abscissaIndex == 0) {
					toSave += "+";
				} else if (abscissaIndex == 0) {
					toSave += "|";
				} else if (ordonnateIndex == 0) {
					toSave += "-";
				} else {
					toSave += " ";
				}
			}
			toSave += "\n";
		}
		Writer.write(toSave);
	}

	public void addPoint(String coordonnate) {
		String[] splitArray = coordonnate.split(",");
		Point point = new Point(Integer.parseInt(String.valueOf(splitArray[0])),
				Integer.parseInt(String.valueOf(splitArray[1])));
		points.add(point);
	}

	private boolean isPointAtCoordonate(Integer ordonnateIndex, Integer abscissaIndex) {
		return (points.stream()
				.anyMatch(p -> p.getOrdonate().equals(ordonnateIndex) && p.getAbscissa().equals(abscissaIndex)));

	}

	private Integer isGreaterCoordonateValue() {
		Integer greaterValue = 5;
		for (Point point : points) {
			if (point.getAbscissa() > greaterValue)
				greaterValue = point.getAbscissa();
			if (point.getOrdonate() > greaterValue)
				greaterValue = point.getOrdonate();
		}
		return greaterValue;
	}

	public List<Point> getPoints() {
		return points;
	}

	public void setPoints(List<Point> points) {
		this.points = points;
	}
}
