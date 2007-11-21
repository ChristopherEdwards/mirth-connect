package com.webreach.mirth.model.hl7v2.v24.message;
import com.webreach.mirth.model.hl7v2.v24.segment.*;
import com.webreach.mirth.model.hl7v2.*;

public class _INRU06 extends Message{	
	public _INRU06(){
		segments = new Class[]{_MSH.class, _EQU.class, _INV.class, _ROL.class};
		repeats = new int[]{0, 0, -1, 0};
		required = new boolean[]{true, true, true, false};
		groups = new int[][]{}; 
		description = "Automated Equipment Inventory Request";
		name = "INRU06";
	}
}
