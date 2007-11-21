package com.webreach.mirth.model.hl7v2.v25.segment;
import com.webreach.mirth.model.hl7v2.v25.composite.*;
import com.webreach.mirth.model.hl7v2.*;

public class _ORC extends Segment {
	public _ORC(){
		fields = new Class[]{_ID.class, _EI.class, _EI.class, _EI.class, _ID.class, _ID.class, _TQ.class, _EIP.class, _TS.class, _XCN.class, _XCN.class, _XCN.class, _PL.class, _XTN.class, _TS.class, _CE.class, _CE.class, _CE.class, _XCN.class, _CE.class, _XON.class, _XAD.class, _XTN.class, _XAD.class, _CWE.class, _CWE.class, _TS.class, _CWE.class, _CWE.class, _CNE.class};
		repeats = new int[]{0, 0, 0, 0, 0, 0, -1, 0, 0, -1, -1, -1, 0, -1, 0, 0, 0, 0, -1, 0, -1, -1, -1, -1, 0, 0, 0, 0, 0, 0};
		required = new boolean[]{false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false};
		fieldDescriptions = new String[]{"Order Control", "Placer Order Number", "Filler Order Number", "Placer Group Number", "Order Status", "Response Flag", "Quantity/Timing", "Parent", "Date/Time of Transaction", "Entered By", "Verified By", "Ordering Provider", "Enterer's Location", "Call Back Phone Number", "Order Effective Date/Time", "Order Control Code Reason", "Entering Organization", "Entering Device", "Action By", "Advanced Beneficiary Notice Code", "Ordering Facility Name", "Ordering Facility Address", "Ordering Facility Phone Number", "Ordering Provider Address", "Order Status Modifier", "Advanced Beneficiary Notice Override Reason", "Filler's Expected Availability Date/Time", "Confidentiality Code", "Order Type", "Enterer Authorization Mode"};
		description = "Common Order";
		name = "ORC";
	}
}
