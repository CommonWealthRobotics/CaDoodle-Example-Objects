package build123d;

import com.neuronrobotics.bowlerstudio.vitamins.Vitamins;
import eu.mihosoft.vrl.v3d.CSG
import eu.mihosoft.vrl.v3d.parametrics.*

import com.neuronrobotics.bowlerstudio.scripting.Build123dLoader
import com.neuronrobotics.bowlerstudio.scripting.ScriptingEngine

import eu.mihosoft.vrl.v3d.CSG

HashMap<String,Double> params=new HashMap<String, Double>();
List<CSG> getObject(){
	if(args==null) {
		args=["Test_key_here"]
	}
	ArrayList<Double> options = new  ArrayList<Double> ()
	for(int i=10;i<=100;i++) {
		options.add(i);
	}
	LengthParameter numTeeth = new LengthParameter(csgdb,
			args[0]+"_CaDoodle_Sprocket_Teeth",
			23,
			options)
	LengthParameter height = new LengthParameter(csgdb,
		args[0]+"_CaDoodle_Sprocket_Height",
		2.1336,
		new  ArrayList<Double> (Arrays.asList(1,5,20)))
	
	ArrayList<Double> modOpts = new  ArrayList<Double> (Arrays.asList(1,12.7,20))
	LengthParameter module = new LengthParameter(csgdb,
		args[0]+"_CaDoodle_Sprocket_Chain-Pitch",
		12.7,
		modOpts)
	ArrayList<Object> params=new ArrayList< Object>();
	params.add("bd_warehouse")
	params.add( "Sprocket")
	params.add("--num_teeth")
	params.add((int)numTeeth.getMM())
	params.add("--thickness")
	params.add(height.getMM())
	params.add("--chain_pitch")
	params.add(module.getMM())
	List<CSG> all=	Build123dLoader.toCSG(csgdb, params)
	for(CSG bin:all) {
		bin.setNoScale(true)
		bin.setParameter(csgdb,type)
			.setParameter(csgdb,numTeeth)
			.setParameter(csgdb,height)
			.setParameter(csgdb,module)
			.setRegenerate({getObject()})
	}
	return all

}

return getObject()

