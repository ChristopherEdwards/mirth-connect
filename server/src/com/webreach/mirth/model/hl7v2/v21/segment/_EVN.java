package com.webreach.mirth.model.hl7v2.v21.segment;
import com.webreach.mirth.model.hl7v2.v21.composite.*;
import com.webreach.mirth.model.hl7v2.*;

public class _EVN extends Segment {
	public _EVN(){
		fields = new Class[]{_ID.class, _TS.class, _TS.class, _ID.class};
		repeats = new int[]{0, 0, 0, 0};
		required = new boolean[]{false, false, false, false};
		fieldDescriptions = new String[]{"Event Type Code", "Date/Time of Event", "Date/Time Planned Event", "Event Reason Code"};
		description = "Event Type";
		name = "EVN";
	}
}
