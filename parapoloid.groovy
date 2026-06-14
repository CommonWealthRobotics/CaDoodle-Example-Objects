import eu.mihosoft.vrl.v3d.*
import javafx.scene.paint.Color
import eu.mihosoft.vrl.v3d.*
import javafx.scene.paint.Color
import javafx.scene.paint.Color

import eu.mihosoft.vrl.v3d.parametrics.*;
CSG getObject(){
	if(args==null)
		args=["Test_key_here"]
		ArrayList<Double> options = new  ArrayList<Double> ()
		options.addAll(Arrays.asList(4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,64,256))
		LengthParameter word = new LengthParameter(	args[0]+"_CaDoodle_ParaboloidGeneration_Sides",
												Integer.parseInt(com.neuronrobotics.bowlerstudio.assets.ConfigurationDatabase.get("CaDoodle", "DefaultNumberOfSides", "16").toString())
	,options)
	double sides = (word.getMM())
	CSG text =  Parabola.cone(10,20,sides).toZMin().setColor(Color.WHITE)
	return text
		.setRegenerate({getObject()})
		.setParameter(word)
}
return getObject()
