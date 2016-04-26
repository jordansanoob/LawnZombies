
/**
 * @author Allison, Jack, Jordan
 * (We all created this Class)
 */

/**
 * Physics class
 * gets bounds and adds the collisions
 */ 
public class Physics {
	/**
	 * calculations behind the collison of the bullet to the zombie
	 */ 
	public static boolean Collision(EntityA enta, EntityB entb){

			if(enta.getBounds().intersects(entb.getBounds())){
				return true;
			
	}
	
	return false;
}	 /**
	 * calculations behind the collison of the bullet to the zombie
	 */ 
	public static boolean Collision(EntityB entb, EntityA enta){

		if(entb.getBounds().intersects(enta.getBounds())){
			return true;
		
}

return false;
}
	

}