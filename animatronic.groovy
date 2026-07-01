
import eu.mihosoft.vrl.v3d.parametrics.*;

import com.neuronrobotics.bowlerstudio.scripting.ScriptingEngine
import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;

class CadoodleHeadMaker{

	ArrayList<CSG>  get(def csgdb,def args) {
		def	 printerOffset		= new LengthParameter(csgdb,"printerOffset",0.5,[2, 0.001])
		def	 noseLength		= new LengthParameter(csgdb,"noseLength",20,[200, 001])
		def	 jawLength		= new LengthParameter(csgdb,"jawLength",40,[200, 001])
		def	 eyeDiam 		= new LengthParameter(csgdb,"Eye Diameter",40,[60, 38])
		def	 servoSizeParam 			= new StringParameter(csgdb,"hobbyServo Default","DHV56mg_sub_Micro",Vitamins.listVitaminSizes("hobbyServo"))
		// servoSizeParam 			= new StringParameter("hobbyServo Default","towerProMG91",Vitamins.listVitaminSizes("hobbyServo"))
		def	 eyemechRadius		= new LengthParameter(csgdb,"Eye Mech Linkage",12,[20, 5])
		def	 hornSizeParam 			= new StringParameter(csgdb,"hobbyServoHorn Default","DHV56mg_sub_Micro_1",Vitamins.listVitaminSizes("hobbyServoHorn"))
		// hornSizeParam 			= new StringParameter("hobbyServoHorn Default","standardMicro1",Vitamins.listVitaminSizes("hobbyServoHorn"))
		def	 eyeCenter 		= new LengthParameter(csgdb,"Eye Center Distance",eyeDiam.getMM()*1.5,[100, eyeDiam.getMM()])
		def	 noseDiameter 		= new LengthParameter(csgdb,"Nose Diameter",eyeDiam.getMM()*2,[eyeDiam.getMM()*3, 10])
		def	 bearingSizeParam 			= new StringParameter(csgdb,"Bearing Size","608zz",Vitamins.listVitaminSizes("ballBearing"))

		String name = args.get(0);
		
		
		ArrayList<CSG>  headParts  = (ArrayList<CSG> )ScriptingEngine.gitScriptRun(csgdb,
				"https://github.com/madhephaestus/ParametricAnimatronics.git",
				"3dPrintableHead.groovy" ,
				[] )


		return headParts
	}
}
return new CadoodleHeadMaker().get(csgdb,args);