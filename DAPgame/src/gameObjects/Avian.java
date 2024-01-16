package gameObjects;

import java.awt.Color;

public class Avian extends GameObject{
	public String path;
	public double radius;
	double speedX;
	double speedY;
	private double speed;
	private double angle;
	double gravity;

	/**
	 * Constructor for Avian class
	 * @param startX - Starting X position
	 * @param startY - Starting Y position
	 * @param width - Width position
	 * @param height - Height position
	 * @param mass - Mass of Avian
	 * @param path - Sprite path file name
	 * @param radius - Radius of Avian
	 * @param speed - Speed of Avian
	 * @param angle - Angle of Avian
	 */
	public Avian(double startX, double startY, double width, double height, double mass, String path, double radius, double speed, double angle) {
		super(startX, startY, width, height, mass);
		//should really only be one size for beta testing purposes
		//this.color = Color.RED;
		this.objType = "Avian";
		this.path = path;
		this.radius = radius;
		this.speedX = speed* Math.cos(Math.toRadians(angle));
		this.speedY = -speed * Math.sin(Math.toRadians(angle));
		this.speed = speed;
		this.angle = angle;
		
	}
	
	public Avian copy(Avian avian) {
		Avian cbird = new Avian(avian.position.getX(), avian.position.getY(),avian.width, avian.height, avian.mass, avian.path, avian.radius, avian.speed, avian.angle);
		cbird.setColor(avian.getColor());
		return cbird;
	}
	
	public String getPath() {
		return path;
	}
	
	public double getRadius() {
		return radius;
	}
	
    public void setRadius(double radius) {
        this.radius = radius;
    }
    
    public double getSpeedY() {
        return speedY;
    }

    public double getSpeedX() {
        return speedX;
    }
    
    public double getSpeed() {
    	return speed;
    }
	
    public void setSpeedX(double speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(double speedY) {
        this.speedY = speedY;
    }
    
    public void setSpeed(double speed) {
    	this.speed = speed;
    }
    
    public double getSpeedFromPosition() {
        if (this.speedX > 0)
            return this.speedX / Math.cos(Math.toRadians(angle));
        else
            return -this.speedX / Math.cos(Math.toRadians(angle));
    }
    
    public void setSpeedAndAngle(double speed, double angle) {
        this.speed = speed;
        this.angle = angle;
        this.speedX = speed * Math.cos(Math.toRadians(angle));
        this.speedY = -speed * Math.sin(Math.toRadians(angle));
    }
    
    public void gravity(double gravity) {
    	this.speedY += gravity;
    	
    }

	
}
