/**
 * @author Allison, Jack, Jordan
 * (We all created this Class)
 */ 
import java.util.LinkedList;
/**
 * Physics class
 * gets bounds and adds the collisions
 */ 
public class Physics {
	/**
	 * calculations behind the collison of the bullet to the zombie
	 */ 
	public static boolean Collision(EntityA enta, LinkedList<EntityB> entb){
		for(int i = 0; i < entb.size(); i++){
			if(enta.getBounds().intersects(entb.get(i).getBounds())){
				return true;

			}
	}
	
	return false;
}        /**
	 * calculations behind the collison of the bullet to the zombie
	 */ 
	public static boolean Collision(EntityB entb, LinkedList<EntityA> enta){
	for(int i = 0; i < enta.size(); i++){
		if(entb.getBounds().intersects(enta.get(i).getBounds())){
			enta.remove(i);
			return true;

		}
}
