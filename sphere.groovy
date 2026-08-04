import eu.mihosoft.vrl.v3d.*
import javafx.scene.paint.Color

import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.Cube
import javafx.scene.paint.Color

import eu.mihosoft.vrl.v3d.parametrics.*;
CSG getObject(CSGDatabaseInstance csgdb){
	if(args==null)
		args=["Test_key_here"]
	ArrayList<Double> options = new  ArrayList<Double> ()
	options.addAll(Arrays.asList(4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,64,256))
	LengthParameter word = new LengthParameter(csgdb,	args[0]+"_CaDoodle_ShereGeneration_Sides",
											Integer.parseInt(com.neuronrobotics.bowlerstudio.assets.ConfigurationDatabase.get("CaDoodle", "DefaultNumberOfSides", "16").toString())
,options)
	LengthParameter diam = new LengthParameter(csgdb,	args[0]+"_CaDoodle_ShereGeneration_Diameter",
20,[])
	if(diam.getMM()<0.001)
		diam.setMM(0.001);
	int getMM2 = (int)(word.getMM()/2)
	if(getMM2<2)getMM2=2
	CSG text = new Sphere(diam.getMM()/2.0,(int)(word.getMM()),getMM2).toCSG().rotx(90).toZMin().setColor(Color.LIGHTBLUE)
	return text
		.setParameter(csgdb,word)
		.setParameter(csgdb,diam)
		.setRegenerate({getObject()})
}
return getObject(csgdb)
