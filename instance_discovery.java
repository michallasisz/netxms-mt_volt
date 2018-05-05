//create SNMP transport to node
transport = CreateSNMPTransport($node);		
//it means it isn't successfull	
if (transport == null)                 							
{
	//we return false, instance will not be created
    return false;					   							
}

//trying to read voltage via SNMP
voltage = SNMPGetValue(transport, ".1.3.6.1.4.1.14988.1.1.3.8.0");	
//it means it not exist on RB
if (voltage == null)												
{
	//we return false, instance will not be create
    return false;												
}
else
{
	//some RB'shave proper OID but return "0"
	if (voltage == 0) 											
	{
	  //we return false, instance will not be created
	  return false;												
	}

	//we are reading custom attribute "mt_ref_voltage"
	AttrVoltage = GetCustomAttribute($node, "mt_ref_voltage"); 	
	//it means it not exist
	if (AttrVoltage == null) 									
	{ 
		//we are setting it with current value
		SetCustomAttribute($node, "mt_ref_voltage", voltage);	
	}
	//we are reading custom attribute "mt_ref_threshold"
	AttrThreshold = GetCustomAttribute($node, "mt_ref_voltage_threshold");	
	//it means it not exist
	if (AttrThreshold == null)												
	{ 
		//we are reading custom attribute "mt_ref_voltage" again for current value
		AttrVoltage = GetCustomAttribute($node, "mt_ref_voltage");		
		//Threshold: approx 15% drop of reference voltage
		//we are calculating threshold based on current custom attribute value
		threshold = round(AttrVoltage - (0.15 * AttrVoltage));			
		//we are setting it
		SetCustomAttribute($node, "mt_ref_voltage_threshold", threshold);		
	}
	
   //we have an instance:)
   return true; 														
}